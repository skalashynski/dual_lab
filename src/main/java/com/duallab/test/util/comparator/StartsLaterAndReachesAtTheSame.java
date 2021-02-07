package com.duallab.test.util.comparator;

import com.duallab.test.model.Service;

import java.util.Comparator;

public class StartsLaterAndReachesAtTheSame implements Comparator<Service> {
    @Override
    public int compare(Service effective, Service ineffective) {
        if (effective.getArrival().compareTo(ineffective.getArrival()) == 0 &&
                effective.getDeparture().compareTo(ineffective.getDeparture()) > 0) {
            return 1;
        }
        return -1;
    }
}
