package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		// we usually don't use this
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode(); //returns the integer keyCode associated with the key in this event
		if(code == KeyEvent.VK_W) { //if user press W then
			upPressed = true;
		}
		
		if(code == KeyEvent.VK_S) { //if user press S then
			downPressed = true;		
		}
		
		if(code == KeyEvent.VK_A) { //if user press A then
			rightPressed = true;
		}
		
		if(code == KeyEvent.VK_D) { //if user press D then
			leftPressed = true;		
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) { //if user press W then
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) { //if user press S then
			downPressed = false;		
		}
		
		if(code == KeyEvent.VK_A) { //if user press A then
			rightPressed = false;
		}
		
		if(code == KeyEvent.VK_D) { //if user press D then
			leftPressed = false;		
		}
	}

}
