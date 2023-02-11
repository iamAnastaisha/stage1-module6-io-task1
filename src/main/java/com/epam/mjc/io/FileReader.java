package com.epam.mjc.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        String str = "";
        try (FileInputStream in = new FileInputStream(file)) {
            int c;
            while ((c = in.read()) != -1) {
                str = str.concat(Character.toString(c));
            }
            String[] lines = str.split("\n");
            profile.setName(lines[0].substring(lines[0].indexOf(':') + 2, lines[0].length()-1));
            String age = lines[1].substring(lines[1].indexOf(':') + 2, lines[1].length()-1);
            if (!age.equals("")) {
                profile.setAge(Integer.parseInt(age));
            }
            profile.setEmail(lines[2].substring(lines[2].indexOf(':') + 2, lines[2].length()-1));
            String phone = lines[1].substring(lines[1].indexOf(':') + 2, lines[1].length()-1);
            if (!phone.equals("")) {
                profile.setPhone(Long.parseLong(phone));
            }
        } catch (IOException ex) {

            System.err.println(ex);
        }
        return profile;
    }
}
