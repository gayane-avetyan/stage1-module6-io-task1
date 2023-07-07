package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();

        try (FileInputStream inputStream = new FileInputStream(file)) {

            StringBuilder fileData = new StringBuilder();

            int c;
            while ((c = inputStream.read()) != -1) {
                fileData.append((char) c);
            }

            String[] lines = fileData.toString().split("\n");

            for (String line : lines) {

                String[] splited = line.split(":");

                String key = splited[0].trim();
                String value = splited[1].trim();

                switch (key) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default:
                        System.out.println("Unknown key: " + key);
                        break;
                }
            }
        } catch (IOException ex) {
            logger.log(Level.WARNING, ex.getMessage());
        }

        return profile;
    }
}
