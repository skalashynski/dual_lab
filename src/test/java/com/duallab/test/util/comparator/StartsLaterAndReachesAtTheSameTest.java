package com.duallab.test.util.comparator;

import com.duallab.test.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Comparator;

import static com.duallab.test.model.Company.POSH;

class StartsLaterAndReachesAtTheSameTest {
    private Comparator<Service> comparator = new StartsLaterAndReachesAtTheSame();

    @Test
    void compare() {
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0))
        ));

        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
        Assertions.assertEquals(1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
    }
}