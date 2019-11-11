package models.tables;

public class Rate {
    private String currency;
    private String code;
    private double mid;

    public Rate(String currency, String effectiveDate, double mid) {
        this.currency = currency;
        this.code = effectiveDate;
        this.mid = mid;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public double getMid() {
        return mid;
    }
}
