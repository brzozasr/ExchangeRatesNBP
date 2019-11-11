package models.tables;

import java.util.List;

public class ExchangeRatesTable {
    private String table;
    private String no;
    private String effectiveDate;
    private List<Rate> rates;

    public ExchangeRatesTable(String table, String no, String effectiveDate, List<Rate> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    /**
     * @return typ tabeli
     */
    public String getTable() {
        return table;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<Rate> getRates() {
        return rates;
    }
}
