package br.com.ari.currencyconversionservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConversionDTO {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;

    public CurrencyConversionDTO(CurrencyConversionDTO currencyConversionDTO, BigDecimal quantity) {
        this.id = currencyConversionDTO.getId();
        this.from = currencyConversionDTO.getFrom();
        this.to = currencyConversionDTO.getTo();
        this.conversionMultiple = currencyConversionDTO.getConversionMultiple();
        this.quantity = quantity;
        this.totalCalculatedAmount = quantity.multiply(currencyConversionDTO.getConversionMultiple());
        this.port = currencyConversionDTO.getPort();
    }
}
