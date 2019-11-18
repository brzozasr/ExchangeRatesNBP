package models.tablec;

import java.util.List;

/**
 * Model tablicy z kompletymi tabelami kursów walut typu C (notowania kursów kupna i sprzedaży walut).
 */
public class ArrayOfExchangeRatesTableC {

    private List<ExchangeRatesTableC> exchangeRatesTablesC;

    public ArrayOfExchangeRatesTableC(List<ExchangeRatesTableC> exchangeRatesTablesC) {
        this.exchangeRatesTablesC = exchangeRatesTablesC;
    }

    /**
     * Pobiera listę tabel notowań kursów kupna i sprzedaży walut z obiektu ArrayOfExchangeRatesTableC
     *
     * @return listę tabeli kursowych {List&#60;ExchangeRatesTableC&#62;}:<br>
     * table - typ tabeli<br>
     * no – numer tabeli<br>
     * tradingDate - data notowania (dotyczy tabeli C)<br>
     * effectiveDate – data publikacji<br>
     * rates – lista {List&#60;RateTablesC&#62;} kursów kupna i sprzedaży walut
     */
    public List<ExchangeRatesTableC> getExchangeRatesTablesC() {
        return exchangeRatesTablesC;
    }
}
