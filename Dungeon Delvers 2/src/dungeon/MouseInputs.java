package dungeon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInputs extends CombatScreenButtons implements MouseListener {
	public static int[] rosterCheck = new int[5];
	
	public MouseInputs() {
		for (int i = 0; i < numberOfButtons; i++) {
			buttonLabel[i].addMouseListener(this);
		}
		
		frame.setVisible(true);
		printConsoleMap();
	}

	
	
	@Override
	public void mouseClicked(MouseEvent event) {
		//Main Menu Screen Buttons
		if (event.getSource() == buttonLabel[0]) {
			startToHeroInfo();
		}
		
		//Hero Info Screen Buttons
		if (event.getSource() == buttonLabel[1]) {
			backToMainMenu();
			
		} else if (event.getSource() == buttonLabel[2]) {
			if (tempOne == 1) {
				backToCombat();
				
			} else if (tempOne == 0) {
				nextToHeroRoster();	
			}
		}
		
		//Hero Roster Screen Buttons
		if (event.getSource() == buttonLabel[9]) {
			backToHeroInfo();
			
		} else if (event.getSource() == buttonLabel[10]) {
			addArtoriasToRoster();
			
		} else if (event.getSource() == buttonLabel[11]) {
			addIssacToRoster();
			
		} else if (event.getSource() == buttonLabel[12]) {
			addVethToRoster();
			
		} else if (event.getSource() == buttonLabel[13]) {
			addIreenaToRoster();
			
		} else if (event.getSource() == buttonLabel[14]) {
			addZimZamToRoster();
			
		} else if (event.getSource() == buttonLabel[15]) {
			nextToCombat();
			
		}
		
		
		for(int i = 16; i < 20; i++) {
			if (event.getSource() == buttonLabel[i]) {
				action(i - 15);
			}
		}
		
		
		for(int i = 20; i < 27; i++) {
			if (event.getSource() == buttonLabel[i]) {
				target(i - 20);
			}
		}
		
			
		if (event.getSource() == buttonLabel[27]) {
			nextTurn();	
		}
		
		
		//Main Menu And Game Over Buttons
		if (event.getSource() == buttonLabel[29]) {
			exitGame();
			
		} 
		
	}

	
	private void displayMenuDialogs(int i)
	{
		switch(i){
		
		case 3:
			displayHowToPlay();
			break;
			
		case 4: 
			displayArtoriasInfo();
			break;
			
		case 5:
			displayIssacInfo();
			break;
			
		case 6:
			displayVethInfo();
			break;
		
		case 7:
			displayZimZamInfo();
			break;
			
		case 8:
			displayIreenaInfo();
			break;
		
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		for(int i = 0; i < 30; i++){
			if (event.getSource() == buttonLabel[i] && (i < 9 || i > 14)) {
				buttonAreaEnter(i);
				displayMenuDialogs(i);
				
				if(i > 15 && i < 20){
					actionDescription(i - 15);
				}
				
			}
		}
	}

	
	
	
	@Override
	public void mouseExited(MouseEvent event) {
		for(int i = 0; i < 30; i++){
			if (event.getSource() == buttonLabel[i] && (i < 9 || i > 14)) {
				buttonAreaExit(i);
				
				if(i > 3 && i < 9) {
					hideText(3);
				} else if(i > 15 && i < 20) {
					hideText(0);
				}
			}
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
	}



	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
	