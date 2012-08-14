package com.lwjgl.Game.output;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;

import net.java.games.*;
import net.java.games.input.Event;

import org.lwjgl.input.*;

public class joystick { // allow control for joystick
	public static Controller gamepad;
	public static Controllers pad;
	public static int controllerAmount;
	public static boolean compatibleGamepad = false;
	public static int controllerNumber;
	public static int joystickYAXIS;// left analog negative = forward, positive
									// = backward
	public static int joystickXAXIS;// left analog negative = left, positive =
									// right
	public static int joystickBTN0;// A
	public static int joystickBTN1;// B
	public static int joystickBTN2;// X
	public static int joystickBTN3;// Y
	public static int joystickBTN4;// left trigger, aim
	public static int joystickBTN5;// right trigger, shoot
	public static int joystickBTN6;// "BACK"
	public static int joystickBTN7;// "START"
	public static int joystickBTN8;// left analog click
	public static int joystickBTN9;// right analog click
	public static int joystickYROTATION;// right analog negative = up, positive
										// = down
	public static int joystickXROTATION;// right analog negative = left,
										// positive = right
	public static float jxr1;
	public static float jxr2;
	public static float jax1;
	public static float jax2;
	public static float jay1;
	public static float jay2;
	public static int joystickZAXIS;// negative = throw grenade 1, positive =
									// throw grenade 2
	public static int joystickPOVX;// d-pad negative = left, positive = right
	public static int joystickPOVY;// d-pad = negative = forward, positive =
									// backward
	public static boolean fullRotate;
	public static boolean fullRotate2;
	public static Controllers controllers;
	public static boolean prone;

