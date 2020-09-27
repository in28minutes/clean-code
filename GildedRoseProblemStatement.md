## Introduction

Gilded Rose Refactoring Kata was originally created by Terry Hughes (http://twitter.com/TerryHughes).

## Problem Statement

The Gilded Rose buys and sells only the finest goods. Unfortunately, most goods are constantly degrading in quality as they approach their sell by date.

### Current System Behavior

- All items have a 
	- **SellIn** value which denotes the number of days till the sell by date
	- **Quality** value which denotes how valuable the item is 
- At the end of each day our system changes both values for every item as defined by the rules

### Rules

#### Default Item Rules:
- Quality decreases by 1 before (and including) the sell by date. 
	- After sell by date, quality degrades twice as fast 
- The Quality of an item is never negative and never more than 50 

#### Rules for Specific Items - Specific Exceptions:
- "Aged Brie" actually increases in Quality the older it gets 
- "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
	- increases by 2 when there are 10 days or less
	- increases by 3 when there are 5 days or less
	- drops to 0 after the concert 

## Exercises
- Step I  : Improve clarity of GildedRoseADefaultItemTest.java
- Step II : Improve clarity of GildedRoseBAgedBrieTest.java
- Step III: Improve clarity of GildedRoseCBackstagePassesTest.java
