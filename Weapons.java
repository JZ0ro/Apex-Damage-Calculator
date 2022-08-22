import java.util.Scanner;

/**
 * Weapons.java contains the possible damage outputs for all the
 * equipable weapons in Apex legends. The damage outputs for each
 * weapon will account for white, blue, purple/gold, and red armor.
 * 
 */

 //NOTE: Address 30-30 damage, for now assume shot is at full charge.
 //NOTE:Use same assumption for bow and charge rifle.
 //When calculating damage for shotguns, assume all pellets hit for now.
 //Note: When calculating guns with the hammerpoint attachment, disregard
 //added damage from said attachements
abstract class Weapons {
    String [] useableWeapons = {"HAVOC","Flatline", 
    "Hemlok", "R-301", "Alternator","Prowler","R-99", "Volt", 
    "C.A.R", "Devotion", "L-STAR", "Spitfire", "Rampage", "G7", "Triple Take", "30-30",
     "Bocek","Charge Rifle", "Longbow", "Kraber", "Sentinel", "EVA-8", "Mastiff", "Mozambique", 
     "Peacekeeper", "RE-45", "P2020", "Wingman"}; //Note: assume all three triple take shots hit,
    
    
    /** NOTE: The 3 integer arrays below each represent damage values of the useable weapons in the game.
    *The damage values are ordered in the order of useableWeapons String array.
    *I.E The first damage value corresponds to the Havoc, the second being the flatline
    *and so on and so fourth*/
    
     Integer [] bodyShotDamageValues = {18, 18, 20, 14, 16, 14, 11, 15, 13, 15, 
    17, 18, 26, 34, 63, 57, 70, 90, 55, 140, 70, 54, 112, 45, 99, 12, 18, 45};

    Integer [] legShotDamageValues = {15, 14, 15, 11, 13, 11, 9, 12, 10, 13, 
    14, 15, 22, 26, 57, 48, 63, 90, 44, 112, 63, 54, 112, 45, 99, 11, 16, 41};
    
    Integer [] headShotDamageValues = {32, 32, 35, 25, 24, 21, 17, 23, 20, 
    23, 26, 27, 39, 60, 111, 100, 123, 101, 118, 280, 140, 72, 144, 57, 121, 18, 27, 97};

    String [] useableShields = {"White Evo", "Blue Evo", "Purple Evo", "Gold Evo", "Red Evo"};

    Integer [] shieldHealthValues = {50, 75, 100, 100, 125};

    private final Double fortifiedModifier = 0.15;

    /**
     * bodyShotCalculator calculates the body shots
     * required to down a apex legend
     * 
     * @param currentWeapon the current weapon used
     * @param currentHealth the current health of the legend in question
     * @param currentArmor the current armor of the legend in question
     * @param currentLegend the current legend in question 
     * 
     * @return returns the body shots required to take down an apex legend
     */
    public Integer bodyShotCalculator(String currentWeapon, Integer currentHealth, String currentArmor, String currentLegend) {
        
        Integer totalHealthLeft = 0;
        Double fortifiedLegendHealth = 0.0;
        Integer weaponDamage = 0;
        Integer shotsFired = 0;

        for (int i = 0; i < useableWeapons.length; i++) {
            if (currentWeapon.equals(useableWeapons[i])) {
                weaponDamage = bodyShotDamageValues[i];
                break;
            }
        }
            
        currentArmor = armorSlangTranslator (currentArmor);

        for (int i = 0; i < useableShields.length; i++) {
            if (currentArmor.equals(useableShields[i])) {
                totalHealthLeft = currentHealth + shieldHealthValues[i];
                fortifiedLegendHealth = (double) currentHealth.intValue() + shieldHealthValues[i];
            }
        }
       
        if (currentLegend.equals("Gibraltar") || currentLegend.equals("Caustic")) {
            Double fortifiedWeaponDamage = ((double)weaponDamage.intValue() - ((double) weaponDamage.intValue() * fortifiedModifier)); 
            while (fortifiedLegendHealth >= 0.0) {
                fortifiedLegendHealth = fortifiedLegendHealth - fortifiedWeaponDamage;
                shotsFired += 1;
            }
        } 
        
        else {
            while (totalHealthLeft >= 0) {
            totalHealthLeft = totalHealthLeft - weaponDamage;
            shotsFired += 1;
            }
        }
        return shotsFired;
    }

