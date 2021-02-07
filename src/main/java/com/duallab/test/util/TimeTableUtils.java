package com.duallab.test.util;

import com.duallab.test.model.Company;
import com.duallab.test.model.Service;
import com.duallab.test.util.comparator.StartAtTheSameAndReachesEarlier;
import com.duallab.test.util.comparator.StartAtTheSameAntReachedAtTheSame;
import com.duallab.test.util.comparator.StartsLaterAndReachesAtTheSame;
import com.duallab.test.util.comparator.StartsLaterAndReachesEarlier;

import java.util.*;
import java.util.stream.Collectors;

public class TimeTableUtils {
    private static List<Comparator<Service>> comparators = Arrays.asList(
            new StartAtTheSameAndReachesEarlier(),
            new StartsLaterAndReachesAtTheSame(),
            new StartsLaterAndReachesEarlier(),
            new StartAtTheSameAntReachedAtTheSame()
    );


    public static boolean isServiceMoreThanHour(Service service) {
        return service.getArrival().minusHours(1).compareTo(service.getDeparture()) > 0;
    }

    public static Map<Company, List<Service>> groupServicesByCompanyAndSortByDepartureDesc(List<Service> services) {
        return services.stream()
                .sorted(Comparator.comparing(Service::getDeparture))
                .collect(Collectors.groupingBy(Service::getCompany, LinkedHashMap::new, Collectors.toList()));
    }

    public static List<Service> skipIneffective(List<Service> services) {
        List<Service> copy = new LinkedList<>(services);
        Set<Service> ineffective = new HashSet<>();
        for (Service copied : copy) {
            for (Service service : services) {
                if (!copied.equals(service)) {
                    if (comparators.stream().anyMatch(comparator -> comparator.compare(copied, service) > 0)) {
                        ineffective.add(service);
                    }
                }
            }
        }
        copy.removeAll(ineffective);
        return copy;
    }

}
