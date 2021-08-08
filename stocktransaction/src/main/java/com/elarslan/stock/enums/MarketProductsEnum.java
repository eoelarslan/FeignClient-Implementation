package com.elarslan.stock.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public enum MarketProductsEnum {
    TESLA(1), ROCKET_LAB(2);

    @Getter
    private final int productId;
    private static final Map<Integer, MarketProductsEnum> lookup = new HashMap<>();

    MarketProductsEnum(int productId) {
        this.productId = productId;
    }

    public int productId() {
        return productId;
    }

    static
    {
        Arrays.stream(MarketProductsEnum.values()).forEach(marketProductsEnum ->
                lookup.put(marketProductsEnum.getProductId(), marketProductsEnum));
    }

    public static MarketProductsEnum get(Integer productId)
    {
        return lookup.get(productId);
    }

}
