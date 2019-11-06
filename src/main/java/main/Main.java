package main;

import java.io.IOException;

import static utils.DataFromURL.readXMLToString;

public class Main {

    static public void main(String[] args) {
        try {
            String xml = readXMLToString("http://api.nbp.pl/api/exchangerates/rates/c/usd/today/?format=xml");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
