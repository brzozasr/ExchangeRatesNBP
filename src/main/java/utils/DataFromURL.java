package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DataFromURL {

    public static void readXMLToString() throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/chf/?format=xml");
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String l;
        while ((l=in.readLine())!=null) {
            System.out.println(l);
        }
    }
}
