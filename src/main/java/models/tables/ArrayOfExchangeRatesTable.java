package models.tables;

import java.util.List;

public class ArrayOfExchangeRatesTable {

    private List<ExchangeRatesTable> exchangeRatesTables;

    public ArrayOfExchangeRatesTable(List<ExchangeRatesTable> exchangeRatesTables) {
        this.exchangeRatesTables = exchangeRatesTables;
    }

    public List<ExchangeRatesTable> getExchangeRatesTables() {
        return exchangeRatesTables;
    }

    //TODO usunąć
    @Override
    public String toString() {
        return "ArrayOfExchangeRatesTable{" +
                "exchangeRatesTables=" + exchangeRatesTables +
                '}';
    }
}
