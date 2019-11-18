package models.tablec;

/**
 * Model kursów kupna i sprzedaży walut obcych osadzony w modelu
 * {ExchangeRatesTableC-&#62;ArrayOfExchangeRatesTableC} dla tabeli typu C.
 */
public class RateTablesC {

    private String country;
    private String symbol;
    private String currency;
    private String code;
    private double bid;
    private double ask;

    public RateTablesC(String country, String symbol, String currency, String code, double bid, double ask) {
        this.country = country;
        this.symbol = symbol;
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }

    /**
     * Pobiera nazwę kraju z obiektu ArrayOfExchangeRatesTableC
     * (dotyczy kursów archiwalnych)
     *
     * @return nazwa kraju (np. Australia, Afganistan)
     */
    public String getCountry() {
        return country;
    }

    /**
     * Pobiera symbol waluty (numeryczny) z obiektu ArrayOfExchangeRatesTableC
     * (dotyczy kursów archiwalnych)
     *
     * @return numeryczny symbol waluty (np. 781, 662)
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Pobiera nazwę waluty z obiektu ArrayOfExchangeRatesTableC
     *
     * @return nazwę waluty (np. "dolar amerykański")
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Pobiera kod waluty z obiektu ArrayOfExchangeRatesTableC
     *
     * @return kod waluty (np. "USD", "EUR")
     */
    public String getCode() {
        return code;
    }

    /**
     * Pobiera przeliczony kurs kupna waluty z obiektu ArrayOfExchangeRatesTableC
     *
     * @return przeliczony kurs kupna waluty (np. "3.8601")
     */
    public double getBid() {
        return bid;
    }

    /**
     * Pobiera przeliczony kurs sprzedaży waluty z obiektu ArrayOfExchangeRatesTableC
     *
     * @return przeliczony kurs sprzedaży waluty (np. "3.9381")
     */
    public double getAsk() {
        return ask;
    }
}