    public Integer legShotCalculator (String currentWeapon, Integer currentHealth, String currentArmor, String currentLegend) {
        Integer totalHealthLeft = 0;
        Double fortifiedLegendHealth = 0.0;
        Integer weaponDamage = 0;
        Integer shotsFired = 0;

        for (int i = 0; i < useableWeapons.length; i++) {
            if (currentWeapon.equals(useableWeapons[i])) {
                weaponDamage = legShotDamageValues[i];
                break;
            }
        }

        currentArmor = armorSlangTranslator (currentArmor);

        for(int i = 0; i < useableShields.length; i++) {
            if (currentArmor.equals(useableShields[i])) {
                totalHealthLeft = currentHealth + shieldHealthValues[i];
                fortifiedLegendHealth = (double) currentHealth.intValue() + shieldHealthValues[i];
            }
        }
        
        if (currentLegend.equals("Gibraltar") || currentLegend.equals("Caustic")) {

            Double fortifiedWeaponDamage = ((double)weaponDamage.intValue() - ((double) weaponDamage.intValue() * fortifiedModifier)); 

            while (fortifiedLegendHealth >= 0.0) {
                fortifiedLegendHealth = fortifiedLegendHealth - fortifiedWeaponDamage;
                shotsFired += 1;
            }
        } 
        
        else {
            while (totalHealthLeft >= 0) {
            totalHealthLeft = totalHealthLeft - weaponDamage;
            shotsFired += 1;
        }
        }
        
        return shotsFired;
    }

    public Integer headShotCalculator (String currentWeapon, Integer currentHealth, String currentArmor, String currentLegend) {
        Integer totalHealthLeft = 0;
        Double fortifiedLegendHealth = 0.0;
        Integer weaponDamage = 0;
        Integer shotsFired = 0;

        for (int i = 0; i < useableWeapons.length; i++) {
            if (currentWeapon.equals(useableWeapons[i])) {
                weaponDamage = headShotDamageValues[i];
                break;
            }
        }

        currentArmor = armorSlangTranslator (currentArmor);

        for(int i = 0; i < useableShields.length; i++) {
            if (currentArmor.equals(useableShields[i])) {
                totalHealthLeft = currentHealth + shieldHealthValues[i];
                fortifiedLegendHealth = (double) currentHealth.intValue() + shieldHealthValues[i];
            }
        }
        
        
        if (currentLegend.equals("Gibraltar") || currentLegend.equals("Caustic")) {

            Double fortifiedWeaponDamage = ((double)weaponDamage.intValue() - ((double) weaponDamage.intValue() * fortifiedModifier)); 

            while (fortifiedLegendHealth >= 0.0) {
                fortifiedLegendHealth = fortifiedLegendHealth - fortifiedWeaponDamage;
                shotsFired += 1;
            }
        } 
        
        else {
            while (totalHealthLeft >= 0) {
            totalHealthLeft = totalHealthLeft - weaponDamage;
            shotsFired += 1;
        }
        }
        
        return shotsFired;
    }

