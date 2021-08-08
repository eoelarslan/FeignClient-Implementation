package com.elarslan.worth.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StockWorthCalculationService implements StockWorthCalculation {

    private static final BigDecimal SHARE_TRANSACTION_RATIO = BigDecimal.valueOf(0.4);

    @Override
    public BigDecimal calculateWorthAfterSold(int numberOfShare, BigDecimal worth) {
        return worth.subtract(SHARE_TRANSACTION_RATIO.multiply(BigDecimal.valueOf(numberOfShare))) ;
    }

    @Override
    public BigDecimal calculateWorthAfterBought(int numberOfShare, BigDecimal worth) {
        return worth.add(SHARE_TRANSACTION_RATIO.multiply(BigDecimal.valueOf(numberOfShare)));
    }
}
