package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class ReadHttpData {

    /**
     * @param jsonUrl
     * @return
     * @throws IOException
     */
    static String readJsonToString(String jsonUrl) throws IOException {
        URL url = new URL(jsonUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        if (httpURLConnection.getResponseCode() == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String jsonLine;
            String json = "";
            while ((jsonLine = in.readLine()) != null) {
                json += jsonLine;
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

