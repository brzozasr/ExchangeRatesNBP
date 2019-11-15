package http;

import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.rates.Rate;
import models.tables.ArrayOfExchangeRatesTable;
import models.tables.ExchangeRatesTable;
import models.tables.RateTables;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static http.ReadHttpData.readJsonToString;

class ReadJSON {

    /**
     * Metoda odczytuje dane z linka {jsonUrl} i dodaje je do obiektu {ExchangeRatesSeries}
     *
     * @param jsonUrl link (url), z którego pobierane są dane w formie JSON
     * @return obiekt {ExchangeRatesSeries}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ExchangeRatesSeries readExchangeRatesSeries(String jsonUrl) throws IOException, NBPDataException {

        String json = readJsonToString(jsonUrl);

        if (json.contains("country")) {
            json = json.replaceAll("country", "currency");
        }

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONObject jsonObject = new JSONObject(json);

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

    /**
     * Metoda odczytuje dane z formatu JSON {json} i dodaje je do obiektu {ExchangeRatesSeries}
     *
     * @param json dane w formacie JSON
     * @return obiekt {ExchangeRatesSeries}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ExchangeRatesSeries readMultiExchangeRatesSeries(String json) throws IOException, NBPDataException {

        if (json.equals("")) {
            throw new NBPDataException("Response code: 404 - Not Found - Brak danych");
        } else {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray rates = jsonObject.getJSONArray("rates");

            List<Rate> rateArrayList = new ArrayList<>();

            for (int i = 0; i < rates.length(); i++) {
                String no = rates.getJSONObject(i).getString("no");
                String effectiveDate = rates.getJSONObject(i).getString("effectiveDate");
                double mid = rates.getJSONObject(i).getDouble("mid");
                rateArrayList.add(new Rate(no, effectiveDate, mid));
            }

            return new ExchangeRatesSeries(rateArrayList);
        }
    }

    /**
     * Metoda odczytuje dane z linka {jsonUrl} i dodaje je do obiektu {ArrayOfExchangeRatesTable}
     *
     * @param jsonUrl link (url), z którego pobierane są dane w formie JSON
     * @return obiekt {ArrayOfExchangeRatesTable}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ArrayOfExchangeRatesTable readArrayOfExchangeRatesTable(String jsonUrl) throws IOException, NBPDataException {

        String json = readJsonToString(jsonUrl);

        if (json.contains("country")) {
            json = json.replaceAll("country", "currency");
        }

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONArray arrayOfExchangeRatesTable = new JSONArray(json);

            List<ExchangeRatesTable> listExchangeRatesTables = new ArrayList<>();
            List<RateTables> listRateTables = new ArrayList<>();

            for (int i = 0; i < arrayOfExchangeRatesTable.length(); i++) {
                String table = arrayOfExchangeRatesTable.getJSONObject(i).getString("table");
                String no = arrayOfExchangeRatesTable.getJSONObject(i).getString("no");
                String effectiveDate = arrayOfExchangeRatesTable.getJSONObject(i).getString("effectiveDate");
                JSONArray arrayRatesTables = arrayOfExchangeRatesTable.getJSONObject(i).getJSONArray("rates");
                for (int j = 0; j < arrayRatesTables.length(); j++) {
                    String currency = arrayRatesTables.getJSONObject(j).getString("currency");
                    String code = arrayRatesTables.getJSONObject(j).getString("code");
                    double mid = arrayRatesTables.getJSONObject(j).getDouble("mid");
                    listRateTables.add(new RateTables(currency, code, mid));
                }
                listExchangeRatesTables.add(new ExchangeRatesTable(table, no, effectiveDate, listRateTables));
            }

            return new ArrayOfExchangeRatesTable(listExchangeRatesTables);
        }
    }
}
