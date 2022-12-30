package dungeon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	public void mouseClicked(MouseEvent e) {
		//Main Menu Screen Buttons
		if (e.getSource() == buttonLabel[0]) {
			startToHeroInfo();
			
		}
		
		//Hero Info Screen Buttons
		if (e.getSource() == buttonLabel[1]) {
			backToMainMenu();
			
		} else if (e.getSource() == buttonLabel[2]) {
			if (tempOne == 1) {
				backToCombat();
				
			} else if (tempOne == 0) {
				nextToHeroRoster();
				
			}
			
		} else if (e.getSource() == buttonLabel[3]) {
			
		} else if (e.getSource() == buttonLabel[4]) {
		
		} else if (e.getSource() == buttonLabel[5]) {
			
		} else if (e.getSource() == buttonLabel[6]) {
			
		} else if (e.getSource() == buttonLabel[7]) {
			
		} else if (e.getSource() == buttonLabel[8]) {
			
		}
		
		//Hero Roster Screen Buttons
		if (e.getSource() == buttonLabel[9]) {
			backToHeroInfo();
			
		} else if (e.getSource() == buttonLabel[10]) {
			addArtoriasToRoster();
			
		} else if (e.getSource() == buttonLabel[11]) {
			addIssacToRoster();
			
		} else if (e.getSource() == buttonLabel[12]) {
			addVethToRoster();
			
		} else if (e.getSource() == buttonLabel[13]) {
			addIreenaToRoster();
			
		} else if (e.getSource() == buttonLabel[14]) {
			addZimZamToRoster();
			
		} else if (e.getSource() == buttonLabel[15]) {
			nextToCombat();
			
		}
		
		
		if (e.getSource() == buttonLabel[16]) {
			ActionOne();
			
		} else if (e.getSource() == buttonLabel[17]) {
			ActionTwo();
			
		} else if (e.getSource() == buttonLabel[18]) {
			ActionThree();
			
		} else if (e.getSource() == buttonLabel[19]) {
			ActionFour();
			
		} else if (e.getSource() == buttonLabel[20]) {
			target(0);
			
		} else if (e.getSource() == buttonLabel[21]) {
			target(1);
			
		} else if (e.getSource() == buttonLabel[22]) {
			target(2);
			
		} else if (e.getSource() == buttonLabel[23]) {
			target(3);
			
		} else if (e.getSource() == buttonLabel[24]) {
			target(4);
			
		} else if (e.getSource() == buttonLabel[25]) {
			target(5);
			
		} else if (e.getSource() == buttonLabel[26]) {
			target(6);
			
		} else if (e.getSource() == buttonLabel[27]) {
			nextTurn();
			
		}
		
		
		//Main Menu And Game Over Buttons
		if (e.getSource() == buttonLabel[28]) {
			
		} else if (e.getSource() == buttonLabel[29]) {
			exitGame();
			
		} 
		
	}

	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		//Main Menu Screen Buttons
		if (e.getSource() == buttonLabel[0]) {
			buttonAreaEnter(0);
			
		}
		

		//Hero Info Screen Buttons
		if (e.getSource() == buttonLabel[1]) {
			buttonAreaEnter(1);
			
		} else if (e.getSource() == buttonLabel[2]) {
			buttonAreaEnter(2);
			
		} else if (e.getSource() == buttonLabel[3]) {
			buttonAreaEnter(3);
			displayHowToPlay();
			
		} else if (e.getSource() == buttonLabel[4]) {
			buttonAreaEnter(4);
			displayArtoriasInfo();
			
		} else if (e.getSource() == buttonLabel[5]) {
			buttonAreaEnter(5);
			displayIssacInfo();
			
		} else if (e.getSource() == buttonLabel[6]) {
			buttonAreaEnter(6);
			displayVethInfo();
			
		} else if (e.getSource() == buttonLabel[7]) {
			buttonAreaEnter(7);
			displayZimZamInfo();
			
		} else if (e.getSource() == buttonLabel[8]) {
			buttonAreaEnter(8);
			displayIreenaInfo();
			
		}
		

		//Hero Roster Screen Buttons
		if (e.getSource() == buttonLabel[9]) {
			
		} else if (e.getSource() == buttonLabel[10]) {
			
		} else if (e.getSource() == buttonLabel[11]) {
			
		} else if (e.getSource() == buttonLabel[12]) {
			
		} else if (e.getSource() == buttonLabel[13]) {
			
		} else if (e.getSource() == buttonLabel[14]) {
			
		} else if (e.getSource() == buttonLabel[15]) {
			buttonAreaEnter(15);
			
		}
		
		
		if (e.getSource() == buttonLabel[16]) {
			buttonAreaEnter(16);
			actionOneDescription();
			
		} else if (e.getSource() == buttonLabel[17]) {
			buttonAreaEnter(17);
			actionOTwoDescription();
			
		} else if (e.getSource() == buttonLabel[18]) {
			buttonAreaEnter(18);
			actionThreeDescription();
			
		} else if (e.getSource() == buttonLabel[19]) {
			buttonAreaEnter(19);
			actionFourDescription();
			
		} else if (e.getSource() == buttonLabel[20]) {
			buttonAreaEnter(20);
			
		} else if (e.getSource() == buttonLabel[21]) {
			buttonAreaEnter(21);
			
		} else if (e.getSource() == buttonLabel[22]) {
			buttonAreaEnter(22);
			
		} else if (e.getSource() == buttonLabel[23]) {
			buttonAreaEnter(23);
			
		} else if (e.getSource() == buttonLabel[24]) {
			buttonAreaEnter(24);
			
		} else if (e.getSource() == buttonLabel[25]) {
			buttonAreaEnter(25);
			
		} else if (e.getSource() == buttonLabel[26]) {
			buttonAreaEnter(26);
			
		} else if (e.getSource() == buttonLabel[27]) {
			buttonAreaEnter(27);
			
		}
		

		//Main Menu And Game Over Buttons
		if (e.getSource() == buttonLabel[28]) {
			buttonAreaEnter(28);
			
		} else if (e.getSource() == buttonLabel[29]) {
			buttonAreaEnter(29);
			
		} 
		
	}

	
	
	
	@Override
	public void mouseExited(MouseEvent e) {
		//Main Menu Screen Buttons
		if (e.getSource() == buttonLabel[0]) {
			buttonAreaExit(0);
			
		}
		
		
		//Hero Info Screen Buttons
		if (e.getSource() == buttonLabel[1]) {
			buttonAreaExit(1);
			
		} else if (e.getSource() == buttonLabel[2]) {
			buttonAreaExit(2);
			
		} else if (e.getSource() == buttonLabel[3]) {
			buttonAreaExit(3);
			hideText(3);
			
		} else if (e.getSource() == buttonLabel[4]) {
			buttonAreaExit(4);
			hideText(3);
			
		} else if (e.getSource() == buttonLabel[5]) {
			buttonAreaExit(5);
			hideText(3);
			
		} else if (e.getSource() == buttonLabel[6]) {
			buttonAreaExit(6);
			hideText(3);
			
		} else if (e.getSource() == buttonLabel[7]) {
			buttonAreaExit(7);
			hideText(3);
			
		} else if (e.getSource() == buttonLabel[8]) {
			buttonAreaExit(8);
			hideText(3);
			
		}
		
		
		//Hero Roster Screen Buttons
		if (e.getSource() == buttonLabel[9]) {
			
		} else if (e.getSource() == buttonLabel[10]) {
			
		} else if (e.getSource() == buttonLabel[11]) {
			
		} else if (e.getSource() == buttonLabel[12]) {
			
		} else if (e.getSource() == buttonLabel[13]) {
			
		} else if (e.getSource() == buttonLabel[14]) {
			
		} else if (e.getSource() == buttonLabel[15]) {
			buttonAreaExit(15);
			
		}
		
		
		if (e.getSource() == buttonLabel[16]) {
			buttonAreaExit(16);
			hideText(0);
			
		} else if (e.getSource() == buttonLabel[17]) {
			buttonAreaExit(17);
			hideText(0);
			
		} else if (e.getSource() == buttonLabel[18]) {
			buttonAreaExit(18);
			hideText(0);
			
		} else if (e.getSource() == buttonLabel[19]) {
			buttonAreaExit(19);
			hideText(0);
			
		} else if (e.getSource() == buttonLabel[20]) {
			buttonAreaExit(20);
			
		} else if (e.getSource() == buttonLabel[21]) {
			buttonAreaExit(21);
			
		} else if (e.getSource() == buttonLabel[22]) {
			buttonAreaExit(22);
			
		} else if (e.getSource() == buttonLabel[23]) {
			buttonAreaExit(23);
			
		} else if (e.getSource() == buttonLabel[24]) {
			buttonAreaExit(24);
			
		} else if (e.getSource() == buttonLabel[25]) {
			buttonAreaExit(25);
			
		} else if (e.getSource() == buttonLabel[26]) {
			buttonAreaExit(26);
			
		} else if (e.getSource() == buttonLabel[27]) {
			buttonAreaExit(27);
			
		}
		

		//Main Menu And Game Over Buttons
		if (e.getSource() == buttonLabel[28]) {
			buttonAreaExit(28);
			
		} else if (e.getSource() == buttonLabel[29]) {
			buttonAreaExit(29);
			
		} 
		
	}
	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
	