import java.util.Scanner;


public class Damage_Calculator  {
    public static void main (String[] args) {
        legends legend1 = new legends();

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
