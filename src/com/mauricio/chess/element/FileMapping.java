package com.mauricio.chess.element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class FileMapping {

    private static final List<String> fileCodesList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h");

    static final Map<Integer, String> fileNumberToFile = new HashMap<>();
    static final Map<String, Integer> fileToFileNumber = new HashMap<>();
    static final Set<String> fileCodesSet = new TreeSet<>(fileCodesList);

    static {
        // mapping from 1-based file number to file letter
        for (int i = 0; i < fileCodesList.size(); i++) {
            fileNumberToFile.put(i + 1, fileCodesList.get(i));
        }

        // mapping from file letter to 1-based file number
        for (int i = 0; i < fileCodesList.size(); i++) {
            fileToFileNumber.put(fileCodesList.get(i), i + 1);
        }
//        fileNumberToFile.put(1, "a");
//        fileNumberToFile.put(2, "b");
//        fileNumberToFile.put(3, "c");
//        fileNumberToFile.put(4, "d");
//        fileNumberToFile.put(5, "e");
//        fileNumberToFile.put(6, "f");
//        fileNumberToFile.put(7, "g");
//        fileNumberToFile.put(8, "h");
//
//        fileToFileNumber.put("a", 1);
//        fileToFileNumber.put("b", 2);
//        fileToFileNumber.put("c", 3);
//        fileToFileNumber.put("d", 4);
//        fileToFileNumber.put("e", 5);
//        fileToFileNumber.put("f", 6);
//        fileToFileNumber.put("g", 7);
//        fileToFileNumber.put("h", 8);
    }


}
