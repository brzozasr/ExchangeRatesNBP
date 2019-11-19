package http;

import enumtypes.CurrencyCodeTableB;
import exceptions.NBPDataException;
import models.rates.ExchangeRatesSeries;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static http.ReadHttpData.readJsonToString;
import static http.ReadJSON.*;

/**
 * kursy średnie walut obcych w złotych określonych w § 2 pkt 3 i § 3 uchwały Nr 51/2002
 * Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie sposobu wyliczania
 * i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).<br>
 * Tabela B kursów średnich walut obcych aktualizowana jest w każdą środę (jeżeli środa jest
 * dniem wolnym od pracy, aktualizacja odbywa się poprzedniego dnia), między godziną 11:45 a 12:15.<br>
 * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.<br>
 * Dane kursów walut udostępniane są na dwa sposoby:<br>
 * - jako kompletna tabela kursów (lub seria tabel kursowych) - typu B {ArrayOfExchangeRatesTable},<br>
 * - jako kurs (lub seria kursów) pojedynczej waluty dla tabeli typu B {ExchangeRatesSeries}.
 */
public class TableB {
    /**
     * Aktualnie obowiązująca tabela kursów typu B
     *
     * @return objekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable currentTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/b/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu B
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 14)
     * @return obiekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable lastTopCountTables(int topCount) throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/b/last/" + topCount + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu B opublikowana w dniu dzisiejszym (albo brak danych).<br>
     * Tabela B kursów średnich walut obcych aktualizowana jest w każdą środę (jeżeli środa jest
     * dniem wolnym od pracy, aktualizacja odbywa się poprzedniego dnia), między godziną 11:45 a 12:15.
     *
     * @return obiekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedTodayTable() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/b/today/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tabela kursów typu B opublikowana w dniu {date} (albo brak danych).
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param date LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedOnDateTable(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/b/" + formatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria tabel kursów typu B opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93). Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param startDate LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @param endDate   LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ArrayOfExchangeRatesTable
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfExchangeRatesTable publishedOnDateRangeTables(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/tables/b/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readArrayOfExchangeRatesTable(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Aktualnie obowiązujący kurs waluty {currencyCodeTableB} z tabeli kursów typu B
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries currentExchangeRate(CurrencyCodeTableB currencyCodeTableB) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} kursów waluty {currencyCodeTableB} z tabeli kursów typu B
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @param topCount           liczba określająca maksymalną liczność zwracanej serii danych
     *                           (limit wyników 255)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries lastTopCountExchangeRate(CurrencyCodeTableB currencyCodeTableB, int topCount) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/last/" + topCount + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Kurs waluty {currencyCodeTableB} z tabeli kursów typu B opublikowany w dniu dzisiejszym (albo brak danych).<br>
     * Tabela B kursów średnich walut obcych aktualizowana jest w każdą środę (jeżeli środa jest
     * dniem wolnym od pracy, aktualizacja odbywa się poprzedniego dnia), między godziną 11:45 a 12:15.
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedTodayExchangeRate(CurrencyCodeTableB currencyCodeTableB) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/today/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Kurs waluty {currencyCodeTableB} z tabeli kursów typu B opublikowany w dniu {date} (albo brak danych).<br>
     * Tabela B kursów średnich walut obcych aktualizowana jest w każdą środę (jeżeli środa jest
     * dniem wolnym od pracy, aktualizacja odbywa się poprzedniego dnia), między godziną 11:45 a 12:15.<br>
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @param date               LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedOnDateExchangeRate(CurrencyCodeTableB currencyCodeTableB, LocalDate date) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/" + formatDate + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria kursów waluty {currencyCodeTableB} z tabeli kursów typu B opublikowanych w zakresie dat od {startDate}
     * do {endDate} (albo brak danych), limit dni 367.<br>
     * Dane archiwalne dostępne są dla kursów walut – od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @param startDate          LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @param endDate            LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2010, 1, 1)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries publishedOnDateRangeExchangeRate(CurrencyCodeTableB currencyCodeTableB, LocalDate startDate, LocalDate endDate) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readExchangeRatesSeries(jsonUrl);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria kursów waluty {currencyCodeTableB} z tabeli kursów typu B
     * od 2 stycznia 2002 r. do bieżącej daty.<br>
     * Archiwalne dane dla kursów walut dostępne są od 2 stycznia 2002 r.
     *
     * @param currencyCodeTableB enum CurrencyCodeTableB (np. UAH, SCR, ILS)
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ExchangeRatesSeries currencyExchangeRate(CurrencyCodeTableB currencyCodeTableB) throws IOException {
        String code = currencyCodeTableB.toString().toLowerCase();
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
            jsonUrl = "http://api.nbp.pl/api/exchangerates/rates/b/" + code + "/" + startFormatDate + "/" + endFormatDate + "/?format=json";
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
            return readMultiExchangeRatesSeries(jsonTrim);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
