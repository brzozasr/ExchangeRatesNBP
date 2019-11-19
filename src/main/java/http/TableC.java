package http;

import exceptions.NBPDataException;
import models.tablec.ArrayOfExchangeRatesTableC;
import models.tables.ArrayOfExchangeRatesTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static http.ReadJSON.readArrayOfExchangeRatesTable;
import static http.ReadJSON.readArrayOfExchangeRatesTableC;

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
}
