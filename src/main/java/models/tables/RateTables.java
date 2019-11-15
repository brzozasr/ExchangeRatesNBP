package models.tables;

/**
 * Model notowania średniego kursu pojedynczej waluty w tabeli osadzony w modelu
 * {ExchangeRatesTable-&#62;ArrayOfExchangeRatesTable} dla określonego typu tabeli.
 */
public class RateTables {
    private String currency;
    private String code;
    private double mid;

    public RateTables(String currency, String effectiveDate, double mid) {
        this.currency = currency;
        this.code = effectiveDate;
        this.mid = mid;
    }

    /**
     * Pobiera nazwę waluty z z obiektu ArrayOfExchangeRatesTable
     *
     * @return nazwę waluty (np. "dolar amerykański" lub z tabel archiwalnych "USA")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Pobiera kod waluty z obiektu ArrayOfExchangeRatesTable
     *
     * @return kod waluty (np. "USD", "EUR")
     */
    public String getCode() {
        return code;
    }

    /**
     * Pobiera kurs średni waluty z obiektu ArrayOfExchangeRatesTable
     *
     * @return przeliczony kurs średni waluty (np. "3.2735")
     */
    public double getMid() {
        return mid;
    }

    //TODO usunąć

    @Override
    public String toString() {
        return "RateTables{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", mid=" + mid +
                '}';
    }
}
