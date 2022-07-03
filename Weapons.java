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
     
    Integer [] weaponDamageValues = {18, 18, 20, 14, 16, 14, 11, 17, 13, 15, 
    17, 18, 26, 36, 63, 57, 60, 90, 55, 140, 70, 63, 112, 45, 99, 12, 18, 45};

    String [] useableShields = {"White Evo", "Blue Evo", "Purple Evo", "Gold Evo", "Red Evo"};

    Integer [] shieldHealthValues = {50, 75, 100, 100, 125};
    
    //private final int headshotMultiplier = 

    public Integer bodyShotCalculator(String currentWeapon, Integer currentHealth, String currentArmor, String currentLegend) {
        
        Integer totalHealthLeft = 0;
        Integer weaponDamage = 0;
        Integer shotsFired = 0;

        for (int i = 0; i < useableWeapons.length; i++) {
            if (currentWeapon.equals(useableWeapons[i])) {
                weaponDamage = weaponDamageValues[i];
                break;
            }
        }

        for(int i = 0; i < useableShields.length; i++) {
            if (currentArmor.equals(useableShields[i])) {
                totalHealthLeft = currentHealth + shieldHealthValues[i];
            }
        }
        if (currentLegend.equals("Gibraltar") || currentLegend.equals("Caustic")) {
            
        }
        while (totalHealthLeft >= 0) {
            totalHealthLeft = totalHealthLeft - weaponDamage;
            shotsFired += 1;
        }
        
        return shotsFired;


    }


    public String getNumberOfWeapons() {
        return "There are currently " + weaponDamageValues.length + " weapons in the game.";
    }
    
    //public String


    

    
}