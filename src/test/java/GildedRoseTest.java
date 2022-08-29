import com.adnane.GildedRose;
import com.adnane.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityDegradesTwiceAsFastWhenSellInDatePass() {
        Item[] items = new Item[] { new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        // Should implement equals and hashCode, since we are not allowed
        // to modify the Item class, we are going to test each field apart
        //assertEquals(new Item("foo", -1, 2), app.getItems()[0]);
        Item item = new Item("foo", -1, 2);
        assertEquals(item.name, app.getItems()[0].name);
        assertEquals(item.quality, app.getItems()[0].quality);
        assertEquals(item.sellIn, app.getItems()[0].sellIn);
    }

}