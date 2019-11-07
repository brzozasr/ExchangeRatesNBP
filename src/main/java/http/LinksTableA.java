package http;

import enumtypes.CurrencyCode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Linki do kursów średnich walut obcych w złotych określonych w § 2 pkt 1 i 2 uchwały Nr 51/2002
 * Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie sposobu wyliczania
 * i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).
 */
public class LinksTableA extends ReadHttpData {

    /**
     * Aktualnie obowiązująca tabela kursów typu A
     *
     * @return String w formie xml
     */
    public String currentTable() throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/?format=xml";
        return readXMLToString(link);
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu A
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return String w formie xml
     */
    public String lastTopCountTables(int topCount) throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/last/" + topCount + "/?format=xml";
        return readXMLToString(link);
    }

    /**
     * Tabela kursów typu A opublikowana w dniu dzisiejszym (albo brak danych)
     *
     * @return String w formie xml
     */
    public String tablePublishedToday() throws IOException {
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=xml";
        return readXMLToString(link);
    }

    /**
     * Tabela kursów typu A opublikowana w dniu {date} (albo brak danych)
     *
     * @param date data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return String w formie xml
     */
    public String tablePublishedOnDate(LocalDate date) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/" + formatDate + "/?format=xml";
        return readXMLToString(link);
    }

    /**
     * Seria tabel kursów typu A opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93)
     *
     * @param startDate data w formacie rrrr-MM-dd (standard ISO 8601)
     * @param endDate   data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return String w formie xml
     */
    public String tablesPublishedOnDateRange(LocalDate startDate, LocalDate endDate) throws IOException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        String link = "http://api.nbp.pl/api/exchangerates/tables/a/" + startFormatDate + "/" + endFormatDate + "/?format=xml";
        return readXMLToString(link);
    }

    /**
     * Aktualnie obowiązujący kurs waluty {currencyCode} z tabeli kursów typu A
     *
     * @param currencyCode enum CurrencyCode
     * @return String w formie xml
     * @throws IOException
     */
    public String currentExchangeRate(CurrencyCode currencyCode) throws IOException {
        String code = currencyCode.toString().toLowerCase();
        String link = "http://api.nbp.pl/api/exchangerates/rates/a/" + code + "/?format=xml";
        return readXMLToString(link);
    }
}
