package dungeon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class Delete extends JFrame implements KeyListener, MouseListener{	
	//To make player spawning easier make it so each character has their own spawning location on the left side of the map
	//For enemy AI make it so like maybe close range enemies scan each column
	//from right to left and target the closest and ranges target the farthest.
	
	//Enemy AI.
	//Enemies have different AI's ranged enemies can have two one that targets random and one that targets weakest characters
	
	//really need to transfer everything to multiple classes.
	
	public static Random random = new Random();
	
	private static final long serialVersionUID = 1L;
	
	//Turn on and off movement when on different screens
	
	//Artorias, Issac, Veth, Zim Zam, Ireena
	public static int[] rosterCheck = new int[5];
	
	public static int temp = 0; //for the back button on the hero info page
	
	public static int temp2; //Also for the back button to determine what buttons person was on previously
	
	public static int round = 0;
	
	public static String[][] map = new String[11][7];
	int mapX;
	int mapY;
	
	public static String[] currentRoster = {null, null, null};
	
	////create bonus damage variable to hold all the bonus damage does
	
	//may be able to remove current order or another variable
	public static int spritesInCombat = 7;
	public static String currentOrder = "Current | ";
	public static String[] turnOrder = new String[spritesInCombat];
	
	public static String currentStats;
	
	public static int a = 0;
	
	public static int numberOfSprites = 5;
	public static JLabel[] spriteLabel = new JLabel[numberOfSprites];
	public static ImageIcon[] spriteImage = new ImageIcon[numberOfSprites];
	public static Sprite[] hero = new Sprite[5];
	
	//Button image 0 to 5 are open still (not used)
	public static int numberOfButtons = 30;
	public static JLabel[] buttonLabel = new JLabel[numberOfButtons];
	public static ImageIcon[] buttonImage = new ImageIcon[numberOfButtons];
	
	public static int numberOfTextAreas = 4;
	public static JLabel[] text = new JLabel[numberOfTextAreas];
	
	public static JLabel infoImageLabel = new JLabel();
	public static ImageIcon[] infoImageImage = new ImageIcon[5];
	
	public static JLabel backgroundLabel = new JLabel();
	public static ImageIcon[] backgroundImage = new ImageIcon[5];
	
	public static JFrame frame = new JFrame();
	
	public static Border border = BorderFactory.createLineBorder(Color.GRAY);
	
	//public static CombatScenarios scenario = new CombatScenarios();
	
	
	
	//
	//
	//
	//Create new timer class that allows me to create a new timer for multi round effects!
	//
	//
	//
	public Delete() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setTitle("Dungeon Delvers 2 (It's Delvin Time)");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.addKeyListener(this);
		
		//name, maxHealth, currentHealth, armor, damage, maxSpeed, currentSpeed, maxMana, currentMana, xLocation, yLocation
		hero[0] = new Sprite("Artorias", 18, 18, 3, 4, 3, 3, 0, 0, 170, 165);
		hero[1] = new Sprite("Issac", 16, 16, 2, 4, 3, 3, 0, 0, 170, 225);
		hero[2] = new Sprite("Veth", 12, 12, 1, 5, 6, 6, 0, 0, 170, 285);
		hero[3] = new Sprite("Zim Zam", 10, 10, 0, 5, 3, 3, 100, 100, 170, 345);
		hero[4] = new Sprite("Ireena", 14, 14, 1, 3, 4, 4, 100, 100, 170, 405);
		
		enemy[0] = new Sprite("Skeleton 1", 15, 15, 1, 3, 3, 3, 0, 0, 770, 105);
		enemy[1] = new Sprite("Skeleton 2", 15, 15, 1, 3, 3, 3, 0, 0, 770, 165);
		enemy[2] = new Sprite("Skeleton 3", 15, 15, 1, 3, 3, 3, 0, 0, 770, 225);
		enemy[3] = new Sprite("Skeleton 4", 15, 15, 1, 3, 3, 3, 0, 0, 770, 285);
		enemy[4] = new Sprite("Skeleton 5", 15, 15, 1, 3, 3, 3, 0, 0, 770, 345);
		enemy[5] = new Sprite("Skeleton 6", 15, 15, 1, 3, 3, 3, 0, 0, 770, 405);
		enemy[6] = new Sprite("Skeleton 7", 15, 15, 1, 3, 3, 3, 0, 0, 770, 465);
		
		/*
		currentOrder = "";
		
		currentStats = hero[a].getName()
				+ " | Health " + hero[a].getCurrentHealth() + "/" + hero[a].getMaxHealth()
				+ " | Armor " + hero[a].getArmor()
				+ " | Damage " + hero[a].getDamage()
				+ " | Speed " + hero[a].getCurrentSpeed() + "/" + hero[a].getMaxSpeed()
				+ " |";
		if (hero[a].getMaxMana() != 0) {
			currentStats = currentStats + " Mana " + hero[a].getCurrentMana() + "/" + hero[a].getMaxMana();
		}
		*/
		
		
		
		
		createEnemySpriteImage(0, "Sword Skeleton.png");
		createEnemySpriteImage(1, "Sword Skeleton.png");
		createEnemySpriteImage(2, "Sword Skeleton.png");
		createEnemySpriteImage(3, "Sword Skeleton.png");
		createEnemySpriteImage(4, "Sword Skeleton.png");
		createEnemySpriteImage(5, "Sword Skeleton.png");
		createEnemySpriteImage(6, "Sword Skeleton.png");
		
		createSpriteImage(0, "Artorias Sprite.png");
		createSpriteImage(1, "Issac Sprite.png");
		createSpriteImage(2, "Veth Sprite.png");
		createSpriteImage(3, "Zim Zam Sprite.png");
		createSpriteImage(4, "Ireena Sprite.png");
		
		infoImageImage[0] = new ImageIcon("Artorias Info Sprite.png");
		infoImageImage[1] = new ImageIcon("Issac Info Sprite.png");
		infoImageImage[2] = new ImageIcon("Veth Info Sprite.png");
		infoImageImage[3] = new ImageIcon("Zim Zam Info Sprite.png");
		infoImageImage[4] = new ImageIcon("Ireena Info Sprite.png");
		
		backgroundImage[0] = new ImageIcon("Splashscreen.png");
		backgroundImage[1] = new ImageIcon("Hero Info.png");
		backgroundImage[2] = new ImageIcon("Hero Roster.png");
		backgroundImage[3] = new ImageIcon("Background.png");
		backgroundImage[4] = new ImageIcon("Game Over Screen.png");
		

		//Image to buttons including hovering image also add hovering image for ? Icon.
		
		//Splashscreen
		createButton(0, "Start", 287, 575, 200, 75);
		
		//Hero Info Button
		createButton(1, "Back", 512, 575, 200, 75);
		createButton(2, "Next", 287, 575, 200, 75);
		createButton(3, "How to Play", 35, 25, 200, 75);
		createButton(4, "Artorias Info", 35, 125, 200, 75);
		createButton(5, "Issac Info", 35, 225, 200, 75);
		createButton(6, "Veth Info", 35, 325, 200, 75);
		createButton(7, "Zim Zam Info", 35, 425, 200, 75);
		createButton(8, "Ireena Info", 35, 525, 200, 75);
		
		//? Button
		createButtonImage(9, "Question Mark.png", 920, 10, 61, 61);
		
		//Roster
		createButtonImage(10, "Artorias Sprite.png", 350, 165, 61, 61);
		createButtonImage(11, "Issac Sprite.png", 410, 165, 61, 61);
		createButtonImage(12, "Veth Sprite.png", 470, 165, 61, 61);
		createButtonImage(13, "Zim Zam Sprite.png", 530, 165, 61, 61);
		createButtonImage(14, "Ireena Sprite.png", 590, 165, 405, 61);
		
		createButton(15, "Next", 400, 575, 200, 75);
		
		//Actions
		createButton(16, "Action 1", 62, 575, 200, 75);
		createButton(17, "Action 2", 287, 575, 200, 75);
		createButton(18, "Action 3", 512, 575, 200, 75);
		createButton(19, "Action 4", 737, 575, 200, 75);
		//Targeting Buttons
		createButton(20, enemy[0].getName(), 24, 575, 115, 60);
		createButton(21, enemy[1].getName(), 160, 575, 115, 60);
		createButton(22, enemy[2].getName(), 297, 575, 115, 60);
		createButton(23, enemy[3].getName(), 434, 575, 115, 60);
		createButton(24, enemy[4].getName(), 571, 575, 115, 60);
		createButton(25, enemy[5].getName(), 708, 575, 115, 60);
		createButton(26, enemy[6].getName(), 845, 575, 115, 60);
	
		//Next Turn
		createButton(27, "Next Turn", 400, 575, 200, 75);
		
		//Game Over
		createButton(28, "Restart", 287, 575, 200, 75);
		createButton(29, "Exit", 512, 575, 200, 75);
		
		infoImageLabel.setBounds(750, 25, 183, 183);
		frame.add(infoImageLabel);
		
		
		
		for (int i = 0; i < numberOfButtons; i++) {
			frame.add(buttonLabel[i]);
			buttonLabel[i].addMouseListener(this);
		}
		
		buttonLabel[0].setVisible(true);
		buttonLabel[29].setVisible(true);
		
		createTextArea(0, "", 70, 670, 850, 75, true);
		createTextArea(1, currentStats, 70, 515, 850, 75, false);
		createTextArea(2, currentOrder, 75, 20, 850, 75, false);
		
		text[2].setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		text[3] = new JLabel();
		text[3].setText("");
		text[3].setBounds(250, 20, 750, 675);
		text[3].setFont(new Font("Times New Roman", Font.PLAIN, 16));
		text[3].setForeground(Color.LIGHT_GRAY);
		text[3].setHorizontalAlignment(text[3].LEFT);
		text[3].setVerticalAlignment(text[3].TOP);
		text[3].setVisible(false);
		
		for (int i = 0; i < numberOfTextAreas; i++) {
			frame.add(text[i]);
		}
		
		
		for (int i = 0; i < numberOfSprites; i++) {
			frame.add(spriteLabel[i]);
		}
		
		for (int i = 0; i < 7; i++) {
			frame.add(enemySpriteLabel[i]);
		}
		
		
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(backgroundImage[0]);
		backgroundLabel.setBounds(0, 0, 1000, 800);
		
		
		frame.add(backgroundLabel);
		
		frame.setVisible(true);
		
		printConsoleMap();
	}
	
	public static void createSpriteImage(int i, String spriteName) {
		spriteImage[i] = new ImageIcon(spriteName);
		spriteLabel[i] = new JLabel();
		spriteLabel[i].setIcon(spriteImage[i]);
		spriteLabel[i].setBounds(hero[i].getXLocation(), hero[i].getYLocation(), 61, 61);
		spriteLabel[i].setVisible(false);
	}
	
	public static void createEnemySpriteImage(int i, String spriteName) {
		enemySpriteImage[i] = new ImageIcon(spriteName);
		enemySpriteLabel[i] = new JLabel();
		enemySpriteLabel[i].setIcon(enemySpriteImage[i]);
		enemySpriteLabel[i].setBounds(enemy[i].getXLocation(), enemy[i].getYLocation(), 61, 61);
		enemySpriteLabel[i].setVisible(false);
	}
	
	public static void createButton(int i, String buttonText, int x, int y, int width, int height) {
		buttonLabel[i] = new JLabel();
		buttonLabel[i].setText(buttonText);
		buttonLabel[i].setBackground(Color.GRAY);
		buttonLabel[i].setBounds(x, y, width, height);
		buttonLabel[i].setHorizontalAlignment(buttonLabel[i].CENTER);
		buttonLabel[i].setVerticalAlignment(buttonLabel[i].CENTER);
		buttonLabel[i].setOpaque(true);
		buttonLabel[i].setVisible(false);
	}
	
	public static void createButtonImage(int i, String png, int x, int y, int width, int height) {
		buttonImage[i] = new ImageIcon(png);
		buttonLabel[i] = new JLabel();
		buttonLabel[i].setIcon(buttonImage[i]);
		buttonLabel[i].setBounds(x, y, width, height);
		buttonLabel[i].setVisible(false);
	}
	
	public static void createTextArea(int i, String words, int x, int y, int width, int height, boolean addBorder) {
		text[i] = new JLabel();
		text[i].setText(words);
		text[i].setBounds(x, y, width, height);
		text[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
		text[i].setForeground(Color.LIGHT_GRAY);
		text[i].setHorizontalAlignment(text[i].CENTER);
		text[i].setVerticalAlignment(text[i].CENTER);
		if (addBorder == true) {
			text[i].setBorder(border);
		}
		text[i].setVisible(false);
	}
	
	
	//may need to change this from a loop to a method that kinda acts as a loop where it does the turn then presents the next
			//button and the next button just calls the loop again but passes in a different hero.
			
			//Make it so when players click an action it then displays the next button and the next button displays the action button
			//Do this before the targeting buttons are added
			
			//Move/Action --> Target --> Next Turn
			
			
			/*
			public static int spritesInCombat = 7;
			public static String currentOrder = "Current | ";
			public static String[] turnOrder = new String[spritesInCombat];
			 */
	//Max of 5 enemies
	public static ImageIcon[] enemySpriteImage = new ImageIcon[7];//1 for each enemy
	public static JLabel[] enemySpriteLabel = new JLabel[7];
	public static Sprite[] enemy = new Sprite[7];
	
	String[] order = new String[3 + 7];
	public static String currentHero = null;
	public static int currentHeroNumber = 0;
	
	
	public void createCombat() {
		//TODO Create Combat
		
		//Text Stuff
		for (int i = 0; i < order.length; i++) {
			order[i] = null;
		}
		
		int mixA;
		int mixB;
		String placeholder;
		
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
				spriteLabel[i].setVisible(true);
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
		
		currentOrder = "Turn Order | ";
		for (int i = 0; i < order.length; i++) {
			currentOrder += order[i] + " | ";
			System.out.print(order[i] + " | ");
		}
		
		
		
	}
		
	//TODO
	//
	//TODO
	//TODO
	//
	// Make it so on left side of the screen it displays those currently alive in the roster and their health.
	// Make it so on the right side of the screen it shows the currently alive enemies and their health.
		
		
		
	
	public void printConsoleMap() {
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 11; x++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		int i = -1;
		
		if (currentHero.equals("Artorias")) {
			i = 0;
		} else if (currentHero.equals("Issac")) {
			i = 1;
		} else if (currentHero.equals("Veth")) {
			i = 2;
		} else if (currentHero.equals("Zim Zam")) {
			i = 3;
		} else if (currentHero.equals("Ireena")) {
			i = 4;
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
		spriteLabel[i].setLocation(hero[i].getXLocation(), hero[i].getYLocation());
		hero[i].setCurrentSpeed(hero[i].getCurrentSpeed() - 1);
		
		currentStats = hero[i].getName()
				+ " | Health " + hero[i].getCurrentHealth() + "/" + hero[i].getMaxHealth()
				+ " | Armor " + hero[i].getArmor()
				+ " | Damage " + hero[i].getDamage()
				+ " | Speed " + hero[i].getCurrentSpeed() + "/" + hero[i].getMaxSpeed()
				+ " |";
		text[1].setText(currentStats);
	}
	
	public void moveOnConsoleMap(int x, int y) {
		String placeholder;
		
		placeholder = map[mapX][mapY];
		map[mapX][mapY] = map[mapX + x][mapY + y];
		map[mapX + x][mapY + y] = placeholder;
	}

	
	/*game over screen kinda
	backgroundLabel[2].setVisible(false);
	
	
	for (int i = 0; i < numberOfSprites; i++) {
		spriteLabel[i].setVisible(false);
	}
	
	text[0].setVisible(false);
	text[1].setVisible(false);
	text[2].setVisible(false);
	buttonLabel[7].setVisible(false);
	*/
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//make it so there's also an exit button that the player can access whenever.
		
		//Main Menu Start Button
		if (e.getSource() == buttonLabel[0]) {
			backgroundLabel.setIcon(backgroundImage[1]);
			buttonLabel[0].setVisible(false);
			buttonLabel[1].setVisible(true);
			buttonLabel[2].setVisible(true);
			buttonLabel[3].setVisible(true);
			buttonLabel[4].setVisible(true);
			buttonLabel[5].setVisible(true);
			buttonLabel[6].setVisible(true);
			buttonLabel[7].setVisible(true);
			buttonLabel[8].setVisible(true);
			buttonLabel[29].setVisible(false);
			text[3].setVisible(true);
			
		} else if (e.getSource() == buttonLabel[1]) {
			backgroundLabel.setIcon(backgroundImage[0]);
			buttonLabel[0].setVisible(true);
			buttonLabel[1].setVisible(false);
			buttonLabel[2].setVisible(false);
			buttonLabel[3].setVisible(false);
			buttonLabel[4].setVisible(false);
			buttonLabel[5].setVisible(false);
			buttonLabel[6].setVisible(false);
			buttonLabel[7].setVisible(false);
			buttonLabel[8].setVisible(false);
			buttonLabel[29].setVisible(true);
			
		} else if (e.getSource() == buttonLabel[2]) {
			if (temp == 1) {
				backgroundLabel.setIcon(backgroundImage[3]);
				
				for(int i = 0; i < 8; i++)
					buttonLabel[i].setVisible(false);
				
				buttonLabel[9].setVisible(true);
				buttonLabel[15].setVisible(false);
				
				System.out.println(temp2);
				if (temp2 == 0) {
					buttonLabel[16].setVisible(true);
					buttonLabel[17].setVisible(true);
					buttonLabel[18].setVisible(true);
					buttonLabel[19].setVisible(true);
				} else if (temp2 == 1) {
					buttonLabel[27].setVisible(true);
				}
				
				buttonLabel[2].setText("Back to Game");
				text[0].setVisible(true);
				text[1].setVisible(true);
				text[2].setVisible(true);
				
				for (int i = 0; i < 5; i++) {
					for (int h = 0; h < 10; h++) {
						if (order[h] == hero[i].getName()) {
							spriteLabel[i].setVisible(true);
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
				
				
			} else if (temp == 0) {
				backgroundLabel.setIcon(backgroundImage[2]);
				buttonLabel[1].setVisible(false);
				buttonLabel[2].setVisible(false);
				buttonLabel[3].setVisible(false);
				buttonLabel[4].setVisible(false);
				buttonLabel[5].setVisible(false);
				buttonLabel[6].setVisible(false);
				buttonLabel[7].setVisible(false);
				buttonLabel[8].setVisible(false);
				buttonLabel[9].setVisible(true);
				buttonLabel[10].setVisible(true);
				buttonLabel[11].setVisible(true);
				buttonLabel[12].setVisible(true);
				buttonLabel[13].setVisible(true);
				buttonLabel[14].setVisible(true);
				
				if (currentRoster[0] != null && currentRoster[1] != null && currentRoster[2] != null) {
					buttonLabel[15].setVisible(true);
				} else {
					buttonLabel[15].setVisible(false);
				}
				
				buttonLabel[2].setText("Back to Roster");
			}
			
		} else if (e.getSource() == buttonLabel[3]) {
		} else if (e.getSource() == buttonLabel[4]) {
		} else if (e.getSource() == buttonLabel[5]) {
		} else if (e.getSource() == buttonLabel[6]) {
		} else if (e.getSource() == buttonLabel[7]) {
		} else if (e.getSource() == buttonLabel[8]) {
			
		} else if (e.getSource() == buttonLabel[9]) {
			backgroundLabel.setIcon(backgroundImage[1]);
			buttonLabel[1].setVisible(true);
			buttonLabel[2].setVisible(true);
			buttonLabel[3].setVisible(true);
			buttonLabel[4].setVisible(true);
			buttonLabel[5].setVisible(true);
			buttonLabel[6].setVisible(true);
			buttonLabel[7].setVisible(true);
			buttonLabel[8].setVisible(true);
			buttonLabel[9].setVisible(false);
			buttonLabel[10].setVisible(false);
			buttonLabel[11].setVisible(false);
			buttonLabel[12].setVisible(false);
			buttonLabel[13].setVisible(false);
			buttonLabel[14].setVisible(false);
			buttonLabel[15].setVisible(false);
			buttonLabel[16].setVisible(false);
			buttonLabel[17].setVisible(false);
			buttonLabel[18].setVisible(false);
			buttonLabel[19].setVisible(false);
			buttonLabel[27].setVisible(false);
			text[0].setVisible(false);
			text[1].setVisible(false);
			text[2].setVisible(false);
			text[3].setVisible(true);
			
			for (int i = 0; i < numberOfSprites; i++) {
				spriteLabel[i].setVisible(false);
			}
		
			for (int i = 0; i < 7; i++) {
				enemySpriteLabel[i].setVisible(false);
			}
			
			
			
		/*
		map[0][1] = "Artorias";
		map[0][2] = "Issac";
		map[0][3] = "Veth";
		map[0][4] = "Zim Zam";
		map[0][5] = "Ireena";
		 */
			
			
		} else if (e.getSource() == buttonLabel[10]) {
			heroRoster(0, 10, 350, "Artorias", 1);
			
		} else if (e.getSource() == buttonLabel[11]) { 
			heroRoster(1, 11, 410, "Issac", 2);
			
		} else if (e.getSource() == buttonLabel[12]) { 
			heroRoster(2, 12, 470, "Veth", 3);
			
		} else if (e.getSource() == buttonLabel[13]) { 
			heroRoster(3, 13, 530, "Zim Zam", 4);
			
		} else if (e.getSource() == buttonLabel[14]) { 
			heroRoster(4, 14, 590, "Ireena", 5);
			
			
			
			
			
			
			
		} else if (e.getSource() == buttonLabel[15]) {
			backgroundLabel.setIcon(backgroundImage[3]);
			buttonLabel[10].setVisible(false);
			buttonLabel[11].setVisible(false);
			buttonLabel[12].setVisible(false);
			buttonLabel[13].setVisible(false);
			buttonLabel[14].setVisible(false);
			buttonLabel[15].setVisible(false);
			buttonLabel[16].setVisible(true);
			buttonLabel[17].setVisible(true);
			buttonLabel[18].setVisible(true);
			buttonLabel[19].setVisible(true);
			buttonLabel[2].setText("Back to Game");
			text[0].setVisible(true);
			text[1].setVisible(true);
			text[2].setVisible(true);
			text[3].setVisible(false);
			temp = 1;
			
			createCombat();
			currentHero = order[0];
			text[2].setText("<html><center> <b>Current Turn | " + currentHero + " |</b></center><br/>" + currentOrder + "</html>");
			changeButtonNames();
			
			if (currentHero != currentRoster[0] && currentHero != currentRoster[1] && currentHero != currentRoster[2]) {
				temp2 = 1;
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
				
			} else if (currentHero.equals(enemy[5].getName())) {
				updateInGameEnemyStats(5);
				
			} else if (currentHero.equals(enemy[6].getName())) {
				updateInGameEnemyStats(6);
				
			}
			
			text[1].setText(currentStats);
			
			/*
			for (int i = 0; i < numberOfSprites; i++) {
				spriteLabel[i].setVisible(true);
			}
			*/
			
			
			//Some buttons don't have a target so they need to skip the targeting and h=just do the action then go to next.
		} else if (e.getSource() == buttonLabel[16]) {
			/*
			if (currentHero.equals("Artorias")) {
				sword();
			} else if (currentHero.equals("Issac")) {
				
			} else if (currentHero.equals("Veth")) {
				
			} else if (currentHero.equals("Zim Zam")) {
				
			} else if (currentHero.equals("Ireena")) {
				
			}
			*/
			
			temp2 = 1;
			speedToZero();
			hideButtons();
			buttonLabel[27].setVisible(true);
			
		} else if (e.getSource() == buttonLabel[17]) {
			/*
			if (currentHero.equals("Artorias")) {
				crushingBlow();
			} else if (currentHero.equals("Issac")) {
				
			} else if (currentHero.equals("Veth")) {
				
			} else if (currentHero.equals("Zim Zam")) {
				
			} else if (currentHero.equals("Ireena")) {
				
			}
			*/
			
			temp2 = 1;
			speedToZero();
			hideButtons();
			buttonLabel[27].setVisible(true);
			
		} else if (e.getSource() == buttonLabel[18]) {
			/*
			if (currentHero.equals("Artorias")) {
				protection();
			} else if (currentHero.equals("Issac")) {
				
			} else if (currentHero.equals("Veth")) {
				
			} else if (currentHero.equals("Zim Zam")) {
				
			} else if (currentHero.equals("Ireena")) {
				
			}
			
			*/
			temp2 = 1;
			speedToZero();
			hideButtons();
			buttonLabel[27].setVisible(true);
			
		} else if (e.getSource() == buttonLabel[19]) {
			
			/*
			if (currentHero.equals("Artorias")) {
				dash();
			} else if (currentHero.equals("Issac")) {
				
			} else if (currentHero.equals("Veth")) {
				
			} else if (currentHero.equals("Zim Zam")) {
				
			} else if (currentHero.equals("Ireena")) {
				
			}
			*/
			
			temp2 = 1;
			speedToZero();
			hideButtons();
			buttonLabel[27].setVisible(true);
			
			
		} else if (e.getSource() == buttonLabel[27]) {
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
				temp2 = 0;
			} else {
				temp2 = 1;
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
			
			text[1].setText(currentStats);
			
			text[2].setText("<html><center> <b>Current Turn | " + currentHero + " |</b></center><br/>" + currentOrder + "</html>");
			
			changeButtonNames();
			
		} else if (e.getSource() == buttonLabel[28]) {
			
		} else if (e.getSource() == buttonLabel[29]) {
			System.exit(0);
		}
	}
	
	public static void speedToZero() {
		for (int i = 0; i < 5; i++) {
			if (currentHero == hero[i].getName()) {
				hero[i].setCurrentSpeed(0);
				updateInGameHeroStats(i);
				text[1].setText(currentStats);
			}
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
			buttonLabel[16].setVisible(false);
			buttonLabel[17].setVisible(false);
			buttonLabel[18].setVisible(false);
			buttonLabel[19].setVisible(false);
			buttonLabel[27].setVisible(true);
		}
	}
	
	
	public static void sword() {
		
		
	}
	
	public static void crushingBlow() {
		
		
	}
	
	public static void protection() {
		
		
	}
	
	public static void dash() {
		
	}
	
	
	
	/*
	map[0][1] = "Artorias";
	map[0][2] = "Issac";
	map[0][3] = "Veth";
	map[0][4] = "Zim Zam";
	map[0][5] = "Ireena";
	 */
	
	//MAKE SURE TO HAVE IT SOMEWHERE (NOT HERE) that the heros return to their original positions or else this won't work
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
	
	public static void hideButtons() {
		buttonLabel[16].setVisible(false);
		buttonLabel[17].setVisible(false);
		buttonLabel[18].setVisible(false);
		buttonLabel[19].setVisible(false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		/*
		if (e.getSource() == buttonLabel[0]) {
		}
		
		if (e.getSource() == buttonLabel[3]) {
			text[0].setText("Action 1");
		} else if (e.getSource() == buttonLabel[4]) {
			text[0].setText("Action 2");
		} else if (e.getSource() == buttonLabel[5]) {
			text[0].setText("Action 3");
		} else if (e.getSource() == buttonLabel[6]) {
			text[0].setText("Action 4");
		}
		*/
		if (e.getSource() == buttonLabel[3]) {
			text[3].setText("<html>do it</html>");

		} else if (e.getSource() == buttonLabel[4]) {
			infoImageLabel.setIcon(infoImageImage[0]);

			text[3].setText("<html>"
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
			
		} else if (e.getSource() == buttonLabel[5]) {
			infoImageLabel.setIcon(infoImageImage[1]);
			
			text[3].setText("<html>"
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
			
		} else if (e.getSource() == buttonLabel[6]) {
			infoImageLabel.setIcon(infoImageImage[2]);
			
			text[3].setText("<html>"
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
			
		} else if (e.getSource() == buttonLabel[7]) {
			infoImageLabel.setIcon(infoImageImage[3]);
			text[3].setText("<html>"
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
			
		} else if (e.getSource() == buttonLabel[8]) {
			infoImageLabel.setIcon(infoImageImage[4]);
			
			text[3].setText("<html>"
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
			
		} else if (e.getSource() == buttonLabel[16]) {
			if (currentHero.equals("Artorias")) {
				text[0].setText("<html>"
						+ "Sword:"
						+ "<br/>Does (" + (Math.ceil(hero[0].getDamage() * 1.0)) + ") 100% of Artorias's damage to an enemy within 1 tile."
						+ "</html>");
				
			} else if (currentHero.equals("Issac")) {
				text[0].setText("<html>"
						+ "Shortsword:"
						+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 1.0)) + ") 100% of Issac's damage to an enemy within 1 tile."
						+ "</html>");
				
			} else if (currentHero.equals("Veth")) {
				text[0].setText("<html>"
						+ "Dagger:"
						+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 1.0)) + ") 100% of Veth's damage to an enemy within 1 tile."
						+ "</html>");
				
			} else if (currentHero.equals("Zim Zam")) {
				text[0].setText("<html>"
						+ "Wand:"
						+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to an enemy within 1 tile."
						+ "</html>");
				
			} else if (currentHero.equals("Ireena")) {
				text[0].setText("<html>"
						+ "Staff:"
						+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of Ireena's damage to an enemy within 1 tile."
						+ "</html>");
				
			}
			
		} else if (e.getSource() == buttonLabel[17]) {
			if (currentHero.equals("Artorias")) {
				text[0].setText("<html>"
						+ "Crushing Blow:"
						+ "<br/>Increases Artorias's damage by (" + (Math.ceil(hero[0].getDamage() * 0.5)) + ") 50% for 3 rounds."
						+ "</html>");
				
			} else if (currentHero.equals("Issac")) {	
				text[0].setText("<html>"
						+ "Bow:"
						+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.75)) + ") 75% of Issac's damage to an enemy anywhere."
						+ "</html>");
			} else if (currentHero.equals("Veth")) {
				text[0].setText("<html>"
						+ "Pierce:"
						+ "<br/>Reduce the armor of an enemy within 1 tile by (" + (Math.ceil(hero[2].getDamage() * 0.5)) + ") 50% of Veth's damage."
						+ "</html>");
				
			} else if (currentHero.equals("Zim Zam")) {
				text[0].setText("<html>"
						+ "Shockwave:"
						+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage to all enemies within 1 tile, costs 20 mana."
						+ "</html>");
				
			} else if (currentHero.equals("Ireena")) {
				text[0].setText("<html>"
						+ "Divine Strike:"
						+ "<br/>Does (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of Ireena's damage to an enemy within 1 tile, Ireena heals equal to (" + (Math.ceil(hero[4].getDamage() * 0.5)) + ") 50% of her damage."
						+ "</html>");
				
			}
			
		} else if (e.getSource() == buttonLabel[18]) {
			if (currentHero.equals("Artorias")) {
				text[0].setText("<html>"
						+ "Protection:"
						+ "<br/>Increases armor given from Defend by (" + (Math.ceil(hero[0].getArmor() * 0.33)) + ") 33% for 4 rounds."
						+ "</html>");
				
			} else if (currentHero.equals("Issac")) {
				text[0].setText("<html>"
						+ "Volley:"
						+ "<br/>Does (" + (Math.ceil(hero[1].getDamage() * 0.25)) + ") 25% of Issac's damage to all enemies anywhere."
						+ "</html>");
				
			} else if (currentHero.equals("Veth")) {
				text[0].setText("<html>"
						+ "Poisonous Strike:"
						+ "<br/>Does (" + (Math.ceil(hero[2].getDamage() * 0.2)) + ") 20% of Veth’s damage to an enemy within 1 tile for next 8 rounds."
						+ "</html>");
				
			} else if (currentHero.equals("Zim Zam")) {
				text[0].setText("<html>"
						+ "Fireball:"
						+ "<br/>Does (" + (Math.ceil(hero[3].getDamage() * 1.5)) + ") 150% of Zim Zam's damage to an enemy anywhere, costs 40 mana."
						+ "</html>");
				
			} else if (currentHero.equals("Ireena")) {
				text[0].setText("<html>"
						+ "Heal:"
						+ "<br/>Ireena heals herself or an ally within 1 tile equal to (" + (Math.ceil(hero[4].getDamage() * 1.0)) + ") 100% of her damage, costs 20 mana."
						+ "</html>");
				
			}
			
		} else if (e.getSource() == buttonLabel[19]) {
			if (currentHero.equals("Artorias")) {
				text[0].setText("<html>"
						+ "Dash:"
						+ "<br/>Increases Artorias's speed by (" + (Math.ceil(hero[0].getMaxSpeed() * 1.0)) + ") 100% for 3 rounds."
						+ "</html>");
				
			} else if (currentHero.equals("Issac")) {
				text[0].setText("<html>"
						+ "Recover:"
						+ "<br/>Issac heals equal to (" + (Math.ceil(hero[1].getDamage() * 0.2)) + ") 20% of his damage."
						+ "</html>");
				
			} else if (currentHero.equals("Veth")) {
				text[0].setText("<html>"
						+ "Dodge:"
						+ "<br/>Increases dodge chance for Evasion by 20% for 3 rounds."
						+ "</html>");
				
			} else if (currentHero.equals("Zim Zam")) {
				text[0].setText("<html>"
						+ "Magic Barrier:"
						+ "<br/>Increases Zim Zam's armor by (" + (Math.ceil(hero[3].getDamage() * 0.5)) + ") 50% of Zim Zam's damage for 3 rounds, costs 70 mana."
						+ "</html>");
				
			} else if (currentHero.equals("Ireena")) {
				text[0].setText("<html>"
						+ "Mass Heal:"
						+ "<br/>Ireena heals herself and each ally equal to (" + (Math.ceil(hero[4].getDamage() * 0.25)) + ") 25% of her damage, costs 20 mana."
						+ "</html>");
				
			}
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		if (e.getSource() == buttonLabel[3]) {
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[4]) {
			infoImageLabel.setIcon(null);
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[5]) {
			infoImageLabel.setIcon(null);
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[6]) {
			infoImageLabel.setIcon(null);
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[7]) {
			infoImageLabel.setIcon(null);
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[8]) {
			infoImageLabel.setIcon(null);
			text[3].setText("");
		} else if (e.getSource() == buttonLabel[16]) {
			text[0].setText("");
		} else if (e.getSource() == buttonLabel[17]) {
			text[0].setText("");
		} else if (e.getSource() == buttonLabel[18]) {
			text[0].setText("");
		} else if (e.getSource() == buttonLabel[19]) {
			text[0].setText("");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
}