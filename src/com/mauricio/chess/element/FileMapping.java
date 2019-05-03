package com.mauricio.chess.element;

import java.util.HashMap;
import java.util.Map;

public class FileMapping {
    public static final Map<Integer, String> fileNumberToFile = new HashMap<>();
    public static final Map<String, Integer> fileToFileNumber = new HashMap<>();

    static {
        fileNumberToFile.put(1, "a");
        fileNumberToFile.put(2, "b");
        fileNumberToFile.put(3, "c");
        fileNumberToFile.put(4, "d");
        fileNumberToFile.put(5, "e");
        fileNumberToFile.put(6, "f");
        fileNumberToFile.put(7, "g");
        fileNumberToFile.put(8, "h");

        fileToFileNumber.put("a", 1);
        fileToFileNumber.put("b", 2);
        fileToFileNumber.put("c", 3);
        fileToFileNumber.put("d", 4);
        fileToFileNumber.put("e", 5);
        fileToFileNumber.put("f", 6);
        fileToFileNumber.put("g", 7);
        fileToFileNumber.put("h", 8);
    }


}
