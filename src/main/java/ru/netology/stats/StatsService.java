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
        return totalSales(purchases) / purchases.length;
    }

    public long maximumPrice(long[] purchases) {
        long maxPrice = purchases[0];
        int maxPriceMonthNum = 0;
        for (int i = 1; i < purchases.length; i++){
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
        for (int i = 1; i < purchases.length; i++){
            if (purchases[i] <= minPrice){
                minPrice = purchases[i];
                minPriceMonthNum = (i + 1);
            }
        }
        return minPriceMonthNum;
    }

    public long numMonthsSalesLessAverage(long[] purchases) {
        float averagePrice = averagePrice(purchases);
        long numMonths = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] < averagePrice){
                numMonths ++;
            }
        }
        return numMonths;
    }

    public long numMonthsSalesMoreAverage(long[] purchases) {
        float averagePrice = averagePrice(purchases);
        long numMonths = 0;
        for (int i = 0; i < purchases.length; i++){
            if (purchases[i] > averagePrice){
                numMonths ++;
            }
        }
        return numMonths;
    }
}