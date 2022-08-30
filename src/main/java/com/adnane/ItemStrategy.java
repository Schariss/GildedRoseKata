package com.adnane;

public class ItemStrategy implements IQualityStrategy{
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
            if (item.sellIn <= 0 && item.quality > 0) {
                item.quality -= 1;
            }
        }
        item.sellIn--;
    }
}
