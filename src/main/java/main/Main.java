package main;

import enumtypes.CurrencyCode;
import http.LinksTableA;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {
        try {
            String json = new LinksTableA().currentTable();
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
