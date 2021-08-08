package com.elarslan.stock.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "companyworthcalculation", url = "http://localhost:8183/worthCalculation")
public interface WorthCalculation {
    @PostMapping(value = "/sellShare")
    ResponseEntity<BigDecimal> sellShare(@RequestParam(value = "share") int numberOfShare, @RequestParam BigDecimal worth);

    @PostMapping(value = "/buyShare")
    ResponseEntity<BigDecimal> buyShare(@RequestParam(value = "share") int numberOfShare, @RequestParam BigDecimal worth);
}