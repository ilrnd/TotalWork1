package org.example.Model.PackAnimalsPack;

import org.example.Model.Commands;
import org.example.Settings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Camel extends PackAnimals {
    private final String type = "Camel";

    public Camel(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public void printAnimalInfo(){
        Settings settings = new Settings();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        System.out.printf("ID: %d, Name: %s, Type: %s, Date of Birth: %s, Commands: %s\n", getId(), getName(), type, getDateOfBirth(), getCommands().toString());
    }
}
