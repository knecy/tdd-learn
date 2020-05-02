package com.jiker.keju.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tools {
    public String fileReader(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String tempString;
        StringBuilder stringBuilder = new StringBuilder();
        while ((tempString = reader.readLine()) != null) {
            stringBuilder.append(tempString).append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }

    public String[] stingToStringArray(String str) {
        return str.split("\n");
    }
}
