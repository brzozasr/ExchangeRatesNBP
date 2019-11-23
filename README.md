# exchange-rates-nbp API for Java [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.brzozasr/exchange-rates-nbp/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.brzozasr/exchange-rates-nbp) [![javadoc](https://javadoc.io/badge2/com.github.brzozasr/exchange-rates-nbp/javadoc.svg)](https://javadoc.io/doc/com.github.brzozasr/exchange-rates-nbp)
#### Exchange rates and gold quotations (price) NBP (Narodowy Bank Polski, National Bank of Poland) API
***
### License
exchange-rates-nbp is licensed under **Apache Software License, Version 2.0**.
***
### News
* Version 1.0.0 released on 23-Nov-2019.
***
### Apache Maven
```apache maven
<dependency>
  <groupId>com.github.brzozasr</groupId>
  <artifactId>exchange-rates-nbp</artifactId>
  <version>1.0.0</version>
</dependency>
```
### Gradle Groovy DSL
```gradle
dependencies {
   implementation 'com.github.brzozasr:exchange-rates-nbp:1.0.0'
}
```
### Scala SBT
```scala stb
libraryDependencies += "com.github.brzozasr" % "exchange-rates-nbp" % "1.0.0"
```
***
## Examples:
Middle exchange rates of foreign currencies – table A (tables, last top count 30)
```java
try {
         ArrayOfExchangeRatesTable arrayERT = new TableA().lastTopCountTables(30);

         for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
              System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
              for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                 System.out.println(
                      // applies to archive exchange rates, it could return null value
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                      // applies to archive exchange rates, it could return null value
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                      arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
               }
            }
      } catch (IOException e) {
          e.printStackTrace();
      }
```
Middle exchange rates of foreign currencies – table A (table from a specific date)
```java
try {
         ArrayOfExchangeRatesTable arrayERT = new TableA().publishedOnDateTable(LocalDate.of(2010, 2, 25));
         for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
             System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
             for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                 System.out.println(
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                       // it could return null value
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                       arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
             }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
```
Middle exchange rates of foreign currencies – table A (for single currency, from January 2, 2002 to the current date)
```java
try {
            ExchangeRatesSeries ers = new TableA().currencyExchangeRate(CurrencyCodeTableA.USD);

            System.out.println("== Example no 1 ====================================================");
            for (int i = 0; i < ers.getRates().size(); i++) {
                System.out.println(ers.getRates().get(i).getNo() +
                        " - " + ers.getRates().get(i).getEffectiveDate() +
                        " - " + ers.getRates().get(i).getMid());
            }

            System.out.println("== Example no 2 ====================================================");
            for(Rate element: ers.getRates()) {
                System.out.println(element.getNo() +
                        " -- " + element.getEffectiveDate() +
                        " -- " + element.getMid());
            }

            System.out.println("== Example no 3 ====================================================");
            ers.getRates().forEach(
                    element -> System.out.println(element.getNo() +
                            " --- " + element.getEffectiveDate() +
                            " --- " + element.getMid()));

        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (currently valid table)
```java
try {
            ArrayOfExchangeRatesTable arrayERT = new TableB().currentTable();

            for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (tables published in a date range)
```java
try {
            ArrayOfExchangeRatesTable arrayERT = new TableB().publishedOnDateRangeTables(
                    LocalDate.of(2003, 2, 25),
                    LocalDate.of(2003, 5, 20));
            for (int i = 0; i < arrayERT.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayERT.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayERT.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                         // applies to archive exchange rates, it could return null value
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                         arrayERT.getExchangeRatesTables().get(i).getRates().get(j).getMid());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (currently valid exchange rates for single currency)
```java
try {
          ExchangeRatesSeries exchangeRatesSeries = new TableB().currentExchangeRate(CurrencyCodeTableB.RUB);
          System.out.println(exchangeRatesSeries.getTable());
          System.out.println(exchangeRatesSeries.getCountry());
          System.out.println(exchangeRatesSeries.getSymbol());
          System.out.println(exchangeRatesSeries.getCurrency());
          System.out.println(exchangeRatesSeries.getCode());
          System.out.println(exchangeRatesSeries.getRates().get(0).getNo()
                  + " <-> " + exchangeRatesSeries.getRates().get(0).getEffectiveDate() +
                  " <-> " + exchangeRatesSeries.getRates().get(0).getMid());
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Middle exchange rates of foreign currencies – table B (for single currency, from January 2, 2002 to the current date)
```java
try {
        ExchangeRatesSeries exchangeRatesSeries = new TableB().currencyExchangeRate(CurrencyCodeTableB.EGP);

        System.out.println("== Example no 1 ====================================================");
        for (int i = 0; i < exchangeRatesSeries.getRates().size(); i++) {
            System.out.println(exchangeRatesSeries.getRates().get(i).getNo()
                    + " <-> " + exchangeRatesSeries.getRates().get(i).getEffectiveDate()
                    + " <-> " + exchangeRatesSeries.getRates().get(i).getMid());
        }

        System.out.println("== Example no 2 ====================================================");
        for (Rate element : exchangeRatesSeries.getRates()) {
            System.out.println(element.getNo() +
                    " -- " + element.getEffectiveDate() +
                    " -- " + element.getMid());
        }

        System.out.println("== Example no 3 ====================================================");
        exchangeRatesSeries.getRates().forEach(
                element -> System.out.println(element.getNo() +
                        " --- " + element.getEffectiveDate() +
                        " --- " + element.getMid()));

    } catch (IOException e) {
        e.printStackTrace();
    }
```
Buy and sell prices of foreign currencies – table C (tables published in a date range)
```java
try {
            ArrayOfExchangeRatesTableC arrayERTC = new TableC().publishedOnDateRangeTables(
                    LocalDate.of(2015, 7, 1),
                    LocalDate.of(2015, 9, 30));
            for (int i = 0; i < arrayERTC.getExchangeRatesTables().size(); i++) {
                System.out.println(arrayERTC.getExchangeRatesTables().get(i).getTable());
                System.out.println(arrayERTC.getExchangeRatesTables().get(i).getNo());
                System.out.println(arrayERTC.getExchangeRatesTables().get(i).getTradingDate());
                System.out.println(arrayERTC.getExchangeRatesTables().get(i).getEffectiveDate());
                for (int j = 0; j < arrayERTC.getExchangeRatesTables().get(i).getRates().size(); j++) {
                    System.out.println(
                        // it could return null value
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getCountry() + " - " +
                        // it could return null value
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getSymbol() + " - " +
                        // it could return null value
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getCurrency() + " - " +
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getCode() + " - " +
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getBid() + " - " +
                        arrayERTC.getExchangeRatesTables().get(i).getRates().get(j).getAsk());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
```
Buy and sell prices of foreign currencies – table C (for single currency, last top count 255)
```java
try {
            ExchangeRatesSeriesC exchangeRatesTableC = new TableC().lastTopCountExchangeRate(
                          CurrencyCodeTableC.GBP, 255);
            System.out.println(exchangeRatesTableC.getTable());
                               // applies to archive exchange rates, it could return null value
            System.out.println(exchangeRatesTableC.getCountry());
                               // applies to archive exchange rates, it could return null value
            System.out.println(exchangeRatesTableC.getSymbol());
            System.out.println(exchangeRatesTableC.getCurrency());
            System.out.println(exchangeRatesTableC.getCode());
            for (int i = 0; i < exchangeRatesTableC.getRates().size(); i++) {
                System.out.println(
                        exchangeRatesTableC.getRates().get(i).getNo()
                        + " <-> " + exchangeRatesTableC.getRates().get(i).getEffectiveDate()
                        + " <-> " + exchangeRatesTableC.getRates().get(i).getBid()
                        + " <-> " + exchangeRatesTableC.getRates().get(i).getAsk());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  ```
  Buy and sell prices of foreign currencies – table C (for single currency, from January 2, 2002 to the current date)
  ```java
  try {
            ExchangeRatesSeriesC ersC = new TableC().currencyExchangeRate(CurrencyCodeTableC.USD);
            
            //Example no 1
            for (int i = 0; i < ersC.getRates().size(); i++) {
                System.out.println(ersC.getRates().get(i).getNo()
                        + " <-> " + ersC.getRates().get(i).getEffectiveDate()
                        + " <-> " + ersC.getRates().get(i).getBid()
                        + " <-> " + ersC.getRates().get(i).getAsk());
            }

            //Example no 2
            for (RateC element : ersC.getRates()) {
                System.out.println(element.getNo() +
                        " -- " + element.getEffectiveDate() +
                        " -- " + element.getBid() +
                        " -- " + element.getAsk());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  ```
  The price of gold (from January 2, 2013 to the current date)
```java
try {
         ArrayOfGoldPrice arrayOfGoldPrice = new Gold().allGoldPrice();

         //Example no 1
         System.out.println("=======================================================");
         for (int i = 0; i < arrayOfGoldPrice.getGoldQuotations().size(); i++) {
             System.out.println(arrayOfGoldPrice.getGoldQuotations().get(i).getDate()
                     + " - " + arrayOfGoldPrice.getGoldQuotations().get(i).getPrice());
         }

         //Example no 2
         System.out.println("=======================================================");
         for (GoldPrice element : arrayOfGoldPrice.getGoldQuotations()) {
             System.out.println(element.getDate() + " - " + element.getPrice());
         }

         //Example no 3
         System.out.println("=======================================================");
         arrayOfGoldPrice.getGoldQuotations().forEach(element ->
                 System.out.println(element.getDate() + " - " + element.getPrice()));

     } catch (IOException e) {
         e.printStackTrace();
     }
```
