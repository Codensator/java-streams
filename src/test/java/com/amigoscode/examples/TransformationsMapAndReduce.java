package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/** 11.01 - Map
 * Ermöglicht es vor allem Eingabe-Datentypen in andere Ausgabe-Typen zu transformieren.
 */
public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> PersonDTOFunction = person -> new PersonDTO(
                person.getId(),
                person.getFirstName(),
                person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(PersonDTO::map)                        //map erwartet an dieser Stelle eine Person und returnt einen anderen Datentyp
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
    }

/** 11.02 - Excersise (Map)
 *
 */
    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);             //mapToDouble hat noch mehr functions um mit double zu arbeiten
        System.out.println(avg);
    }

    /** 11.04 - Reduce
     * Anders als Map wird bei Reduce nicht nur der Datentyp eines Eingabe-Wertes geändert
     * Mit Reduce kann ein Ergebnis aus einer Sequenz von Elementen erzugt werden
     */
    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers).reduce(0,  Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (left, right) -> left - right);

        System.out.println(sum);
        System.out.println(sub);

    }
}

