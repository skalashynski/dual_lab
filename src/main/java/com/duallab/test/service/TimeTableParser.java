package com.duallab.test.service;

import com.duallab.test.model.Company;
import com.duallab.test.model.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TimeTableParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeTableParser.class);
    private static final String REGEX = "(Posh|Grotty)\\s+(\\d{1,2}):(\\d{2})\\s+(\\d{1,2}):(\\d{2})";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static TimeTableParser INSTANCE;

    private TimeTableParser() {

    }

    public static TimeTableParser getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        return new TimeTableParser();
    }

    public List<Service> readFile(String content) {
        return Arrays.stream(content.split("\n"))
                .map(line -> {
                    Matcher matcher = PATTERN.matcher(line);
                    if (matcher.find()) {
                        try {
                            Company company = Company.valueOf(matcher.group(1).toUpperCase());
                            LocalTime localTime1 = LocalTime.of(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
                            LocalTime localTime2 = LocalTime.of(Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
                            return new Service(company, localTime1, localTime2);
                        } catch (NumberFormatException e) {
                            LOGGER.error(String.format("Can't convert line: %s", line), e);
                            return null;
                        }
                    }
                    LOGGER.warn("Can't parse line: {}", line);
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
