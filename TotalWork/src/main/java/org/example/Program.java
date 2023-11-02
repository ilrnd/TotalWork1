package org.example;

import org.example.View.Menu;
import org.example.resources.DBconnector;


public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
    public void run() {
        Menu menu = new Menu();
        menu.startMenu();
        DBconnector dBconnector = new DBconnector();
        dBconnector.connection();
    }
}