package com.elarslan.stock.service.product;

import com.elarslan.stock.dto.Company;
import com.elarslan.stock.enums.MarketProductsEnum;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import static com.elarslan.stock.constant.CompanyConstants.TOTAL_SHARES;
import static com.elarslan.stock.constant.CompanyConstants.WORTH;

@Service
public class ProductService {

    public Company getProductInfo(int productId) {
        return getProductDetail(productId);
    }

    @NonNull
    private Company getProductDetail(int productId) {
        Company company = Company.builder().share(TOTAL_SHARES).worth(WORTH).build();
        company.setProductId(productId);
        company.setProductName(getProductName(productId));
        return company;
    }

    private String getProductName(int productId) {
        return MarketProductsEnum.get(productId).toString();
    }
}
