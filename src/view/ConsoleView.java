package view;

import controller.UserController;
import java.util.Scanner;

public class ConsoleView {
    static Scanner scanner =  new Scanner(System.in);
    public static final String RESET = "\033[0m";
    public static final String BLUE = "\033[0;34m";
    public static final String RED = "\033[0;31m";
    public static void showMenu() {
        System.out.println(BLUE + "\n====================== MENU ======================" + RESET);
        System.out.println("""
                1. View Food Menu
                2. Add to Cart
                3. View Cart
                4. Remove from Cart
                5. Start Order
                6. Exit
                """);
    }
    public static void showMessage(String message) {
        System.out.println(message);
    }
    public static void login() {
        System.out.println(RED+"====================== Welcome to FoodPanda! ======================"+RESET);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (UserController.login(username, password)) {
            System.out.println(sound.SoundEffect.playSuccessSound()); // Alert sound
        } else {
            System.out.println(sound.SoundEffect.playFailSound());
            login();
        }
    }
    public static int getValidInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}