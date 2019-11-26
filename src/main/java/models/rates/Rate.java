package models.rates;

import java.time.LocalDate;

/**
 * Model notowania średniego kursu pojedynczej waluty osadzony w modelu {ExchangeRatesSeries}
 * dla określonego typu tabeli oraz symbolu waluty.
 */
public class Rate {
    private String no;
    private LocalDate effectiveDate;
    private double mid;

    /**
     * Konstruktor obiektu Rate
     *
     * @param no            numer tabeli
     * @param effectiveDate data publikacji
     * @param mid           przeliczony kurs średni waluty (dotyczy tabel A oraz B)
     */
    public Rate(String no, LocalDate effectiveDate, double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    /**
     * Pobiera numer tabeli, w której jest zamieszczone notowanie średnie waluty z obiektu ExchangeRatesSeries
     *
     * @return numer tabeli (np. "064/A/NBP/2016")
     */
    public String getNo() {
        return no;
    }

    /**
     * Pobiera datę publikacji kursu średniego waluty z obiektu ExchangeRatesSeries
     *
     * @return data publikacji (np. "2016-04-04")
     */
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Pobiera przeliczony kurs średni waluty z obiektu ExchangeRatesSeries
     *
     * @return przeliczony kurs średni waluty (np. "3.7254")
     */
    public double getMid() {
        return mid;
    }
}
