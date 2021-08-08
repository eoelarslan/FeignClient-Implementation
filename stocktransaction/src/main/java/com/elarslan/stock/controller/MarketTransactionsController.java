package com.elarslan.stock.controller;

import com.elarslan.stock.dto.Company;
import com.elarslan.stock.dto.base.GenericResponseDto;
import com.elarslan.stock.enums.singleton.WorthEnumSingleton;
import com.elarslan.stock.service.product.ProductService;
import com.elarslan.stock.service.stockmarket.transaction.MarketTransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/markettransaction")
public class MarketTransactionsController {

    private final MarketTransactionService marketTransactionService;
    private final ProductService productService;

    public MarketTransactionsController(MarketTransactionService marketTransactionService, ProductService productService) {
        this.marketTransactionService = marketTransactionService;
        this.productService = productService;
    }

    @PostMapping(value = "/sellShare")
    @ApiOperation(value = "This api created to sell a share for an asset", notes = "This api created to sell a share for an asset", response = ResponseEntity.class)
    public ResponseEntity<GenericResponseDto<Company>> sellShare(@RequestParam(value = "share") int numberOfShare,
                                                                 @RequestParam(value = "productId") int productId) {

        Company company = marketTransactionService.sell(productService.getProductInfo(productId), numberOfShare);
        return ResponseEntity.ok(new GenericResponseDto<>(HttpStatus.OK,"Share sold!", company));
    }

    @PostMapping(value = "/buyShare")
    @ApiOperation(value = "This api created to buy a share for an asset", notes = "This api created to buy a share for an asset", response = ResponseEntity.class)
    public ResponseEntity<GenericResponseDto<Company>> buyShare(@RequestParam(value = "share") int numberOfShare,
                                                                @RequestParam(value = "productId") int productId) {

        Company company = marketTransactionService.buy(productService.getProductInfo(productId), numberOfShare);
        return ResponseEntity.ok(new GenericResponseDto<>(HttpStatus.OK,"Share bought!", company));
    }
}
