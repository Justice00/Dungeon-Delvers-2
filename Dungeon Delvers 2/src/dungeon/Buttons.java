package dungeon;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Buttons extends Items {
	public static int numberOfButtons = 30;
	public static JLabel[] buttonLabel = new JLabel[numberOfButtons];
	public static ImageIcon buttonImage = new ImageIcon();
	
	public Buttons() {
		//Splashscreen
		createButton(0, "Start", null, 287, 575, 200, 75);
		
		//Hero Info Button
		createButton(1, "Back", null, 512, 575, 200, 75);
		createButton(2, "Next", null, 287, 575, 200, 75);
		createButton(3, "How to Play", null, 35, 25, 200, 75);
		createButton(4, "Artorias Info", null, 35, 125, 200, 75);
		createButton(5, "Issac Info", null, 35, 225, 200, 75);
		createButton(6, "Veth Info", null, 35, 325, 200, 75);
		createButton(7, "Zim Zam Info", null, 35, 425, 200, 75);
		createButton(8, "Ireena Info", null, 35, 525, 200, 75);
				
		//Game Info Button
		createButton(9, "", "Question Mark.png", 920, 10, 61, 61);
		
		//Roster Buttons
		createButton(10, "", "Artorias Sprite.png", 350, 165, 61, 61);
		createButton(11, "", "Issac Sprite.png", 410, 165, 61, 61);
		createButton(12, "", "Veth Sprite.png", 470, 165, 61, 61);
		createButton(13, "", "Zim Zam Sprite.png", 530, 165, 61, 61);
		createButton(14, "", "Ireena Sprite.png", 590, 165, 405, 61);
		
		createButton(15, "Next", null, 400, 575, 200, 75);
		
		//Combat Buttons
		createButton(16, "Action 1", null, 62, 575, 200, 75);
		createButton(17, "Action 2", null,  287, 575, 200, 75);
		createButton(18, "Action 3", null, 512, 575, 200, 75);
		createButton(19, "Action 4", null, 737, 575, 200, 75);
				
		createButton(20, enemy[0].getName(), null, 24, 575, 115, 60);
		createButton(21, enemy[1].getName(), null, 160, 575, 115, 60);
		createButton(22, enemy[2].getName(), null, 297, 575, 115, 60);
		createButton(23, enemy[3].getName(), null, 434, 575, 115, 60);
		createButton(24, enemy[4].getName(), null, 571, 575, 115, 60);
		createButton(25, enemy[5].getName(), null, 708, 575, 115, 60);
		createButton(26, enemy[6].getName(), null, 845, 575, 115, 60);
			
		createButton(27, "Next Turn", null, 400, 575, 200, 75);
				
		//Game Over Buttons
		createButton(28, "Restart", null ,287, 575, 200, 75);
		createButton(29, "Exit", null, 512, 575, 200, 75);
		
		for (int i = 0; i < numberOfButtons; i++) {
			frame.add(buttonLabel[i]);
		}
		
		buttonLabel[0].setVisible(true);
		buttonLabel[29].setVisible(true);
	}
	
	public static void createButton(int buttonNumber, String buttonText, String png, int x, int y, int width, int height) {
		buttonLabel[buttonNumber] = new JLabel();
		buttonLabel[buttonNumber].setBounds(x, y, width, height);
		
		if (png != null) {
			buttonImage = new ImageIcon(png);
			buttonLabel[buttonNumber].setIcon(buttonImage);
			
		} else {
			buttonLabel[buttonNumber].setText(buttonText);
			buttonLabel[buttonNumber].setBackground(Color.GRAY);
			buttonLabel[buttonNumber].setHorizontalAlignment(buttonLabel[buttonNumber].CENTER);
			buttonLabel[buttonNumber].setVerticalAlignment(buttonLabel[buttonNumber].CENTER);
			buttonLabel[buttonNumber].setOpaque(true);
		}
		
		buttonLabel[buttonNumber].setVisible(false);
	}
}
