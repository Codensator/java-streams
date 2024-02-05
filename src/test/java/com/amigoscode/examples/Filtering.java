package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();

/** 10.01 - Filter
 * Neben Filter gibt es noch eine Reihe spezifischer anderer Filter-Befehle
 */
        List<Car> carsLessThan20k = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00)
                .filter(car -> car.getColor().equals("Yellow"))
                .collect(Collectors.toList());

        carsLessThan20k.forEach(System.out::println);
    }

/** 10.03 - Drop While
 * Ist das Gegenteil von Take While. Der Filter-Vorgang wird so lange nicht ausgeführt bis das predicate zu trifft
 */
    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
    }

/** 10.02 - Take While
 * Funktioniert wie Filter, aber führt den Filter-Vorgang, solange bis das predicate nicht mehr zu trifft
 */
    @Test
    public void takeWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        System.out.println("using take while");
    }
/** 10.04 - Find First
 * Findet den ersten Eintrag auf den das Predicate zutrifft
 */

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 50)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

/** 10.05 - Find Any
 * Ist fast dasselbe wie Find First. Der Unterschied liegt darin, dass Find Any irgendeinen Eintrag findet und keiner Reihenfolge folgt.
 */
    @Test
    public void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 9)
                .findFirst()
                .orElse(-1);
        System.out.println(result);
    }

/** 10.06 - AllMatch and AnyMatch
 * AllMatch: Gibt einen boolean zurück, der aussagt, ob alle Einträge das predicate erfüllen
 * AnyMatch: Gibt einen boolean zurück, der aussagt, ob mindestens ein Eintrag das predicate erfüllt
 */
    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11, 13};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).allMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }

}



