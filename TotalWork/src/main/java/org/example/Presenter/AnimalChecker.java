package org.example.Presenter;

import org.example.Model.Animals;
import org.example.Model.Commands;
import org.example.Settings;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalChecker {
    private Settings settings = new Settings();


    public String nameChecker(String name){
        return name;
    }

    public LocalDate dateChecker(String dateOfBirthStr){
        LocalDate dateOfBirth = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        try {
            dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
        } catch (DateTimeException e) {
            System.out.println("Incorrect date format, please input date format as " + settings.getDateFormat() + "\n");
        }
        return dateOfBirth;
    }

    public Commands commandsChecker(String commandsStr){
        String[] commandsStrArr = commandsStr.split(",");
        Commands commands = new Commands();
        for (String command: commandsStrArr){
            commands.addCommand(command);
        }
        return commands;
    }
}
