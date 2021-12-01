package br.com.ari.currencyconversionservice.controller;

import br.com.ari.currencyconversionservice.client.CurrencyExchangeServiceClient;
import br.com.ari.currencyconversionservice.dto.CurrencyConversionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeServiceClient proxy;

    public CurrencyConversionController(CurrencyExchangeServiceClient proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversionDTO response = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionDTO(response, quantity);
    }

}
