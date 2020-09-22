package com.c.refactoring.movie;

import java.util.Arrays;
import java.util.List;

import com.c.refactoring.StringUtils;

public class MovieRefactored {

	String rating;

	public MovieRefactored(String rating) {
		super();
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public boolean isValidRating() {

		List<String> validBRatings = Arrays.asList("B1", "B2", "B3", "B4");

		if (this.getRating() == null)
			return false;

		if (validBRatings.contains(this.getRating()))
			return true;

		if (isValidARating())
			return true;

		return false;
	}

	private boolean isValidARating() {
		return this.getRating().startsWith("A")
				&& this.getRating().length() == 3
				&& StringUtils.isNumeric(this.getRating().substring(1));
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
