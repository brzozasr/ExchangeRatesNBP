package http;

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
    public String current() {
        return "http://api.nbp.pl/api/exchangerates/tables/a/?format=xml";
    }

    /**
     * Seria ostatnich {topCount} tabel kursów typu A
     *
     * @param topCount liczba określająca maksymalną liczność zwracanej serii
     *                 danych (limit wyników 67)
     * @return String - link do xml
     */
    public String lastTopCount(int topCount) {
        return "http://api.nbp.pl/api/exchangerates/tables/a/last/" + topCount + "/?format=xml";
    }
}
