package main;

import enumtypes.CurrencyCodeTableA;
import http.TableA;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    static public void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.of(2002, 01, 02);
        LocalDate endDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        int counter = (int) Math.ceil((double) days / 367);

        LocalDate startDateUrl = startDate;
        LocalDate endDateUrl = startDateUrl.plusDays(367);

        for (int i = 0; i < counter; i++) {
            String startFormatDate = dateTimeFormatter.format(startDateUrl);
            String endFormatDate = dateTimeFormatter.format(endDateUrl);
            System.out.println("http://api.nbp.pl/api/exchangerates/rates/a/usd/" + startFormatDate + "/" + endFormatDate + "/?format=json");
            startDateUrl = startDateUrl.plusDays(368);
            if (i < counter - 2) {
                endDateUrl = startDateUrl.plusDays(367);
            } else {
                endDateUrl = LocalDate.now();
            }
        }


        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().publishedOnDateRangeExchangeRate(CurrencyCodeTableA.USD,
                    LocalDate.of(2002, 01, 02), LocalDate.of(2003, 01, 04));
            //System.out.println(exchangeRatesSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
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
        }
    }
}
