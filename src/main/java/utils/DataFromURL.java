package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipFile;

public class DataFromURL {

    private static String readXMLToString(String xmlUrl) throws IOException {
        URL url = new URL(xmlUrl);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String xmlLine;
        String xml = null;
        while ((xmlLine = in.readLine()) != null) {
            xml = xml + xmlLine;
        }
        in.close();

        return xml;
    }

    public static String getXml(String xmlUrl) throws IOException, IncorrectXmlException {
        String xml = readXMLToString(xmlUrl);

        if (xml.contains("404 Not Found")) {
            throw new IncorrectXmlException("404 Not Found");
        } else if(xml.contains("400 Bad Request")) {
            throw new IncorrectXmlException("400 Bad Request");
        } else if(xml.contains("400 Bad Request - Przekroczony limit 93 dni")) {
            throw new IncorrectXmlException("400 Bad Request - Przekroczony limit 93 dni / Limit of 93 days has been exceeded");
        } else if(xml.contains("400 BadRequest - Przekroczony limit 367 dni")) {
            throw new IncorrectXmlException("400 BadRequest - Przekroczony limit 367 dni / Limit of 367 days has been exceeded");
        }else {
            return xml;
        }
    }
}

