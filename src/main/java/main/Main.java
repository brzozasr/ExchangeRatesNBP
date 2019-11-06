package main;

import java.io.IOException;

import static utils.DataFromURL.readXMLToString;

public class Main {

    static public void main(String[] args) {
        try {
            readXMLToString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
