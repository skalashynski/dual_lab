package com.duallab.test;

import com.duallab.test.model.Service;
import com.duallab.test.service.FileProcessor;
import com.duallab.test.service.TimeTableParser;
import com.duallab.test.util.TimeTableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.duallab.test.util.TimeTableUtils.skipIneffective;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<Service> services = TimeTableParser.getInstance().readFile(FileProcessor.readFromFile(args[0]));
            services = services.stream()
                    .filter(e -> !TimeTableUtils.isServiceMoreThanHour(e))
                    .collect(Collectors.toList());

            services = skipIneffective(services);

            FileProcessor.writeToFile(TimeTableUtils.groupServicesByCompanyAndSortByDepartureDesc(services));
        } catch (IOException e) {
            LOGGER.error("Can't process file by the reason", e);
        }
    }
}
