package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] cities = {"Харків", "Амстердам", "Варшава", "Лондон", "Київ"};
        boolean[] used = new boolean[cities.length];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Давай пограємо у «Міста». Ти перший називай!");

        char lastChar = ' ';
        boolean computerTurn = false;

        while (true) {
            if (!computerTurn) {
                System.out.print("Твій хід: ");
                String userInput = scanner.nextLine().trim();

                // Перевірка, чи місто не було вже використано
                boolean alreadyUsed = false;
                for (int i = 0; i < cities.length; i++) {
                    if (!used[i] && cities[i].equalsIgnoreCase(userInput)) {
                        used[i] = true;
                        lastChar = cities[i].charAt(cities[i].length() - 1);
                        alreadyUsed = true;
                        break;
                    }
                }

                if (!alreadyUsed) {
                    System.out.println("Ти ввів неправильне місто або вже використане. Спробуй інше!");
                    continue;
                }

                computerTurn = true;
            } else {
                System.out.println("Мій хід:");

                // Пошук міста, яке починається на відповідну літеру
                boolean found = false;
                for (int i = 0; i < cities.length; i++) {
                    if (!used[i] && cities[i].charAt(0) == Character.toUpperCase(lastChar)) {
                        System.out.println(cities[i]);
                        used[i] = true;
                        lastChar = cities[i].charAt(cities[i].length() - 1);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Я програв, ти знаєш більше за міста.");
                    break;
                }

                computerTurn = false;
            }
        }
        scanner.close();
    }
}