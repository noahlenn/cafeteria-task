/*

3. With the result from task 2 as your starting point, implement the
feature specified below. Save a copy of your code in a file that has
"task3" as part of its name.

Specification: There should be a finite amount of servings for each
 dish on the menu, i.e. 15 Dagens, 2 Vegetar, 5 Halal. Requesting a
 dish that has no servings left should return the message "Sorry, no
 more left of <dish name> today."
 
*/

import java.util.Scanner;

class Cafeteria {

    String[] menu = new String[] { "Dagens", "Vegetar", "Halal" };
    double[] prices = new double[] {
        53.90D, // for Dagens
        42.50D, // for Vegetar
        59.90D // for Halal
    };
    int[] servings = new int[] {
        15, // for Dagens
        2, // for Vegetar
        5 // for Halal
    };

    void displayMenu(){
        System.out.println("===MENY===");
        for(int i = 0; i < menu.length; i++) {
            System.out.println(menu[i] + " " + prices[i] + "kr");
        }
        System.out.println("==========");
    }


    double sum = 0.0;
    double totalSum = 0.0;

    void sell(String item) throws Exception {
        for (int i = 0; i < menu.length; i++) {
            if (item.equals(menu[i])) {
                if (servings[i] > 0) {
                    sum += prices[i];
                    totalSum += prices[i];
                    servings[i]--;
                    System.out.println(item + ", here you go.");
                    return;
                } else {
                    throw new Exception("Sorry, no more left of " + item + " today");
                }

            }
        }
        throw new Exception(item + " is not on the menu.");
    }


    void emptyCashRegistry() {
        sum = 0D;
        System.out.println("Cash registry emptied. Thieves be warned!");
    }


    void businessStatus() {
        if (totalSum == 0) {
            System.out.println("Not good so far. No one seems to be hungry today!");
        } else if (totalSum > 500) {
            System.out.println("Excellent! Lots of hungry students around today.");
        } else if (totalSum > 0) {
            System.out.println("Alright. Could have been better");
        }

    }


    void handleCustomer() {

        while (true) {
            System.out.println("What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)");

            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("not hungry")) {
                System.out.println("Welcome back later!");
                scanner.close();
                break;
            }

            if (input.equals("how is business?")) {
                businessStatus();
            } else {
                try {
                    sell(input);
                } catch (Exception e) {
                    System.out.println("Sorry: " + e.getMessage());
                }
            }

            if (sum > 200) {
                emptyCashRegistry();
            }
        }
    }


    public static void main(String[] args) {

        Cafeteria fredrikke = new Cafeteria();

        fredrikke.displayMenu();

        fredrikke.handleCustomer();
    }
}
