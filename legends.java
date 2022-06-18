public class legends {
    
    private String legendName = "";
    private Integer currentHealth = 0;
    private String currentArmour = "White Evo Shield";
    private String fortifiedStatus = "None";

    public legends (String legendName, Integer currentHealth, String currentArmour, String fortifiedStatus) {
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

    public String getFortifiedStatus () {
        return fortifiedStatus;
    }
    
}
