package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseRefactoredTest {
	
	private static final int POSITIVE_SELLIN_LESS_THAN_5 = 2;
	private static final int SELLIN_BETWEEN_5_AND_10 = 7;
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final int SELLIN_GREATER_THAN_10 = 15;
	private static final int MAXIMUM_QUALITY = 50;
	private static final String AGED_BRIE = "Aged Brie";
	private static final int EXPIRED_SELLIN = -2;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	private static final int DEFAULT_QUALITY = 4;
	private static final int NOT_EXPIRED_SELLIN = 16;

	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, 
						NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM, 
						NOT_EXPIRED_SELLIN - 1,DEFAULT_QUALITY - 1);
			
		assertItem(expected, app.items[0]);
	}
	
	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, 
						EXPIRED_SELLIN , DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM, 
				EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);
			
		assertItem(expected, app.items[0]);
	}

	@Test
	public void unexpiredAgedBrie_qualityIncreasesBy1() {
		
		GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, 
						NOT_EXPIRED_SELLIN , DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, 
				NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 1 );
			
		assertItem(expected, app.items[0]);
	}

	@Test
	public void expiredAgedBrie_qualityIncreasesBy2() {
		
		GildedRose app = 
				createGildedRoseWithOneItem(AGED_BRIE, 
						EXPIRED_SELLIN , DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, 
			EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 2 );
			
		assertItem(expected, app.items[0]);
	}

	@Test
	public void unexpiredAgedBrie_qualityDoesNotGoBeyondMaximum() {
		
		GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, 
						NOT_EXPIRED_SELLIN , MAXIMUM_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(AGED_BRIE, 
				NOT_EXPIRED_SELLIN - 1, MAXIMUM_QUALITY );
			
		assertItem(expected, app.items[0]);
	}

	
	@Test
	public void backStagePassesBeyond10Days_qualityIncreasesBy1() {
		
		GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, 
						SELLIN_GREATER_THAN_10 , DEFAULT_QUALITY );
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES, 
				SELLIN_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1 );
			
		assertItem(expected, app.items[0]);
	}
	
	@Test
	public void backStageBetween5And10Days_qualityIncreasesBy2() {
		
		GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, 
						SELLIN_BETWEEN_5_AND_10 , DEFAULT_QUALITY );
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES, 
				SELLIN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY +  2);
			
		assertItem(expected, app.items[0]);
	}

	@Test
	public void backStageLessThan5Days_qualityIncreasesBy3() {
		
		GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, 
						POSITIVE_SELLIN_LESS_THAN_5 , DEFAULT_QUALITY );
		
		app.updateQuality();
		
		Item expected = new Item(BACKSTAGE_PASSES, 
				POSITIVE_SELLIN_LESS_THAN_5 - 1, DEFAULT_QUALITY +  3);
			
		assertItem(expected, app.items[0]);
	}

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithOneItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

}