package dungeon;

import java.awt.Color;

public class MainMenuScreenButtons extends Actions {
	
	public static void startToHeroInfo() {
		backgroundLabel.setIcon(backgroundImage[1]);
		
		textLabel[3].setVisible(true);
		
		buttonLabel[0].setVisible(false);
		buttonLabel[29].setVisible(false);
		
		for (int i = 1; i < 9; i++) {
			buttonLabel[i].setVisible(true);
		}
	}
	
	
	
	
	public static void exitGame() {
		System.out.println("Thanks For Playing");
		System.exit(0);
	}
	
	
	
	
	public static void buttonAreaEnter(int i) {
		buttonLabel[i].setBackground(Color.DARK_GRAY);
	}

	
	public static void buttonAreaExit(int i) {
		buttonLabel[i].setBackground(Color.GRAY);
	}
}
