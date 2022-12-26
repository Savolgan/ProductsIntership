package com.olga.olga;

import java.io.FileWriter;
import java.io.IOException;

public class LogInFile {
    public static void logInFile(String string) throws IOException {
        FileWriter fileWriter = new FileWriter("Log.txt", true);
        fileWriter.write(string);
        fileWriter.flush();
        fileWriter.close();
    }
}
