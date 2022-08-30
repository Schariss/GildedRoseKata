package com.adnane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.adnane.ItemHelper.assertItemEquals;

public class AgedBrieTest {

    private static final String AGED_BRIE = "Aged Brie";

    @Test
    @DisplayName("Increases quality")
    void qualityIncreases() {
        // Given
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 22) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(AGED_BRIE, 9, 23);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality cannot go over 50")
    void qualityCannotGoOver50() {
        // Given
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 49) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();
        System.out.println(app.getItems()[0]);
        // Then
        Item item = new Item(AGED_BRIE, -1, 50);
        assertItemEquals(item, app.getItems()[0]);
    }
}
