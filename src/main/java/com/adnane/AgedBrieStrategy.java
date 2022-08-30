package com.adnane;

public class AgedBrieStrategy implements IQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50){
            if(item.quality < 49)
                item.quality++;
            if(item.sellIn <= 0)
                item.quality++;
        }
        item.sellIn--;
    }
}
