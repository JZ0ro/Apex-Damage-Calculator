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

    String equipableArmor [] =  { "white", "blue", "purple", "gold", "red" };

    String equipableHelmet [] = {"white", "blue", "purple", "gold" };
    
    private String legendName = "";
    
    private Integer currentHealth = 0;
   
    private String currentArmour = "";

    private String currentHelmet = "";
    
    private String weaponUsed = "";

    private String bodyPartShotAt = "";
    
    
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
                System.out.print("NOTICE: legend selection is case sensitive,"); 
                System.out.print(" please choose legends present in the list only");
                System.out.println("");           
            }
           
        }
        
       
        System.out.println("");
        System.out.println("How much health does " + legendName + " have? Please enter a non-negative value");
        
        boolean invalidLegendHealth = true;
        while (invalidLegendHealth == true) { 
            
            try {
                currentHealth = Integer.parseInt(currentLegend.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("NOTICE: Inputted health must be greater than 0, please try again");
                continue;
            }
             

            if (currentHealth <= 0) {
                continue;
            } else {
                invalidLegendHealth = false;
            }
        }
        
        
        System.out.println("");
        System.out.println("What kind of armor does " + legendName + " have?");
        System.out.println("Choose from the following: white, blue, purple, gold, or red armor");

        boolean invalidArmorSelection = true;

        while (invalidArmorSelection == true) {
            String legendShotArmor = currentLegend.nextLine();
            
            for (int i = 0; i < equipableArmor.length; i++) {
                if (legendShotArmor.equals(equipableArmor[i])) {
                    currentArmour = legendShotArmor;
                    invalidArmorSelection = false;
                    break;
                }
            }
            
            if (invalidArmorSelection == false) {
                break;
            } else {
                System.out.print("NOTICE: armor selection is case sensitive");
                System.out.print(", please try again");
                System.out.println("");
            }
        }
        
        
        System.out.println("");
        System.out.println("What kind of helmet does " + getLegendName() + " have?");
        System.out.println("Choose from the following: white, blue, purple or gold?");


        boolean invalidHelmetSelection = true;

        while (invalidHelmetSelection == true) {
            String legendShotHelmet = currentLegend.nextLine();

            for (int i = 0; i < equipableHelmet.length; i++) {
                if (legendShotHelmet.equals(equipableHelmet[i])) {
                    currentHelmet = legendShotHelmet;
                    invalidHelmetSelection = false;
                    break;
                }
            }

            if (invalidHelmetSelection == false) {
                break;
            } else {
                System.out.print("NOTICE: helmet selection is case sensitive");
                System.out.print(", please try again");
                System.out.println("");
            }
        }
        

        System.out.println("");
        getShotsToDown();
    }

    private String getLegendName () {
        return legendName;
    }

    private Integer getCurrentHealth () {
        return currentHealth;
    }

    private String getCurrentArmour () {
        return currentArmour;
    }

    private String getWeaponUsed() {
        return weaponUsed;
    }

    private String getCurrentHelmet() {
        return currentHelmet;
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

        boolean invalidArmorSelection = true;
        while (invalidArmorSelection == true) {
            String inputtedGun = currentGun.nextLine();

            for (int i = 0; i < useableWeapons.length; i++ ) {
                if (inputtedGun.equals(useableWeapons[i])) {
                    weaponUsed = inputtedGun;
                    invalidArmorSelection = false;
                    break;
                }
            }
            
            if (invalidArmorSelection == false) {
                break;
            } else {
                System.out.println("Note: weapon selection is case sensitive, please try again");
            }
        }
    
        
        System.out.println("");
        System.out.println("Where on the legend are you shooting? The body, legs, head or");
        System.out.println("would you like to provide a custom situtation?");
        Scanner scanner = new Scanner(System.in);

        String[] possibleSituations = {"body", "legs","head", "custom"};
        boolean invalidSituationSelected = true;
       
        while (invalidSituationSelected == true) {
            String desiredCalc = scanner.nextLine();  

            for (int i = 0; i < possibleSituations.length; i++) {
                if (desiredCalc.equals(possibleSituations[i])) {
                    invalidSituationSelected = false;
                    bodyPartShotAt = desiredCalc;
                    break;
                } 
            } 
            if (invalidSituationSelected == false) {
                break;
            } else {
                System.out.println("Situation selection is case sensitive, please try again");
            }
        }

        
        // if user is shooting a legend in the body
        if (bodyPartShotAt.equals("The body") || bodyPartShotAt.equals("body")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            bodyShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        
        // if user is shooting a legend in the legs
        else if (bodyPartShotAt.equals("legs")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            legShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown;
        } 
        
        // if user is shooting a legend in a custom situation
        else if (bodyPartShotAt.equals("custom")) {
            
            shotsToDown = customShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), getLegendName());
            System.out.println(shotsToDown);
            return shotsToDown;
        }
        
        // if user is shooting a legend in the head
        else if (bodyPartShotAt.equals("head")) {
            System.out.println("");
            
            shotsToDown = "It will take " + 
            headShotCalculator(getWeaponUsed(), getCurrentHealth(), getCurrentArmour(), 
            getLegendName(), getCurrentHelmet()) + " shots to down " + getLegendName();
            
            System.out.println(shotsToDown);
            return shotsToDown; 
        } 
        
        // if a user wishes to quit
        else if (bodyPartShotAt.equals("q")) {
            return "";
        } 
        
        
        else {
            return "Incorrect input given, please choose which case you desire. Note, input required is case sensitive";
        }

    }
    
}
