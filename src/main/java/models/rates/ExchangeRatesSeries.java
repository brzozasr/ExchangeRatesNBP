package models.rates;

import java.util.List;

/**
 * Model kursów waluty udostępniony jako kurs (lub seria kursów)
 * dla określonego typu tabeli oraz symbolu waluty.
 */
public class ExchangeRatesSeries {
    private String table;
    private String country;
    private String symbol;
    private String currency;
    private String code;
    private List<Rate> rates;

    /**
     * Konstruktor obiektu ExchangeRatesSeries
     *
     * @param table    typ babeli
     * @param country  nazwa kraju
     * @param symbol   symbol waluty (numeryczny, dotyczy kursów archiwalnych)
     * @param currency nazwa waluty
     * @param code     kod waluty
     * @param rates    lista tabel notowań waluty {List&#60;Rate&#62;}
     */
    public ExchangeRatesSeries(String table, String country, String symbol, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    /**
     * Konstruktor obiektu ExchangeRatesSeries
     *
     * @param rates lista tabel notowań waluty {List&#60;Rate&#62;}
     */
    public ExchangeRatesSeries(List<Rate> rates) {
        this.rates = rates;
    }

    /**
     * Pobiera typ tabeli z obiektu ExchangeRatesSeries
     *
     * @return typ tabeli (np. "A", "B")
     */
    public String getTable() {
        return table;
    }

    /**
     * Pobiera nazwę kraju z obiektu ExchangeRatesSeries
     * (dotyczy kursów archiwalnych)
     *
     * @return nazwa kraju (np. Australia, Afganistan)
     */
    public String getCountry() {
        return country;
    }

    /**
     * Pobiera symbol waluty (numeryczny) z obiektu ExchangeRatesSeries
     * (dotyczy kursów archiwalnych)
     *
     * @return numeryczny symbol waluty (np. 787, 662)
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Pobiera nazwę waluty z obiektu ExchangeRatesSeries
     *
     * @return nazwa waluty (np. "dolar amerykański" lub z kursów archiwalnych "USA")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Pobiera trzyliterowy kod waluty (standard ISO 4217) z obiektu ExchangeRatesSeries
     *
     * @return kod waluty (np. "USD", "EUR")
     */
    public String getCode() {
        return code;
    }

    /**
     * Pobiera serię danych z notowań kursów walut z obiektu ExchangeRatesSeries
     *
     * @return listę kursów {List&#60;Rate&#62;} poszczególnych walut:<br>
     * no – numer tabeli<br>
     * effectiveDate – data publikacji<br>
     * mid – przeliczony kurs średni waluty
     */
    public List<Rate> getRates() {
        return rates;
    }
}
