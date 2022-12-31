package dungeon;

public class InfoScreenButtons extends MainMenuScreenButtons {
	public static int tempOne = 0;
	public static int tempTwo;
	
	public static void backToMainMenu() {
		backgroundLabel.setIcon(backgroundImage[0]);

		buttonLabel[0].setVisible(true);
		buttonLabel[29].setVisible(true);

		for (int i = 1; i < 9; i++) {
			buttonLabel[i].setVisible(false);
		}
	}
	
	
	
	
	public static void nextToHeroRoster() {
		backgroundLabel.setIcon(backgroundImage[2]);

		for (int i = 1; i < 9; i++) {
			buttonLabel[i].setVisible(false);
		}

		for (int i = 9; i < 15; i++) {
			buttonLabel[i].setVisible(true);
		}

		if (currentRoster[0] != null && currentRoster[1] != null && currentRoster[2] != null) {
			buttonLabel[15].setVisible(true);
		} else {
			buttonLabel[15].setVisible(false);
		}

		buttonLabel[2].setText("Back to Roster");
	}
	
	
	
	
	public static void backToCombat() {
		backgroundLabel.setIcon(backgroundImage[3]);

		for (int i = 0; i < 9; i++) {
			buttonLabel[i].setVisible(false);
		}

		buttonLabel[9].setVisible(true);
		buttonLabel[15].setVisible(false);

		if (tempTwo == 0) {
			for (int i = 16; i < 20; i++) {
				buttonLabel[i].setVisible(true);
			}
		} else if (tempTwo == 1) {
			showTargets();
		} else if (tempTwo == 2) {
			buttonLabel[27].setVisible(true);
		}

		buttonLabel[2].setText("Back to Game");
		textLabel[0].setVisible(true);
		textLabel[1].setVisible(true);
		textLabel[2].setVisible(true);

		for (int i = 0; i < 5; i++) {
			for (int h = 0; h < 10; h++) {
				if (order[h] == hero[i].getName()) {
					heroSpriteLabel[i].setVisible(true);
				}
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int h = 0; h < 10; h++) {
				if (order[h] == enemy[i].getName()) {
					enemySpriteLabel[i].setVisible(true);
				}
			}
		}
	}

	
	
	
	public static void displayHowToPlay() {
		textLabel[3].setText("<html>do it</html>");
	}
	
	
	public static void displayArtoriasInfo() {
		infoImageLabel.setIcon(infoImageImage[0]);

		textLabel[3].setText("<html>"
				+ "<b>Artorias</b>"
				+ "<br/><i>Stats</i>"
				+ "<br/><ul>Health: " + hero[0].getCurrentHealth() + "/" + hero[0].getMaxHealth()
				+ "<br/>Armor: " + hero[0].getArmor()
				+ "<br/>Damage: " + hero[0].getDamage()
				+ "<br/>Speed: " + hero[0].getCurrentSpeed() + "/" + hero[0].getMaxSpeed()
				+ "<br/></ul>"
				+ "<br/><i>Active Abilities</i>"
				+ "<br/><ul>Sword:"
				+ "<br/>Does (" + (Math.ceil(hero[0].getDamage() * 1.0)) + ") 100% of Artorias's damage to an enemy within 1 tile."
				+ "<br/>"
				+ "<br/>Crushing Blow:"
				+ "<br/>Increases Artorias's damage by (" + (Math.ceil(hero[0].getDamage() * 0.5)) + ") 50% for 3 rounds."
				+ "<br/>"
				+ "<br/>Protection:"
				+ "<br/>Increases armor given from Defend by (" + (Math.ceil(hero[0].getArmor() * 0.33)) + ") 33% for 4 rounds."
				+ "<br/>"
				+ "<br/>Dash:"
				+ "<br/>Increases Artorias's speed by (" + (Math.ceil(hero[0].getMaxSpeed() * 1.0)) + ") 100% for 3 rounds."
				+ "<br/></ul>"
				+ "<br/><i>Passive Abilities</i>"
				+ "<br/><ul>Defend:"
				+ "<br/>Increases allies armor within 1 tile by (" + (Math.ceil(hero[0].getArmor() * 0.33)) + ") 33% of Artorias’s armor."
				+ "</ul></html>");
	}

	
	public static void displayIssacInfo() {
		infoImageLabel.setIcon(infoImageImage[1]);
		
		textLabel[3].setText("<html>"
				+ "<b>Issac</b>"
				+ "<br/><i>Stats</i>"
				+ "<br/><ul>Health: " + hero[1].getCurrentHealth() + "/" + hero[1].getMaxHealth()
				+ "<br/>Armor: " + hero[1].getArmor()
				+ "<br/>Damage: " + hero[1].getDamage()
				+ "<br/>Speed: " + hero[1].getCurrentSpeed() + "/" + hero[1].getMaxSpeed()
				+ "<br/></ul>"
				+ "<br/><i>Active Abilities</i>"
				+ "<br/><ul>Shortsword:"
				+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 1.0)) + ") 100% of Issac's damage to an enemy within 1 tile."
				+ "<br/>"
				+ "<br/>Bow:"
				+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.75)) + ") 75% of Issac's damage to an enemy anywhere."
				+ "<br/>"
				+ "<br/>Volley:"
				+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.25)) + ") 25% of Issac's damage to all enemies anywhere."
				+ "<br/>"
				+ "<br/>Recover:"
				+ "<br/>Issac heals equal to (" + (Math.ceil(hero[1].getDamage() * 0.2)) + ") 20% of his damage."
				+ "<br/></ul>"
				+ "<br/><i>Passive Abilities</i>"
				+ "<br/><ul>Deadeye:"
				+ "<br/>Issac's damage increase by (" + (Math.ceil(hero[1].getDamage() * 1.0)) + ") 100% during his first turn in combat."
				+ "</ul></html>");
	}

	
	public static void displayVethInfo() {
		infoImageLabel.setIcon(infoImageImage[2]);
		
		textLabel[3].setText("<html>"
				+ "<b>Veth</b>"
				+ "<br/><i>Stats</i>"
				+ "<br/><ul>Health: " + hero[2].getCurrentHealth() + "/" + hero[2].getMaxHealth()
				+ "<br/>Armor: " + hero[2].getArmor()
				+ "<br/>Damage: " + hero[2].getDamage()
				+ "<br/>Speed: " + hero[2].getCurrentSpeed() + "/" + hero[2].getMaxSpeed()
				+ "<br/></ul>"
				+ "<br/><i>Active Abilities</i>"
				+ "<br/><ul>Dagger:"
				+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 1.0)) + ") 100% of Veth's damage to an enemy within 1 tile."
				+ "<br/>"
				+ "<br/>Pierce:"
				+ "<br/>Reduce the armor of an enemy within 1 tile by (" + (Math.ceil(hero[2].getDamage() * 0.5)) + ") 50% of Veth's damage."
				+ "<br/>"
				+ "<br/>Poisonous Strike:"
				+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 0.2)) + ") 20% of Veth’s damage to an enemy within 1 tile for next 8 rounds."
				+ "<br/>"
				+ "<br/>Dodge:"
				+ "<br/>Increases dodge chance for Evasion by 20% for 3 rounds."
				+ "<br/></ul>"
				+ "<br/><i>Passive Abilities</i>"
				+ "<br/><ul>Evasion:"
				+ "<br/>Attacks against Veth have a 20% chance of missing."
				+ "</ul></html>");
	}

	
	public static void displayZimZamInfo() {
		infoImageLabel.setIcon(infoImageImage[3]);
		
		textLabel[3].setText("<html>"
				+ "<b>Zim Zam</b>"
				+ "<br/><i>Stats</i>"
				+ "<br/><ul>Health: " + hero[3].getCurrentHealth() + "/" + hero[3].getMaxHealth()
				+ "<br/>Armor: " + hero[3].getArmor()
				+ "<br/>Damage: " + hero[3].getDamage()
				+ "<br/>Speed: " + hero[3].getCurrentSpeed() + "/" + hero[3].getMaxSpeed()
				+ "<br/>Mana: " + hero[3].getCurrentMana() + "/" + hero[3].getMaxMana()
				+ "<br/></ul>"
				+ "<br/><i>Active Abilities</i>"
				+ "<br/><ul>Wand:"
				+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to an enemy within 1 tile."
				+ "<br/>"
				+ "<br/>Shockwave:"
				+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to all enemies within 1 tile, costs 20 mana."
				+ "<br/>"
				+ "<br/>Fireball:"
				+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 1.5)) + ") 150% of Zim Zam's damage to an enemy anywhere, costs 40 mana."
				+ "<br/>"
				+ "<br/>Magic Barrier:"
				+ "<br/>Increases Zim Zam's armor by (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage for 3 rounds, costs 70 mana."
				+ "<br/></ul>"
				+ "<br/><i>Passive Abilities</i>"
				+ "<br/><ul>Mana Regeneration:"
				+ "<br/>Zim Zam regains 10 mana at the start of his turn."
				+ "</ul></html>");
	}

	
	public static void displayIreenaInfo() {
		infoImageLabel.setIcon(infoImageImage[4]);
		
		textLabel[3].setText("<html>"
				+ "<b>Ireena</b>"
				+ "<br/><i>Stats</i>"
				+ "<br/><ul>Health: " + hero[4].getCurrentHealth() + "/" + hero[4].getMaxHealth()
				+ "<br/>Armor: " + hero[4].getArmor()
				+ "<br/>Damage: " + hero[4].getDamage()
				+ "<br/>Speed: " + hero[4].getCurrentSpeed() + "/" + hero[4].getMaxSpeed()
				+ "<br/>Mana: " + hero[4].getCurrentMana() + "/" + hero[4].getMaxMana()
				+ "<br/></ul>"
				+ "<br/><i>Active Abilities</i>"
				+ "<br/><ul>Staff:"
				+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of Ireena's damage to an enemy within 1 tile."
				+ "<br/>"
				+ "<br/>Divine Strike:"
				+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of Ireena's damage to an enemy within 1 tile, Ireena heals equal to (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of her damage."
				+ "<br/>"
				+ "<br/>Heal:"
				+ "<br/>Ireena heals herself or an ally within 1 tile equal to (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of her damage, costs 20 mana."
				+ "<br/>"
				+ "<br/>Mass Heal:"
				+ "<br/>Ireena heals herself and each ally equal to (" + (Math.ceil(hero[4].getDamage() * 0.25)) + ") 25% of her damage, costs 20 mana."
				+ "<br/></ul>"
				+ "<br/><i>Passive Abilities</i>"
				+ "<br/><ul>Health Regeneration:"
				+ "<br/>Ireena heals equal to (" + (Math.ceil(hero[4].getDamage() * 0.1)) + ") 10% of her damage at the start of her turn."
				+ "</ul></html>");
	}
	
	
	public static void hideText(int i) {
		infoImageLabel.setIcon(null);
		textLabel[i].setText("");
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void showTargets() {
		if (action.equals("Heal")) {
			for (int i = 22; i < 25; i++) {
				buttonLabel[i].setText(currentRoster[i - 22]);
				buttonLabel[i].setVisible(true);
			}
			
		} else {
			for (int i = 20; i < 27; i++) {
				buttonLabel[i].setText(enemy[i - 20].getName());
				buttonLabel[i].setVisible(true);
			}
			
		}
	}

}
