package dungeon;

public class Actions extends KeyInputs {
	public static String target;
	public static String action;
	
	public static void heroActions(int i) {
		if (action.contentEquals("Sword")) {
			singleTargetDamage(0, i, 1.0);
			updateInGameHeroStats(0);
			
		} else if (action.contentEquals("Crushing Blow")) {
			//Timer
			
			updateInGameHeroStats(0);
			
		} else if (action.contentEquals("Protection")) {
			//Timer
			
			updateInGameHeroStats(0);
			
		} else if (action.contentEquals("Dash")) {
			//Timer
			
			updateInGameHeroStats(0);
			
		}
		
		
		
		
		
		if (action.contentEquals("Shortsword")) {
			singleTargetDamage(1, i, 1.0);
			updateInGameHeroStats(1);
			
		} else if (action.contentEquals("Bow")) {
			singleTargetDamage(1, i, 0.75);
			updateInGameHeroStats(1);
			
		} else if (action.contentEquals("Volley")) {
			volley(0.25);
			updateInGameHeroStats(1);
			
		} else if (action.contentEquals("Recover")) {
			singleTargetHeal(1, 1, 0.20);
			updateInGameHeroStats(1);
			
		}
		
		
		
		
		
		if (action.contentEquals("Dagger")) {
			singleTargetDamage(2, i, 1.0);
			updateInGameHeroStats(2);
			
		} else if (action.contentEquals("Pierce")) {
			pierce(i, 0.50);
			updateInGameHeroStats(2);
			
		} else if (action.contentEquals("Poisonous Strike")) {
			//Timer
			
			updateInGameHeroStats(2);
		} else if (action.contentEquals("Dodge")) {
			//Timer
			
			updateInGameHeroStats(2);
		}
		
		
		
		
		
		if (action.contentEquals("Wand")) {
			singleTargetDamage(3, i, 0.50);
			updateInGameHeroStats(3);
			
		} else if (action.contentEquals("Shockwave")) {
			shockwave(0.50);
			useMana(3, 20);
			updateInGameHeroStats(3);
			
		} else if (action.contentEquals("Fireball")) {
			singleTargetDamage(3, i, 1.50);
			useMana(3, 40);
			updateInGameHeroStats(3);
			
		} else if (action.contentEquals("Magic Barrier")) {
			//Timer
			
			useMana(3, 70);
			
			updateInGameHeroStats(3);
		}
		
		
		
		
		
		if (action.contentEquals("Staff")) {
			singleTargetDamage(4, i, 1.0);
			updateInGameHeroStats(4);
			
		} else if (action.contentEquals("Divine Strike")) {
			divineStrike(i, 0.50, 0.50);
			updateInGameHeroStats(4);
			
		} else if (action.contentEquals("Heal")) {
			singleTargetHeal(i, 4, 0.25);
			useMana(4, 20);
			updateInGameHeroStats(4);
			
		} else if (action.contentEquals("Mass Heal")) {
			massHeal();
			useMana(4, 20);
			updateInGameHeroStats(4);
			
		}
		
		textLabel[1].setText(currentStats);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void singleTargetDamage(int heroNumber, int enemyNumber, double damageMultiplier) {
		enemy[enemyNumber].setCurrentHealth((int) (enemy[enemyNumber].getCurrentHealth() - Math.round((hero[heroNumber].getDamage() * damageMultiplier))));
		textLabel[0].setText(hero[heroNumber].getName() + " does " + Math.round(hero[heroNumber].getDamage() * damageMultiplier) + " damage to " + enemy[enemyNumber].getName());
	}
	
	
	public static void singleTargetHeal(int receiverHeroNumber, int giverHeroNumber, double healMultiplier) {
		hero[receiverHeroNumber].setCurrentHealth((int) (hero[receiverHeroNumber].getCurrentHealth() + Math.round(hero[giverHeroNumber].getDamage() * healMultiplier)));
		textLabel[0].setText(hero[giverHeroNumber].getName() + " heals " + hero[receiverHeroNumber].getName() + " " + Math.round(hero[giverHeroNumber].getDamage() * healMultiplier) + " health");
		
		if (hero[receiverHeroNumber].getCurrentHealth() > hero[receiverHeroNumber].getMaxHealth()) {
			hero[receiverHeroNumber].setCurrentHealth(hero[receiverHeroNumber].getMaxHealth());
		}
		
		
	}
	
	
	public static void useMana(int heroNumber, int manaReduced) {
		hero[heroNumber].setCurrentMana(hero[heroNumber].getCurrentMana() - manaReduced);
		
		if (hero[heroNumber].getCurrentMana() < 0) {
			hero[heroNumber].setCurrentMana(hero[heroNumber].getMaxMana());
		}
		
		textLabel[0].setText(textLabel[0].getText() + " using " + manaReduced + " mana");
	}
	
	
	public static void checkIfAlive() {
		
	}
	
///////////////////////////////////////////////////////////Unique Actions
	
	public static void volley(double damageMultiplier) {
		for (int i = 0; i < 7; i++) {
			enemy[i].setCurrentHealth((int) (enemy[i].getCurrentHealth() - Math.round((hero[1].getDamage() * damageMultiplier))));
		}
		
		textLabel[0].setText(hero[1].getName() + " does " + Math.round(hero[1].getDamage() * damageMultiplier) + " damage to each enemy");
	}
	
	
	
	
	
	public static void pierce(int i, double armorReduceMultiplier) {
		enemy[i].setArmor((int) (enemy[i].getArmor() - Math.round(hero[2].getDamage() * armorReduceMultiplier)));
		textLabel[0].setText(hero[2].getName() + " reduces " + enemy[i].getName() + "'s armor by " + Math.round(hero[2].getDamage() * armorReduceMultiplier));
		
		if (enemy[i].getArmor() < 0) {
			enemy[i].setArmor(0);
		}
	}
	
	
	
	
	
	public static void shockwave(double damageMultiplier) {
		int zimZamX = 0;
		int zimZamY = 0;
		
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 11; x++) {
				if (map[x][y] != null) {
					if (map[x][y].equals(hero[3].getName())) {
						zimZamX = x;
						zimZamY = y;
					}
				}
			}
		}
		
