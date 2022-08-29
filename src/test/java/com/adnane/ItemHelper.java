package com.adnane;

import com.adnane.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemHelper {

    public static void assertItemEquals(Item expectedItem, Item actualItem){
        assertEquals(expectedItem.name, actualItem.name);
        assertEquals(expectedItem.quality, actualItem.quality);
        assertEquals(expectedItem.sellIn, actualItem.sellIn);
    }
}
