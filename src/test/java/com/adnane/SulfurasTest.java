package com.adnane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.adnane.ItemHelper.assertItemEquals;

public class SulfurasTest {

    private static final String SULFURAS =  "Sulfuras, Hand of Ragnaros";

    @Test
    @DisplayName("Never has to be sold or decreases in Quality")
    void neverChange() {
        // Given
        Item[] items = new Item[] { new Item(SULFURAS, 0, 49, new SulfurasStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();
        System.out.println(app.getItems()[0]);
        // Then
        Item item = new Item(SULFURAS, 0, 49);
        assertItemEquals(item, app.getItems()[0]);
    }
}
