package com.elarslan.stock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
public class Company extends StockMarketEntity{
    private int share; //shares of company in stock market
    private BigDecimal worth; // value of company in stock market
}
