package com.adnane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.adnane.ItemHelper.assertItemEquals;


class GildedRoseTest {

    @Test
    @DisplayName("Quality degrades twice as fast When the sell by date has passed")
    void qualityDegradesTwiceAsFastWhenSellInDatePass() {
        // Given
        Item[] items = new Item[] { new Item("foo", 0, 4, new ItemStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Should implement equals and hashCode, since we are not allowed
        // to modify the Item class, we are going to test each field apart
        //assertEquals(new Item("foo", -1, 2), app.getItems()[0]);
        // Then
        Item item = new Item("foo", -1, 2);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality of an item is never negative")
    void qualityCannotBeNegative() {
        // Given
        Item[] items = new Item[] { new Item("foo", 0, 1, new ItemStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item("foo", -1, 0);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("quality decreases")
    void qualityDecreases() {
        // Given
        Item[] items = new Item[] { new Item("foo", 10, 22, new ItemStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item("foo", 9, 21);
        assertItemEquals(item, app.getItems()[0]);
    }

}