package org.example.Model.PetsPack;

import org.example.Model.Commands;
import org.example.Settings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hamster extends Pets {
    private final String type = "Hamster";
    public Hamster(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public String getType() {
        return type;
    }

    public void printAnimalInfo(){
        Settings settings = new Settings();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        System.out.printf("ID: %d, Name: %s, Type: %s, Date of Birth: %s, Commands: %s\n", getId(), getName(), type, getDateOfBirth(), getCommands().toString());
    }
}
