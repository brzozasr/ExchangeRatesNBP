package models.gold;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * Pobiera maksymalną wartość ceny złota z wybranego przedziału czasowego<br>
     * (np. ostanie 30 notowań - new Gold().lastTopCountGoldPrice(30)).
     *
     * @return maksymalną (najwyższą) cenę złota
     */
    public Double getMax() {
        List<GoldPrice> list = goldQuotations;
        if (list.size() > 0) {
            List<Double> price = new ArrayList<>();
            for (GoldPrice prices : list) {
                price.add(prices.getPrice());
            }
            return Collections.max(price);
        } else {
            return null;
        }
    }

    /**
     * Pobiera minimalną (najniższą) wartość ceny złota z wybranego przedziału czasowego<br>
     * (np. ostanie 30 notowań - new Gold().lastTopCountGoldPrice(30)).
     *
     * @return minimalną (najniższą) cenę złota
     */
    public Double getMin() {
        List<GoldPrice> list = goldQuotations;
        if (list.size() > 0) {
            List<Double> price = new ArrayList<>();
            for (GoldPrice prices : list) {
                price.add(prices.getPrice());
            }
            return Collections.min(price);
        } else {
            return null;
        }
    }
}
