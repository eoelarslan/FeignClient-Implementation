package com.elarslan.worth.controller;

import com.elarslan.worth.service.StockWorthCalculationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/worthCalculation")
public class WorthCalculationController {

    private final StockWorthCalculationService calculateWorth;

    public WorthCalculationController(StockWorthCalculationService calculateWorth) {
        this.calculateWorth = calculateWorth;
    }

    @PostMapping(value = "/sellShare")
    public ResponseEntity<BigDecimal> sellShare(@RequestParam(value = "share") int numberOfShare,
                                            @RequestParam(value = "worth") BigDecimal worth) {
        return ResponseEntity.ok(calculateWorth.calculateWorthAfterSold(numberOfShare, worth));
    }

    @PostMapping(value = "/buyShare")
    public ResponseEntity<BigDecimal> buyShare(@RequestParam(value = "share") int numberOfShare,
                                                @RequestParam(value = "worth") BigDecimal worth) {
        return ResponseEntity.ok(calculateWorth.calculateWorthAfterBought(numberOfShare, worth));
    }
}
