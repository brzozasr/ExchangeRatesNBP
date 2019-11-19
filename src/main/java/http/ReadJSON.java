package http;

import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.rates.Rate;
import models.ratesc.ExchangeRatesSeriesC;
import models.ratesc.RateC;
import models.tablec.ArrayOfExchangeRatesTableC;
import models.tablec.ExchangeRatesTableC;
import models.tablec.RateTablesC;
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

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONObject jsonObject = new JSONObject(json);

            String table = jsonObject.getString("table");
            String country = null;
            if (jsonObject.has("country")) {
                country = jsonObject.getString("country");
            }
            String symbol = null;
            if (jsonObject.has("symbol")) {
                symbol = jsonObject.getString("symbol");
            }
            String currency = null;
            if (jsonObject.has("currency")) {
                currency = jsonObject.getString("currency");
            }
            String code = jsonObject.getString("code");
            JSONArray rates = jsonObject.getJSONArray("rates");

            List<Rate> rateArrayList = new ArrayList<>();

            for (int i = 0; i < rates.length(); i++) {
                String no = rates.getJSONObject(i).getString("no");
                String effectiveDate = rates.getJSONObject(i).getString("effectiveDate");
                double mid = rates.getJSONObject(i).getDouble("mid");
                rateArrayList.add(new Rate(no, effectiveDate, mid));
            }
            return new ExchangeRatesSeries(table, country, symbol, currency, code, rateArrayList);
        }
    }

    /**
     * Metoda odczytuje dane z linka {jsonUrl} i dodaje je do obiektu {ExchangeRatesSeriesC}
     *
     * @param jsonUrl link (url), z którego pobierane są dane w formie JSON
     * @return obiekt {ExchangeRatesSeriesC}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ExchangeRatesSeriesC readExchangeRatesSeriesC(String jsonUrl) throws IOException, NBPDataException {

        String json = readJsonToString(jsonUrl);

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONObject jsonObject = new JSONObject(json);

            String table = jsonObject.getString("table");
            String country = null;
            if (jsonObject.has("country")) {
                country = jsonObject.getString("country");
            }
            String symbol = null;
            if (jsonObject.has("symbol")) {
                symbol = jsonObject.getString("symbol");
            }
            String currency = null;
            if (jsonObject.has("currency")) {
                currency = jsonObject.getString("currency");
            }
            String code = jsonObject.getString("code");
            JSONArray rates = jsonObject.getJSONArray("rates");

            List<RateC> rateArrayList = new ArrayList<>();

            for (int i = 0; i < rates.length(); i++) {
                String no = rates.getJSONObject(i).getString("no");
                String effectiveDate = rates.getJSONObject(i).getString("effectiveDate");
                double bid = rates.getJSONObject(i).getDouble("bid");
                double ask = rates.getJSONObject(i).getDouble("ask");
                rateArrayList.add(new RateC(no, effectiveDate, bid, ask));
            }
            return new ExchangeRatesSeriesC(table, country, symbol, currency, code, rateArrayList);
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
     * Metoda odczytuje dane z formatu JSON {json} i dodaje je do obiektu {ExchangeRatesSeriesC}
     *
     * @param json dane w formacie JSON
     * @return obiekt {ExchangeRatesSeriesC}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ExchangeRatesSeriesC readMultiExchangeRatesSeriesC(String json) throws IOException, NBPDataException {

        if (json.equals("")) {
            throw new NBPDataException("Response code: 404 - Not Found - Brak danych");
        } else {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray rates = jsonObject.getJSONArray("rates");

            List<RateC> rateArrayList = new ArrayList<>();

            for (int i = 0; i < rates.length(); i++) {
                String no = rates.getJSONObject(i).getString("no");
                String effectiveDate = rates.getJSONObject(i).getString("effectiveDate");
                double bid = rates.getJSONObject(i).getDouble("bid");
                double ask = rates.getJSONObject(i).getDouble("ask");
                rateArrayList.add(new RateC(no, effectiveDate, bid, ask));
            }
            return new ExchangeRatesSeriesC(rateArrayList);
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

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONArray arrayOfExchangeRatesTable = new JSONArray(json);

            List<ExchangeRatesTable> listExchangeRatesTables = new ArrayList<>();

            for (int i = 0; i < arrayOfExchangeRatesTable.length(); i++) {
                String table = arrayOfExchangeRatesTable.getJSONObject(i).getString("table");
                String no = arrayOfExchangeRatesTable.getJSONObject(i).getString("no");
                String effectiveDate = arrayOfExchangeRatesTable.getJSONObject(i).getString("effectiveDate");
                JSONArray arrayRatesTables = arrayOfExchangeRatesTable.getJSONObject(i).getJSONArray("rates");
                List<RateTables> listRateTables = new ArrayList<>();

                for (int j = 0; j < arrayRatesTables.length(); j++) {
                    String country = null;
                    if (arrayRatesTables.getJSONObject(j).has("country")) {
                        country = arrayRatesTables.getJSONObject(j).getString("country");
                    }
                    String symbol = null;
                    if (arrayRatesTables.getJSONObject(j).has("symbol")) {
                        symbol = arrayRatesTables.getJSONObject(j).getString("symbol");
                    }
                    String currency = null;
                    if (arrayRatesTables.getJSONObject(j).has("currency")) {
                        currency = arrayRatesTables.getJSONObject(j).getString("currency");
                    }
                    String code = arrayRatesTables.getJSONObject(j).getString("code");
                    double mid = arrayRatesTables.getJSONObject(j).getDouble("mid");
                    listRateTables.add(new RateTables(country, symbol, currency, code, mid));
                }
                listExchangeRatesTables.add(new ExchangeRatesTable(table, no, effectiveDate, listRateTables));
            }
            return new ArrayOfExchangeRatesTable(listExchangeRatesTables);
        }
    }

    /**
     * Metoda odczytuje dane z linka {jsonUrl} i dodaje je do obiektu {ArrayOfExchangeRatesTableC}
     *
     * @param jsonUrl link (url), z którego pobierane są dane w formie JSON
     * @return obiekt {ArrayOfExchangeRatesTableC}
     * @throws IOException      input / output exception (wyjątek)
     * @throws NBPDataException wyjątek zwracany przez stronę NBP
     */
    static ArrayOfExchangeRatesTableC readArrayOfExchangeRatesTableC(String jsonUrl) throws IOException, NBPDataException {

        String json = readJsonToString(jsonUrl);

        if (json.startsWith("Response code:")) {
            throw new NBPDataException(json);
        } else {
            JSONArray arrayOfExchangeRatesTableC = new JSONArray(json);

            List<ExchangeRatesTableC> listExchangeRatesTablesC = new ArrayList<>();

            for (int i = 0; i < arrayOfExchangeRatesTableC.length(); i++) {
                String table = arrayOfExchangeRatesTableC.getJSONObject(i).getString("table");
                String no = arrayOfExchangeRatesTableC.getJSONObject(i).getString("no");
                String tradingDate = arrayOfExchangeRatesTableC.getJSONObject(i).getString("tradingDate");
                String effectiveDate = arrayOfExchangeRatesTableC.getJSONObject(i).getString("effectiveDate");
                JSONArray arrayRatesTables = arrayOfExchangeRatesTableC.getJSONObject(i).getJSONArray("rates");
                List<RateTablesC> listRateTablesC = new ArrayList<>();

                for (int j = 0; j < arrayRatesTables.length(); j++) {
                    String country = null;
                    if (arrayRatesTables.getJSONObject(j).has("country")) {
                        country = arrayRatesTables.getJSONObject(j).getString("country");
                    }
                    String symbol = null;
                    if (arrayRatesTables.getJSONObject(j).has("symbol")) {
                        symbol = arrayRatesTables.getJSONObject(j).getString("symbol");
                    }
                    String currency = null;
                    if (arrayRatesTables.getJSONObject(j).has("currency")) {
                        currency = arrayRatesTables.getJSONObject(j).getString("currency");
                    }
                    String code = arrayRatesTables.getJSONObject(j).getString("code");
                    double bid = arrayRatesTables.getJSONObject(j).getDouble("bid");
                    double ask = arrayRatesTables.getJSONObject(j).getDouble("ask");
                    listRateTablesC.add(new RateTablesC(country, symbol, currency, code, bid, ask));
                }
                listExchangeRatesTablesC.add(new ExchangeRatesTableC(table, no, tradingDate, effectiveDate, listRateTablesC));
            }
            return new ArrayOfExchangeRatesTableC(listExchangeRatesTablesC);
        }
    }
}
