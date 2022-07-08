/**
 * legends.java creates the legends we will be taking information
 * from such as their health, armor, and fortified status.
 * This class will have acess to calculator methods which
 * will calculate the damage required to kill a legend based off 
 * three choices, a best case, worst case, and custom case.
 * Actual calculations overhauled to a different classes.
 */

import java.util.Scanner;

public class legends extends Weapons {
    
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
        Scanner currentLegend = new Scanner(System.in);
        System.out.println("What legend are you currently shooting at right now?");
        
        
        String legendBeingShot = currentLegend.nextLine();
        legendName = legendBeingShot;
        
       
        System.out.println("");
        System.out.println("How much health does " + legendName + " have? Please enter a value");
        Integer legendShotHealth = Integer.parseInt(currentLegend.nextLine());
        currentHealth = legendShotHealth;
        
        
        System.out.println("");
        System.out.println("What kind of armor does " + legendName + " have? White, Blue, Purple, Gold, or Red");
        String legendShotArmor = currentLegend.nextLine();
        currentArmour = legendShotArmor;
        
        System.out.println("");
        getShotsToDown();
    }
    /**
     * Custom constructor that instantiates a 
     * legend object with given argumenets
     *
     *  @param legendName The legends current named
     * @param currentHealth The legends current health
     * @param currentArmour The legends current Armor
     */
    public legends (String legendName, Integer currentHealth, String currentArmour) {
        //REMIND: create more conditionals to account for incorrect arguements
        //Remind: Incorrect arguements examples: Integer for current Armour
        if (legendName == null || currentHealth == null || currentArmour == null || currentArmour == null) {
            System.out.println("One of args given is null");
            throw new NullPointerException();
        } else {
            this.legendName = legendName;
            this.currentHealth = currentHealth;
            this.currentArmour = currentArmour;

            System.out.println("The current legend selected is " + getLegendName());
            System.out.println("");

            getShotsToDown();
        }
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

    private String getShotsToDown () {
        String shotsToDown = "";
        Scanner currentGun = new Scanner(System.in);
        System.out.println("What gun are you using?");

        
        String inputtedGun = currentGun.nextLine();
        weaponUsed = inputtedGun;
        
        System.out.println("");
        System.out.println("Where on the legend are you shooting? The body, legs, head or custom?");
        Scanner scanner = new Scanner(System.in);


        String desiredCalc = scanner.nextLine();        
        if (desiredCalc.equals("The body") || desiredCalc.equals("body")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            bodyShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        else if (desiredCalc.equals("legs")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            legShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        else if (desiredCalc.equals("custom")) {
            return shotsToDown;
        } 
        else if (desiredCalc.equals("q")) {
            return "";
        } 
        else {
            return "Incorrect input given, please choose which case you desire. Note, input required is case sensitive";
        }

    }
    
}
