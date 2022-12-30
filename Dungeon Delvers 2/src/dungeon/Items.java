package dungeon;

public class Items extends CreateCombat {
	
	public static void grayHealthAmulet() {
		hero[0].setMaxHealth(hero[0].getMaxHealth() + 2);
		hero[0].setCurrentHealth(hero[0].getCurrentHealth() + 2);
	}
	
	public static void greenHealthAmulet() {
		hero[1].setMaxHealth(hero[1].getMaxHealth() + 2);
		hero[1].setCurrentHealth(hero[1].getCurrentHealth() + 2);
	}
	
	public static void blackHealthAmulet() {
		hero[2].setMaxHealth(hero[2].getMaxHealth() + 2);
		hero[2].setCurrentHealth(hero[2].getCurrentHealth() + 2);
	}
	
	public static void blueHealthAmulet() {
		hero[3].setMaxHealth(hero[3].getMaxHealth() + 2);
		hero[3].setCurrentHealth(hero[3].getCurrentHealth() + 2);
	}
	
	public static void whiteHealthAmulet() {
		hero[4].setMaxHealth(hero[4].getMaxHealth() + 2);
		hero[4].setCurrentHealth(hero[4].getCurrentHealth() + 2);
	}
	
	
	public static void paddedHeavyArmor() {
		hero[0].setArmor(hero[0].getArmor() + 1);
	}
	
	public static void paddedMediumArmor() {
		hero[1].setArmor(hero[1].getArmor() + 1);
	}
	
	public static void paddedLightArmor() {
		hero[2].setArmor(hero[2].getArmor() + 1);
	}
	
	public static void paddedWizardRobes() {
		hero[3].setArmor(hero[3].getArmor() + 1);
	}
	
	public static void paddedPriestsRobes() {
		hero[4].setArmor(hero[4].getArmor() + 1);
	}

	
	public static void enchantedSword() {
		hero[0].setDamage(hero[0].getDamage() + 1);
	}
	
	public static void enchantedBow() {
		hero[1].setDamage(hero[1].getDamage() + 1);
	}
	
	public static void enchantedDagger() {
		hero[2].setDamage(hero[2].getDamage() + 1);
	}
	
	public static void enchantedWand() {
		hero[3].setDamage(hero[3].getDamage() + 1);
	}
	
	public static void enchantedStaff() {
		hero[4].setDamage(hero[4].getDamage() + 1);
	}
	
	
	public static void grayBoots() {
		hero[0].setMaxSpeed(hero[0].getMaxSpeed() + 1);
		hero[0].setCurrentSpeed(hero[0].getMaxSpeed());
	}
	
	public static void greenBoots() {
		hero[1].setMaxSpeed(hero[1].getMaxSpeed() + 1);
		hero[1].setCurrentSpeed(hero[1].getMaxSpeed());
	}
	
	public static void blackBoots() {
		hero[2].setMaxSpeed(hero[2].getMaxSpeed() + 1);
		hero[2].setCurrentSpeed(hero[2].getMaxSpeed());
	}
	
	public static void blueBoots() {
		hero[3].setMaxSpeed(hero[3].getMaxSpeed() + 1);
		hero[3].setCurrentSpeed(hero[3].getMaxSpeed());
	}
	
	public static void whiteBoots() {
		hero[4].setMaxSpeed(hero[4].getMaxSpeed() + 1);
		hero[4].setCurrentSpeed(hero[4].getMaxSpeed());
	}

	
	public static void healthCrystal() {
		for (int i = 0; i < 5; i++) {
			hero[i].setMaxHealth(hero[i].getMaxHealth() + 1);
			hero[i].setCurrentHealth(hero[i].getCurrentHealth() + 1);
		}
	}
	
	public static void armorCrystal() {
		for (int i = 0; i < 5; i++) {
			hero[i].setArmor(hero[i].getArmor() + 1);
		}
	}
	
	public static void damageCrystal() {
		for (int i = 0; i < 5; i++) {
			hero[i].setDamage(hero[i].getDamage() + 1);
		}
	}
	
	public static void speedCrystal() {
		for (int i = 0; i < 5; i++) {
			hero[i].setMaxSpeed(hero[i].getMaxSpeed() + 1);
			hero[i].setCurrentSpeed(hero[i].getMaxSpeed());
		}
	}
	
	public static void manaCrystal() {
		hero[3].setMaxMana(hero[3].getMaxMana() + 20);
		hero[4].setMaxMana(hero[4].getMaxMana() + 20);
		
		hero[3].setCurrentMana(hero[3].getCurrentMana() + 20);
		hero[4].setCurrentMana(hero[4].getCurrentMana() + 20);	
	}
	
	
	public static void extraHeavyArmor() {
		hero[0].setArmor(hero[0].getArmor() + 3);
		hero[0].setMaxSpeed(hero[0].getMaxSpeed() - 2);
		
		if (hero[0].getMaxSpeed() < 1) {
			hero[0].setMaxSpeed(1);
		}
		
		hero[0].setCurrentSpeed(hero[0].getMaxSpeed());
	}
	
	public static void lightBow() {
		hero[1].setMaxSpeed(hero[1].getMaxSpeed() + 2);
		hero[1].setDamage(hero[1].getDamage() - 1);
		
		if (hero[1].getDamage() < 1) {
			hero[1].setDamage(1);
		}
		
		hero[1].setCurrentSpeed(hero[1].getMaxSpeed());
	}
	
	public static void bloodDagger() {
		hero[2].setMaxHealth(hero[2].getMaxHealth() + 4);
		hero[2].setArmor(hero[2].getArmor() - 1);
		
		if (hero[2].getArmor() < 0) {
			hero[2].setArmor(0);
		}
		
		hero[2].setCurrentHealth(hero[2].getCurrentHealth() + 4);
	}
	
	public static void magicBand() {
		hero[3].setMaxMana(hero[3].getMaxMana() + 100);
		hero[3].setDamage(hero[3].getDamage() - 2);
		
		if (hero[3].getDamage() < 1) {
			hero[3].setDamage(1);
		}
		
		hero[3].setCurrentMana(hero[3].getCurrentMana() + 100);
	}
	
	public static void healingStaff() {
		hero[4].setDamage(hero[4].getDamage() + 3);
		hero[4].setMaxHealth(hero[4].getMaxHealth() - 5);
		hero[4].setCurrentHealth(hero[4].getCurrentHealth() - 5);
		
		if (hero[4].getMaxHealth() < 1) {
			hero[4].setMaxHealth(1);
		}
		
		if (hero[4].getCurrentHealth() < 1) {
			hero[4].setCurrentHealth(1);
		}
		
		if (hero[4].getCurrentHealth() > hero[4].getMaxHealth()) {
			hero[4].setCurrentHealth(hero[4].getMaxHealth());
		}
	}
}
