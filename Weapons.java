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
    
     Integer [] bodyShotDamageValues = {18, 18, 20, 14, 16, 14, 11, 17, 13, 15, 
    17, 18, 26, 36, 63, 57, 60, 90, 55, 140, 70, 63, 112, 45, 99, 12, 18, 45};

    Integer [] legShotDamageValues = {15, 14, 15, 11, 13, 11, 9, 14, 10, 13, 
    14, 15, 22, 27, 57, 48, 54, 90, 44, 112, 63, 54, 112, 45, 99, 11, 16, 41};
    
    Integer [] headShotDamageValues = {32, 32, 35, 25, 24, 21, 17, 26, 20, 
    23, 26, 27, 39, 72, 111, 100, 105, 101, 118, 280, 140, 72, 144, 57, 121, 18, 27, 97};

    

    String [] useableShields = {"White Evo", "Blue Evo", "Purple Evo", "Gold Evo", "Red Evo"};

    Integer [] shieldHealthValues = {50, 75, 100, 100, 125};

    private final Double fortifiedModifier = 0.15;

    private boolean armorSlangGiven = false;
    
    //private final int headshotMultiplier = 

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
            
        if (currentArmor.equals("white") || (currentArmor.equals("white ") || (currentArmor.equals(" white")))) {
                currentArmor = useableShields[0];
        } else if (currentArmor.equals("blue") || (currentArmor.equals("blue ") || (currentArmor.equals(" blue")))) {
            currentArmor = useableShields[1];
        } else if(currentArmor.equals("purple") || (currentArmor.equals("purple ") || (currentArmor.equals(" purple")))) {
            currentArmor = useableShields[2];
        } else if (currentArmor.equals("gold") || (currentArmor.equals("gold ") || (currentArmor.equals(" gold")))) {
            currentArmor = useableShields[3];
        } else if (currentArmor.equals("red") || (currentArmor.equals("red ") || (currentArmor.equals(" red")))) {
            currentArmor = useableShields[4];
        } else {
            System.out.println("Error, armor inputted is not in the game. Please try again");
        }

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



   
    



    

    
}