package com.epam.mjc.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            profile.setName(lines[0].substring(lines[0].indexOf(':') + 2));
            String age = lines[1].substring(lines[1].indexOf(':') + 2);
            if (!age.equals("")) {
                profile.setAge(Integer.parseInt(age));
            }
            profile.setEmail(lines[2].substring(lines[2].indexOf(':') + 2));
            String phone = lines[3].substring(lines[3].indexOf(':') + 2);
            if (!phone.equals("")) {
                profile.setPhone(Long.parseLong(phone));
            }
        } catch (IOException ex) {
            Logger logger = Logger.getLogger(
                    FileReader.class.getName());
            logger.log(Level.WARNING, ex.toString());
        }
        return profile;
    }
}
