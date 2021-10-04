package ru.netology.stats;

public class StatsService {

    int totalSalesAmount;        // Сумма продаж
    int meanSale;                // Значение средней продажи в месяц

    public int calculateTotalSalesAmount(int[] sales) {     //Сумма всех продаж
        totalSalesAmount = 0;
        for (int delta : sales) {
            totalSalesAmount += delta; // равнозначно totalSalesAmount = totalSalesAmount + delta
        }
        return totalSalesAmount;
    }


    public int calculateMeanSale(int[] sales) {     // Среднемесячная продажа
        meanSale = calculateTotalSalesAmount(sales) / sales.length;
        return meanSale;
    }


    public int findNumberLastMonthWithTheHighestSales(int[] sales) {        // Номер месяца, в котором был пик продаж
        int maxSale = sales[0];     // Значение наивысших продаж
        int i = 0;
        int iMax = 0;               // Номер месяца, в котором был пик продаж
        for (int sale : sales) {
            if (maxSale < sale) {
                maxSale = sale;
            }
        }

        for (int sale : sales) {
            i++;
            if (sale == maxSale) {
                iMax = i;
            }
        }
        return iMax;
    }


    public int findNumberLastMonthWithTheLowestSales(int[] sales) {        // Номер месяца, в котором был минимум продаж
        int minSale = sales[0];     // Значение наименьших продаж
        int i = 0;
        int iMin = 0;               // Номер месяца, в котором был минимум продаж
        for (int sale : sales) {
            if (minSale > sale) {
                minSale = sale;
            }
        }

        for (int sale : sales) {
            i++;
            if (sale == minSale) {
                iMin = i;
            }
        }
        return iMin;
    }


    public int numberOfMonthsWithBelowAverageSales(int[] sales) {
        int i = 0;
// Ибо учат нас быть ленивыми и экономными программистами, мы не будет считать по новой значение средней продажи и
// отдадим эту честь нашему сервису, написанному выше.
        for (int sale : sales) {
            if (calculateMeanSale(sales) > sale) {
                i++;
            }
        }
        return i;
    }


    public int numberOfMonthsWithAboveAverageSales(int[] sales) {
        int i = 0;
        meanSale = calculateMeanSale(sales);
        for (int sale : sales) {
            if (meanSale < sale) {
                i++;
            }
        }
        return i;
    }
}