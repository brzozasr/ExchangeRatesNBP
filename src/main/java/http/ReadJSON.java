package http;

import models.rates.ExchangeRatesSeries;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static http.ReadHttpData.readJsonToString;

public class ReadJSON {

    public ExchangeRatesSeries readRates() throws IOException {

        JSONObject jsonObject = new JSONObject(readJsonToString("http://api.nbp.pl/api/exchangerates/rates/a/usd/last/5/"));

        String table = jsonObject.getString("table");
        String currency = jsonObject.getString("currency");
        String code = jsonObject.getString("code");
        //JSONArray rates = jsonObject.getJSONArray("rates");

        ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries(table, currency, code);

        return exchangeRatesSeries;
    }
}
