package com.epam.mjc.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        FileInputStream in = null;
        String str = "";
        try {
            in = new FileInputStream("Profile.txt");
            int c;
            while ((c = in.read()) != -1) {
                str = str.concat(Character.toString(c));
            }
            in.close();
            String[] lines = str.split("\n");
            profile.setName(lines[0].substring(lines[0].indexOf(':') + 2));
            profile.setAge(Integer.parseInt(lines[1].substring(lines[1].indexOf(':') + 2)));
            profile.setEmail(lines[2].substring(lines[2].indexOf(':') + 2));
            profile.setPhone(Long.parseLong(lines[3].substring(lines[3].indexOf(':') + 2)));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return profile;
    }
}
