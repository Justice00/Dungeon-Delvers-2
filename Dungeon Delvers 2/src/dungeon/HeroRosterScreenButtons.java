package dungeon;

public class HeroRosterScreenButtons extends InfoScreenButtons {
	public static int[] rosterCheck = new int[5];
	
	public static void backToHeroInfo() {
		backgroundLabel.setIcon(backgroundImage[1]);
		
		for (int i = 1; i < 9; i++) {
			buttonLabel[i].setVisible(true);
		}
		
		for (int i = 9; i < 28; i++) {
			buttonLabel[i].setVisible(false);
		}
		
		textLabel[0].setVisible(false);
		textLabel[1].setVisible(false);
		textLabel[2].setVisible(false);
		textLabel[3].setVisible(true);
		
		for (int i = 0; i < numberOfHeroSprites; i++) {
			heroSpriteLabel[i].setVisible(false);
		}
	
		for (int i = 0; i < numberOfEnemySprites; i++) {
			enemySpriteLabel[i].setVisible(false);
		}
	}
	
	
	
	
	public static void addArtoriasToRoster() {
		heroRoster(0, 10, 350, "Artorias", 1);
	}
	
	
	public static void addIssacToRoster() {
		heroRoster(1, 11, 410, "Issac", 2);
	}


	public static void addVethToRoster() {
		heroRoster(2, 12, 470, "Veth", 3);
	}


	public static void addIreenaToRoster() {
		heroRoster(3, 13, 530, "Zim Zam", 4);
	}


	public static void addZimZamToRoster() {
		heroRoster(4, 14, 590, "Ireena", 5);
	}
	
	
	
	
	public static void nextToCombat() {
		backgroundLabel.setIcon(backgroundImage[3]);
		
		for (int i = 10; i < 16; i++) {
			buttonLabel[i].setVisible(false);
		}
		
		
		for (int i = 16; i < 20; i++) {
			buttonLabel[i].setVisible(true);
		}
		
		buttonLabel[2].setText("Back to Game");
		
		textLabel[0].setVisible(true);
		textLabel[1].setVisible(true);
		textLabel[2].setVisible(true);
		textLabel[3].setVisible(false);
		tempOne = 1;
		
		combatInfo();
		
		currentHero = order[0];
		
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
		
		if (currentHero != currentRoster[0] && currentHero != currentRoster[1] && currentHero != currentRoster[2]) {
			tempTwo = 2;
		}
		
		for (int i = 0; i < 5; i++) {
			if (currentHero.equals(hero[i].getName())) {
				updateInGameHeroStats(i);
			}
		}
			
		for (int i = 0; i < 7; i++) {
			if (currentHero.equals(enemy[i].getName())) {
				updateInGameEnemyStats(i);
			}
		}
		
		textLabel[1].setText(currentStats);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void heroRoster(int roster, int button, int X, String name, int consoleMap) {
		if (rosterCheck[roster] == 0) {
			if (currentRoster[0] == null) {
				buttonLabel[button].setLocation(410, 345);
				currentRoster[0] = name;
				rosterCheck[roster] = 1;
				
			} else if (currentRoster[1] == null) {
				buttonLabel[button].setLocation(470, 345);
				currentRoster[1] = name;
				rosterCheck[roster] = 1;
				
			} else if (currentRoster[2] == null) {
				buttonLabel[button].setLocation(530, 345);
				currentRoster[2] = name;
				rosterCheck[roster] = 1;
				
			}
			map[0][consoleMap] = name;
			//spriteLabel[roster].setVisible(true);
			
		} else if (rosterCheck[roster] == 1){
			if (currentRoster[0] == name) {
				buttonLabel[button].setLocation(X, 165);
				currentRoster[0] = null;
				rosterCheck[roster] = 0;
				
			} else if (currentRoster[1] == name) {
				buttonLabel[button].setLocation(X, 165);
				currentRoster[1] = null;
				rosterCheck[roster] = 0;
				
			} else if (currentRoster[2] == name) {
				buttonLabel[button].setLocation(X, 165);
				currentRoster[2] = null;
				rosterCheck[roster] = 0;
				
			}
			map[0][consoleMap] = null;
			//spriteLabel[roster].setVisible(false);
		}
			
		System.out.println(currentRoster[0] + ", " + currentRoster[1] + ", " + currentRoster[2]);		
		
		if (currentRoster[0] != null && currentRoster[1] != null && currentRoster[2] != null) {
			buttonLabel[15].setVisible(true);
		} else {
			buttonLabel[15].setVisible(false);
		}
	}
	
	
	
	
	public static void updateInGameHeroStats(int i) {
		currentStats = hero[i].getName()
				+ " | Health " + hero[i].getCurrentHealth() + "/" + hero[i].getMaxHealth()
				+ " | Armor " + hero[i].getArmor()
				+ " | Damage " + hero[i].getDamage()
				+ " | Speed " + hero[i].getCurrentSpeed() + "/" + hero[i].getMaxSpeed()
				+ " |";
		if (hero[i].getMaxMana() != 0) {
			currentStats = currentStats + " Mana " + hero[i].getCurrentMana() + "/" + hero[i].getMaxMana();
		}
	}
	
	
	public static void updateInGameEnemyStats(int i) {
		currentStats = enemy[i].getName()
				+ " | Health " + enemy[i].getCurrentHealth() + "/" + enemy[i].getMaxHealth()
				+ " | Armor " + enemy[i].getArmor()
				+ " | Damage " + enemy[i].getDamage()
				+ " | Speed " + enemy[i].getCurrentSpeed() + "/" + enemy[i].getMaxSpeed()
				+ " |";
		if (enemy[i].getMaxMana() != 0) {
			currentStats = currentStats + " Mana " + enemy[i].getCurrentMana() + "/" + enemy[i].getMaxMana();
		}
	}
	
	
	
	
	public static void changeButtonNames() {
		if (currentHero.equals("Artorias")) {
			buttonLabel[16].setText("Sword");
			buttonLabel[17].setText("Crushing Blow");
			buttonLabel[18].setText("Protection");
			buttonLabel[19].setText("Dash");
			
		} else if (currentHero.equals("Issac")) {
			buttonLabel[16].setText("Shortsword");
			buttonLabel[17].setText("Bow");
			buttonLabel[18].setText("Volley");
			buttonLabel[19].setText("Recover");
			
		} else if (currentHero.equals("Veth")) {
			buttonLabel[16].setText("Dagger");
			buttonLabel[17].setText("Pierce");
			buttonLabel[18].setText("Poisonous Strike");
			buttonLabel[19].setText("Dodge");
			
		} else if (currentHero.equals("Zim Zam")) {
			buttonLabel[16].setText("Wand");
			buttonLabel[17].setText("Shockwave");
			buttonLabel[18].setText("Fireball");
			buttonLabel[19].setText("Magic Barrier");
			
		} else if (currentHero.equals("Ireena")) {
			buttonLabel[16].setText("Staff");
			buttonLabel[17].setText("Divine Strike");
			buttonLabel[18].setText("Heal");
			buttonLabel[19].setText("Mass Heal");
			
		} else {
			for (int i = 16; i < 20; i++) {
				buttonLabel[i].setVisible(false);
			}
			
			buttonLabel[27].setVisible(true);
		}
	}
}
