package org.example;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class PackAnimals extends Animals {
    private final String superType = "Pack Animals";


    public PackAnimals(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }
}
