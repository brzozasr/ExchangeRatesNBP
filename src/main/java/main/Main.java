package main;

import enumtypes.CurrencyCodeTableA;
import http.TableA;
import models.rates.ExchangeRatesSeries;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startDate = LocalDate.of(2002, 1, 2);
//        LocalDate endDate = LocalDate.now();
//        String jsonUrl = "";
//        String json = "";
//        String jsonTrim = "";
//
//        long days = ChronoUnit.DAYS.between(startDate, endDate);
//        int counter = (int) Math.ceil((double) days / 367);
//
//        LocalDate startDateUrl = startDate;
//        LocalDate endDateUrl = startDateUrl.plusDays(367);
//
//        for (int i = 0; i < counter; i++) {
//            String startFormatDate = dateTimeFormatter.format(startDateUrl);
//            String endFormatDate = dateTimeFormatter.format(endDateUrl);
//            jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/usd/" + startFormatDate + "/" + endFormatDate + "/?format=json";
//            startDateUrl = startDateUrl.plusDays(368);
//            if (i < counter - 2) {
//                endDateUrl = startDateUrl.plusDays(367);
//            } else {
//                endDateUrl = LocalDate.now();
//            }
//
//            try {
//                json = readJsonToString(jsonUrl);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if(!json.startsWith("Response code:")) {
//                int firstIndex = json.indexOf(":[");
//                int lastIndex = json.indexOf("]}");
//                json = json.substring(firstIndex + 2, lastIndex);
//                jsonTrim = jsonTrim.concat(json).concat(",");
//            }
//        }
//
//        if (jsonTrim.endsWith(",")) {
//            jsonTrim = jsonTrim.substring(0, jsonTrim.length() - 1);
//        }
//
//        jsonTrim = "{\"rates\":[" + jsonTrim + "]}";
//
//        System.out.println(jsonTrim.length());
//        System.out.println(jsonTrim);

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
