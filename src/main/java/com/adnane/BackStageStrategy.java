package com.adnane;

public class BackStageStrategy implements IQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        if(item.quality < 50){
            item.quality++;
            if(item.sellIn <= 10 && item.quality < 50){
                item.quality++;
                if(item.sellIn <= 5 && item.quality < 50)
                    item.quality++;
            }
            if(item.sellIn <= 0)
                item.quality = 0;
        }
        item.sellIn--;
    }
}
