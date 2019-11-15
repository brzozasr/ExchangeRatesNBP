package models.tables;

import java.util.List;

/**
 * Model tablicy z kompletymi tabelami kursów walut określonego typu.
 */
public class ArrayOfExchangeRatesTable {

    private List<ExchangeRatesTable> exchangeRatesTables;

    public ArrayOfExchangeRatesTable(List<ExchangeRatesTable> exchangeRatesTables) {
        this.exchangeRatesTables = exchangeRatesTables;
    }

    /**
     * Pobiera listę tabel kursowych z obiektu ArrayOfExchangeRatesTable
     *
     * @return listę tabeli kursowych {List&#60;ExchangeRatesTable&#62;}:<br>
     * table - typ tabeli<br>
     * no – numer tabeli<br>
     * effectiveDate – data publikacji<br>
     * rates – lista {List&#60;RateTables&#62;} kursu średniego walut
     */
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
