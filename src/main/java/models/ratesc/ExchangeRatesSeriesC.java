package models.ratesc;


import java.util.List;

/**
 * Model kursów kupna i sprzedaży walut obcych udostępniony jako kurs (lub seria kursów) pojedynczej waluty
 * dla tabeli typu C oraz symbolu waluty.
 */
public class ExchangeRatesSeriesC {

    private String table;
    private String country;
    private String symbol;
    private String currency;
    private String code;
    private List<RateC> rates;

    public ExchangeRatesSeriesC(String table, String country, String symbol, String currency, String code, List<RateC> rates) {
        this.table = table;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public ExchangeRatesSeriesC(List<RateC> rates) {
        this.rates = rates;
    }

    /**
     * Pobiera typ tabeli z obiektu ExchangeRatesSeriesC
     *
     * @return typ tabeli ("C")
     */
    public String getTable() {
        return table;
    }

    /**
     * Pobiera nazwę kraju z obiektu ExchangeRatesSeriesC
     * (dotyczy kursów archiwalnych)
     *
     * @return nazwa kraju (np. USA, Szwajcaria)
     */
    public String getCountry() {
        return country;
    }

    /**
     * Pobiera symbol waluty (numeryczny) z obiektu ExchangeRatesSeriesC
     * (dotyczy kursów archiwalnych)
     *
     * @return numeryczny symbol waluty (np. 787, 662)
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Pobiera nazwę waluty z obiektu ExchangeRatesSeriesC
     *
     * @return nazwa waluty (np. "dolar amerykański")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Pobiera trzyliterowy kod waluty (standard ISO 4217) z obiektu ExchangeRatesSeriesC
     *
     * @return kod waluty (np. "USD", "EUR")
     */
    public String getCode() {
        return code;
    }

    /**
     * Pobiera serię danych z notowań kursów kupna i sprzedaży walut z obiektu ExchangeRatesSeriesC
     *
     * @return listę kursów {List&#60;RateC&#62;} poszczególnych walut:<br>
     * no – numer tabeli<br>
     * effectiveDate – data publikacji<br>
     * bid – przeliczony kurs kupna waluty (dotyczy tabeli C) (np. "3.8601")<br>
     * ask - przeliczony kurs sprzedaży waluty (dotyczy tabeli C) (np. "3.9381")
     */
    public List<RateC> getRates() {
        return rates;
    }
}
