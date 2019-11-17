package main;

import enumtypes.CurrencyCodeTableA;
import http.TableA;
import http.TableB;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    static public void main(String[] args) {
/*

        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().currencyExchangeRate(CurrencyCodeTableA.USD);
            System.out.println(exchangeRatesSeries.getTable());
            System.out.println(exchangeRatesSeries.getCurrency());
            System.out.println(exchangeRatesSeries.getCode());
            for(int i = 0; i < exchangeRatesSeries.getRates().size(); i++) {
                System.out.println(exchangeRatesSeries.getRates().get(i).getNo() + " <-> " + exchangeRatesSeries.getRates().get(i).getEffectiveDate() +
                " <-> " + exchangeRatesSeries.getRates().get(i).getMid());
            }
            //System.out.println(exchangeRatesSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        try {
            ArrayOfExchangeRatesTable arrayOfExchangeRatesTable = new TableA().publishedOnDateRangeTables(LocalDate.of(2002, 1, 2),
                    LocalDate.of(2002, 04, 5));
            for(int i = 0; i < arrayOfExchangeRatesTable.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCountry());
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getSymbol());
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCurrency());
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCode());
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getTable());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getNo());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getEffectiveDate());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCountry());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCode());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getMid());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getCurrency());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getCountry());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getCode());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getMid());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getCurrency());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getCountry());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getCode());
//            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getMid());
//            System.out.println(arrayOfExchangeRatesTable);
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().publishedOnDateRangeExchangeRate(CurrencyCodeTableA.USD,
                    LocalDate.of(2002, 01, 02), LocalDate.of(2003, 01, 04));
            //System.out.println(exchangeRatesSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
       /* try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().publishedOnDateExchangeRate(CurrencyCodeTableA.USD,
                    LocalDate.of(2002, 01, 03));
            System.out.println(exchangeRatesSeries.getTable());
            System.out.println(exchangeRatesSeries.getCurrency());
            System.out.println(exchangeRatesSeries.getCode());
            System.out.println(exchangeRatesSeries.getRates().get(0).getNo());
            System.out.println(exchangeRatesSeries.getRates().get(0).getEffectiveDate());
            System.out.println(exchangeRatesSeries.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
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
        }*/

       /* try {
            ArrayOfExchangeRatesTable arrayOfExchangeRatesTable = new TableA().publishedOnDateTable(LocalDate.of(2002, 01, 04));
            //System.out.println(arrayOfExchangeRatesTable);
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getTable());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getNo());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getEffectiveDate());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCurrency());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getCode());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(0).getMid());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getCurrency());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getCode());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(1).getMid());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getCurrency());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getCode());
            System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(0).getRates().get(2).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
