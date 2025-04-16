package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	//screen settings
	final int originalFileSize = 16; //16*16 tiles (default size of player/map/..)
	
	final int scale =3;
	final int tileSize = originalFileSize*scale; //48*48
	
	final int maxScreenCol = 16;
	final int maxScreenRow = 16;
	
	final int screenWidth = tileSize*maxScreenCol; //768pixels
	final int screenHeight = tileSize*maxScreenRow;//576pixels
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; // smth u can start and stop and one a thread started it keeps the program running until u stop it
	
	//set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4; // 4 pixels
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //all the drawing from this component will be done in an off_screen painting buffer
		this.addKeyListener(keyH);
		this.setFocusable(true); //with this, this GamePanelcan be focused to receive key input
	}
	
	public void startGameThread() {
		gameThread = new Thread(this); //this means this class( it's how we initiate a thread)
		gameThread.start();
	}
	
	@Override
	public void run() {
		// when we call gameThread it automatically calls run method
		//we'll be creating a game loop
		double drawInterval = 1000000000/FPS; // 1sec in nanoSec / 0.016667 sec
		double nextDrawTime = System.nanoTime() + drawInterval; // the allocated time for a loop is 0.16667
		
		while(gameThread != null) {
			//long currentTime = System.nanoTime(); //returns the current value of the running java virtual machine's high-resolution time source in nanoseconds
			//System.out.println("the game loop is running");
			//1-Update : update information such as character positions
			update();
			//2-Draw : draw the screen with the updated information
			repaint(); // it's how we call paintComponent
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime); // this method works with millisecond
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	
	public void update() {
		if(keyH.upPressed == true) {
			playerY -= playerSpeed; // x values increases to the right
									// y values increases as they go down
		}
		else if(keyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if(keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if(keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //whenever we used graphics and stuff we should use it
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize); //(x,y,width,height)
		g2.dispose();
		
	}
	
	
}
