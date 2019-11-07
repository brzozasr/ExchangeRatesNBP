package main;

import http.LinksTableA;

import java.io.IOException;
import java.time.LocalDate;

import static http.ReadHttpData.readXMLToString;

public class Main {

    static public void main(String[] args) {
        try {
            String xml = readXMLToString(new LinksTableA().lastTopCountTables(68));
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
