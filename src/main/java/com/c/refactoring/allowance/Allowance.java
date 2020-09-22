package com.c.refactoring.allowance;

import java.math.BigDecimal;

public class Allowance {

    int allowanceId;

    BigDecimal allowanceValue;

    public Allowance(int allowanceId , BigDecimal allowanceValue) {
        super();
        this.allowanceId = allowanceId;
        this.allowanceValue = allowanceValue;
    }

    public int getAllowanceId() {
        return allowanceId;
    }

    public BigDecimal getAllowanceValue() {
        return allowanceValue;
    }

    public void setAllowanceId(int allowanceId) {
        this.allowanceId = allowanceId;
    }

    public void setAllowanceValue(BigDecimal allowanceValue) {
        this.allowanceValue = allowanceValue;
    }

}
