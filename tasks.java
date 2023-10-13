/* PRE-INTERVIEW ASSIGNMENT

Thank you for your interest in the position. We would like to ask you
to solve the following tasks. After each task, you are asked to save a
copy of your code in a new file. These are the files we want to
see. Give it 1 to 3 hours of your best effort and email your source 
code back to us.

Good luck! :)

==TASKS==

1. The program below contains a bug, tagged with a FIXME comment in
the code. Fix it. Do not change any more code than necessary. Save a
copy of your code as task1.java.

2. With the result from task 1 as your starting point, do one of the
following:

A) If you are most comfortable with Java: Refactor the code to make it
easier to read, maintain, and extend. Save a copy of your code as
task2.java.

B) Rewrite the program in the programming language you are most
comfortable with. It should work exactly the same, but you are free to
structure the code differently from the original. Save a copy of your
code in a file that has "task2" as part of its name.

3. With the result from task 2 as your starting point, implement the
feature specified below. Save a copy of your code in a file that has
"task3" as part of its name.

Specification: There should be a finite amount of servings for each
 dish on the menu, i.e. 15 Dagens, 2 Vegetar, 5 Halal. Requesting a
 dish that has no servings left should return the message "Sorry, no
 more left of <dish name> today."


Example run:
What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)
> Vegetar
Vegetar, here you go.
What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)
> Vegetar
Vegetar, here you go.
What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)
> Vegetar
Sorry, no more left of <Vegetar> today.
What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)
> [...]

*/


import java.util.Scanner;

class Cafeteria {
    String[] menu = new String[] { "Dagens", "Vegetar", "Halal" };
    double[] prices = new double[] {
        53.90D, // for Dagens
        42.50D, // for Vegetar
        59.90D // for Halal
    };
    double sum = 0D;
    double totalSum = 0D;

    void sell(String item) throws Exception {
        if (item.equals("Dagens")) {
            sum = sum + prices[0];
            totalSum = totalSum + prices[0];
            System.out.println("Dagens, here you go.");
        }
        else if (item.equals("Vegetar")) {
            sum = sum + prices[1];
            totalSum = totalSum + prices[1];
            System.out.println("Vegetar, here you go.");
        }
        else if (item.equals("Halal")) {
            sum = sum + prices[2];
            totalSum = totalSum + prices[2];
            System.out.println("Halal, here you go.");
        }
        else {
            throw new Exception(item + " is not on the menu.");
        }
    }

    void emptyCashRegistry() {
        sum = 0D;
        System.out.println("Cash registry emptied. Thieves be warned!");
    }

    public static void main(String[] args) {
        Cafeteria fredrikke = new Cafeteria();
        System.out.println("What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("not hungry")) {
            boolean notAQuestion = false;
            if (input.equals("how is business?")) {
                notAQuestion = true;
                if (fredrikke.totalSum == 0) {
                    System.out.println("Not good so far. No one seems to be hungry today!");
                } else if (fredrikke.totalSum > 0) {
                    System.out.println("Alright. Could have been better");
                } else if (fredrikke.totalSum > 500) {
                    // FIXME: this doesn't work properly
                    System.out.println("Excellent! Lots of hungry students around today.");
                }
            }
            if (!notAQuestion) {
                try {
                    fredrikke.sell(input);
                } catch (Exception e) {
                    System.out.println("Sorry: " + e.getMessage());
                }
            }
            if (fredrikke.sum > 200) {
                fredrikke.emptyCashRegistry();
            }
            System.out.println("What would you like today? (type 'how is business?' to attempt small talk, or 'not hungry' to stop)");
            System.out.print("> ");
            input = scanner.nextLine();
        }
        System.out.println("Welcome back later!");
    }
}
