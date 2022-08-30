package com.adnane;

import java.util.function.Predicate;

public class GildedRose {
    private final Item[] items;
    private final int MAX_QUALITY = 50;
    private final int MIN_QUALITY = 0;
    public static final String AGED_BRIE =  "Aged Brie";
    public static final String BACKSTAGE =  "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS =  "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED =  "Conjured Mana Cake";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems(){ return items; }

    public void updateQuality() {
        for (Item item :items) {

            if(!item.name.equals(BACKSTAGE) && !item.name.equals(AGED_BRIE) && !item.name.equals(SULFURAS)){
                handleQualityForConjuredAndNormalItems(item);
            }

            if(item.name.equals(AGED_BRIE))
                handleQualityForAgedBrieItems(item);

            if(item.name.equals(BACKSTAGE))
                handleQualityForBackStagePassesItems(item);
        }
    }

    public Predicate<Item> isExpired = item -> item.sellIn < 1;

    public void decreaseSellIn(Item item){
        item.sellIn -= 1;
    }

    public void handleQuality(Item item, int by){
        item.quality = item.quality + by;
        if(item.quality > MAX_QUALITY)
            item.quality = MAX_QUALITY;
        else if(item.quality < MIN_QUALITY)
            item.quality = MIN_QUALITY;
    }

    public void handleQualityForConjuredAndNormalItems(Item item){
        int rate = item.name.equals(CONJURED)? -2: -1;
        if(isExpired.test(item))
            rate = rate*2;
        handleQuality(item, rate);
        decreaseSellIn(item);
    }

    public void handleQualityForAgedBrieItems(Item item){
        int rate = isExpired.test(item)? 2: 1;
        handleQuality(item, rate);
        decreaseSellIn(item);
    }

    public void handleQualityForBackStagePassesItems(Item item){
        handleQuality(item, 1);
        if(item.sellIn <= 10){
            handleQuality(item, 1);
            if(item.sellIn <= 5)
                handleQuality(item, 1);
            if(isExpired.test(item))
                handleQuality(item, -item.quality);
        }
        decreaseSellIn(item);
    }
}