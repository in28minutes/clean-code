package com.a.introduction.gildedrose;

public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "\n name=" + name + ", " + sellIn + ", " + quality + "\n" ;
	}
	
	
}
