package com.lwjgl.Game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;

import java.io.File;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.lwjgl.Game.Entity.EntityPlayer;
import com.lwjgl.Game.Render.Graphics;
import com.lwjgl.Game.input.InputHandler;

public class Main {
	public static float quadX = 400, quadY = 300, rotation = 0;

	// Textures variables
	private static int cNum = 1;
	public static int x;
	public static int y;
	public static int z;
	public static int firstQuadY = (int) quadY;
	public static Texture pistol;

	// public void start() {
	public Main() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			Mouse.create();
			Keyboard.create();
			System.out.println("Initialized");
			Display.setTitle("ZombPocalipse LWJGL EDITION Pre-Alpha 0.02");
			Time.lastFPS = Time.getTime();
			Mouse.setGrabbed(true);

			// Display.sync(60); // cap fps to 60fps
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// init OpenGL here
		initGL();

		while (!Display.isCloseRequested()) {

			// render OpenGL here
			// Clear the screen and depth buffer
			glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			// set the color of the quad (R,G,B,A)
			// GL11.glColor4f(0.070f,0.097f,0.207f, 0.0f);

			Time.getDelta();

			/** RENDER **/
			renderGL();

			/*** REFRESH INPUT ***/
			InputHandler.mouseRefresh();
			InputHandler.keyboardRefresh();

			/*** PROCESS INPUT ***/
			// inputProcess();
			processInput();
			InputHandler.mouseProcessor();
			InputHandler.mouseShoot();

			/*** SETUP TIME ***/
			Time.updateFPS();
			// MoveableEntity box = new Gun(100, 100, 50, 50);
			// box.draw();
			// box.update(Time.delta);

			/*
			 * VERSION|FPS -------|--- PA-0.15|716-3336
			 */
			Display.update();

		}

		Mouse.destroy();
		Keyboard.destroy();
		AL.destroy();
		Display.destroy();
	}

	public void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		Graphics.initTexture();

	}

	public void renderGL() {
		// Clear The Screen And The Depth Buffer

		Graphics.Render();

	}

	public void processInput() {
		if (!Graphics.openMENU) {
			if (InputHandler.mouseTurnLeft) {
				rotation += 3;
			}
			if (InputHandler.mouseTurnRight) {
				rotation -= 3;
			}
			if (InputHandler.keyboardS) {
				z++;
				quadY += 1;
				if (z > 50) {
					z = 50;
					quadY = firstQuadY + 50;
				}
				EntityPlayer.X--;
			}

			if (InputHandler.keyboardD) {
				quadX--;
				EntityPlayer.Y++;
			}

			if (InputHandler.keyboardW) {
				z--;
				quadY -= 1;
				EntityPlayer.X++;
			}

			if (InputHandler.keyboardA) {
				quadX++;
				EntityPlayer.Y--;
			}

			if (InputHandler.keyboardRETURN) {
				String currentScreen = "ScreenShot" + cNum + ".png";
				File screen = new File(currentScreen);
				// ScreenShot.takeScreen(screen, "PNG");
				ScreenShot.takeScreen(screen, "PNG");
				cNum++;
			}

			if (InputHandler.keyboardESC) {
				/*
				 * Mouse.destroy(); Keyboard.destroy(); AL.destroy();
				 * Display.destroy();
				 */
				System.out.println("test");
				Graphics.openMENU = true;
				Mouse.setGrabbed(false);
			}
		}
		if (InputHandler.keyboardDELETE) {
			Display.destroy();
		}

	}

	public static void main(String[] argv) {
		try {
			new Main();
		} catch (Exception e) {

		}
	}
}
