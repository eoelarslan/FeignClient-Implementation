package com.elarslan.stock.feignclient;

import com.elarslan.stock.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "${company.worth.calculation.module}", url = "${feign.worth.calculation.url}", configuration = FeignConfig.class)
public interface WorthCalculation {
    @PostMapping(value = "/sellShare")
    ResponseEntity<BigDecimal> sellShare(@RequestParam(value = "share") int numberOfShare, @RequestParam BigDecimal worth);

    @PostMapping(value = "/buyShare")
    ResponseEntity<BigDecimal> buyShare(@RequestParam(value = "share") int numberOfShare, @RequestParam BigDecimal worth);
}
