

import java.util.Scanner;

/**
 * Author: JZ0ro
 * 
 * Damage_Calculator.java is the "front end" of the apex damage
 * calculator. When run, it takes in user input. Utilzes 
 * legends.java and weapons.java to take user input and provide its
 * subsequent output.
 */

public class Damage_Calculator  {
    public static void main (String[] args) {
        
        //legend object created to start damage calculator
        legends runDamageCalc = new legends();

        boolean quit = false;
        while (quit != true) {
        System.out.println("");
        System.out.println("Would you like to try a calculation for a different legend?");
        System.out.println("If yes, input yes, else input no");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if (userInput.equals("no")) {
            quit = true;
        } 
        
        else if (userInput.equals("yes")) {
            legends legend2 = new legends();
        }
       }

    }
}
