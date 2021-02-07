package com.duallab.test.util.comparator;

import com.duallab.test.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Comparator;

import static com.duallab.test.model.Company.POSH;

class StartAtTheSameAndReachesEarlierTest {
    private Comparator<Service> comparator = new StartAtTheSameAndReachesEarlier();

    @Test
    public void compare() {
        Assertions.assertEquals(1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 2))
        ));

        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 2)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1))
        ));
    }
}