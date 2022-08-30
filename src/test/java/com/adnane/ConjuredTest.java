package com.adnane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.adnane.ItemHelper.assertItemEquals;

public class ConjuredTest {

    private static final String CONJURED =  "Conjured Mana Cake";

    @Test
    @DisplayName("Quality degrades twice as fast")
    void qualityDegradesTwiceAsFast() {
        // Given
        Item[] items = new Item[] { new Item(CONJURED, 3, 5, new ConjuredStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(CONJURED, 2, 3);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality degrades twice as fast when sell in is expired")
    void qualityDegradesTwiceAsFastEvenWhenSellInIsExpired() {
        // Given
        Item[] items = new Item[] { new Item(CONJURED, 0, 5, new ConjuredStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(CONJURED, -1, 1);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality cannot be negative")
    void qualityCannotBeNegative() {
        // Given
        Item[] items = new Item[] { new Item(CONJURED, 0, 1, new ConjuredStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(CONJURED, -1, 0);
        assertItemEquals(item, app.getItems()[0]);
    }
}
