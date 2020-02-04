
/**
 * This program is part 1 of Yahtzee
 * - Gives out three rolls
 * - Computes possible points for score sheet slots
 *
 * CPSC224, Spring 2020
 * Yahtzee Homework #1
 * No sources to cite.
 *
 * @author Jordan Maddox
 * @version v1.0
 */

import java.util.Random;
import java.util.Scanner;

public class YahtzeeHW1 {

        static final int NUM_DIE = 5;

        public static int main(String[] args) {

            Scanner kb = new Scanner(System.in);
            int[] hand = new int[NUM_DIE];
            String[] keep = new String[NUM_DIE];

            System.out.print("Welcome to Yahtzee: Part 1.");
            System.out.println();

            int again;
            do {

                //play hand
                int turn = 1;
                keep[0] = "n";
                keep[1] = "n";
                keep[2] = "n";
                keep[3] = "n";
                keep[4] = "n";

                while (turn < 4 && keep[0] != "y" && keep[1] != "y" && keep[2] != "y" && keep[3] != "y" && keep[4] != "y") {

                    //roll die not wanted
                    for (int i = 0; i < hand.length; i++) {
                        if (keep[i].equals("n")) {
                            hand[i] = randomDie();
                        }
                    }

                    //display roll
                    System.out.println("Roll: ");
                    for (int dieNumber = 0; dieNumber < NUM_DIE; dieNumber++) {
                        System.out.println(hand[dieNumber]);
                    }

                    System.out.println();

                    //roll again if turns left
                    if (turn < 3) {
                        System.out.println("Enter dice to keep (y or n): ");
                        //keep = kb.nextLine();
                    }

                }


                //display scorecard
                System.out.println();
                System.out.println("Your Scorecard: ");
                System.out.println();

                //upper scorecard
                for (int scoreSlot = 1; scoreSlot <= 6; scoreSlot++) {
                    int count = 0;
                    for (int dieSlot = 0; dieSlot < 5; dieSlot++) {
                        if (hand[dieSlot] == scoreSlot) {
                            count++;
                        }
                    }

                    System.out.println("Score: " + scoreSlot * count + " on the " + scoreSlot + " line.");
                    System.out.println();

                }
                //lower scorecard


                //ask user if they want to play the game again
                System.out.println("Would you like to play again? (1 = yes, 0 = no)");
                again = kb.nextInt();

            } while (again == 1) ;
        }

        private static int randomDie() {
            Random randRef = new Random();
            int randDie = randRef.nextInt(6);
            int i = randDie + 1;
            return i;
        }


}
