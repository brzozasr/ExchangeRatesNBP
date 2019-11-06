package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpData {

    public static String readXMLToString(String xmlUrl) throws IOException {
        URL url = new URL(xmlUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String xmlLine;
            String xml = null;
            while ((xmlLine = in.readLine()) != null) {
                xml += xmlLine;
            }
            in.close();
            return xml;
        }
        httpURLConnection.disconnect();
        return "Response code: " + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage();

    }
}

