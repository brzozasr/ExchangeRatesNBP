package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DataFromURL {

    public static void readXMLToString(String xmlUrl) throws IOException {
        URL url = new URL(xmlUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String xml;
        while ((xml=in.readLine())!=null) {
            System.out.println(xml);
        }
    }
}

