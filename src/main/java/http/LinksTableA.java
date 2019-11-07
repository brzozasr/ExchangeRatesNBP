package http;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Linki do kursów średnich walut obcych w złotych określonych w § 2 pkt 1 i 2 uchwały Nr 51/2002
 * Zarządu Narodowego Banku Polskiego z dnia 23 września 2002 r. w sprawie sposobu wyliczania
 * i ogłaszania bieżących kursów walut obcych (Dz. Urz. NBP z 2017 r. poz. 15).
 */
public class LinksTableA {

    /**
     * Aktualnie obowiązująca tabela kursów typu A
     *
     * @return String - link do xml
     */
    public String currentTable() {
        return "http://api.nbp.pl/api/exchangerates/tables/a/?format=xml";
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu A
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return String - link do xml
     */
    public String lastTopCountTables(int topCount) {
        return "http://api.nbp.pl/api/exchangerates/tables/a/last/" + topCount + "/?format=xml";
    }

    /**
     * Tabela kursów typu A opublikowana w dniu dzisiejszym (albo brak danych)
     *
     * @return String - link do xml
     */
    public String tablePublishedToday() {
        return "http://api.nbp.pl/api/exchangerates/tables/a/today/?format=xml";
    }

    /**
     * Tabela kursów typu A opublikowana w dniu {date} (albo brak danych)
     *
     * @param date data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return link do xml
     */
    public String tablePublishedOnDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDate = dateTimeFormatter.format(date);
        return "http://api.nbp.pl/api/exchangerates/tables/a/" + formatDate + "/?format=xml";
    }

    /**
     * Seria tabel kursów typu A opublikowanych w zakresie dat od {startDate} do {endDate} (albo brak danych),
     * (limit dni 93)
     *
     * @param startDate data w formacie rrrr-MM-dd (standard ISO 8601)
     * @param endDate   data w formacie rrrr-MM-dd (standard ISO 8601)
     * @return link do xml
     */
    public String tablesPublishedOnDateRange(LocalDate startDate, LocalDate endDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        return "http://api.nbp.pl/api/exchangerates/tables/a/" + startFormatDate + "/" + endFormatDate + "/?format=xml";
    }
}
