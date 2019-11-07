package main;

import http.LinksTableA;

import java.io.IOException;

public class Main {

    static public void main(String[] args) {
        try {
            String xml = new LinksTableA().lastTopCountTables(10);
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
