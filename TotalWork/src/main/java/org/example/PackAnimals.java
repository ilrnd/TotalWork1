package org.example;

import java.util.Date;
import java.util.List;

public abstract class PackAnimals extends Animals {
    private final String type = "Pack Animals";

    public PackAnimals(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }
}
