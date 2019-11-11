package main;

import enumtypes.CurrencyCode;
import http.TableA;
import http.ReadJSON;
import models.rates.ExchangeRatesSeries;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {
        try {
            String json = new TableA().currentExchangeRate(CurrencyCode.USD);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ExchangeRatesSeries exchangeRatesSeries = new TableA().lastTopCountExchangeRate(CurrencyCode.USD, 256);
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
    }
}
