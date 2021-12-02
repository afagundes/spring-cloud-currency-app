package br.com.ari.currencyconversionservice.client;

import br.com.ari.currencyconversionservice.dto.CurrencyConversionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forex-service")
public interface CurrencyExchangeServiceClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDTO retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
