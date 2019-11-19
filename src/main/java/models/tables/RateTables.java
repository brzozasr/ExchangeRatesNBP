package models.tables;

/**
 * Model notowania średniego kursu pojedynczej waluty w tabeli osadzony w modelu
 * {ExchangeRatesTable-&#62;ArrayOfExchangeRatesTable} dla określonego typu tabeli.
 */
public class RateTables {
    private String country;
    private String symbol;
    private String currency;
    private String code;
    private double mid;

    public RateTables(String country, String symbol, String currency, String code, double mid) {
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.mid = mid;
    }

    /**
     * Pobiera nazwę kraju z obiektu ArrayOfExchangeRatesTable
     * (dotyczy kursów archiwalnych)
     *
     * @return nazwa kraju (np. Australia, Afganistan)
     */
    public String getCountry() {
        return country;
    }

    /**
     * Pobiera symbol waluty (numeryczny) z obiektu ArrayOfExchangeRatesTable
     * (dotyczy kursów archiwalnych)
     *
     * @return numeryczny symbol waluty (np. 781, 662)
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Pobiera nazwę waluty z obiektu ArrayOfExchangeRatesTable
     *
     * @return nazwę waluty (np. "dolar amerykański")
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

    @Override
    public String toString() {
        return "RateTables{" +
                "country='" + country + '\'' +
                ", symbol='" + symbol + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", mid=" + mid +
                "}\n";
    }
}
