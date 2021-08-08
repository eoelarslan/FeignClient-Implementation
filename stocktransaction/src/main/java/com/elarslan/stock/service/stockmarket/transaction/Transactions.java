package com.elarslan.stock.service.stockmarket.transaction;


import com.elarslan.stock.dto.StockMarketEntity;

public interface Transactions<E extends StockMarketEntity> {
    /**
     *
     * @param e refers to any company object passed to method
     * @param numberOfShare indicates entities(share) of a company to sell in stock market from a shareholder
     * @return company detail after share sold in stock market
     */
    E sell(E e, int numberOfShare);
    /**
     *
     * @param e refers to any company object passed to method
     * @param numberOfShare indicates entities(share) of a company to buy in stock market from a shareholder
     * @return company detail after share bought in stock market
     */
    E buy(E e, int numberOfShare);
}
