package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class ReadHttpData {

    /**
     * Metoda odczytuje dane z linka {jsonUrl} i zwraca je w postaci JSON.
     *
     * @param jsonUrl link (url) z którego pobierane są dane w formie JSON
     * @return dane w formacie JSON, jeżeli są niedostępne to zwraca kod i wiadomość błędu
     * @throws IOException input / output exception (wyjątek)
     */
    static String readJsonToString(String jsonUrl) throws IOException {
        URL url = new URL(jsonUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String jsonLine;
            String json = "";
            while ((jsonLine = in.readLine()) != null) {
                json = json.concat(jsonLine);
            }
            in.close();
            httpURLConnection.disconnect();
            return json;
        } else {
            httpURLConnection.disconnect();
            return "Response code: " + httpURLConnection.getResponseCode() + " - " + httpURLConnection.getResponseMessage();
        }
    }
}

