package models.tables;

public class RateTables {
    private String currency;
    private String code;
    private double mid;

    public RateTables(String currency, String effectiveDate, double mid) {
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
