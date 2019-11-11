package models.rates;

import java.util.List;

public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public ExchangeRatesSeries(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    /**
     * @return typ tabeli
     */
    public String getTable() {
        return table;
    }

    /**
     * @return nazwa waluty
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @return kod waluty
     */
    public String getCode() {
        return code;
    }

    /**
     * @return lista kursów poszczególnych walut
     */
    public List<Rate> getRates() {
        return rates;
    }

    //TODO usunąć
    @Override
    public String toString() {
        return "table: " + table + "\n" +
                "currency: " + currency + "\n" +
                "code: " + code + "\n" +
                "rates: " + rates + "\n";
    }
}
