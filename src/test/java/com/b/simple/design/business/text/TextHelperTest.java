package com.b.simple.design.business.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.b.simple.design.business.text.TextHelper;

public class TextHelperTest {

	TextHelper helper = new TextHelper();
	
	@Test
	@Disabled
	public void testSwapLastTwoCharacters() {
		assertEquals("",helper.swapLastTwoCharacters(""));
		assertEquals("A",helper.swapLastTwoCharacters("A"));
		assertEquals("BA",helper.swapLastTwoCharacters("AB"));
		assertEquals("RANI",helper.swapLastTwoCharacters("RAIN"));
	}

	@Test
	@Disabled
	public void testTruncateAInFirst2Positions() {
		assertEquals("",helper.truncateAInFirst2Positions(""));
		assertEquals("BCD",helper.truncateAInFirst2Positions("ABCD"));
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("BCD",helper.truncateAInFirst2Positions("BACD"));
		assertEquals("BBAA",helper.truncateAInFirst2Positions("BBAA"));
	}
}
