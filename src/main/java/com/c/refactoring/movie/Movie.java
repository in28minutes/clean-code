package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

public class Movie {

    String rating;

    public Movie(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    /*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/
    public boolean isValidRating() {
        if (this.getRating() != null) {
            if (this.getRating().substring(0, 1).equalsIgnoreCase("B")
                    && this.getRating().length() == 2) {
                if (StringUtils.isNumeric(this.getRating().substring(1, 2))
                        && Integer.parseInt(this.getRating().substring(1, 2)) > 0
                        && Integer.parseInt(this.getRating().substring(1, 2)) < 5)
                    return true;

            } else if (this.getRating().substring(0, 1).equalsIgnoreCase("A")
                    && this.getRating().length() == 3
                    && StringUtils.isNumeric(this.getRating().substring(1, 3)))
                return true;

        }
        return false;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
