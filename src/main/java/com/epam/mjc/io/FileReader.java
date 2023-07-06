package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();

        try(FileInputStream inputStream = new FileInputStream(file)){

            String fileData = "";

            int c;
            while((c = inputStream.read()) != -1){
                fileData += (char)c;
            }

            String[] lines = fileData.split("\n");

            for (String line : lines) {

                String[] splited = line.split(":");

                String key = splited[0].trim();
                String value = splited[1].trim();

                switch (key){
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
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        return profile;
    }
}
