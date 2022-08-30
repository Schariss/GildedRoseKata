package com.adnane;

import java.util.Arrays;

public class GildedRose {
    private Item[] items;
    public static final String AGED_BRIE =  "Aged Brie";
    public static final String BACKSTAGE =  "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS =  "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED =  "Conjured Mana Cake";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems(){ return items; }

    public void updateQuality() {
        this.items = Arrays.stream(items).map(this::qualityUpdater).toArray(Item[]::new);
    }

    private Item qualityUpdater(Item item) {

        if(item.name.equals(AGED_BRIE))
            item = new Item(item.name, item.sellIn, item.quality, new AgedBrieStrategy());
        else if(item.name.equals(BACKSTAGE))
            item = new Item(item.name, item.sellIn, item.quality, new BackStageStrategy());
        else if(item.name.equals(SULFURAS))
            item = new Item(item.name, item.sellIn, item.quality, new SulfurasStrategy());
        else if(item.name.equals(CONJURED))
            item = new Item(item.name, item.sellIn, item.quality, new ConjuredStrategy());
        else
            item = new Item(item.name, item.sellIn, item.quality, new ItemStrategy());
        item.execute();
        return item;
    }
}