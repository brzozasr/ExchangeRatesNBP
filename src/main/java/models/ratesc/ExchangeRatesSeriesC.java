package models.ratesc;


import models.rates.Rate;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * Konstruktor obiektu ExchangeRatesSeriesC
     *
     * @param table    typ tabeli
     * @param country  nazwa kraju
     * @param symbol   symbol waluty (numeryczny, dotyczy kursów archiwalnych)
     * @param currency nazwa waluty
     * @param code     kod waluty
     * @param rates    lista tabel notowań waluty {List&#60;RateC&#62;}
     */
    public ExchangeRatesSeriesC(String table, String country, String symbol, String currency, String code, List<RateC> rates) {
        this.table = table;
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    /**
     * Konstruktor obiektu ExchangeRatesSeriesC
     *
     * @param rates lista tabel notowań waluty {List&#60;RateC&#62;}
     */
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

    /**
     * Pobiera maksymalną (najwyższą) wartość przeliczoną kursu kupna waluty z wybranego przedziału czasowego
     * (np. ostanie 30 notowań - new TableC().lastTopCountExchangeRate(CurrencyCodeTableC.USD, 30)).
     *
     * @return maksymalną (najwyższą) przeliczoną kursu kupna waluty
     */
    public Double getBidMax() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> bid = new ArrayList<>();
            for (RateC bids : list) {
                bid.add(bids.getBid());
            }
            return Collections.max(bid);
        } else {
            return null;
        }
    }

    /**
     * Pobiera minimalną (najniższą) wartość przeliczoną kursu kupna waluty z wybranego przedziału czasowego
     * (np. ostanie 30 notowań - new TableA().lastTopCountExchangeRate(CurrencyCodeTableA.USD, 30)).
     *
     * @return minimalną (najniższą) wartość przeliczoną kursu kupna waluty
     */
    public Double getBidMin() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> bid = new ArrayList<>();
            for (RateC bids : list) {
                bid.add(bids.getBid());
            }
            return Collections.min(bid);
        } else {
            return null;
        }
    }

    /**
     * Pobiera maksymalną (najwyższą) wartość przeliczoną kursu sprzedaży waluty z wybranego przedziału czasowego
     * (np. od 2 stycznia 2002 r. do bieżącej daty - new TableC().currencyExchangeRate(CurrencyCodeTableC.USD)).
     *
     * @return maksymalną (najwyższą) przeliczoną kursu sprzedaży waluty
     */
    public Double getAskMax() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> ask = new ArrayList<>();
            for (RateC asks : list) {
                ask.add(asks.getAsk());
            }
            return Collections.max(ask);
        } else {
            return null;
        }
    }

    /**
     * Pobiera minimalną (najniższą) wartość przeliczoną kursu sprzedaży waluty z wybranego przedziału czasowego
     * (np. od 2 stycznia 2002 r. do bieżącej daty - new TableC().currencyExchangeRate(CurrencyCodeTableC.USD)).
     *
     * @return minimalną (najniższą) wartość przeliczoną kursu sprzedaży waluty
     */
    public Double getAskMin() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> ask = new ArrayList<>();
            for (RateC asks : list) {
                ask.add(asks.getAsk());
            }
            return Collections.min(ask);
        } else {
            return null;
        }
    }

    /**
     * Pobiera maksymalną (najwyższą) wartość przeliczoną kursu kupna i sprzedaży waluty z wybranego przedziału czasowego
     * (np. od 2 stycznia 2002 r. do bieżącej daty - new TableC().currencyExchangeRate(CurrencyCodeTableC.USD)).
     *
     * @return maksymalną (najwyższą) przeliczoną kursu kupna i sprzedaży waluty
     */
    public Double getMax() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> bid = new ArrayList<>();
            for (RateC bids : list) {
                bid.add(bids.getBid());
            }
            double maxBid = Collections.max(bid);

            List<Double> ask = new ArrayList<>();
            for (RateC asks : list) {
                ask.add(asks.getAsk());
            }
            double maxAsk = Collections.max(ask);

            List<Double> upper = new ArrayList<>();
            upper.add(maxBid);
            upper.add(maxAsk);

            return Collections.max(upper);
        } else {
            return null;
        }
    }

    /**
     * Pobiera minimalną (najniższą) wartość przeliczoną kursu kupna i sprzedaży waluty z wybranego przedziału czasowego
     * (np. od 2 stycznia 2002 r. do bieżącej daty - new TableC().currencyExchangeRate(CurrencyCodeTableC.USD)).
     *
     * @return minimalną (najniższą) wartość przeliczoną kursu kupna i sprzedaży waluty
     */
    public Double getMin() {
        List<RateC> list = rates;
        if (list.size() > 0) {
            List<Double> bid = new ArrayList<>();
            for (RateC bids : list) {
                bid.add(bids.getBid());
            }
            double minBid = Collections.min(bid);

            List<Double> ask = new ArrayList<>();
            for (RateC asks : list) {
                ask.add(asks.getAsk());
            }
            double minAsk = Collections.min(ask);

            List<Double> lower = new ArrayList<>();
            lower.add(minBid);
            lower.add(minAsk);

            return Collections.min(lower);
        } else {
            return null;
        }
    }
}
