package br.com.ari.forexservice.service;

import br.com.ari.forexservice.model.ExchangeValue;
import br.com.ari.forexservice.repository.ExchangeValueRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {

    private final Environment environment;
    private final ExchangeValueRepository repository;

    public ExchangeValueServiceImpl(Environment environment, ExchangeValueRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @Override
    public ExchangeValue retrieveExchangeValue(String from, String to) {
        return repository
                .findByFromAndTo(from, to)
                .stream()
                .peek(exchangeValue -> exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")))))
                .findFirst()
                .orElse(null);
    }

}
