package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String name = scanner.nextLine();
        String strDate  = scanner.nextLine();
        String commands = scanner.nextLine();
        Date date;
        try {
            date = formater.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Animals animal = new Pets(name, date, commands);
        animal.printAnimalInfo();
    }
}