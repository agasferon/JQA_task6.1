## Домашнее задание к занятию «2.4. Циклы, параметризованные тесты и аннотации»
# Задача №1 - Статистика

### Исходный код StatsService.java
```java
package ru.netology.stats;

public class StatsService {

    public long totalSales(long[] purchases) {
        long sum = 0;
        for (long purchase : purchases) {
            sum += purchase;
        }
        return sum;
    }

    public float averagePrice(long[] purchases) {
        StatsService sum = new StatsService();
        return sum.totalSales(purchases) / purchases.length;
    }

    public long maximumPrice(long[] purchases) {
        long maxPrice = purchases[0];
        int maxPriceMonthNum = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] >= maxPrice){
                maxPrice = purchases[i];
                maxPriceMonthNum = (i + 1);
            }
        }
        return maxPriceMonthNum;
    }

    public long minimumPrice(long[] purchases) {
        long minPrice = purchases[0];
        int minPriceMonthNum = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] <= minPrice){
                minPrice = purchases[i];
                minPriceMonthNum = (i + 1);
            }
        }
        return minPriceMonthNum;
    }

    public long numMonthsSalesLessAverage(long[] purchases) {
        StatsService sum = new StatsService();
        float averagePrice = sum.averagePrice(purchases);
        long numMonths = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] < averagePrice){
                numMonths ++;
            }
        }
        return numMonths;
    }

    public long numMonthsSalesMoreAverage(long[] purchases) {
        StatsService sum = new StatsService();
        float averagePrice = sum.averagePrice(purchases);
        long numMonths = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] > averagePrice){
                numMonths ++;
            }
        }
        return numMonths;
    }
}
```
### Исходный код StatsServiceTest.java
```java
package ru.netology.stats;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    long[] purchases = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

    @org.junit.jupiter.api.Test
    void totalSales() {
        StatsService service = new StatsService();
        long expected = 180;
        long actual = service.totalSales(purchases);
        System.out.println("Sales amount = " + actual);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void averagePrice() {
        StatsService service = new StatsService();
        long expected = 15;
        long actual = (long) service.averagePrice(purchases);
        System.out.println("Average price = " + actual);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void maximumPrice() {
        StatsService service = new StatsService();
        long expected = 8;
        long actual = service.maximumPrice(purchases);
        System.out.println("Month of maximum price (latest) = " + actual);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void minimumPrice() {
        StatsService service = new StatsService();
        long expected = 9;
        long actual = service.minimumPrice(purchases);
        System.out.println("Month of minimum price = " + actual);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void numMonthsSalesLessAverage() {
        StatsService service = new StatsService();
        long expected = 5;
        long actual = service.numMonthsSalesLessAverage(purchases);
        System.out.println("Number of months in which sales are less than average = " + actual);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void numMonthsSalesMoreAverage() {
        StatsService service = new StatsService();
        long expected = 5;
        long actual = service.numMonthsSalesMoreAverage(purchases);
        System.out.println("Number of months in which sales are more than average = " + actual);
        assertEquals(expected, actual);
    }
}
```
## Исходный код pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>task_6.1</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
            </plugin>
        </plugins>
    </build>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
```
## Работа написана в следующем окружении:
* Windows 10 1903 18362.778
* openjdk version "11.0.7" 2020-04-14
* OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.7+10)
* OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.7+10, mixed mode)