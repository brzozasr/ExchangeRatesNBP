package models.gold;

import java.util.List;

/**
 * Model tablicy z notowaniami ceny złota wyliczonymi w NBP, cena 1 g złota (w próbie 1000).
 */
public class ArrayOfGoldPrice {

    private List<GoldPrice> goldQuotations;

    /**
     * Konstruktor obiektu ArrayOfGoldPrice
     *
     * @param goldQuotations lista tabel notowań ceny złota {List&#60;GoldPrice&#62;}
     */
    public ArrayOfGoldPrice(List<GoldPrice> goldQuotations) {
        this.goldQuotations = goldQuotations;
    }

    /**
     * Pobiera listę tabel notowań ceny złota z obiektu ArrayOfGoldPrice
     *
     * @return listę tabel notowań ceny złota {List&#60;GoldPrice&#62;}:<br>
     * date - data publikacji<br>
     * price - cena wyliczona w NBP cena 1 g złota (w próbie 1000)
     */
    public List<GoldPrice> getGoldQuotations() {
        return goldQuotations;
    }
}
