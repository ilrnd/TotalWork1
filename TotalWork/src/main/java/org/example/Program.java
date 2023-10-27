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
        Settings settings = new Settings();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formater = new SimpleDateFormat(settings.getDateFormat());
        String name = scanner.nextLine();
        String strDate  = scanner.nextLine();
        String commands = scanner.nextLine();
        Date date = null;
        try {
            date = formater.parse(strDate);
        } catch (ParseException e) {
            //throw new RuntimeException("Incorrect date type, correct type: yyyy-MM-dd");
            System.out.printf("Incorrect date format, correct format: %s", settings.getDateFormat());
        }
        Animals animal = new Pets(name, date);
        animal.printAnimalInfo();
    }
}