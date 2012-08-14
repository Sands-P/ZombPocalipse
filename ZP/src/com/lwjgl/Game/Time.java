package com.lwjgl.Game;

import org.lwjgl.opengl.Display;

import com.lwjgl.Game.input.InputHandler;

public class Time {

	public static long time;
	public static long lastFrame;
	public static long lastFPS;
	public static int fps;
	public static int delta;
	public static int maxFPS = 0;

	public static long getTime() {
		time = System.nanoTime() / 1000000;// milliseconds
		return time;
	}

	public static int getDelta() {
		time = getTime();
		delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public static long updateFPS() {
		if (getTime() - lastFPS > 1000) {
			if (fps > maxFPS) {
				maxFPS = fps;
			}

			Display.setTitle("Minefront LWJGL EDITION Pre-Alpha 0.01: FPS: "
					+ fps + " Max fps reached: " + maxFPS + " Points: "
					+ InputHandler.points);
			fps = 0; // reset the FPS counter
			lastFPS += 1000; // add one second
		}
		fps++;
		/*
		 * if(!((getTime() - lastFPS) > 1000)) { return fps; }
		 */
		return fps;

	}

}
