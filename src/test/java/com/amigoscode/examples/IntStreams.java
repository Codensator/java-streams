package com.amigoscode.examples;


import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** 07.01 - IntStreams
 *
 */
public class IntStreams {

    @Test
    public void range() throws Exception {
        for(int i = 0; i <= 10; i++){
            System.out.println(i);

        }
/*      System.out.println("with int stream exclusive");
        IntStream intStream = IntStream.range(0, 10);
        intStream.forEach(value -> System.out.println(value));

        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(value -> System.out.println(value));
*/
    }


/** 07.02 - Exercise
 *
 */
    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    System.out.println(people.get(index));
                });
    }


/** 07.04 - IntStreams Iterate
 *
 */
    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, value -> value +1)
                .limit(10)
                .forEach(System.out::println);

    }
}
