package dungeon;

import java.util.Random;

public class CreateCombat extends MapTracker {
	public static Random random = new Random();
	
	public static boolean[] alive = new boolean[10];
	
	public static String[] order = new String[10];
	public static String currentOrder;
	
	public static String[] currentRoster = {null, null, null};
	public static String currentHero = null;
	public static int currentHeroNumber = 0;
	
	//Need to make it so enemies show up on console map
	public static void combatInfo() {
		int mixA;
		int mixB;
		String placeholder;
		
		resetCombat();
		
		if (currentRoster[0].equals("Artorias") || currentRoster[1].equals("Artorias") || currentRoster[2].equals("Artorias")) {
			map[0][1] = "Artorias";
		} else if (currentRoster[0].equals("Issac") || currentRoster[1].equals("Issac") || currentRoster[2].equals("Issac")) {
			map[0][2] = "Issac";
		} else if (currentRoster[0].equals("Veth") || currentRoster[1].equals("Veth") || currentRoster[2].equals("Veth")) {
			map[0][3] = "Veth";
		} else if (currentRoster[0].equals("Zim Zam") || currentRoster[1].equals("Zim Zam") || currentRoster[2].equals("Zim Zam")) {
			map[0][4] = "Zim Zam";
		} else if (currentRoster[0].equals("Ireena") || currentRoster[1].equals("Ireena") || currentRoster[2].equals("Ireena")) {
			map[0][5] = "Ireena";
		}
		
		
		order[0] = currentRoster[0];
		order[1] = currentRoster[1];
		order[2] = currentRoster[2];
		
		//Create Enemies
		for (int i = 0; i < 7; i++) {
			order[i + 3] = enemy[i].getName();
		}
		
		//Image Stuff
		for (int i = 0; i < 7; i++) {
			enemySpriteLabel[i].setVisible(true);
		}
		
		for (int i = 0; i < 5; i++) {
			if (hero[i].getName() == currentRoster[0] || hero[i].getName() == currentRoster[1] || hero[i].getName() == currentRoster[2]) {
				heroSpriteLabel[i].setVisible(true);
			}
		}
		
		//Order Mixer
		for (int i = 0; i < order.length; i++) {
			for (int x = 0; x < order.length; x++) {
				mixA = random.nextInt(order.length);
				mixB = random.nextInt(order.length);
				placeholder = order[mixB];
				order[mixB] = order[mixA];
				order[mixA] = placeholder;
			}
		}
	}
	
	
	
	public static void resetCombat() {
		for (int i = 0; i < order.length; i++) {
			order[i] = null;
			alive[i] = true;
		}
	}
}