		System.out.println(zimZamX + "X, " + zimZamY + "Y");
		
		for (int i = 0; i < 7; i++) {
			if (zimZamY != 6) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, 0, 1);
			}
			
			if (zimZamY != 0) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, 0, -1);
			}
			
			if (zimZamX != 10) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, 1, 0);
			}
			
			if (zimZamX != 0) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, -1, 0);
			}
			
			if (zimZamY != 6 && zimZamX != 10) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, 1, 1);
			}
			
			if (zimZamY != 0 && zimZamX != 0) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, -1, -1);
			}
			
			if (zimZamY != 0 && zimZamX != 10) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, 1, -1);
			}
			
			if (zimZamY != 6 && zimZamX != 0) {
				shockwaveCondition(i, damageMultiplier, zimZamX, zimZamY, -1, 1);
			}
			
		}
		
		textLabel[0].setText(hero[3].getName() + " does " + Math.round(hero[3].getDamage() * damageMultiplier) + " damage to each enemy around him");
		
	}
	
	public static void shockwaveCondition(int i, double damageMultiplier, int zimZamX, int zimZamY, int xChange, int yChange) {
		if (enemy[i].getName().equals(map[zimZamY + yChange][zimZamX + xChange])) {
			enemy[i].setCurrentHealth((int) (enemy[i].getCurrentHealth() - Math.round((hero[3].getDamage() * damageMultiplier))));
			System.out.println(map[zimZamY + yChange][zimZamX + xChange]);
		}
	}
	
	
	
	public static void divineStrike(int enemyNumber, double damageMultiplier, double healMultiplier) {
		hero[4].setCurrentHealth((int) (hero[4].getCurrentHealth() + Math.round(hero[4].getDamage() * healMultiplier)));
		enemy[enemyNumber].setCurrentHealth((int) (enemy[enemyNumber].getCurrentHealth() - Math.round((hero[4].getDamage() * damageMultiplier))));
		
		textLabel[0].setText(hero[4].getName() + " does " + Math.round(hero[4].getDamage() * damageMultiplier) + " damage to " + enemy[enemyNumber].getName()
					+ " and heals " + Math.round(hero[4].getDamage() * healMultiplier) + " health");
		
		if (hero[4].getCurrentHealth() > hero[4].getMaxHealth()) {
			hero[4].setCurrentHealth(hero[4].getMaxHealth());
		}		
	}
	
	
	
	
	
	public static void massHeal() {
		for (int i = 0; i < 10; i++) {
			if (order[i] == currentRoster[0] || order[i] == currentRoster[1] || order[i] == currentRoster[2]) {
				if (alive[i] == true) {
					for (int x = 0; x < 5; x++) {
						if (order[i] == hero[x].getName()) {
							hero[x].setCurrentHealth((int) (hero[x].getCurrentHealth() + Math.round(hero[x].getDamage() * 0.25)));
							
							if (hero[x].getCurrentHealth() > hero[x].getMaxHealth()) {
								hero[x].setCurrentHealth(hero[x].getMaxHealth());
							}
						}
					}
				}
			}
		}
		textLabel[0].setText(hero[4].getName() + " heals each hero " + Math.round(hero[4].getDamage() * 0.25));
	}
	
	
	
	
///////////////////////////////////////////////////////////
	
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
}
