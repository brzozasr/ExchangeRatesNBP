package models.rates;

/**
 * Model notowania średniego kursu pojedynczej waluty osadzony w modelu {ExchangeRatesSeries}
 * dla określonego typu tabeli oraz symbolu waluty.
 */
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;

    public Rate(String no, String effectiveDate, double mid) {
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
    public String getEffectiveDate() {
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

    //TODO usunąć
    @Override
    public String toString() {
        return "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid='" + mid + '\'';
    }
}
