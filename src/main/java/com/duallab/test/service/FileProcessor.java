package com.duallab.test.service;

import com.duallab.test.model.Company;
import com.duallab.test.model.Service;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static com.duallab.test.model.Company.GROTTY;
import static com.duallab.test.model.Company.POSH;

public class FileProcessor {
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static String readFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public static void writeToFile(Map<Company, List<Service>> map) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<Service> poshes = map.get(POSH);
        if (poshes != null) {
            poshes.forEach(posh-> {
                sb.append("Posh ").append(posh.getDeparture().toString()).append(" ").append(posh.getArrival().toString()).append("\r\n");
            });
        }
        List<Service> grotties = map.get(GROTTY);
        if (grotties != null) {
            sb.append("\r\n");
            grotties.forEach(grotty-> {
                sb.append("Grotty ").append(grotty.getDeparture().toString()).append(" ").append(grotty.getArrival().toString()).append("\r\n");
            });
        }

        try (BufferedWriter br = new BufferedWriter(new FileWriter(new File(OUTPUT_FILE_PATH)))) {
            br.write(sb.toString());
            br.flush();
        }
    }

}
