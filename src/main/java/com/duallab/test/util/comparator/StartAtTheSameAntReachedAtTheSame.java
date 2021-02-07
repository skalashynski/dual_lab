package com.duallab.test.util.comparator;

import com.duallab.test.model.Company;
import com.duallab.test.model.Service;

import java.util.Comparator;

import static com.duallab.test.model.Company.GROTTY;
import static com.duallab.test.model.Company.POSH;

public class StartAtTheSameAntReachedAtTheSame implements Comparator<Service> {
    @Override
    public int compare(Service effective, Service ineffective) {
        if (effective.getDeparture().equals(ineffective.getDeparture())
                && effective.getArrival().equals(ineffective.getArrival())
                && effective.getCompany().equals(POSH)
                && ineffective.getCompany().equals(GROTTY)
        ) {
            return 1;
        }
        return -1;
    }
}
