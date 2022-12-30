package dungeon;

public class MapTracker extends CreateSprites {
	public static String[][] map = new String[11][7];
	int mapX;
	int mapY;
	
	public MapTracker() {
		
	}
	
	public void printConsoleMap() {
		for (int y = 0; y < 7; y++) {
			for (int x = 0; x < 11; x++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
