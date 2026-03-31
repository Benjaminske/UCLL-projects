import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void backstagePasses_sellin10DaysOrLess_qualityIncreasingBy2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);
    }

    @Test
    void backstagepasses_sellin5DaysOrLess_qualityIncreasingBy3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

    @Test
    void backstagepasses_sellinOver_qualityBecomes0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void agedBrie_qualityNeverOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 4, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }


    @Test
    void elixirOfTheMongoose() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void elixirOfTheMongoose_overSellin_qualityDicreasesTwiceAsFast() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 2, 7) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void elixirOfTheMongoose_qualityNeverBecomesNegative() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 3) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredManaCake() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 2, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void conjuredCinnamonRoll() {
        Item[] items = new Item[] { new Item("Conjured Cinnamon Roll", 6, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertEquals("Conjured Cinnamon Roll", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
