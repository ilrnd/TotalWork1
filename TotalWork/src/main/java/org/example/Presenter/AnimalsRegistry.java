package org.example.Presenter;

import org.example.Model.Animals;
import org.example.resources.DBconnector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AnimalsRegistry {
    private List<Animals> animalsList = new ArrayList<>();
    private int counter;

    private DBconnector dBconnector = new DBconnector();

    public int getCounter() {
        return counter;
    }

    public List<Animals> getAnimalsList() {
        return animalsList;
    }

    public void printAnimalRegistry(){
        Collections.sort(animalsList);
        for(Animals animal: animalsList){
            animal.printAnimalInfo();
        }
    }

    public void addAnimalToRegistry(Animals animal){
        if (animal.getName() != null && animal.getDateOfBirth() !=null && animal.getCommands() != null) {
            animalsList.add(animal);
            counter++;
            dBconnector.addSQL("'" + animal.getName() +"'","'type'" , "'" + animal.getDateOfBirth().toString() + "'", "'" + animal.getCommands().toString() + "'");
        }
        else System.out.println("Adding animal is impossible, incorrect data format");
    }


}
