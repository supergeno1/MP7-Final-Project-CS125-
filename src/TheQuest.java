import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
public class TheQuest extends Applet implements KeyListener {

	int imgxpos;
	int imgypos;
	int rows;
	int cols;
	int userRow;
	int userCol;
	boolean win;
	int waterCounter;
	boolean justice;
	boolean priestess;
	boolean lovers;
	int killCounter;
	boolean dead;
	boolean beginning;
	boolean key;
	int grid[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,12,1,1,1,1,1,1,1,1,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,14,1,1,1,1,1,1,1,14,1,1,1,1,1,1,1,1,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,16,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,16,1,1,1,0},
					{1,1,1,1,1,1,1,1,1,16,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0},
					{1,1,1,1,1,1,1,1,1,1,1,14,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0},
					{1,1,1,1,1,1,1,12,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,0,0,0,0,0,0,0},
					{1,1,1,1,1,1,1,1,1,1,1,1,4,4,4,4,4,4,6,4,4,4,4,4,4,1,1,1,1,1,0,0,0,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,12,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,22,1,1,1,1,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,24,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,26,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

	public void paint(Graphics g) {
		if (grid[15][29] == 21 && grid[16][29] == 23 && grid[17][29] == 25) {
			win = true;
		}
		if (waterCounter == 0) {
			waterCounter = 1;
			this.repaint();
		}
		else if (waterCounter == 1) {
			waterCounter = 2;
			this.repaint();
		}
		else {
			waterCounter = 0;
			this.repaint();
		}
		if (killCounter == 9) {
			key=true;
		}
		if (win == false && dead == false && beginning == false){
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					if (grid[row][col] == 1 || grid[row][col] == 2) {
						g.drawImage(getImage(getCodeBase(), "Ground2.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 0) {
						g.drawImage(getImage(getCodeBase(), "Water" + waterCounter + ".jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 3) {
						g.drawImage(getImage(getCodeBase(), "BridgeTop.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 4) {
						g.drawImage(getImage(getCodeBase(), "BridgeMid.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 5) {
						g.drawImage(getImage(getCodeBase(), "BridgeBottom.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 6) {
						g.drawImage(getImage(getCodeBase(), "Seal.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 12) {
						g.drawImage(getImage(getCodeBase(), "Skeleton.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 14) {
						g.drawImage(getImage(getCodeBase(), "Demon.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 16) {
						g.drawImage(getImage(getCodeBase(), "Dragon.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 22) {
						g.drawImage(getImage(getCodeBase(), "Eye.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 24) {
						g.drawImage(getImage(getCodeBase(), "Ghoul.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 26) {
						g.drawImage(getImage(getCodeBase(), "Serpent.gif"), 25 * col, 25 * row, 25, 25, this);
					}
					if (grid[row][col] == 11 || grid[row][col] == 13 || grid[row][col] == 15 || grid[row][col] == 21 || grid[row][col] == 23 || grid[row][col] == 25) {
						g.drawImage(getImage(getCodeBase(), "Dead.jpg"), 25 * col, 25 * row, 25, 25, this);
					}
				}
			}
		}
		if (beginning == false && dead == false && win == false) {
			g.drawImage(getImage(getCodeBase(), "Hero.jpg"), imgxpos, imgypos, 25, 25, this);
			if (justice == true) {
				g.drawImage(getImage(getCodeBase(), "Justice.jpg"), 10, 510, 200, 230, this);
			}
			if (priestess == true) {
				g.drawImage(getImage(getCodeBase(), "Priestess.jpg"), 350, 510, 200, 230, this);
			}
			if (lovers == true) {
				g.drawImage(getImage(getCodeBase(), "Lovers.jpg"), 690, 510, 200, 230, this);
			}
		}
		if (beginning == true) {
			g.drawString("The boat drops you off on a deserted island with your card powers. The sailors left you with some instructions.", 30, 50);
			g.drawString("'Make sure to hit those skeletons with a sword to crush their bones. The power of the Justice card should do well.'", 30, 140);
			g.drawString("'Those demons will be tough. You may have to purify them with the power of the Priestess card.'", 30, 170);
			g.drawString("'The dragons that terrorize the island must be pacified with the Lovers card. Be careful.'", 30, 200);
			g.drawString("'You can't pass that old bridge without getting rid of the rest of the monsters and gaining their power.'", 30, 230);
			g.drawString("'A huge monster will be waiting on the other side. You must attack its different parts with different powers to defeat it.'", 30, 260);
			g.drawString("'We're counting on you to reclaim this island and its resources. Remember, you'll get a large portion of the profits.'", 30, 290);
			g.drawString("You can use the 1, 2, and 3 keys to cycle through your cards, but it's up to you to decipher their true powers.", 30, 380);
			g.drawString("Tread carefully, however. One wrong move against these powerful monsters will lead to your demise.", 30, 410);
			g.drawString("Press 1 to begin your quest.", 30, 440);
		}
		if (win == true) {
			g.drawString("You've defeated the Lich-Ghoul-Snake and saved the island!", 30, 50);
			g.drawString("By completing this quest, you felt your powers grow stronger!", 30, 80);
			g.drawImage(getImage(getCodeBase(), "yourewinner.png"), 30, 110, 500, 600, this);
		}
		if (beginning == false && win == false && dead == false && key == true) {
			g.drawString("You have obtained the power to pass the bridge seal and face the true demon!", 10, 760);
		}
		if (dead == true) {
			g.drawImage(getImage(getCodeBase(), "Death.jpg"), 0, 0, 900, 600, this);
		}
	}

	public void init() {
		this.resize(grid[0].length * 25, (grid.length * 25) + 275);
		imgxpos = 0;
		imgypos = 0;
		userRow = 0;
		userCol = 0;
		rows = grid.length;
		cols = grid[0].length;
		killCounter = 0;
		waterCounter = 0;
		win = false;
		justice = true;
		priestess = false;
		lovers = false;
		dead = false;
		beginning = true;
		addKeyListener(this);
	}

	public void keyPressed(KeyEvent e){
		if (win == false){
			if (e.getKeyCode() == 49) { // #1 Pressed
				justice = true;
				priestess = false;
				lovers = false;
				beginning = false;
			}
			if (e.getKeyCode() == 50) { // #2 Pressed
				justice = false;
				priestess = true;
				lovers = false;
			}
			if (e.getKeyCode() == 51) { // #3 Pressed
				justice = false;
				priestess = false;
				lovers = true;
			}
			if (e.getKeyCode() == 37) { // Left Arrow
				if (userCol > 0) {
					userCol = userCol - 1;
					imgxpos = imgxpos - 25;
				}
				if (grid[userRow][userCol] == 0 || grid[userRow][userCol] == 3 || grid[userRow][userCol] == 5) {
					userCol = userCol + 1;
					imgxpos = imgxpos + 25;
				}
				if (grid[userRow][userCol] == 6) {
					if (key == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 2;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 12 || grid[userRow][userCol] == 26) {
					if (justice == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 14 || grid[userRow][userCol] == 24) {
					if (priestess == true){
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 16 || grid[userRow][userCol] == 22) {
					if (lovers == true){
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else{
						dead=true;
					}
				}
			}
			if (e.getKeyCode() == 38) { // Up Arrow
				if (userRow > 0){
					userRow = userRow - 1;
					imgypos = imgypos - 25;
				}
				if (grid[userRow][userCol] == 0 || grid[userRow][userCol] == 3 || grid[userRow][userCol] == 5) {
					userRow = userRow + 1;
					imgypos = imgypos + 25;
				}
				if (grid[userRow][userCol] == 6) {
					if (key == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 2;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 12 || grid[userRow][userCol] == 26) {
					if (justice == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 14 || grid[userRow][userCol] == 24) {
					if (priestess == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 16 || grid[userRow][userCol] == 22) {
					if (lovers == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
			}
			if (e.getKeyCode() == 39) { // Right Arrow
				if (userCol < grid[0].length - 1) {
					userCol = userCol + 1;
					imgxpos = imgxpos + 25;
				}
				if (grid[userRow][userCol] == 0 || grid[userRow][userCol] == 3 || grid[userRow][userCol] == 5) {
					userCol = userCol - 1;
					imgxpos = imgxpos - 25;
				}
				if (grid[userRow][userCol] == 6) {
					if (key == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 2;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 12 || grid[userRow][userCol] == 26) {
					if (justice == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 14 || grid[userRow][userCol] == 24) {
					if (priestess == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 16 || grid[userRow][userCol] == 22) {
					if (lovers == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
			}
			if (e.getKeyCode() == 40) { // Down Arrow
				if (userRow < grid.length - 1) {
					userRow = userRow + 1;
					imgypos = imgypos + 25;
				}
				if (grid[userRow][userCol] == 0 || grid[userRow][userCol] == 3 || grid[userRow][userCol] == 5) {
					userRow = userRow - 1;
					imgypos = imgypos - 25;
				}
				if (grid[userRow][userCol] == 6) {
					if (key == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 2;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 12 || grid[userRow][userCol] == 26) {
					if (justice == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 14 || grid[userRow][userCol] == 24) {
					if (priestess == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
				if (grid[userRow][userCol] == 16 || grid[userRow][userCol] == 22) {
					if (lovers == true) {
						grid[userRow][userCol] = grid[userRow][userCol] - 1;
						killCounter++;
					}
					else {
						dead = true;
					}
				}
			}
			if (grid[userRow][userCol] == 1) {
				grid[userRow][userCol] += 1;
			}
		repaint();
		}
	}

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	private Graphics dBufferedGraphic = null;
	private Image dbufferedImage = null;
	public void update (Graphics g) {
		if (dbufferedImage == null) {
			dbufferedImage = createImage(this.getSize().width, this.getSize().height);
			dBufferedGraphic = dbufferedImage.getGraphics();
		}
		dBufferedGraphic.setColor(getBackground());
		dBufferedGraphic.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dBufferedGraphic.setColor(getForeground());
		paint(dBufferedGraphic);
		g.drawImage(dbufferedImage , 0, 0, this);
	}
}
