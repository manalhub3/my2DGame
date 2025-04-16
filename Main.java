package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		GamePanel gamepanel = new GamePanel();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); //whether the frame is resizable or not
		window.setTitle("2D Arcane");
		
		window.add(gamepanel);
		window.pack();
		gamepanel.startGameThread();
		
		window.setLocationRelativeTo(null); //not specify the location of the window(center of the screen)
		window.setVisible(true);
		
		
		
	}
}
