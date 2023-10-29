package org.example;

import java.time.LocalDate;
import java.util.Date;

public abstract class Pets extends Animals{
    private final String superType = "Pets";

    public Pets(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }

    public String getSuperType() {
        return superType;
    }
}
