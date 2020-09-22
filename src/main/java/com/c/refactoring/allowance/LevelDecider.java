package com.c.refactoring.allowance;

import java.math.BigDecimal;

import com.c.refactoring.Log;

public class LevelDecider {

    public String determineLevel(File fileVersion,
            long fileVersionIdPrev,
            Allowance allowance, BigDecimal allowanceVal) {
        String Level = "";
        boolean isAllowanceDiffPercLessConfig = false;
        if (fileVersion.getPrevFileVersionStatus().equals(
                Constants.FILE_STATUS_CLOSED)) {
            Level = Constants.LEVEL_D2;
        } else if (allowanceVal != null && fileVersionIdPrev != 0
                && allowance.getAllowanceId() != 0) {
            BigDecimal allowancePrevVal = allowance.getAllowanceValue();
            Log.debug("Previous Allowance value = # {0}", allowancePrevVal);
            // calculate Allowance Diff
            BigDecimal allowanceDiff = allowanceVal.subtract(allowancePrevVal);
            Log.debug("Allowance Difference value = # {0}", allowanceDiff);
            Log.logApplicationDebug(" Level :" + Level,
                    getClass());
            BigDecimal allowanceDiffPerc = Constants.BIG_DECIMAL_ZERO;
            // Get configured Allowance limit value & allowance difference percentage
            BigDecimal configuredDiffPerc = new BigDecimal(
                    Constants.CONFIGURATION_ALLOWANCE_PERCENT);
            BigDecimal configuredDiffAmt = new BigDecimal(
                    Constants.CONFIGURATION_ALLOWANCE_LIMIT);
            // calculate Allowance Diff Percentage
            if (allowancePrevVal != null && allowancePrevVal.doubleValue() != 0) {
                allowanceDiffPerc = allowanceDiff.abs()
                        .divide(allowancePrevVal, 2, BigDecimal.ROUND_HALF_UP)
                        .multiply(Constants.BIG_DECIMAL_HUNDRED);
                isAllowanceDiffPercLessConfig = allowanceDiffPerc
                        .compareTo(configuredDiffPerc) < 1;
            }

            Log.logApplicationInfo(
                    "Allowance Diff : " + allowanceDiff.doubleValue(),
                    allowanceDiff, getClass());
            Log.logApplicationInfo("Allowance Diff Perc : "
                    + allowanceDiffPerc.doubleValue(), allowanceDiffPerc,
                    getClass());
            if (allowanceDiff.abs().compareTo(configuredDiffAmt) < 1
                    || isAllowanceDiffPercLessConfig) {
                Level = Constants.LEVEL_D1;
            } else {
                Level = Constants.LEVEL_D2;
            }
        } else {
            // if prev file  or allowance for previous file 
            // does not exsits
            // then  level is D2
            Level = Constants.LEVEL_D2;
        }
        return Level;
    }
}