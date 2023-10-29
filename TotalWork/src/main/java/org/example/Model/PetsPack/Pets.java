package org.example.Model.PetsPack;

import org.example.Model.Animals;
import org.example.Model.Commands;

import java.time.LocalDate;

public abstract class Pets extends Animals {
    private final String superType = "Pets";

    public Pets(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public String getSuperType() {
        return superType;
    }
}
