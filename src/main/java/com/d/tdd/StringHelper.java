package com.d.tdd;

public class StringHelper {

	public String replaceAInFirst2Positions(String str) {
		
		if(str.length()<2)
			return str.replaceAll("A", "");
		
		String first2Chars = str.substring(0, 2);
		String restOfTheString = str.substring(2);
		
		return first2Chars.replaceAll("A", "") + restOfTheString;
	}

	public boolean areFirstTwoAndLastTwoCharsTheSame(String str) {
		
		int length = str.length();
		
		if(length<2)
			return false;
		
		String first2Chars = str.substring(0, 2);
		String last2Chars = str.substring(length - 2);
		
		return first2Chars.equals(last2Chars);
	}

}
