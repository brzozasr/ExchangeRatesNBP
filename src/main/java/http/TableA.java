package http;

import enumtypes.CurrencyCodeTableA;
import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static http.ReadHttpData.readJsonToString;
import static http.ReadJSON.*;

/**
 * Linki do kursów średnich walut obcych w złotych określonych w § 2 pkt 1 i 2 uchwały Nr 51/2002
 * Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie sposobu wyliczania
 * i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).
 * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
 */
public class TableA {

    /**
     * Aktualnie obowiązująca tabela kursów typu A
     *
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable currentTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu A
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable lastTopCountTables(int topCount) throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/last/" + topCount + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu A opublikowana w dniu dzisiejszym (albo brak danych).
     * Tabela A kursów średnich walut obcych aktualizowana jest w każdy dzień roboczy,
     * między godziną 11:45 a 12:15.
     *
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedTodayTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu A opublikowana w dniu {date} (albo brak danych).
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param date LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedOnDateTable(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/" + formatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria tabel kursów typu A opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93). Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param startDate LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @param endDate   LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedOnDateRangeTables(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/a/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Aktualnie obowiązujący kurs waluty {currencyCodeTableA} z tabeli kursów typu A
     *
     * @param currencyCodeTableA enum CurrencyCodeTableA (np. usd, gbp, chf)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries currentExchangeRate(CurrencyCodeTableA currencyCodeTableA) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} kursów waluty {currencyCodeTableA} z tabeli kursów typu A
     *
     * @param currencyCodeTableA enum CurrencyCodeTableA (np. usd, gbp, chf)
     * @param topCount           liczba określająca maksymalną liczność zwracanej serii danych
     *                           (limit wyników 255)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries lastTopCountExchangeRate(CurrencyCodeTableA currencyCodeTableA, int topCount) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/last/" + topCount + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Kurs waluty {currencyCodeTableA} z tabeli kursów typu A opublikowany w dniu dzisiejszym (albo brak danych).
     * Tabela A kursów średnich walut obcych aktualizowana jest w każdy dzień roboczy, między godziną 11:45 a 12:15.
     *
     * @param currencyCodeTableA enum CurrencyCodeTableA (np. usd, gbp, chf)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedTodayExchangeRate(CurrencyCodeTableA currencyCodeTableA) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/today/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Kurs waluty {currencyCodeTableA} z tabeli kursów typu A opublikowany w dniu {date} (albo brak danych).
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableA enum CurrencyCodeTableA (np. usd, gbp, chf)
     * @param date               LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedOnDateExchangeRate(CurrencyCodeTableA currencyCodeTableA, LocalDate date) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/" + formatDate + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Seria kursów waluty {currencyCodeTableA} z tabeli kursów typu A opublikowanych w zakresie dat od {startDate}
     * do {endDate} (albo brak danych), limit dni 367.
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableA enum CurrencyCodeTableA (np. usd, gbp, chf)
     * @param startDate          LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @param endDate            LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 01, 01)
     * @return objekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedOnDateRangeExchangeRate(CurrencyCodeTableA currencyCodeTableA, LocalDate startDate, LocalDate endDate) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ExchangeRatesSeries currencyExchangeRate(CurrencyCodeTableA currencyCodeTableA) throws IOException {
        String code = currencyCodeTableA.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.of(2002, 1, 2);
        LocalDate endDate = LocalDate.now();
        String jsonUrl = "";
        String json = "";
        String jsonTrim = "";

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        int counter = (int) Math.ceil((double) days / 367);

        LocalDate startDateUrl = startDate;
        LocalDate endDateUrl = startDateUrl.plusDays(367);

        for (int i = 0; i < counter; i++) {
            String startFormatDate = dateTimeFormatter.format(startDateUrl);
            String endFormatDate = dateTimeFormatter.format(endDateUrl);
            jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
            startDateUrl = startDateUrl.plusDays(368);
            if (i < counter - 2) {
                endDateUrl = startDateUrl.plusDays(367);
            } else {
                endDateUrl = LocalDate.now();
            }

            try {
                json = readJsonToString(jsonUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!json.startsWith("Response code:")) {
                int firstIndex = json.indexOf(":[");
                int lastIndex = json.indexOf("]}");
                json = json.substring(firstIndex + 2, lastIndex);
                jsonTrim = jsonTrim.concat(json).concat(",");
            }
        }

        if (jsonTrim.endsWith(",")) {
            jsonTrim = jsonTrim.substring(0, jsonTrim.length() - 1);
        }

        jsonTrim = "{\"rates\":[" + jsonTrim + "]}";

        return readMultiExchangeRatesSeries(jsonTrim);
    }
}
