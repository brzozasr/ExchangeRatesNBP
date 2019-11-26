package models.tablec;

import java.time.LocalDate;
import java.util.List;

/**
 * Model kompletnej tabeli kursowej osadzony w modelu {ArrayOfExchangeRatesTableC}
 * dla tabeli typu C.
 */
public class ExchangeRatesTableC {

    private String table;
    private String no;
    private LocalDate tradingDate;
    private LocalDate effectiveDate;
    private List<RateTablesC> rates;

    /**
     * Konstruktor obiektu ExchangeRatesTableC
     *
     * @param table         typ tabeli
     * @param no            numer tabeli
     * @param tradingDate   data notowania (dotyczy tabeli C)
     * @param effectiveDate data publikacji
     * @param rates         lista notowań walut {List&#60;RateTablesC&#62;}
     */
    public ExchangeRatesTableC(String table, String no, LocalDate tradingDate, LocalDate effectiveDate, List<RateTablesC> rates) {
        this.table = table;
        this.tradingDate = tradingDate;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    /**
     * Pobiera typ tabeli z obiektu ArrayOfExchangeRatesTableC
     *
     * @return typ tabeli ("C")
     */
    public String getTable() {
        return table;
    }

    /**
     * Pobiera numer tabeli, w której są zamieszczone notowania kursów kupna i sprzedaży walut
     * z obiektu ArrayOfExchangeRatesTableC
     *
     * @return numer tabeli (np. "090/C/NBP/2012")
     */
    public String getNo() {
        return no;
    }

    /**
     * Pobiera datę notowania kursów kupna i sprzedaży walut (dotyczy tabeli C)
     * z obiektu ArrayOfExchangeRatesTableC
     *
     * @return datę notowania kursów kupna i sprzedaży walut (np. "2012-05-08")
     */
    public LocalDate getTradingDate() {
        return tradingDate;
    }

    /**
     * Pobiera datę publikacji tabeli, w której są zamieszczone notowania kursów kupna i sprzedaży
     * walut z obiektu ArrayOfExchangeRatesTableC
     *
     * @return data publikacji (np. "2012-05-10")
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Pobiera listę kursów kupna i sprzedaży walut z obiektu ArrayOfExchangeRatesTableC
     *
     * @return listę kursów walut z tabeli {List&#60;RateTablesC&#62;}:<br>
     * country - nazwa kraju (dotyczy kursów archiwalnych)<br>
     * symbol - symbol waluty (numeryczny, dotyczy kursów archiwalnych)<br>
     * currency - nazwa waluty (np. "dolar amerykański")<br>
     * code - kod waluty (np. "USD", "EUR")<br>
     * bid - przeliczony kurs kupna waluty (dotyczy tabeli C) (np. "3.8601")<br>
     * ask - przeliczony kurs sprzedaży waluty (dotyczy tabeli C) (np. "3.9381")
     */
    public List<RateTablesC> getRates() {
        return rates;
    }
}
