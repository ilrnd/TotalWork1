package org.example.PetsPack;

import org.example.Commands;
import org.example.Pets;

import java.time.LocalDate;
import java.util.Date;

public class Cat extends Pets {
    private final String type = "Cat";
    public Cat(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public String getType() {
        return type;
    }
}
