package dungeon;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CreateSprites extends CreateWindow {
	public static int numberOfHeroSprites = 5;
	public static JLabel[] heroSpriteLabel = new JLabel[numberOfHeroSprites];
	public static ImageIcon[] heroSpriteImage = new ImageIcon[numberOfHeroSprites];
	public static Sprite[] hero = new Sprite[numberOfHeroSprites];
	
	public static int numberOfEnemySprites = 7;
	public static JLabel[] enemySpriteLabel = new JLabel[numberOfEnemySprites];
	public static ImageIcon[] enemySpriteImage = new ImageIcon[1];
	public static Sprite[] enemy = new Sprite[numberOfEnemySprites];
	
	public CreateSprites() {
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
		
		createHeroSpriteImage(0, "Artorias Sprite.png");
		createHeroSpriteImage(1, "Issac Sprite.png");
		createHeroSpriteImage(2, "Veth Sprite.png");
		createHeroSpriteImage(3, "Zim Zam Sprite.png");
		createHeroSpriteImage(4, "Ireena Sprite.png");
		
		createEnemySpriteImage(0, "Sword Skeleton.png");
		createEnemySpriteImage(1, "Sword Skeleton.png");
		createEnemySpriteImage(2, "Sword Skeleton.png");
		createEnemySpriteImage(3, "Sword Skeleton.png");
		createEnemySpriteImage(4, "Sword Skeleton.png");
		createEnemySpriteImage(5, "Sword Skeleton.png");
		createEnemySpriteImage(6, "Sword Skeleton.png");
		
		for (int i = 0; i < numberOfHeroSprites; i++) {
			frame.add(heroSpriteLabel[i]);
		}
		
		for (int i = 0; i < numberOfEnemySprites; i++) {
			frame.add(enemySpriteLabel[i]);
		}
	}
	
	public static void createHeroSpriteImage(int i, String spriteName) {
		heroSpriteImage[i] = new ImageIcon(spriteName);
		heroSpriteLabel[i] = new JLabel();
		heroSpriteLabel[i].setIcon(heroSpriteImage[i]);
		heroSpriteLabel[i].setBounds(hero[i].getXLocation(), hero[i].getYLocation(), 61, 61);
		heroSpriteLabel[i].setVisible(false);
	}
	
	public static void createEnemySpriteImage(int i, String spriteName) {
		enemySpriteImage[0] = new ImageIcon(spriteName);
		enemySpriteLabel[i] = new JLabel();
		enemySpriteLabel[i].setIcon(enemySpriteImage[0]);
		enemySpriteLabel[i].setBounds(enemy[i].getXLocation(), enemy[i].getYLocation(), 61, 61);
		enemySpriteLabel[i].setVisible(false);
	}
}
