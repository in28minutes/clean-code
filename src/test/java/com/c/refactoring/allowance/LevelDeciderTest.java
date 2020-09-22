package com.c.refactoring.allowance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class LevelDeciderTest {

    LevelDecider levelDecider = new LevelDecider();

    @Test
    public void testDetermineDecisionLevel_NotAFKAllowanceDiffLessThanConfigured() {
        File file = new File();
        file.setPrevFileVersionStatus("TEST_VALUE_NOT_CLOSED");
        assertEquals(Constants.LEVEL_D1, levelDecider.determineLevel(
                file, 10, new Allowance(10, new BigDecimal(1000.00)),
                new BigDecimal(1100.00)));
    }

    @Test
    public void testDetermineDecisionLevel_NotAFKAllowanceDiffPercGreaterThanConfigured() {
        File file = new File();
        file.setPrevFileVersionStatus("TEST_VALUE_NOT_AFK");
        assertEquals(Constants.LEVEL_D2, levelDecider.determineLevel(
                file, 10, new Allowance(10, new BigDecimal(4200000.00)),
                new BigDecimal(5000000.00)));
    }

    @Test
    public void testDetermineDecisionLevel_NotAFKAllowanceDiffPercLessThanConfigured() {
        File file = new File();
        file.setPrevFileVersionStatus("TEST_VALUE_NOT_CLOSED");
        assertEquals(Constants.LEVEL_D1, levelDecider.determineLevel(
                file, 10, new Allowance(10, new BigDecimal(4600000.00)),
                new BigDecimal(5000000.00)));
    }

    @Test
    public void testDetermineDecisionLevel_NotAFKAllowanceDiffZero() {
        File file = new File();
        file.setPrevFileVersionStatus("TEST_VALUE_NOT_CLOSED");
        assertEquals(Constants.LEVEL_D1, levelDecider.determineLevel(
                file, 10, new Allowance(10, new BigDecimal(1000.00)),
                new BigDecimal(1000.00)));

    }

    @Test
    public void testDetermineDecisionLevel_PreviousFileVerisonAFK() {
        File file = new File();
        file.setPrevFileVersionStatus(Constants.FILE_STATUS_CLOSED);
        assertEquals(Constants.LEVEL_D2,
                levelDecider.determineLevel(file, 10,
                        null, null));
    }

    @Test
    public void testDetermineDecisionLevel_PreviousFileVerisonNotAFKAndAllowancesNull() {
        File file = new File();
        file.setPrevFileVersionStatus("TEST_VALUE_NOT_CLOSED");
        assertEquals(Constants.LEVEL_D2,
                levelDecider.determineLevel(file, 10, null, null));
    }

}