	@SuppressWarnings("static-access")
	public static void getJoystick() {
		pad.poll();
		controllerAmount = pad.getControllerCount();

		System.out.println(Controllers.getControllerCount());

		if (controllerAmount == 0) {
			try {
				Controllers.create();
				controllerAmount = Controllers.getControllerCount();
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}// System.load();
		if (controllerAmount > 0) {
			try {

				controllerAmount = Controllers.getControllerCount();
				System.out.println(controllerAmount);
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		for (int i = 0; i < controllerAmount; i++) {
			gamepad = pad.getController(i);
			if (gamepad.getName().equals("Controller (Gamepad F310)")) {
				System.out.println("Compatible controller found");
				JFrame frame = new JFrame();
				int n = JOptionPane.showConfirmDialog(frame,
						"A compatible gamepad was found: " + gamepad.getName()
								+ " would you like to use it?",
						"GAMEPAD SETUP", JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					compatibleGamepad = false;

				}
				if (n == 0) {
					compatibleGamepad = true;

				}

				System.out.println("index: " + gamepad.getIndex() + "|i: " + i);
				// JOptionPane.showMessageDialog(frame, "" +
				// gamepad.getIndex());

				controllerNumber = i;

			} else {
				System.out.println("no compatible controller found");
				/*
				 * JFrame frame = new JFrame();
				 * JOptionPane.showMessageDialog(frame,
				 * "No compatible controller found");
				 */
			}
		}
	}

	@SuppressWarnings("static-access")
	public static void refreshJoystick() {

		if (compatibleGamepad) {
			try {
				// index = controllerAmount;
				gamepad = pad.getController(controllerNumber);
				gamepad.poll();
				// System.out.println("Event Fired: ");
				/*
				 * System.out.println("\t"+Controllers.getEventNanoseconds());
				 * System
				 * .out.println("\t"+Controllers.getEventSource()+":"+Controllers
				 * .getEventControlIndex()+":"+Controllers.isEventButton());
				 * System
				 * .out.println("\t"+Controllers.isEventXAxis()+":"+Controllers
				 * .isEventYAxis());
				 */
				// System.out.println(gamepad.getAxisCount());
				if (gamepad.getAxisCount() >= 1) {
					for (int i = 0; i < gamepad.getAxisCount(); i++) {
						// System.out.println(i + " : " +
						// gamepad.getAxisName(i));
					}
				} else {
					// System.out.println("No axis");
				}
				if (gamepad.getButtonCount() >= 1) {
					for (int i = 0; i < gamepad.getButtonCount(); i++) {
						// /System.out.println(i + " : " +
						// gamepad.getButtonName(i));
					}
				} else {
					// System.out.println("no buttons");
				}

				jay1 = gamepad.getYAxisValue();

				if (jay1 >= 0.5) {
					// Game.forward = false;
					// Game.back = true;
				}
				if (jay1 <= -0.5) {
					// Game.back = false;
					// Game.forward = true;
				}
				if (jay1 < 0.5 && jay1 > -0.5) {
					// Game.back = false;
					// Game.forward = false;
				}

				jax1 = gamepad.getXAxisValue();

				if (jax1 >= 0.5) {
					// Game.right = true;
					// Game.left = false;
				}
				if (jax1 <= -0.5) {
					// Game.right = false;
					// Game.left = true;
				}
				if (jax1 < 0.5 && jax1 > -0.5) {
					// Game.left = false;
					// Game.right = false;
				}
				if (gamepad.getPovX() == -0.1) {

				}
				if (gamepad.getPovX() == 0.1) {

				}
				if (gamepad.getPovY() == -0.1) {

				}
				if (gamepad.getPovY() == 0.1) {

				}

				jxr1 = gamepad.getRXAxisValue();

				if (jxr1 >= 0.5) {
					// Controlls.turnLeft = false;
					// Controlls.turnRight = true;
				}
				if (jxr1 <= -0.5) {
					// Controlls.turnLeft = true;
					// Controlls.turnRight = false;
				}
				if (jxr1 < 0.5 && jxr1 > -0.5) {
					// Controlls.turnLeft = false;
					// Controlls.turnRight = false;
				}
				// Display.mouseSpeed = 25;

				if (gamepad.isButtonPressed(5)) {
					// InputHandler.attack = 3;
				}

				if (gamepad.isButtonPressed(4)) {
					// Game.aim = true;
				}
				if (gamepad.isButtonPressed(1)) {
					/*
					 * if(Game.prone) { //Game.prone = false;
					 * 
					 * Game.prone = false; } if(!Game.prone) { //Game.prone =
					 * true;
					 * 
					 * Game.prone = true; }
					 */
				}

				if (gamepad.isButtonPressed(3)) {
					/*
					 * fullRotate = false; if(Display.selected[0] &&
					 * !fullRotate) { Game.chosenItem = 2; Display.selected[0] =
					 * false; Display.selected[1] = true; fullRotate = true;
					 * //System.out.println("2" + Display.selected[1]); }
					 * if(Display.selected[1] && !fullRotate) { Game.chosenItem
					 * = 3; Display.selected[1] = false; Display.selected[2] =
					 * true; fullRotate = true; System.out.println("3" +
					 * Display.selected[2]); } if(Display.selected[2] &&
					 * !fullRotate) { Game.chosenItem = 4; Display.selected[2] =
					 * false; Display.selected[3] = true; fullRotate = true;
					 * //System.out.println("4" + Display.selected[3]); }
					 * if(Display.selected[3] && !fullRotate) { Game.chosenItem
					 * = 5; Display.selected[3] = false; Display.selected[4] =
					 * true; fullRotate = true; //System.out.println("5" +
					 * Display.selected[4]); } if(Display.selected[4] &&
					 * !fullRotate) { Game.chosenItem = 1; Display.selected[4] =
					 * false; Display.selected[0] = true; fullRotate = true;
					 * //System.out.println("1" + Display.selected[0]); }
					 */
				}
			} catch (Exception e) {
				e.printStackTrace();
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, e.getMessage());
			}
		} else {

		}
	}

	public static void joystickGet(Event event) {
		if (compatibleGamepad) {
			try {
				gamepad = Controllers.getController(controllerNumber);
				gamepad.poll();
				System.out.println(gamepad.getAxisCount());
				if (gamepad.getAxisCount() >= 1) {
					for (int i = 0; i < gamepad.getAxisCount(); i++) {
						System.out.println(i + " : " + gamepad.getAxisName(i));
					}
				} else {
					System.out.println("No axis");
				}
				if (gamepad.getButtonCount() >= 1) {
					for (int i = 0; i < gamepad.getButtonCount(); i++) {
						System.out
								.println(i + " : " + gamepad.getButtonName(i));
					}
				} else {
					System.out.println("no buttons");
				}
				/*
				 * System.out.println(gamepad.getXAxisValue());
				 * System.out.println(gamepad.getYAxisValue());
				 * System.out.println(gamepad.getPovY());
				 * System.out.println(gamepad.getPovX());
				 * System.out.println(gamepad.getName());
				 * System.out.println(Controllers.isCreated());
				 */
				/*
				 * if(gamepad.getYAxisValue() > -0.1 && gamepad.getXAxisValue()
				 * < 0.1) { Game.forward = false; Game.back = false; }
				 * if(gamepad.getXAxisValue() > -0.1 && gamepad.getXAxisValue()
				 * < 0.1) { Game.left = false; Game.right = false; }
				 * if(gamepad.getYAxisValue() <= -0.1) {
				 * System.out.println(gamepad.getYAxisValue()); Game.forward =
				 * true; Game.back = false; } if(gamepad.getYAxisValue() >= 0.1)
				 * { System.out.println(gamepad.getYAxisValue()); Game.back =
				 * true; Game.forward = false; } if(gamepad.getXAxisValue() <=
				 * -0.1) { System.out.println(gamepad.getXAxisValue());
				 * Game.left = true; Game.right = false; }
				 * if(gamepad.getXAxisValue() >= 0.1) {
				 * System.out.println(gamepad.getXAxisValue()); Game.left =
				 * false; Game.right = true; }
				 */
				jay1 = gamepad.getYAxisValue();
				/*
				 * if(jay1 > jay2 && jay1 != 0.0) { Game.back = true; } if(jay1
				 * < jay2 && jay1 != 0.0) { Game.forward = true; } if(jay1 ==
				 * jay2) { if(jay1 == 0.0) { Game.back = false; Game.forward =
				 * false; } if(jay1 != 0.0) {
				 * 
				 * } }
				 */
				if (jay1 >= 0.5) {
					// Game.forward = false;
					// Game.back = true;
				}
				if (jay1 <= -0.5) {
					// Game.back = false;
					// Game.forward = true;
				}
				if (jay1 < 0.5 && jay1 > -0.5) {
					// Game.back = false;
					// Game.forward = false;
				}
				// jay2 = jay1;
				jax1 = gamepad.getXAxisValue();
				/*
				 * if(jax1 > jax2 && jax1 != 0.0) { Game.right = true; } if(jax1
				 * < jax2 && jax1 != 0.0) { Game.left = true; } if(jax1 == jax2)
				 * { if(jax1 == 0.0) { Game.right = false; Game.left = false; }
				 * if(jax1 != 0.0) {
				 * 
				 * } } jax2 = jax1;
				 */
				if (jax1 >= 0.5) {
					// Game.right = true;
					// Game.left = false;
				}
				if (jax1 <= -0.5) {
					// Game.right = false;
					// Game.left = true;
				}
				if (jax1 < 0.5 && jax1 > -0.5) {
					// Game.left = false;
					// Game.right = false;
				}
				if (gamepad.getPovX() == -0.1) {

				}
				if (gamepad.getPovX() == 0.1) {

				}
				if (gamepad.getPovY() == -0.1) {

				}
				if (gamepad.getPovY() == 0.1) {

				}
				/*
				 * if(gamepad.getRXAxisValue() > -0.1 &&
				 * gamepad.getRXAxisValue() < 0.1) { Controlls.turnLeft = false;
				 * Controlls.turnRight = false; } if(gamepad.getRXAxisValue() <=
				 * -0.1) { Controlls.turnLeft = true; Controlls.turnRight =
				 * false; } if(gamepad.getRXAxisValue() >= 0.1) {
				 * Controlls.turnLeft = false; Controlls.turnRight = true; }
				 */
				jxr1 = gamepad.getRXAxisValue();
				/*
				 * if(jxr1 > jxr2) { Controlls.turnRight = true; } if(jxr1 <
				 * jxr2) { Controlls.turnLeft = true; } if(jxr1 == jxr2) {
				 * Controlls.turnLeft = false; Controlls.turnRight = false; }
				 * Display.mouseSpeed = 100; jxr2 = jxr1;
				 */
				if (jxr1 >= 0.5) {
					// Controlls.turnLeft = false;
					// Controlls.turnRight = true;
				}
				if (jxr1 <= -0.5) {
					// Controlls.turnLeft = true;
					// Controlls.turnRight = false;
				}
				if (jxr1 < 0.5 && jxr1 > -0.5) {
					// Controlls.turnLeft = false;
					// Controlls.turnRight = false;
				}
				// Display.mouseSpeed = 25;
				/*
				 * if(gamepad.getRXAxisValue() > -0.1 &&
				 * gamepad.getRXAxisValue() < 0.1) { Controlls.turnLeft = false;
				 * Controlls.turnRight = false; } if(gamepad.getRXAxisValue() <=
				 * -0.1) { Controlls.turnLeft = true; Controlls.turnRight =
				 * false; } if(gamepad.getRXAxisValue() >= 0.1) {
				 * Controlls.turnLeft = false; Controlls.turnRight = true; }
				 */
				if (gamepad.isButtonPressed(5)) {
					// InputHandler.attack = 3;
				}

				if (gamepad.isButtonPressed(4)) {
					// Game.aim = true;
				}
				if (gamepad.isButtonPressed(3)) {
					/*
					 * fullRotate = false; if(Display.selected[0] &&
					 * !fullRotate) { Game.chosenItem = 2; Display.selected[0] =
					 * false; Display.selected[1] = true; fullRotate = true;
					 * System.out.println("2" + Display.selected[1]); }
					 * if(Display.selected[1] && !fullRotate) { Game.chosenItem
					 * = 3; Display.selected[1] = false; Display.selected[2] =
					 * true; fullRotate = true; System.out.println("3" +
					 * Display.selected[2]); } if(Display.selected[2] &&
					 * !fullRotate) { Game.chosenItem = 4; Display.selected[2] =
					 * false; Display.selected[3] = true; fullRotate = true;
					 * System.out.println("4" + Display.selected[3]); }
					 * if(Display.selected[3] && !fullRotate) { Game.chosenItem
					 * = 5; Display.selected[3] = false; Display.selected[4] =
					 * true; fullRotate = true; System.out.println("5" +
					 * Display.selected[4]); } if(Display.selected[4] &&
					 * !fullRotate) { Game.chosenItem = 1; Display.selected[4] =
					 * false; Display.selected[0] = true; fullRotate = true;
					 * System.out.println("1" + Display.selected[0]); }
					 */
				}
			} catch (Exception e) {
				e.printStackTrace();
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, e.getMessage());
			}
		} else {

		}
	}

	@SuppressWarnings("static-access")
	public static void mainJoy() {
		controllers = new Controllers();
		try {
			for (int i = 0; i < controllers.getControllerCount(); i++) {
				controllers.create();
				Controller joystick;
				if (controllers.getControllerCount() > 0) {
					joystick = controllers.getController(i);
					System.out.println("Joystick has "
							+ joystick.getButtonCount()
							+ " buttons. Its name is " + joystick.getName());
					if (joystick.getName().equals("Controller (Gamepad F310)")) {
						joystick = controllers.getController(i);
						gamepad = controllers.getController(i);
						System.out.println("good controller");
						controllerNumber = i;
						return;
					} else {
						System.out
								.println("Joystick has "
										+ joystick.getButtonCount()
										+ " buttons. Its name is "
										+ joystick.getName());
					}
				} else
					joystick = null;
			}
		} catch (org.lwjgl.LWJGLException e) {
			System.err.println("Couldn't initialize Controllers: "
					+ e.getMessage());
		}
	}
}
