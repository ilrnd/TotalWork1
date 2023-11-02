package org.example.View;

import org.example.Model.Animals;
import org.example.Model.Commands;
import org.example.Model.PackAnimalsPack.Camel;
import org.example.Model.PackAnimalsPack.Donkey;
import org.example.Model.PackAnimalsPack.Horse;
import org.example.Model.PetsPack.Cat;
import org.example.Model.PetsPack.Dog;
import org.example.Model.PetsPack.Hamster;
import org.example.Presenter.AnimalChecker;
import org.example.Presenter.AnimalsRegistry;
import org.example.Settings;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private Settings settings = new Settings();
    private Scanner scanner = new Scanner(System.in);
    private String inputName;
    private String inputDate;
    private String inputCommands = new String();
    Commands commands;

    private AnimalChecker animalChecker = new AnimalChecker();
    private AnimalsRegistry animalsRegistry = new AnimalsRegistry();

    public void startMenu() {
        System.out.println(settings.getMenuText());
        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("q")) {
            switch (inputCommand) {
                case "a":
                    menu1();
                    break;
                case "p":
                    animalsRegistry.printAnimalRegistry();
                    break;
                case "c":
                    System.out.println("Animals in register:");
                    System.out.println(animalsRegistry.getCounter());
                    break;
                case "v":
                    System.out.println("Input id of animals to look commands");
                    animalsRegistry.printAnimalRegistry();
                    String id = scanner.nextLine();
                    for (Animals animal:
                         animalsRegistry.getAnimalsList()) {
                        if (String.valueOf(animal.getId()).equals(id)){
                            System.out.println("You chose " + animal.getName());
                            System.out.println("Commands of " + animal.getName() +":");
                            System.out.println(animal.getCommands());
                        } else {
                            System.out.println("Sorry! But we don't find the animal with ID " + id);
                        }
                    }
                    break;
                case "n":
                    System.out.println("Input id of animals to add commands:");
                    id = scanner.nextLine();
                    Boolean flag = false;
                    for (Animals animal:
                            animalsRegistry.getAnimalsList()) {
                        if (String.valueOf(animal.getId()).equals(id)){
                            System.out.println("You chose " + animal.getName());
                            System.out.println("Commands of " + animal.getName() +":");
                            System.out.println(animal.getCommands());
                            System.out.println("Input one command to add:");
                            String newCommand = scanner.nextLine();
                            commands = animal.getCommands();
                            commands.addCommand(newCommand);
                            System.out.println("Wow! Look now commands of " + animal.getName() + ":");
                            System.out.println(animal.getCommands());
                            flag = true;
                        }
                    }
                    if (!flag){
                        System.out.println("Sorry! But we don't find the animal with ID " + id);
                    }
            }
            System.out.println(settings.getMenuText());
            inputCommand = scanner.nextLine();
        }
    }

    private void menu1() {
        String name;
        LocalDate DateOfBirth;
        Commands commands = new Commands();
        Animals animal;
        System.out.println("Please choose the type of animal " + settings.getAnimalsList());
        String menu1 = scanner.nextLine();
        if (settings.getAnimals().containsKey(menu1)) {
            System.out.println("Well! You choose " + settings.getAnimals().get(menu1));
            System.out.println("Input name: ");
            inputName = scanner.nextLine();
            name = animalChecker.nameChecker(inputName);
            System.out.println("Input date of birth (format: yyyy-MM-dd): ");
            inputDate = scanner.nextLine();
            DateOfBirth = animalChecker.dateChecker(inputDate);
            System.out.println("Input commands, separate by ',' :");
            inputCommands = scanner.nextLine();
            commands = animalChecker.commandsChecker(inputCommands);
            switch (menu1){
                case "1":
                    animal = new Cat(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
                case "2":
                    animal = new Dog(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
                case "3":
                    animal = new Hamster(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
                case "4":
                    animal = new Horse(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
                case "5":
                    animal = new Donkey(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
                case "6":
                    animal = new Camel(name, DateOfBirth, commands);
                    animalsRegistry.addAnimalToRegistry(animal);
                    break;
            }
        } else {
            System.out.println("Wrong number");
        }
        }

    }

