package br.com.ari.forexservice.controller;

import br.com.ari.forexservice.model.ExchangeValue;
import br.com.ari.forexservice.service.ExchangeValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class ForexController {

    private final ExchangeValueService exchangeValueService;

    public ForexController(ExchangeValueService exchangeValueService) {
        this.exchangeValueService = exchangeValueService;
    }

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return exchangeValueService.retrieveExchangeValue(from, to);
    }

}
