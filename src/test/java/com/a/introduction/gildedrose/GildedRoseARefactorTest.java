package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseARefactorTest {

	public static final int NOT_EXPIRED_SELLIN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";

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

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, -1, 3);
		app.updateQuality();
		assertEquals(DEFAULT_ITEM, app.items[0].name);
		assertEquals(-2, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
	}
}