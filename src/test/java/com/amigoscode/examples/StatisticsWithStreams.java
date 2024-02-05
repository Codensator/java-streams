package com.amigoscode.examples;


import com.amigoscode.beans.Car;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;


public class StatisticsWithStreams {

/** 12.01 - Count
 *
 */
    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        Long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .filter(car -> car.getYear().intValue() > 2010)
                .count();
        System.out.println(count);
    }

/** 12.02 - Min Max without comparators
 *
 */
    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();
        double min = cars.stream()
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(min);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        double max = cars.stream()
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);
    }


/** 12.03 - Average and Sum
 *
 */
    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        double ave = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(ave);

    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        System.out.println(BigDecimal.valueOf(sum));
    }


/** 12.04 - Summary Statistics
 * Mit summaryStatistics kann man im Wesentlichen alle functions von weiter oben auch umsetzen
 */
    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        // und noch viele weitere Möglichkeiten



    }

}