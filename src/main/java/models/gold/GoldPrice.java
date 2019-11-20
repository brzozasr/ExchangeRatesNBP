package models.gold;

import java.time.LocalDate;

/**
 * Model notowania ceny złota osadzony w modelu {ArrayOfGoldPrice}
 */
public class GoldPrice {

    private LocalDate date;
    private int price;

    /**
     * Konstruktor obiektu GoldPrice
     *
     * @param data  data publikacji
     * @param price cena wyliczona w NBP cena 1 g złota (w próbie 1000)
     */
    public GoldPrice(LocalDate data, int price) {
        this.date = data;
        this.price = price;
    }

    /**
     * Pobiera datę notowania ceny złota z obiektu GoldPrice
     *
     * @return datę notowania w formacie rrrr-MM-dd
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Pobiera cenę notowania złota z obiektu GoldPrice
     *
     * @return cenę notowania złota
     */
    public int getPrice() {
        return price;
    }
}
