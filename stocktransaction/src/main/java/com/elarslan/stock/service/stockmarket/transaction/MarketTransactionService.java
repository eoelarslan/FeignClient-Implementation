package com.elarslan.stock.service.stockmarket.transaction;

import com.elarslan.stock.dto.Company;
import com.elarslan.stock.enums.singleton.WorthEnumSingleton;
import com.elarslan.stock.feignclient.WorthCalculation;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MarketTransactionService implements Transactions<Company> {

    private WorthCalculation worthCalculation;

    public MarketTransactionService(WorthCalculation worthCalculation) {
        this.worthCalculation = worthCalculation;
    }

    /**
     *
     * @param company refers to any company object passed to method
     * @param numberOfShare indicates entities(share) of a company to sell in stock market from a shareholder
     * @return company detail after share sold in stock market
     */
    @Override
    public Company sell(@NonNull Company company, int numberOfShare) {
        company.setShare(company.getShare() - numberOfShare);
        company.setWorth(worthCalculation.sellShare(numberOfShare,company.getWorth()).getBody());
        return company;
    }

    /**
     *
     * @param company refers to any company object passed to method
     * @param numberOfShare indicates entities(share) of a company to buy in stock market from a shareholder
     * @return company detail after share bought in stock market
     */
    @Override
    public Company buy(@NonNull Company company, int numberOfShare) {
        company.setShare(company.getShare() + numberOfShare);
        company.setWorth(worthCalculation.buyShare(numberOfShare,company.getWorth()).getBody());
        return company;
    }
}
