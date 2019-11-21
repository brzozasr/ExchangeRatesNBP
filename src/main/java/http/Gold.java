package http;

import exceptions.NBPDataException;
import models.gold.ArrayOfGoldPrice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static http.ReadHttpData.readJsonToString;
import static http.ReadJSON.readGoldPriceSeries;
import static http.ReadJSON.readMultiGoldPriceSeries;

/**
 * Ceny i notowania złota wyliczona w NBP, cena 1 g złota (w próbie 1000).
 * Dane archiwalne dla cen złota dostępne są od 2 stycznia 2013 r.
 */
public class Gold {

    /**
     * Aktualnie obowiązująca cena złota
     *
     * @return objekt ArrayOfGoldPrice
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice currentGoldPrice() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/cenyzlota/?format=json";
        try {
            return readGoldPriceSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria ostatnich {topCount} notowań cen złota
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 255)
     * @return obiekt ArrayOfGoldPrice
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice lastTopCountGoldPrice(int topCount) throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/cenyzlota/last/" + topCount + "/?format=json";
        try {
            return readGoldPriceSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cena złota opublikowana w dniu dzisiejszym (albo brak danych).
     *
     * @return obiekt ArrayOfGoldPrice
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice publishedTodayGoldPrice() throws IOException {
        String jsonUrl = "http://api.nbp.pl/api/cenyzlota/today/?format=json";
        try {
            return readGoldPriceSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cena złota opublikowana w dniu {date} (albo brak danych).<br>
     * Dane archiwalne dla cen złota dostępne są od 2 stycznia 2013 r.
     *
     * @param date LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2014, 5, 10)
     * @return obiekt ArrayOfGoldPrice
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice publishedOnDateGoldPrice(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String jsonUrl = "http://api.nbp.pl/api/cenyzlota/" + formatDate + "/?format=json";
        try {
            return readGoldPriceSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria cen złota opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych), (limit dni 367).<br>
     * Dane archiwalne dla cen złota dostępne są od 2 stycznia 2013 r.
     *
     * @param startDate LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2013, 1, 2)
     * @param endDate   LocalDate, data w formacie rrrr-MM-dd (standard ISO 8601), np. LocalDate.of(2013, 2, 19)
     * @return obiekt ArrayOfGoldPrice
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice publishedOnDateRangeGoldPrice(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String jsonUrl = "http://api.nbp.pl/api/cenyzlota/" + startFormatDate + "/" + endFormatDate + "/?format=json";
        try {
            return readGoldPriceSeries(jsonUrl);
        } catch (NBPDataException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Seria wszystkich cen złota, dane są dostępnych od 2 stycznia 2013 r. do bieżącej daty.<br>
     * Dane archiwalne dla cen złota dostępne są od 2 stycznia 2013 r.
     *
     * @return obiekt ExchangeRatesSeries
     * @throws IOException input / output exception (wyjątek)
     */
    public ArrayOfGoldPrice allGoldPrice() throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.of(2013, 1, 2);
        LocalDate endDate = LocalDate.now();
        String jsonUrl;
        String json = "";
        String jsonTrim = "";

        long days = ChronoUnit.DAYS.between(startDate, endDate);
        int counter = (int) Math.ceil((double) days / 367);

        LocalDate startDateUrl = startDate;
        LocalDate endDateUrl = startDateUrl.plusDays(367);

        for (int i = 0; i < counter; i++) {
            String startFormatDate = dateTimeFormatter.format(startDateUrl);
            String endFormatDate = dateTimeFormatter.format(endDateUrl);
            jsonUrl = "http://api.nbp.pl/api/cenyzlota/" + startFormatDate + "/" + endFormatDate + "/?format=json";
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
                int firstIndex = json.indexOf("[");
                int lastIndex = json.indexOf("]");
                json = json.substring(firstIndex + 1, lastIndex);
                jsonTrim = jsonTrim.concat(json).concat(",");
            }
        }

        if (jsonTrim.endsWith(",")) {
            jsonTrim = jsonTrim.substring(0, jsonTrim.length() - 1);
        }

        if (!jsonTrim.equals("")) {
            jsonTrim = "[" + jsonTrim + "]";
        }

        try {
            return readMultiGoldPriceSeries(jsonTrim);
        } catch (NBPDataException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
