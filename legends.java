/**
 * Author: JZ0ro
 * 
 * legends.java creates the legends we will be taking information
 * from such as their health, armor, and fortified status.
 * This class will have acess to calculator methods which
 * will calculate the damage required to kill a legend based off 
 * three choices, a best case, worst case, and custom case.
 * Actual calculations overhauled to a different classes.
 */

import java.util.Scanner;

public class legends extends Weapons {

    private String [] playableLegends = {"Wraith", "Bangalore", 
    "Mirage", "Octane", "Revenant", "Horizon", "Fuse", "Ash", 
    "Mad Maggie", "Fade", "Gibraltar", "Caustic", "Wattson",
    "Rampart", "Newcastle", "Lifeline", "Loba", "Bloodhound",
    "Pathfinder", "Crypto", "Valkyrie", "Seer"};
    
    private String legendName = "";
    
    private Integer currentHealth = 0;
   
    private String currentArmour = "";
    
    private String weaponUsed = "";
    
    
    /*
     * Default constructor that instantiates a legend object
     * When called, constructor asks for legend in question
     * and gives said legend all white/basic armor.
     */
    public legends() {
        boolean invalidLegendChosen = true;
        Scanner currentLegend = new Scanner(System.in);
        while (invalidLegendChosen == true) {

        System.out.println("What legend are you currently shooting at right now?");
        System.out.println("");
        System.out.println("Please choose from this list");
            for (int i = 0; i < playableLegends.length; i++) {
                System.out.println(playableLegends[i]);
            }
        
            System.out.println("");
            
            legendName = currentLegend.nextLine();
            

            for (int i = 0; i < playableLegends.length; i++) {
                if (legendName.equals(playableLegends[i])) {
                    
                    invalidLegendChosen = false;
                    break;
                }
            }
            
            if (invalidLegendChosen == false) {
                break;
            } else {
                System.out.println("NOTICE: legend selection is case sensitive, please choose legends present in the list only");            }
           
        }
        
       
        System.out.println("");
        System.out.println("How much health does " + legendName + " have? Please enter a non-negative value");
        
        boolean invalidLegendHealth = false;
        while (invalidLegendHealth == false) {
            currentHealth = Integer.parseInt(currentLegend.nextLine()); //TODO AUTOMATE USER INPUT CHECKER

            if (currentHealth < 0) {
                continue;
            } else {
                invalidLegendHealth = true;
            }
        }
        
        
        
        
        System.out.println("");
        System.out.println("What kind of armor does " + legendName + " have?");
        System.out.println("Choose from the following: white, blue, purple, gold, or red armor");
        String legendShotArmor = currentLegend.nextLine();
        currentArmour = legendShotArmor;
        
        System.out.println("");
        getShotsToDown();
    }

    public String getLegendName () {
        return legendName;
    }

    public Integer getCurrentHealth () {
        return currentHealth;
    }

    public String getCurrentArmour () {
        return currentArmour;
    }

    public String getWeaponUsed() {
        return weaponUsed;
    }

    
    /**
     * Getter method that gets the
     * shots to down the inputted legend
     * 
     * @return returns the shots to down the inputted legend
     */
    private String getShotsToDown () {
        String shotsToDown = "";
        Scanner currentGun = new Scanner(System.in);
        System.out.println("What gun are you using?");
        System.out.println("");
        System.out.println("Please choose from the following: ");

        for (int i = 0; i < useableWeapons.length; i++) {
            System.out.println(useableWeapons[i]);
        }
        System.out.println("Note: Please type the selected weapon with a capital letter first");

        
        String inputtedGun = currentGun.nextLine();
        weaponUsed = inputtedGun;
        
        System.out.println("");
        System.out.println("Where on the legend are you shooting? The body, legs, head or");
        System.out.println("would you like to provide a custom situtation?");
        //System.out.println("NOTICE: Choosing the options of the body, legs, or head will only output the shots required to down a legend if shot at the inputted body part");
        Scanner scanner = new Scanner(System.in);


        String desiredCalc = scanner.nextLine();        
        
        // if user is shooting a legend in the body
        if (desiredCalc.equals("The body") || desiredCalc.equals("body")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            bodyShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        
        // if user is shooting a legend in the legs
        else if (desiredCalc.equals("legs")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            legShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        
        // if user is shooting a legend in a custom situation
        else if (desiredCalc.equals("custom")) {
            
            shotsToDown = customShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName());
            System.out.println(shotsToDown);
            return shotsToDown;
        }
        
        // if user is shooting a legend in the head
        else if (desiredCalc.equals("head")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            headShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown; 
        } 
        
        // if a user wishes to quit
        else if (desiredCalc.equals("q")) {
            return "";
        } 
        
        
        else {
            return "Incorrect input given, please choose which case you desire. Note, input required is case sensitive";
        }

    }
    
}
