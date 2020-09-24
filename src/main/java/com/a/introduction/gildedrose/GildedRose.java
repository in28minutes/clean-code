package com.a.introduction.gildedrose;

import java.util.Arrays;

class GildedRose {
	
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public static void main(String[] args) {

		Item[] items = new Item[] { 
							new Item("Default Item", 10, 20)
					   };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		System.out.println(app);

	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
				if (items[i].quality > 0) {
					if (items[i].name != "Sulfuras, Hand of Ragnaros") {
						items[i].quality = items[i].quality - 1;
					}
				}
			} else {
				// This part handles the items for which quality can increase
				// "Backstage passes to a TAFKAL80ETC concert" and "Aged Brie"

				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
						if (items[i].sellIn < 11) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}

						if (items[i].sellIn < 6) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}
					}
				}
			}

			// Everything except for Sulfuras the sellIn Decreases
			if (items[i].name != "Sulfuras, Hand of Ragnaros") {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (items[i].name != "Aged Brie") {

					if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
						if (items[i].quality > 0) {
							if (items[i].name != "Sulfuras, Hand of Ragnaros") {
								items[i].quality = items[i].quality - 1;
							}
						}
					} else {
						// For Backstage passes with sellin less than zero
						// quality is set to zero
						items[i].quality = 0;
					}
				} else {
					// For Aged Brie below 50 quality increases actually by 2
					// In the previous line
					if (items[i].quality < 50) {
						items[i].quality = items[i].quality + 1;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

}