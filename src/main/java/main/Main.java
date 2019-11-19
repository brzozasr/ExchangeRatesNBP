package main;

import enumtypes.CurrencyCodeTableC;
import http.TableA;
import http.TableC;
import models.ratesc.ExchangeRatesSeriesC;
import models.tablec.ArrayOfExchangeRatesTableC;
import models.tablec.ExchangeRatesTableC;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    static public void main(String[] args) {

        try {
            ExchangeRatesSeriesC exchangeRatesTableC = new TableC().currencyExchangeRate(CurrencyCodeTableC.EUR);
            System.out.println(exchangeRatesTableC.getTable());
            System.out.println(exchangeRatesTableC.getCountry());
            System.out.println(exchangeRatesTableC.getSymbol());
            System.out.println(exchangeRatesTableC.getCurrency());
            System.out.println(exchangeRatesTableC.getCode());
            for (int i = 0; i < exchangeRatesTableC.getRates().size(); i++) {
                System.out.println(exchangeRatesTableC.getRates().get(i).getNo() + " <-> " + exchangeRatesTableC.getRates().get(i).getEffectiveDate() +
                        " <-> " + exchangeRatesTableC.getRates().get(i).getBid() + " <-> " + exchangeRatesTableC.getRates().get(i).getAsk());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            ArrayOfExchangeRatesTableC arrayOfExchangeRatesTableC = new TableC().publishedOnDateRangeTables(LocalDate.of(2002, 1, 4),
                    LocalDate.of(2002, 3, 10));
            for (int i = 0; i < arrayOfExchangeRatesTableC.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getTradingDate());
                System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getBid() + " - " +
                            arrayOfExchangeRatesTableC.getExchangeRatesTables().get(i).getRates().get(j).getAsk());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
/*
        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().currencyExchangeRate(CurrencyCodeTableA.GBP);
            System.out.println(exchangeRatesSeries.getTable());
            System.out.println(exchangeRatesSeries.getCountry());
            System.out.println(exchangeRatesSeries.getSymbol());
            System.out.println(exchangeRatesSeries.getCurrency());
            System.out.println(exchangeRatesSeries.getCode());
            for (int i = 0; i < exchangeRatesSeries.getRates().size(); i++) {
                System.out.println(exchangeRatesSeries.getRates().get(i).getNo() + " <-> " + exchangeRatesSeries.getRates().get(i).getEffectiveDate() +
                        " <-> " + exchangeRatesSeries.getRates().get(i).getMid());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
/*
        try {
            ArrayOfExchangeRatesTable arrayOfExchangeRatesTable = new TableA().lastTopCountTables(30);

            for (int i = 0; i < arrayOfExchangeRatesTable.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                            arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                            arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                            arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                            arrayOfExchangeRatesTable.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

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
