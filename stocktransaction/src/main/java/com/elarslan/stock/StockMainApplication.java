package com.elarslan.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StockMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockMainApplication.class, args);
    }
}
