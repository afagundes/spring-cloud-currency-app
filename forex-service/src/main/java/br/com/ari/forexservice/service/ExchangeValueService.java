package br.com.ari.forexservice.service;

import br.com.ari.forexservice.model.ExchangeValue;

public interface ExchangeValueService {

    ExchangeValue retrieveExchangeValue(String from, String to);

}
