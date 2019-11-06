package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DataFromURL {

    public static String readXMLToString(String xmlUrl) throws IOException {
        URL url = new URL(xmlUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String xmlLine;
        String xml = null;
        while ((xmlLine=in.readLine())!=null) {
            xml = xml + xmlLine;
        }
        return xml;
    }
}

