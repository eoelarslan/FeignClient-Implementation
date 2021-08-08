package com.elarslan.stock.constant;

import com.elarslan.stock.exception.InvalidActionException;

import java.math.BigDecimal;

public class CompanyConstants {
    private CompanyConstants() throws InvalidActionException {
        throw new InvalidActionException("Constructor cannot be used");
    }
    public static final int ONE_ITEM = 1;
    public static final int TOTAL_SHARES = 100;
    public static final BigDecimal WORTH = BigDecimal.valueOf(1000);
}
