package com.elarslan.worth.service;

import java.math.BigDecimal;

public interface StockWorthCalculation {
    BigDecimal calculateWorthAfterSold(int numberOfShare, BigDecimal worth);
    BigDecimal calculateWorthAfterBought(int numberOfShare, BigDecimal worth);
}
