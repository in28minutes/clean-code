package com.b.simple.design.business.text;

public class TextHelperRefactored {
    public String swapLastTwoCharacters(String str) {

        int lengthStr = str.length();

        if (lengthStr < 2) return str;

        char lastChar = str.charAt(lengthStr - 1);
        char secondLastChar = str.charAt(lengthStr - 2);

        return str.substring(0, str.length() - 2) + lastChar + secondLastChar;

    }

    public String truncateAInFirst2Positions(String str) {
        int length = str.length();

        if (length == 0) return str;

        if (length == 1 || length == 2) return str.replaceAll("A", "");

        String firstTwoChars = str.substring(0, 2);

        return firstTwoChars.replaceAll("A", "") + str.substring(2);
    }

    public String truncateFirst2CharactersExceptAB(String str) {
        int lengthStr = str.length();

        if (lengthStr == 0) return str;

        if (lengthStr == 1) return str.equals("A") ? "A" : "";

        StringBuilder truncatedString = new StringBuilder(str);

        char firstChar = str.charAt(0);
     
        if (firstChar == 'A') {
            truncatedString.append(firstChar);
        }

        char secondChar = str.charAt(1);
        
        if (secondChar == 'B') {
            truncatedString.append(secondChar);
        }

        final String remainingString = str.substring(2);
        
		return truncatedString.append(remainingString).toString();
    }

}
