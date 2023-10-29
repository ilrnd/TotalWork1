package org.example.Model.PetsPack;

import org.example.Model.Commands;

import java.time.LocalDate;

public class Cat extends Pets {
    private final String type = "Cat";
    public Cat(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public String getType() {
        return type;
    }
}
