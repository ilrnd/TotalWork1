package org.example.Model.PackAnimalsPack;

import org.example.Model.Commands;

import java.time.LocalDate;

public class Camel extends PackAnimals {

    public Camel(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }
}
