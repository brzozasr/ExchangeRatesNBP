package models.rates;

import java.util.ArrayList;

public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private ArrayList<Rate> rates;

    public ExchangeRatesSeries(String table, String currency, String code/*, ArrayList<Rate> rates*/) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        /*this.rates = rates;*/
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public void addRate(Rate rate) {

        if (rates == null) {
            rates = new ArrayList<>();
        }
        rates.add(rate);
    }

    //TODO usunąć
    @Override
    public String toString() {
        return "ExchangeRatesSeries{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
