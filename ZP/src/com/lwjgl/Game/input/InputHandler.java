package com.lwjgl.Game.input;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import com.lwjgl.Game.Main;
import com.lwjgl.Game.Entity.EntityPlayer;
import com.lwjgl.Game.Render.Graphics;
import com.lwjgl.Game.Stats.tempWood;
import com.lwjgl.Game.output.Save;

public class InputHandler {

	/* MOUSE */
	public static int mouseXPos;
	public static int mouseYPos;
	public static int mouseButtonCount;
	public static int mouseButton;
	public static int mouseScroll;
	public static boolean mouseButtonDown;
	public static boolean mouseGrabbed;
	public static boolean mouseLeftButton;
	public static boolean mouseRightButton;
	public static boolean mouseTurnLeft;
	public static boolean mouseTurnRight;
	public static boolean mouseLookUp;
	public static boolean mouseLookDown;
	public static int earlyX;
	public static int laterX;
	public static int earlyY;
	public static int laterY;
	public static int DX;
	public static int DY;
	/* /MOUSE/ */

	/* MATH */
	public static double pydouble;
	public static int py;
	public static int points;
	/* /MATH/ */

	/* KEYBOARD */
	public static boolean keyboardW;// forward
	public static boolean keyboardA;// left
	public static boolean keyboardS;// backward
	public static boolean keyboardD;// right
	public static boolean keyboardR;// sprint
	public static boolean keyboardE;// inventory
	public static boolean keyboardSHIFT;// crouch
	public static boolean keyboardCTRL;// prone
	public static boolean keyboardSPACE;// jump
	public static boolean keyboardZ;// aim
	public static boolean keyboardESC;// menu
	public static boolean keyboardRETURN;// take screenshot
	public static boolean keyboardDELETE;// destroy

	/* /KEYBOARD/ */

	/* XY_COORD */

	/* /XY_COORD/ */

	public static void mouseRefresh() {
		mouseXPos = Mouse.getX();
		mouseYPos = 600 - Mouse.getY();
		mouseButtonCount = Mouse.getButtonCount();
		mouseLeftButton = Mouse.isButtonDown(0);
		mouseRightButton = Mouse.isButtonDown(1);
		DX = Mouse.getDX();
		DY = -Mouse.getDY();

		earlyX = mouseXPos;
		if (earlyX < laterX) {
			mouseTurnLeft = false;
			mouseTurnRight = true;
			System.out.println("right");
		}
		if (earlyX > laterX) {
			mouseTurnRight = false;
			mouseTurnLeft = true;
			System.out.println("left");
		}
		if (earlyX == laterX) {
			mouseTurnLeft = false;
			mouseTurnRight = false;
			// System.out.println("straight");
		}
		laterX = earlyX;

		earlyY = mouseYPos;
		if (earlyY > laterY) {
			mouseLookDown = true;
			mouseLookUp = false;
			System.out.println("down");
		}
		if (earlyY < laterY) {
			mouseLookUp = true;
			mouseLookDown = false;
			System.out.println("up");
		}
		if (earlyY == laterY) {
			mouseLookDown = false;
			mouseLookUp = false;
			// System.out.println("straight");
		}
		laterY = earlyY;

		/*
		 * System.out.println("left: " + mouseTurnLeft);
		 * System.out.println("right: " + mouseTurnRight);
		 * System.out.println("Mouse X Position: " + mouseXPos);
		 * System.out.println("Mouse Y Position: " + mouseYPos);
		 * System.out.println("Mouse button count: " + mouseButtonCount);
		 * System.out.println("Mouse left button: " + mouseLeftButton);
		 * System.out.println("Mouse right button: " + mouseRightButton);
		 */
	}

	public static void keyboardRefresh() {
		keyboardW = Keyboard.isKeyDown(Keyboard.KEY_W);
		keyboardA = Keyboard.isKeyDown(Keyboard.KEY_A);
		keyboardS = Keyboard.isKeyDown(Keyboard.KEY_S);
		keyboardD = Keyboard.isKeyDown(Keyboard.KEY_D);
		keyboardR = Keyboard.isKeyDown(Keyboard.KEY_R);
		keyboardE = Keyboard.isKeyDown(Keyboard.KEY_E);
		keyboardSHIFT = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
		keyboardCTRL = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
		keyboardSPACE = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
		keyboardZ = Keyboard.isKeyDown(Keyboard.KEY_Z);
		keyboardESC = Keyboard.isKeyDown(Keyboard.KEY_ESCAPE);
		keyboardRETURN = Keyboard.isKeyDown(Keyboard.KEY_RETURN);
		keyboardDELETE = Keyboard.isKeyDown(Keyboard.KEY_DELETE);
	}

	public static void mouseShoot() {

	}

	public static void mouseProcessor() {

		if (mouseRightButton) {
			System.out.println(mouseXPos + " " + mouseYPos);
			/*
			 * pydouble theory texture x / 2 * texture x / 2 * 2 square root
			 * if(quadX >= (400 - above) || quadX <= (400 + above) || quadY >=
			 * (300 - above) || quadY <= (300 + above)) {
			 */
			pydouble = Math.sqrt((Graphics.woodDamage[tempWood.woodDamage]
					.getImageWidth() / 2)
					* (Graphics.woodDamage[tempWood.woodDamage]
							.getImageHeight() / 2));
			// Math.sqr(a) + Math.sqr(b) = Math.sqr(c); //Pythagorean's Theorem
			py = (int) (Math.round(pydouble));
			/*
			 * if (!(Main.quadX <= (400 - py) || Main.quadX >= (400 + py) ||
			 * Main.quadY <= (300 - py) || Main.quadY >= (300 + py))) {
			 * System.out.println("hit");
			 * 
			 * points += 100; }
			 */
			if (!((Main.quadX) <= (400 - py) || (Main.quadX) >= (400 + py)
					|| (Main.quadY) <= (300 - py) || (Main.quadY) >= (300 + py))) {
				System.out.println("hit");
				if (tempWood.woodDamage < 9) {
					try {
						tempWood.woodDamage += 1;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					tempWood.woodDamage = 9;
				}
				// points += 100;
			}
		}

		if (mouseLeftButton) {
			if (mouseXPos >= 160 && mouseXPos <= 638 && mouseYPos >= 82
					&& mouseYPos <= 124 && Graphics.openMENU) {
				// options
			}
			if (mouseXPos >= 160 && mouseXPos <= 638 && mouseYPos >= 158
					&& mouseYPos <= 199 && Graphics.openMENU) {
				// about
			}
			if (mouseXPos >= 160 && mouseXPos <= 638 && mouseYPos >= 235
					&& mouseYPos <= 277 && Graphics.openMENU) {
				Save.SAVE(EntityPlayer.X, EntityPlayer.Y);
			}
			if (mouseXPos >= 160 && mouseXPos <= 638 && mouseYPos >= 506
					&& mouseYPos <= 548 && Graphics.openMENU) {
				Graphics.openMENU = false;
				Mouse.setGrabbed(true);
			}
			if (mouseXPos >= 160 && mouseXPos <= 638 && mouseYPos >= 311
					&& mouseYPos <= 354 && Graphics.openMENU) {
				Display.destroy();
			}
		}

	}

}
