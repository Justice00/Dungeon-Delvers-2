package dungeon;

public class CombatScreenButtons extends HeroRosterScreenButtons {
	public static String target;
	
	public static void action(int i) {
		
		tempTwo = 1;
		speedToZero();
		hideButtons();
		showTargets();
		
		// put action dependent instruction here justman
		switch(i) {
		
		case 1:
			
			break;
		
		case 2:
			
			break;
		
		case 3:
			
			break;
		}
	}
	
	
	public static void target(int i) {
		tempTwo = 2;
		
		
		target = enemy[i].getName();
		
		for (int x = 20; x < 27; x++) {
			buttonLabel[x].setVisible(false);
		}
		
		buttonLabel[27].setVisible(true);
	}
	
	
	
	
	public static void nextTurn() {
		buttonLabel[16].setVisible(true);
		buttonLabel[17].setVisible(true);
		buttonLabel[18].setVisible(true);
		buttonLabel[19].setVisible(true);
		buttonLabel[27].setVisible(false);
		
		currentHeroNumber++;
		
		if (currentHeroNumber == 10) {
			currentHeroNumber = 0;
		}
		
		currentHero = order[currentHeroNumber];
		
		if (currentHero == currentRoster[0] || currentHero == currentRoster[1] || currentHero == currentRoster[2]) {
			tempTwo = 0;
		} else {
			tempTwo = 2;
		}
		
		for (int i = 0; i < 5; i++) {
			if (currentHero == hero[i].getName()) {
				hero[i].setCurrentSpeed(hero[i].getMaxSpeed());
			}
		}
		
		if (currentHero.equals("Artorias")) {
			updateInGameHeroStats(0);
			
		} else if (currentHero.equals("Issac")) {
			updateInGameHeroStats(1);
			
		} else if (currentHero.equals("Veth")) {
			updateInGameHeroStats(2);
			
		} else if (currentHero.equals("Zim Zam")) {
			updateInGameHeroStats(3);
			
		} else if (currentHero.equals("Ireena")) {
			updateInGameHeroStats(4);
			
			
		} else if (currentHero.equals(enemy[0].getName())) {
			updateInGameEnemyStats(0);
			
		} else if (currentHero.equals(enemy[1].getName())) {
			updateInGameEnemyStats(1);
			
		} else if (currentHero.equals(enemy[2].getName())) {
			updateInGameEnemyStats(2);
			
		} else if (currentHero.equals(enemy[3].getName())) {
			updateInGameEnemyStats(3);
			
		} else if (currentHero.equals(enemy[4].getName())) {
			updateInGameEnemyStats(4);
			
		}  else if (currentHero.equals(enemy[5].getName())) {
			updateInGameEnemyStats(5);
			
		} else if (currentHero.equals(enemy[6].getName())) {
			updateInGameEnemyStats(6);
			
		}
		
		textLabel[1].setText(currentStats);
		
		currentOrder = "Turn Order | ";
		for (int i = 0; i < order.length; i++) {
			if (currentHero == order[i]) {
				currentOrder += "<b><u>" + order[i] + "</u></b> | ";
				System.out.print(order[i] + " | ");
				
			} else {
				currentOrder += order[i] + " | ";
				System.out.print(order[i] + " | ");
				
			}
		}
		
		textLabel[2].setText("<html><center> <b>Current Turn | <u>" + currentHero + "</u> |</b></center><br/>" + currentOrder + "</html>");
		
		changeButtonNames();
	}
	
	
	
	
	public static void actionDescription(int i) {
		
		switch(i) {
		case 1:
			actionOneDescription();
			break;
			
		case 2:
			actionTwoDescription();
			break;
			
		case 3:
			actionThreeDescription();
			break;
			
		case 4:
			actionFourDescription();
			break;
		}
	}
	
	
	private static void actionOneDescription() {
		if (currentHero.equals("Artorias")) {
			textLabel[0].setText("<html>"
					+ "Sword:"
					+ "<br/>Does (" + (Math.ceil(hero[0].getDamage() * 1.0)) + ") 100% of Artorias's damage to an enemy within 1 tile."
					+ "</html>");
			
		} else if (currentHero.equals("Issac")) {
			textLabel[0].setText("<html>"
					+ "Shortsword:"
					+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 1.0)) + ") 100% of Issac's damage to an enemy within 1 tile."
					+ "</html>");
			
		} else if (currentHero.equals("Veth")) {
			textLabel[0].setText("<html>"
					+ "Dagger:"
					+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 1.0)) + ") 100% of Veth's damage to an enemy within 1 tile."
					+ "</html>");
			
		} else if (currentHero.equals("Zim Zam")) {
			textLabel[0].setText("<html>"
					+ "Wand:"
					+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to an enemy within 1 tile."
					+ "</html>");
			
		} else if (currentHero.equals("Ireena")) {
			textLabel[0].setText("<html>"
					+ "Staff:"
					+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of Ireena's damage to an enemy within 1 tile."
					+ "</html>");
		}
	}
	
	private static void actionTwoDescription() {
		if (currentHero.equals("Artorias")) {
			textLabel[0].setText("<html>"
					+ "Crushing Blow:"
					+ "<br/>Increases Artorias's damage by (" + (Math.ceil(hero[0].getDamage() * 0.5)) + ") 50% for 3 rounds."
					+ "</html>");
			
		} else if (currentHero.equals("Issac")) {	
			textLabel[0].setText("<html>"
					+ "Bow:"
					+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.75)) + ") 75% of Issac's damage to an enemy anywhere."
					+ "</html>");
		} else if (currentHero.equals("Veth")) {
			textLabel[0].setText("<html>"
					+ "Pierce:"
					+ "<br/>Reduce the armor of an enemy within 1 tile by (" + (Math.ceil(hero[2].getDamage() * 0.5)) + ") 50% of Veth's damage."
					+ "</html>");
			
		} else if (currentHero.equals("Zim Zam")) {
			textLabel[0].setText("<html>"
					+ "Shockwave:"
					+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to all enemies within 1 tile, costs 20 mana."
					+ "</html>");
			
		} else if (currentHero.equals("Ireena")) {
			textLabel[0].setText("<html>"
					+ "Divine Strike:"
					+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of Ireena's damage to an enemy within 1 tile, Ireena heals equal to (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of her damage."
					+ "</html>");
		}
	}


	private static void actionThreeDescription() {
		if (currentHero.equals("Artorias")) {
			textLabel[0].setText("<html>"
					+ "Protection:"
					+ "<br/>Increases armor given from Defend by (" + (Math.ceil(hero[0].getArmor() * 0.33)) + ") 33% for 4 rounds."
					+ "</html>");
			
		} else if (currentHero.equals("Issac")) {
			textLabel[0].setText("<html>"
					+ "Volley:"
					+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.25)) + ") 25% of Issac's damage to all enemies anywhere."
					+ "</html>");
			
		} else if (currentHero.equals("Veth")) {
			textLabel[0].setText("<html>"
					+ "Poisonous Strike:"
					+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 0.2)) + ") 20% of Veth’s damage to an enemy within 1 tile for next 8 rounds."
					+ "</html>");
			
		} else if (currentHero.equals("Zim Zam")) {
			textLabel[0].setText("<html>"
					+ "Fireball:"
					+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 1.5)) + ") 150% of Zim Zam's damage to an enemy anywhere, costs 40 mana."
					+ "</html>");
			
		} else if (currentHero.equals("Ireena")) {
			textLabel[0].setText("<html>"
					+ "Heal:"
					+ "<br/>Ireena heals herself or an ally within 1 tile equal to (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of her damage, costs 20 mana."
					+ "</html>");
		}
	}
	
	
	private static void actionFourDescription() {
		if (currentHero.equals("Artorias")) {
			textLabel[0].setText("<html>"
					+ "Dash:"
					+ "<br/>Increases Artorias's speed by (" + (Math.ceil(hero[0].getMaxSpeed() * 1.0)) + ") 100% for 3 rounds."
					+ "</html>");
			
		} else if (currentHero.equals("Issac")) {
			textLabel[0].setText("<html>"
					+ "Recover:"
					+ "<br/>Issac heals equal to (" + (Math.ceil(hero[1].getDamage() * 0.2)) + ") 20% of his damage."
					+ "</html>");
			
		} else if (currentHero.equals("Veth")) {
			textLabel[0].setText("<html>"
					+ "Dodge:"
					+ "<br/>Increases dodge chance for Evasion by 20% for 3 rounds."
					+ "</html>");
			
		} else if (currentHero.equals("Zim Zam")) {
			textLabel[0].setText("<html>"
					+ "Magic Barrier:"
					+ "<br/>Increases Zim Zam's armor by (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage for 3 rounds, costs 70 mana."
					+ "</html>");
			
		} else if (currentHero.equals("Ireena")) {
			textLabel[0].setText("<html>"
					+ "Mass Heal:"
					+ "<br/>Ireena heals herself and each ally equal to (" + (Math.ceil(hero[4].getDamage() * 0.25)) + ") 25% of her damage, costs 20 mana."
					+ "</html>");
		}
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void speedToZero() {
		for (int i = 0; i < 5; i++) {
			if (currentHero == hero[i].getName()) {
				hero[i].setCurrentSpeed(0);
				updateInGameHeroStats(i);
				textLabel[1].setText(currentStats);
			}
		}
	}
	
	
	
	
	public static void hideButtons() {
		buttonLabel[16].setVisible(false);
		buttonLabel[17].setVisible(false);
		buttonLabel[18].setVisible(false);
		buttonLabel[19].setVisible(false);
	}
}
