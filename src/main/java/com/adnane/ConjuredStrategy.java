package com.adnane;

public class ConjuredStrategy implements IQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        item.quality -= 2;
        if (item.sellIn <= 0) {
            item.quality -= 2;
        }
        if(item.quality < 0) item.quality = 0;
        item.sellIn--;
    }
}
