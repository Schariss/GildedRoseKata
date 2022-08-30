package com.adnane;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.adnane.ItemHelper.assertItemEquals;

public class BackStageTest {

    private static final String BACKSTAGE =  "Backstage passes to a TAFKAL80ETC concert";

    @Test
    @DisplayName("Increases quality by one When sell is > 10 days ")
    void qualityIncreasesByOneWhenSellInIsGreaterThanTenDays() {
        // Given
        Item[] items = new Item[] { new Item(BACKSTAGE, 11, 22, new BackStageStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(BACKSTAGE, 10, 23);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Increases quality by two When sell is <= 10 days ")
    void qualityIncreasesByTwoWhenSellInIsLessOrEqualsTenDays() {
        // Given
        Item[] items = new Item[] { new Item(BACKSTAGE, 10, 1, new BackStageStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(BACKSTAGE, 9, 3);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Increases quality by three When sell is <= 5 days ")
    void qualityIncreasesByThreeWhenSellInIsLessOrEqualsFiveDays() {
        // Given
        Item[] items = new Item[] { new Item(BACKSTAGE, 4, 1, new BackStageStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(BACKSTAGE, 3, 4);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality drops to zero after the concert ")
    void qualityGoesToZeroAfterTheConcert() {
        // Given
        Item[] items = new Item[] { new Item(BACKSTAGE, 0, 49, new BackStageStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(BACKSTAGE, -1, 0);
        assertItemEquals(item, app.getItems()[0]);
    }

    @Test
    @DisplayName("Quality cannot go over 50")
    void qualityCannotGoOverFifty() {
        // Given
        Item[] items = new Item[] { new Item(BACKSTAGE, 1, 50, new BackStageStrategy()) };
        GildedRose app = new GildedRose(items);

        // When
        app.updateQuality();

        // Then
        Item item = new Item(BACKSTAGE, 0, 50);
        assertItemEquals(item, app.getItems()[0]);
    }
}
