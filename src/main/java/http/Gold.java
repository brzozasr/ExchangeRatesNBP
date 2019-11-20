package http;

import exceptions.NBPDataException;
import models.gold.ArrayOfGoldPrice;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static http.ReadJSON.readGoldPriceSeries;

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
}
