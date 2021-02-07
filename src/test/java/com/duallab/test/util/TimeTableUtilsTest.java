package com.duallab.test.util;


import com.duallab.test.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static com.duallab.test.model.Company.POSH;

class TimeTableUtilsTest {

    @Test
    void isServiceLongerThanHour() {
        Assertions.assertFalse(TimeTableUtils.isServiceMoreThanHour(new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 1))));
        Assertions.assertTrue(TimeTableUtils.isServiceMoreThanHour(new Service(POSH, LocalTime.of(10, 0), LocalTime.of(10, 59))));
        Assertions.assertTrue(TimeTableUtils.isServiceMoreThanHour(new Service(POSH, LocalTime.of(10, 0), LocalTime.of(11, 0))));
    }
}