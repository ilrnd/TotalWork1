package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Animals {
    String name;
    Date dateOfBirth;
    String commands;

    public Animals(String name, Date dateOfBirth, String commands) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCommands() {
        return commands;
    }

    public void printAnimalInfo(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.printf("Name: %s, Date of Birth: %s, Commands: %s", name, dateFormat.format(dateOfBirth), commands);
    }
}
