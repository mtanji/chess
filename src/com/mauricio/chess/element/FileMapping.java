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
    }


}
