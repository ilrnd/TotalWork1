package org.example;

import org.example.Model.Animals;
import org.example.Model.Commands;
import org.example.Model.PackAnimalsPack.Camel;
import org.example.Model.PetsPack.Cat;
import org.example.Presenter.AnimalChecker;
import org.example.Presenter.AnimalsRegistry;
import org.example.View.Menu;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
    public void run() {
        Menu menu = new Menu();
        menu.startMenu();
    }
}