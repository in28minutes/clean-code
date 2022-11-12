package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseARefactorTest {

	public static final int HIGHEST_QUALITY = 50;
	public static final String AGED_BRIE = "Aged Brie";
	public static final int EXPIRED_SELLIN = -1;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";

	public static final int NOT_EXPIRED_4DAYS_SELLIN = 4;
	public static final int DEFAULT_QUALITY = 3;
	public static final int NOT_EXPIRED_15DAYS_SELLIN = 15;


	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM,
				NOT_EXPIRED_15DAYS_SELLIN,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM,
				NOT_EXPIRED_15DAYS_SELLIN - 1,
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

	@Test
	public void unexpiredAgedBrie_qualityIncreasesBy1() {
		GildedRose app = createGildedRoseWithOneItem(AGED_BRIE,
				NOT_EXPIRED_4DAYS_SELLIN,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE,
				NOT_EXPIRED_4DAYS_SELLIN - 1,
				DEFAULT_QUALITY + 1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void oldAgedBrie_qualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, EXPIRED_SELLIN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE,
				EXPIRED_SELLIN - 1,
				DEFAULT_QUALITY + 2);

		assertItem(expected, app.items[0]);

	}

	@Test
	public void oldestAgedBrie_qualityKeepsMaximum() {
		GildedRose app = createGildedRoseWithOneItem(AGED_BRIE,
				NOT_EXPIRED_4DAYS_SELLIN,
				HIGHEST_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE,
				NOT_EXPIRED_4DAYS_SELLIN - 1,
				HIGHEST_QUALITY );

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
}