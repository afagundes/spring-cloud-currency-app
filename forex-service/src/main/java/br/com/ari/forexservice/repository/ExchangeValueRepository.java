package br.com.ari.forexservice.repository;

import br.com.ari.forexservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    Optional<ExchangeValue> findByFromAndTo(String from, String to);

}
