package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    private final String dateFormat = "yyyy-MM-dd";
    private final Map<String, String> animals = new HashMap<>();
    private final String[] animalsArr = {"cat", "dog", "hamster", "horse", "donkey", "camel"};

    {
        for (int i = 0; i < animalsArr.length; i++) {
            animals.put(String.valueOf(i + 1), animalsArr[i]);
        }
    }

    private final String menuText = "Input menu: \n" +
            "'a' - add animal,\n" +
            "'q' - quit\n" +
            "'p' - print animals\n" +
            "'c' - to look animal's count\n" +
            "'v' - to view commands of animal\n" +
            "'n' - to add new command for animal"
            ;


    public String getDateFormat() {
        return dateFormat;
    }

    public Map<String, String> getAnimals() {
        return animals;
    }

    public String getMenuText() {
        return menuText;
    }

    public String getAnimalsList(){
        return animals.toString();
    }
}
