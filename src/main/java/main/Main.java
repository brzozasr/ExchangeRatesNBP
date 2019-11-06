package main;

import utils.IncorrectXmlException;

import java.io.IOException;

import static utils.DataFromURL.getXml;

public class Main {

    static public void main(String[] args) {
        try {
            String xml = getXml("http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2013-12-31/");
            System.out.println(xml);
        } catch (IncorrectXmlException | IOException e) {
            e.printStackTrace();
        }

    }
}
