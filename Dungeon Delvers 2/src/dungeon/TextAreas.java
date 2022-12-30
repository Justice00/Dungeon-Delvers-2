package dungeon;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TextAreas extends Buttons {
	public static int numberOfTextAreas = 4;
	public static JLabel[] textLabel = new JLabel[numberOfTextAreas];
	
	public static JLabel infoImageLabel = new JLabel();
	public static ImageIcon[] infoImageImage = new ImageIcon[5];
	
	public TextAreas() {
		createTextArea(0, "", 70, 670, 850, 75, 20, true);
		createTextArea(1, "currentStats", 70, 515, 850, 75, 20, false);
		createTextArea(2, "currentOrder", 75, 20, 850, 75, 16, false);
		createTextArea(3, "", 250, 20, 750, 675, 16, false);
		
		textLabel[3].setHorizontalAlignment(JLabel.LEFT);
		textLabel[3].setVerticalAlignment(JLabel.TOP);
		
		for (int i = 0; i < numberOfTextAreas; i++) {
			frame.add(textLabel[i]);
		}
		
		InfoImage();
	}
	
	public static void createTextArea(int TextAreaNumber, String words, int x, int y, int width, int height, int fontSize, boolean addBorder) {
		textLabel[TextAreaNumber] = new JLabel();
		textLabel[TextAreaNumber].setBounds(x, y, width, height);
		textLabel[TextAreaNumber].setText(words);
		textLabel[TextAreaNumber].setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
		textLabel[TextAreaNumber].setForeground(Color.LIGHT_GRAY);
		textLabel[TextAreaNumber].setHorizontalAlignment(JLabel.CENTER);
		textLabel[TextAreaNumber].setVerticalAlignment(JLabel.CENTER);
		
		if (addBorder == true) {
			textLabel[TextAreaNumber].setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		
		textLabel[TextAreaNumber].setVisible(false);
	}
	
	public static void InfoImage() {
		infoImageImage[0] = new ImageIcon("Artorias Info Sprite.png");
		infoImageImage[1] = new ImageIcon("Issac Info Sprite.png");
		infoImageImage[2] = new ImageIcon("Veth Info Sprite.png");
		infoImageImage[3] = new ImageIcon("Zim Zam Info Sprite.png");
		infoImageImage[4] = new ImageIcon("Ireena Info Sprite.png");
		
		infoImageLabel.setBounds(750, 25, 183, 183);
		frame.add(infoImageLabel);
	}
}