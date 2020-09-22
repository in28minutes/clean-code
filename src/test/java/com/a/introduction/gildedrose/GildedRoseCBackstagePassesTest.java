package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {
	@Test
	public void testUpdateQualityBackstagePasses1() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(14, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses2() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(6, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses3() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(5, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses4() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(9, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses5() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(0, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses6() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(4, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses7() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(-1, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses8() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(4, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses9() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10,
				50);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(9, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses10() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(0, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}
}