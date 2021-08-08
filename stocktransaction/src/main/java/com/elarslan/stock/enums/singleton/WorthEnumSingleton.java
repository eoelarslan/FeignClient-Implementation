package com.elarslan.stock.enums.singleton;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public enum WorthEnumSingleton {

    COMPANY_WORTH(BigDecimal.valueOf(1000));

    @Getter
    @Setter
    private BigDecimal worth;

    WorthEnumSingleton(BigDecimal worth) {
        this.worth = worth;
    }

    public WorthEnumSingleton getInstance() {
        return COMPANY_WORTH;
    }
}
