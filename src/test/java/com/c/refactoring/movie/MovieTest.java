package com.c.refactoring.movie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MovieTest {
    @Test
    public void testIsValidRating() {
        assertTrue(new MovieRefactored("B1").isValidRating());
        assertTrue(new MovieRefactored("B2").isValidRating());
        assertTrue(new MovieRefactored("B3").isValidRating());
        assertTrue(new MovieRefactored("B4").isValidRating());
        assertFalse(new MovieRefactored("B5").isValidRating());
        assertFalse(new MovieRefactored("B10").isValidRating());

        assertTrue(new MovieRefactored("A10").isValidRating());
        assertTrue(new MovieRefactored("A11").isValidRating());
        assertTrue(new MovieRefactored("A99").isValidRating());

        assertFalse(new MovieRefactored("A1").isValidRating());
        assertFalse(new MovieRefactored("A2").isValidRating());
        assertFalse(new MovieRefactored("A100").isValidRating());
        assertFalse(new MovieRefactored("A786").isValidRating());
    }

}