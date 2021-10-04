package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatsServiceTest {
    // Да будет объявлен массив продаж по месяцам прямо тут, дабы сократить количество строк кода.
    public int[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    //  А так же вынесем обращение к сервису "наверх" сократив код
    public StatsService service = new StatsService();


    @Test
        //Сумма всех продаж
    void calculateTotalSalesAmount() {
        int expected = 180;
        // Как и вместо объявления переменной, которой мы присваиваем значение результат обращения к сервису,
        // мы сделаем обращение к сервису непосредственно в сравнении ожидаемого и фактического результатов
        assertEquals(expected, service.calculateTotalSalesAmount(sales));
    }


    @Test
        // Среднемесячная продажа
    void calculateMeanSale() {
        int expected = 15;
        assertEquals(expected, service.calculateMeanSale(sales));
    }


    @Test
        // Номер месяца, в котором был пик продаж
    void findNumberLastMonthWithTheHighestSales() {
        int expected = 8;
        assertEquals(expected, service.findNumberLastMonthWithTheHighestSales(sales));
    }


    @Test
        // Номер месяца, в котором был минимум продаж
    void findNumberLastMonthWithTheLowestSales() {
        int expected = 9;
        assertEquals(expected, service.findNumberLastMonthWithTheLowestSales(sales));
    }

    @Test
        // Кол-во месяцев, в которых продажи были ниже среднего
    void numberOfMonthsWithBelowAverageSales() {
        int expected = 5;
        assertEquals(expected, service.numberOfMonthsWithBelowAverageSales(sales));
    }

    @Test
        // Кол-во месяцев, в которых продажи были выше среднего
    void numberOfMonthsWithAboveAverageSales() {
        int expected = 5;
        assertEquals(expected, service.numberOfMonthsWithAboveAverageSales(sales));
    }

}