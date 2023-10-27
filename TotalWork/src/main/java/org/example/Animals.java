package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

abstract class Animals {
    String name;
    Date dateOfBirth;

    public Animals(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void getCommands() {
    }

    public void printAnimalInfo(){
        Settings settings = new Settings();
        SimpleDateFormat dateFormat = new SimpleDateFormat(settings.getDateFormat());
        System.out.printf("Name: %s, Date of Birth: %s, Commands: %s", name, dateFormat.format(dateOfBirth));
    }
}
