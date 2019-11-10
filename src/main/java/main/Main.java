package main;

import enumtypes.CurrencyCode;
import http.LinksTableA;
import http.ReadJSON;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {
        try {
            String json = new LinksTableA().lastTopCountExchangeRate(CurrencyCode.USD, 5);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(new ReadJSON().readExchangeRatesSeries().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
