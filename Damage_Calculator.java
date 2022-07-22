import java.util.Scanner;


public class Damage_Calculator  {
    public static void main (String[] args) {
        /*legends BloodHound = new legends("BloodHound", 100, "White Evo Shield", "None");
        
        //System.out.println(BloodHound.getCurrentArmour());
        //System.out.println(BloodHound.getShotsToDown());
        System.out.println(BloodHound.getShotsToDown());**/
       //legends test = new legends();
        //legends Wraith = new legends("Wraith", 100, "White Evo");
        //legends Gibraltar = new legends ("Gibraltar", 100,"Red Evo");
       //legends Wraith = new legends ("Wraith", 100, "Red Evo");
       
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
