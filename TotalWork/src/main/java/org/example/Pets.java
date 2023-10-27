package org.example;

import java.util.Date;

public class Pets extends Animals{
    private final String type = "Pets";

    public Pets(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }
}
