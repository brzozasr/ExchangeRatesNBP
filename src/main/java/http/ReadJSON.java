package http;

import models.rates.ExchangeRatesSeries;
import models.rates.Rate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static http.ReadHttpData.readJsonToString;

public class ReadJSON {

    public ExchangeRatesSeries readExchangeRatesSeries() throws IOException {

        JSONObject jsonObject = new JSONObject(readJsonToString("http://api.nbp.pl/api/exchangerates/rates/a/usd/last/5/"));

        String table = jsonObject.getString("table");
        String currency = jsonObject.getString("currency");
        String code = jsonObject.getString("code");
        JSONArray rates = jsonObject.getJSONArray("rates");

        List<Rate> rateArrayList = new ArrayList<>();

        for (int i = 0; i < rates.length(); i++) {
            String no = rates.getJSONObject(i).getString("no");
            String effectiveDate = rates.getJSONObject(i).getString("effectiveDate");
            double mid = rates.getJSONObject(i).getDouble("mid");
            rateArrayList.add(new Rate(no, effectiveDate, mid));
        }

        return new ExchangeRatesSeries(table, currency, code, rateArrayList);
    }
}
