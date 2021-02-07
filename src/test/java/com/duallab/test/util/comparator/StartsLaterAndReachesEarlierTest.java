package com.duallab.test.util.comparator;

import com.duallab.test.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Comparator;

import static com.duallab.test.model.Company.POSH;
import static org.junit.jupiter.api.Assertions.*;

class StartsLaterAndReachesEarlierTest {
    private Comparator<Service> comparator = new StartsLaterAndReachesEarlier();

    @Test
    void startsLater() {
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));

        Assertions.assertEquals(1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1))
        ));
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 1)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
    }

    @Test
    void startsAtTheSameTime() {
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1))
        ));

        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
    }

    @Test
    void startsEarlier() {
        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));

        Assertions.assertEquals(-1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 1)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))
        ));
        Assertions.assertEquals(1, comparator.compare(
                new Service(POSH, LocalTime.of(10, 1), LocalTime.of(11, 0)),
                new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1))
        ));
    }
}