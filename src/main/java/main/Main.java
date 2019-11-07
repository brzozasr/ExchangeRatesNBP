package main;

import java.io.IOException;

import static http.ReadHttpData.readXMLToString;

public class Main {

    static public void main(String[] args) {
        try {
            String xml = readXMLToString("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2013-01-02/?format=xml");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
