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
    private Boolean fortifiedStatus = false;
    private String weaponUsed = "";

    public legends (String legendName, Integer currentHealth, String currentArmour, Boolean fortifiedStatus) {
        //REMIND: create more conditionals to account for incorrect arguements
        //Remind: Incorrect arguements examples: Integer for current Armour
        if (legendName == null || currentHealth == null || currentArmour == null || currentArmour == null || fortifiedStatus == null) {
            System.out.println("One of args given is null");
            throw new NullPointerException();
        } else {
            this.legendName = legendName;
            this.currentHealth = currentHealth;
            this.currentArmour = currentArmour;
            this.fortifiedStatus = fortifiedStatus;
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

    public Boolean getFortifiedStatus () {
        return fortifiedStatus;
    }

    public String getWeaponUsed() {
        return weaponUsed;
    }

    public String getShotsToDown () {
        Scanner currentGun = new Scanner(System.in);
        System.out.println("What gun are you using?");

        String inputtedGun = currentGun.nextLine();
        weaponUsed = inputtedGun;
        
        System.out.println("How comprehensive do you want your calculation to be?");
        System.out.println("Do you want to account for the best case, worst case, or custom? input q to exit.");
        Scanner scanner = new Scanner(System.in);

        String desiredCalc = scanner.nextLine();
        if (desiredCalc.equals("best case")) {
            return "It will take " + bestCaseCalculation() + " to down " + getLegendName();
        } else if (desiredCalc.equals("worst case")) {
            return desiredCalc;
        } else if (desiredCalc.equals("custom")) {
            return desiredCalc;
        } else if (desiredCalc.equals("q")) {
            return "";
        } else {
            return "Incorrect input given, please choose which case you desire. Note, input required is case sensitive";
        }
    }
    /**
     * bestCaseCalculation calculates the shots required to down a legend
     * when all shots fired are headshots on a white helmet
     * @return
     */
    public Integer bestCaseCalculatorInteger() { 
        //Best case scenario when legend only has white armor, full HP and is not fortified
        Integer damageRequired = 0;
        if (getCurrentArmour().equals("White Evo Shield") && getCurrentHealth() == 100 && getFortifiedStatus() != true) {
            
            return 
        }

    }
    
}
