package dungeon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Backgrounds extends TextAreas {
	public static JLabel backgroundLabel = new JLabel();
	public static ImageIcon[] backgroundImage = new ImageIcon[5];
	
	public Backgrounds() {
		backgroundImage[0] = new ImageIcon("Splashscreen.png");
		backgroundImage[1] = new ImageIcon("Hero Info.png");
		backgroundImage[2] = new ImageIcon("Hero Roster.png");
		backgroundImage[3] = new ImageIcon("Background.png");
		backgroundImage[4] = new ImageIcon("Game Over Screen.png");
		
		backgroundLabel = new JLabel();
		backgroundLabel.setBounds(0, 0, 1000, 800);
		backgroundLabel.setIcon(backgroundImage[0]);
		
		frame.add(backgroundLabel);
		
		/*
		frame.setVisible(true);
		
		for (int i = 0; i < numberOfButtons; i++) {
			buttonLabel[i].addMouseListener(this);
			System.out.println(i);
		}
		*/
		
	}
}
