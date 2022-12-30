package dungeon;

public class Main {
	public static CreateWindow createWindow = new CreateWindow();
	//May need to gwt ride of all the commented one below as they cause wierd problems
	
	//public static Buttons buttons = new Buttons();
	//public static TextAreas textAreas = new TextAreas();
	//public static Backgrounds backgrounds = new Backgrounds();
	//public static KeyInputs keyInputs = new KeyInputs();
	
	public static MouseInputs mouseInputs = new MouseInputs();
	
	//public static KeyInputs keyInputs = new KeyInputs();
	
	//public static MainMenuScreenButtons mainMenuScreenButtons = new MainMenuScreenButtons();
	//public static InfoScreenButtons infoScreenButtons = new InfoScreenButtons();
	
	public static void main(String[] args) {
		//Parallel Array Order for stats:
		//0 = Artorias
		//1 = Issac
		//2 = Veth
		//3 = Zim Zam
		//4 = Ireena
		
		//new Window();
		new Game();
	}

}
