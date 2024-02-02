

package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GettingStarted {

/** 06.06 - Excercise
 *
 */
    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();


/**7 - Impretive Solution
 *
 */


    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();

        //in der kombinierten Lösung kann man mit filter nicht mehr die ersten 10 rauszufiltern,
        // weil man dazu auf den Index von people zugreifen muss und der bereits durch den ersten Filter manipuliert wurde
        List<Person> youngPeople = people.stream()
                .filter(p -> p.getAge() <= 18)
                .limit(10)
                .collect(Collectors.toList());

 /*     //Ich habe die Aufgabe erst missverstanden und gedacht, ich soll die Liste auf zwei unterschiedliche Arten manipulieren
        List<Person> Answer1 = people
                .stream()
                .filter(p -> p.getAge() <= 18)
                .collect(Collectors.toList());
        List<Person> Answer2 = people
                .stream()
                .filter(p -> people.indexOf(p) <= 9) //hier funktioniert filter noch für die Anzahl.
                .collect(Collectors.toList());
*/


        //System.out.println("### ### GettingStarted ### ###"); youngPeople.forEach(System.out::println);


    }
}
