package com.lymar.aviasales.util;

import java.io.*;
import java.util.HashMap;

public final class Reader {
    private static BufferedReader reader;
    private static HashMap<Integer, String> map;

    public static HashMap<Integer, String> getFlight(File file) {
        if (map == null) {
            map = readerFile(file);
            return map;
        }
        return map;
    }

    private static HashMap<Integer, String> readerFile(File file) {
        int header = 0;
        map = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String readLine;
            while ((readLine = reader.readLine()) != null) {
                if(header != 0) {
                    String[] token = readLine.split(" ", 2);
                    map.put(Integer.parseInt(token[0]), token[1]);

                }
                header = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
