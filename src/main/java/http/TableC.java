package http;

import enumtypes.CurrencyCodeTableB;
import enumtypes.CurrencyCodeTableC;
import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.ratesc.ExchangeRatesSeriesC;
import models.tablec.ArrayOfExchangeRatesTableC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static http.ReadHttpData.readJsonToString;
import static http.ReadJSON.*;

/**
 * Kursy kupna i sprzedaży walut obcych za złote określonych w § 5 uchwały
 * Nr 51/2002 Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie
 * sposobu wyliczania i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).<br>
 * Tabela C kursów kupna i sprzedaży walut obcych oraz tabela kursów jednostek rozliczeniowych
 * aktualizowane są w każdy dzień roboczy, między godziną 7:45 a 8:15.<br>
 * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.<br>
 * Dane kursów walut udostępniane są na dwa sposoby:<br>
 * - jako kompletna tabela kursów (lub seria tabel kursowych) - typu C {ArrayOfExchangeRatesTableC},<br>
 * - jako kurs (lub seria kursów) pojedynczej waluty dla tabeli typu C {ExchangeRatesSeriesC}.
 */
public class TableC {
    /**
     * Aktualnie obowiązująca tabela kursów typu C
     *
     * @return objekt ArrayOfExchangeRatesTableC
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTableC currentTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/c/?format=json";
        try {
            return readArrayOfExchangeRatesTableC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu C
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return obiekt ArrayOfExchangeRatesTableC
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTableC lastTopCountTables(int topCount) throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/c/last/" + topCount + "/?format=json";
        try {
            return readArrayOfExchangeRatesTableC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu A opublikowana w dniu dzisiejszym (albo brak danych).<br>
     * Tabela C kursów kupna i sprzedaży walut obcych oraz tabela kursów jednostek
     * rozliczeniowych aktualizowane są w każdy dzień roboczy, między godziną 7:45 a 8:15.
     *
     * @return obiekt ArrayOfExchangeRatesTableC
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTableC publishedTodayTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/c/today/?format=json";
        try {
            return readArrayOfExchangeRatesTableC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu C opublikowana w dniu {date} (albo brak danych).
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param date LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ArrayOfExchangeRatesTableC
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTableC publishedOnDateTable(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/c/" + formatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTableC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria tabel kursów typu C opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93). Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param startDate LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @param endDate   LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 2, 1)
     * @return obiekt ArrayOfExchangeRatesTableC
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTableC publishedOnDateRangeTables(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/c/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTableC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Aktualnie obowiązujący kurs kupna i sprzedaży waluy obcej {currencyCodeTableC} z tabeli kursów typu C
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. USD, EUR)
     * @return obiekt ExchangeRatesSeriesC
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC currentExchangeRate(CurrencyCodeTableC currencyCodeTableC) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/?format=json";
        try {
            return readExchangeRatesSeriesC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatniego {topCount} kursu kupna i sprzedaży waluty obcej {currencyCodeTableC} z tabeli kursów typu C
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. USD, EUR)
     * @param topCount           liczba określająca maksymalną liczność zwracanej serii danych
     *                           (limit wyników 255)
     * @return obiekt ExchangeRatesSeriesC
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC lastTopCountExchangeRate(CurrencyCodeTableC currencyCodeTableC, int topCount) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/last/" + topCount + "/?format=json";
        try {
            return readExchangeRatesSeriesC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Kurs kupna i sprzedaży waluty {currencyCodeTableC} z tabeli kursów typu C opublikowany
     * w dniu dzisiejszym (albo brak danych).<br>
     * Tabela C kursów kupna i sprzedaży walut obcych oraz tabela kursów jednostek rozliczeniowych
     * aktualizowane są w każdy dzień roboczy, między godziną 7:45 a 8:15.
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. USD, EUR)
     * @return obiekt ExchangeRatesSeriesC
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC publishedTodayExchangeRate(CurrencyCodeTableC currencyCodeTableC) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/today/?format=json";
        try {
            return readExchangeRatesSeriesC(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Kurs kupna i sprzedaży waluty {currencyCodeTableC} z tabeli kursów typu C opublikowany w dniu {date} (albo brak danych).<br>
     * Tabela C kursów kupna i sprzedaży walut obcych oraz tabela kursów jednostek rozliczeniowych
     * aktualizowane są w każdy dzień roboczy, między godziną 7:45 a 8:15.<br>
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. UAH, SCR, ILS)
     * @param date               LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC publishedOnDateExchangeRate(CurrencyCodeTableC currencyCodeTableC, LocalDate date) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/" + formatDate + "/?format=json";
        try {
            return readExchangeRatesSeriesC(jsonUrl);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria kursu kupna i sprzedaży waluty {currencyCodeTableC} z tabeli kursów typu C opublikowanych
     * w zakresie dat od {startDate} do {endDate} (albo brak danych), limit dni 367.<br>
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. USD, EUR)
     * @param startDate          LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @param endDate            LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 2, 1)
     * @return obiekt ExchangeRatesSeriesC
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC publishedOnDateRangeExchangeRate(CurrencyCodeTableC currencyCodeTableC, LocalDate startDate, LocalDate endDate) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readExchangeRatesSeriesC(jsonUrl);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria kursu kupna i sprzedaży waluty {currencyCodeTableC} z tabeli kursów typu C
     * od 2 stycznia 2002 r. do bieżącej daty.<br>
     * Archiwalne dane dla kursów walut dostępne są od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableC enum CurrencyCodeTableC (np. USD, EUR)
     * @return obiekt ExchangeRatesSeriesC
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeriesC currencyExchangeRate(CurrencyCodeTableC currencyCodeTableC) throws IOException {
        String code = currencyCodeTableC.toString().toLowerCase();
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
            jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/c/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
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

            if (!json.startsWith("Response code:")) {
                int firstIndex = json.indexOf(":[");
                int lastIndex = json.indexOf("]}");
                json = json.substring(firstIndex + 2, lastIndex);
                jsonTrim = jsonTrim.concat(json).concat(",");
            }
        }

        if (jsonTrim.endsWith(",")) {
            jsonTrim = jsonTrim.substring(0, jsonTrim.length() - 1);
        }

        if (!jsonTrim.equals("")) {
            jsonTrim = "{\"rates\":[" + jsonTrim + "]}";
        }

        try {
            return readMultiExchangeRatesSeriesC(jsonTrim);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
