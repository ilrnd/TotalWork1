package org.example.Model;

import org.example.Settings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animals implements Traineble, Comparable<Animals> {
    private static int count = 0;
    private int id;
    final private String name;
    final private LocalDate dateOfBirth;
    private Commands commands;
    {
         this.id = ++count;
    }

    public Animals(String name, LocalDate dateOfBirth, Commands commands) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Commands getCommands() {
        return commands;
    }

    public int getId() {
        return id;
    }

    public void setCommands(Commands commands) {
        this.commands = commands;
    }

    public void printAnimalInfo(){
        Settings settings = new Settings();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        System.out.printf("ID: %d Name: %s, Date of Birth: %s, Commands: %s\n", id, name, dateOfBirth, commands.toString());
    }

    public void printCommands(){
        System.out.println(commands.toString());
    }

    @Override
    public int compareTo(Animals o) {
        return  this.getDateOfBirth().compareTo(o.getDateOfBirth());
    }

}
