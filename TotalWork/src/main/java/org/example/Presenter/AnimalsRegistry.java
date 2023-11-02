package org.example.Presenter;

import org.example.Model.Animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalsRegistry {
    private List<Animals> animalsList = new ArrayList<>();
    private int counter;

    public int getCounter() {
        return counter;
    }

    public List<Animals> getAnimalsList() {
        return animalsList;
    }

    public void printAnimalRegistry(){
        for(Animals animal: animalsList){
            animal.printAnimalInfo();
        }
    }

    public void addAnimalToRegistry(Animals animal){
        if (animal.getName() != null && animal.getDateOfBirth() !=null && animal.getCommands() != null) {
            animalsList.add(animal);
            counter++;
        }
        else System.out.println("Adding animal is impossible, incorrect data format");
    }


}
