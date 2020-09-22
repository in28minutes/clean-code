
```java
package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTestRefactored {

	private static final int DEFAULT_QUALITY = 3;
	private static final int QUALITY_NEAR_MAX = 50;
	private static final int MAXIMUM_QUALITY = 50;

	private static final int POSITIVE_SELL_IN = 15;
	private static final int SELL_IN_MORE_THAN_10 = 15;
	private static final int NEGATIVE_SELL_IN = -15;
	private static final String DEFAULT_ITEM_NAME = "DEFAULT_ITEM";
	private static final String AGED_BRIE_NAME = "Aged Brie";
	private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
	private static final int SELL_IN_BETWEEN_6_AND_10 = 7;
	private static final int SELL_IN_BETWEEN_1_AND_5 = 3;

	@Test
	public void defaultUnExpiredItem_QualityDecreasesBy1() {
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM_NAME,
				POSITIVE_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM_NAME, POSITIVE_SELL_IN - 1,
				DEFAULT_QUALITY - 1);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void defaultExpiredItem_QualityDecreasesBy2() {
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM_NAME,
				NEGATIVE_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM_NAME, NEGATIVE_SELL_IN - 1,
				DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void agedBrieUnExpired_QualityIncreasesBy1() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE_NAME,
				POSITIVE_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE_NAME, POSITIVE_SELL_IN - 1,
				DEFAULT_QUALITY + 1);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void agedBrieExpired_QualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE_NAME,
				NEGATIVE_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE_NAME, NEGATIVE_SELL_IN - 1,
				DEFAULT_QUALITY + 2);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void agedBrie_QualityDoesNotGoBeyondMaximum() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE_NAME,
				POSITIVE_SELL_IN, QUALITY_NEAR_MAX);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE_NAME, POSITIVE_SELL_IN - 1,
				MAXIMUM_QUALITY);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePassesSellInMoreThan10_QualityIncreasesBy1() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME,
				SELL_IN_MORE_THAN_10, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME,
				SELL_IN_MORE_THAN_10 - 1, DEFAULT_QUALITY + 1);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePassesSellInBetween6And10_QualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME,
				SELL_IN_BETWEEN_6_AND_10, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME,
				SELL_IN_BETWEEN_6_AND_10 - 1, DEFAULT_QUALITY + 2);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePasses_SellInBoundaryCondition10_QualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME, 10,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME, 10 - 1,
				DEFAULT_QUALITY + 2);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePassesSellInBetween1And5_QualityIncreasesBy3() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME,
				SELL_IN_BETWEEN_1_AND_5, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME,
				SELL_IN_BETWEEN_1_AND_5 - 1, DEFAULT_QUALITY + 3);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePasses_SellInBoundaryCondition5_QualityIncreasesBy3() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME, 5,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME, 5 - 1,
				DEFAULT_QUALITY + 3);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePasses_SellInBoundaryCondition0_QualityDropsToZero() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME, 0,
				DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME, 0 - 1, 0);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePasses_NegativeSellIn_QualityDropsToZero() {
		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME,
				NEGATIVE_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME, NEGATIVE_SELL_IN - 1,
				0);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	@Test
	public void backStagePasses_QualityDoesNotExceedMaximum() {

		GildedRose app = createGildedRoseWithItem(BACKSTAGE_PASSES_NAME,
				POSITIVE_SELL_IN, QUALITY_NEAR_MAX);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES_NAME, POSITIVE_SELL_IN - 1,
				MAXIMUM_QUALITY);

		Item actual = app.items[0];

		assertItem(expected, actual);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithItem(String itemName, int sellIn,
			int quality) {
		Item item = new Item(itemName, sellIn, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

}
```