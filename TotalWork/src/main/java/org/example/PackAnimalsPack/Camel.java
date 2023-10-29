package org.example.PackAnimalsPack;

import org.example.Commands;
import org.example.PackAnimals;

import java.time.LocalDate;
import java.util.Date;

public class Camel extends PackAnimals {

    public Camel(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }
}
