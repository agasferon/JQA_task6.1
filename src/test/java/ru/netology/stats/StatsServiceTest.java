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