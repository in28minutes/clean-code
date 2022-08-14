package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseARefactorTest {

	public static final int NOT_EXPIRED_SELLIN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELLIN = -1;

	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM,
				NOT_EXPIRED_SELLIN,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM,
				NOT_EXPIRED_SELLIN - 1,
				DEFAULT_QUALITY - 1);

		assertItem(expected, app.items[0]);

	}



	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM,
				EXPIRED_SELLIN,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM,
				EXPIRED_SELLIN - 1,
				DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);

	}

	// ================ Adding B Aged Brie Tests  ========================


	@Test
	public void testUpdateQualityAgedBrie1() {
		Item item = new Item("Aged Brie", 4, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityAgedBrie2() {
		Item item = new Item("Aged Brie", -1, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(-2, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityAgedBrie3() {
		Item item = new Item("Aged Brie", 4, 50);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}

	// ============ Hasta aquí B Aged Brie Test  ================================






	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithOneItem(String itemType, int sellIn, int defaultQuality) {
		Item item = new Item(itemType, sellIn, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}
}