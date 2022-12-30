package dungeon;

import javax.swing.JFrame;

public class Window extends Game {
	public static JFrame frame = new JFrame();
	
	public Window() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setTitle("Dungeon Delvers 2 (It's Delvin Time)");
		frame.setResizable(false);
		frame.setLayout(null);
	}
}
