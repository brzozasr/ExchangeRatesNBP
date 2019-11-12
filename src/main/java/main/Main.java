package main;

import enumtypes.CurrencyCodeTableA;
import http.TableA;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {
        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().currentExchangeRate(CurrencyCodeTableA.CHF);
            System.out.println(exchangeRatesSeries.getTable());
            System.out.println(exchangeRatesSeries.getCurrency());
            System.out.println(exchangeRatesSeries.getCode());
            System.out.println(exchangeRatesSeries.getRates().get(0).getNo());
            System.out.println(exchangeRatesSeries.getRates().get(0).getEffectiveDate());
            System.out.println(exchangeRatesSeries.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().lastTopCountExchangeRate(CurrencyCodeTableA.USD, 255);
            //System.out.println(exchangeRatesSeries.toString());
            System.out.println(exchangeRatesSeries.getTable());
            System.out.println(exchangeRatesSeries.getCurrency());
            System.out.println(exchangeRatesSeries.getCode());
            System.out.println(exchangeRatesSeries.getRates().get(0).getNo());
            System.out.println(exchangeRatesSeries.getRates().get(0).getEffectiveDate());
            System.out.println(exchangeRatesSeries.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ArrayOfExchangeRatesTable arrayOfExchangeRatesTable = new TableA().lastTopCountTables(2);
            //System.out.println(arrayOfExchangeRatesTable);
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getTable());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getNo());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getEffectiveDate());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCode());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
