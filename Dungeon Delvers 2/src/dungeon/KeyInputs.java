package dungeon;

import java.awt.event.*;

public class KeyInputs extends Backgrounds implements KeyListener {
	public static String currentStats;
	
	public KeyInputs() {
		frame.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int i = -1;
		
		for (int x = 0; x < 5; x++) {
			if (currentHero.equals(hero[x].getName())) {
				i = x;
			}
		}
		
		if (i != -1) {
			for (int y = 0; y < 7; y++) {
				for (int x = 0; x < 11; x++) {
					if (map[x][y] == currentHero) {
						mapX = x;
						mapY = y;
						break;
					}
				}
			}
			
			if (e.getKeyChar() == 'w' && mapY != 0 && map[mapX][mapY - 1] == null && hero[i].getCurrentSpeed() != 0) {
				moveOnMap(i, 0, -60);
				moveOnConsoleMap(0, -1);
					
			} else if (e.getKeyChar() == 'a' && mapX != 0 && map[mapX - 1][mapY] == null && hero[i].getCurrentSpeed() != 0) {
				moveOnMap(i, -60, 0);
				moveOnConsoleMap(-1, 0);
					
			} else if (e.getKeyChar() == 's' && mapY != 6 && map[mapX][mapY + 1] == null && hero[i].getCurrentSpeed() != 0) {
				moveOnMap(i, 0, 60);
				moveOnConsoleMap(0, 1);
				
			} else if (e.getKeyChar() == 'd' && mapX != 10 && map[mapX + 1][mapY] == null && hero[i].getCurrentSpeed() != 0) {
				moveOnMap(i, 60, 0);
				moveOnConsoleMap(1, 0);
			}
			printConsoleMap();
		}
	}
	
	
	
	
	public void moveOnMap(int i, int x, int y) {
		hero[i].setXLocation(hero[i].getXLocation() + x);
		hero[i].setYLocation(hero[i].getYLocation() + y);
		heroSpriteLabel[i].setLocation(hero[i].getXLocation(), hero[i].getYLocation());
		hero[i].setCurrentSpeed(hero[i].getCurrentSpeed() - 1);
		
		currentStats = hero[i].getName()
				+ " | Health " + hero[i].getCurrentHealth() + "/" + hero[i].getMaxHealth()
				+ " | Armor " + hero[i].getArmor()
				+ " | Damage " + hero[i].getDamage()
				+ " | Speed " + hero[i].getCurrentSpeed() + "/" + hero[i].getMaxSpeed()
				+ " |";
		textLabel[1].setText(currentStats);
	}
	
	
	
	
	public void moveOnConsoleMap(int x, int y) {
		String placeholder;
		
		placeholder = map[mapX][mapY];
		map[mapX][mapY] = map[mapX + x][mapY + y];
		map[mapX + x][mapY + y] = placeholder;
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {	
	}
}