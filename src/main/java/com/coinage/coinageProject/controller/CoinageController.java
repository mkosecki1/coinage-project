package com.coinage.coinageProject.controller;

import com.coinage.coinageProject.serwice.CoinageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class CoinageController {

    private CoinageService coinageService;

    @GetMapping(value = "/v1/abc")
    public ResponseEntity<Double> calculateValue(@RequestParam String currencyExchange, @RequestParam Double quantity) {
        log.info("retrived data {}");

        double res = coinageService.calculateCurrency(currencyExchange, quantity);

        return ResponseEntity.ok(res);
    }

}