    public String customShotCalculator (String currentWeapon, Integer currentHealth, String currentArmor, String currentLegend) {
        int totalHealthLeft = 0;
        Double fortifiedLegendHealth = 0.0;
        Integer weaponDamage = 0;
    
        Integer bodyShotsGiven = 0;
        Integer legShotsGiven = 0;
        Integer headShotGiven = 0;

        System.out.println("");
        System.out.println("You have selected custom!");
        System.out.println("");
    
        System.out.println("How many body shots have you hit on the legend?");
        
        Scanner bodyShotscanner = new Scanner(System.in);
        bodyShotsGiven = bodyShotscanner.nextInt();

        System.out.println("How many leg shots have you hit on the legend?");

        Scanner legShotScanner = new Scanner(System.in);
        legShotsGiven = legShotScanner.nextInt();

        System.out.println("How many head shots have you hit on the legend?");

        Scanner headShotScanner = new Scanner(System.in);
        headShotGiven = headShotScanner.nextInt();

        //token used to get specific weapon damage values
        Integer currentWeaponToken = 0;

        for (int i = 0; i < useableWeapons.length; i++) {
            if (currentWeapon.equals(useableWeapons[i])) {
                currentWeaponToken = i;
                break;
            }
        }

        currentArmor = armorSlangTranslator(currentArmor);

        for(int i = 0; i < useableShields.length; i++) {
            if (currentArmor.equals(useableShields[i])) {
                totalHealthLeft = currentHealth + shieldHealthValues[i];
                fortifiedLegendHealth = (double) currentHealth.intValue() + shieldHealthValues[i];
            }
        }

        int bodyShotDamageGiven = 0;
        int legShotDamageGiven = 0;
        int headShotDamageGiven = 0;
        
        if (bodyShotsGiven > 0) {
            for (int i = 0; i < bodyShotsGiven; i++) {
                bodyShotDamageGiven += bodyShotDamageValues[currentWeaponToken];
            }
        } if (legShotsGiven > 0) {
            for (int i = 0; i < bodyShotsGiven; i++) {
                legShotDamageGiven += legShotDamageValues[currentWeaponToken];
            }
        } if (headShotGiven > 0) {
            for (int i = 0; i < headShotGiven; i++) {
                headShotDamageGiven += headShotDamageValues[currentWeaponToken];
            }
        }
        
        int totalShots = bodyShotsGiven + legShotsGiven + headShotGiven;
        int totalDamage = bodyShotDamageGiven + legShotDamageGiven + headShotDamageGiven;
        int healthAfterHit  = Math.abs(totalDamage - totalHealthLeft);
        
        String customShotOutput = "You Shot a total of " + totalShots + " on " + 
        currentLegend +  " and did a total of " + totalDamage + " damage.";

        if (totalDamage > totalHealthLeft) {
            
            String deathReport = "The legend in question was killed " +
            "as the legend received " + totalDamage
             + "  damage which was greater than his pool of health being " + totalHealthLeft;
            
             return customShotOutput + " " +  deathReport;
        } else {
            String deathReport = "The legend in question was " +
            "not killed after receiving " + totalShots + " shots as he still has " +
            healthAfterHit + " health left. The legend would've been dead if ";


            return customShotOutput + " " +  deathReport;

        }
    }

    private String armorSlangTranslator (String armorSlang) {
    String translatedArmor = "";
    
    if (armorSlang.equals("white") || (armorSlang.equals("white ") || (armorSlang.equals(" white")))) {
        translatedArmor = useableShields[0];
        return translatedArmor;
    } else if (armorSlang.equals("blue") || (armorSlang.equals("blue ") || (armorSlang.equals(" blue")))) {
        translatedArmor = useableShields[1];
        return translatedArmor;
    } else if(armorSlang.equals("purple") || (armorSlang.equals("purple ") || (armorSlang.equals(" purple")))) {
        translatedArmor = useableShields[2];
        return translatedArmor;
    } else if (armorSlang.equals("gold") || (armorSlang.equals("gold ") || (armorSlang.equals(" gold")))) {
        translatedArmor = useableShields[3];
        return translatedArmor;
    } else if (armorSlang.equals("red") || (armorSlang.equals("red ") || (armorSlang.equals(" red")))) {
        translatedArmor = useableShields[4];
        return translatedArmor;
    } else {
        System.out.println("Error, armor inputted is not in the game. Please try again");
        return "";
    } 
    }
}



   
    



    

    
