/*Program rolls two die and prints the result of the roll as to ints. Keeps generating
* rolls until the sum of the two die equals 8. Program then reports the number of rolls
* needed to achieve that result and asks the user if they would like to try again. Keeps
* running the script as long as user enters "Yes" when prompted. Quits when anything else
* is entered. */

// Author: Nathan Heidt
// Date Due: 9-11-2019

import java.util.Scanner;

public class CSIS335Program2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean tryAgain = true;

        while (tryAgain) {
            rollDiceForResult(2, 6, 8);
            System.out.print("Try Again? (Yes/No): ");
            String choice = input.next().toLowerCase();
            if (choice.equals("yes")) { }
            else { tryAgain = false; }
        }
    }
    /*Utilized StackOverflow to gain an understanding of how Math.random() worked
    * as well as a few nuances on how to use it in the scenario of rolling dice.*/
    //URL: https://stackoverflow.com/questions/7961788/math-random-explanation/16624834

    private static int tossDice(int numSides) {
        return (int)(Math.random() * numSides + 1);
    }

    private static void rollDiceForResult(int dieRolled, int numSides, int desiredResult) {
        int tmpResult = 0;
        int tries = 0;

        if (desiredResult > (dieRolled * numSides) | desiredResult < dieRolled) {
            System.out.printf("Can't roll a total of %d with %d %d-sided dice.%n",
                               desiredResult, dieRolled, numSides);
            return;
        }
        while (tmpResult != desiredResult) {
            tmpResult = 0;
            tries++;
            System.out.print("Toss:");
            for (int dice = 1; dice <= dieRolled; dice++) {
                int toss = tossDice(numSides);
                System.out.printf(" %d", toss);
                tmpResult += toss;
            }
            System.out.print("**");
        }
        System.out.printf("%nYou won in %d rolls.%n", tries);
    }
}
