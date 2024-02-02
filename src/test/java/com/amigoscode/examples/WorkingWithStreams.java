package com.amigoscode.examples;
/** 06.05 - Getting Started With Streams
 *
 */


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void steams() {
        //Liste mit Strings - List hat Stream-Methode
        List<String> names = List.of("Amigoscode", "Alex", "Zara");
        //ein neuer Stream, der als Wert die Liste names zugewiesen bekommt - aber in gestreamter Form
        Stream<String> stream = names.stream();

        //Streams können im Wesentlichen auch mit derselben Synthax erstellt werden, wie streambare Objekte z.B. List
        Stream<String> namesStream = Stream.of("Amigoscode", "Alex", "Zara");

        List<Object> collect = stream
                .limit(2).map(null).sorted(null).dropWhile(null)    //verknüpfte intermediate operators verarbeiten die Argumente
                .collect(Collectors.toList());                                                         //terminal operators beenden den Stream und geben das gewünschte Objekt aus

        String[] namesArray = {};
        Arrays.stream(namesArray); // namesArray.stream wäre eigentlich der zu erwartende Ausdruck, aber der Synthax ist hier anders

    }
}
