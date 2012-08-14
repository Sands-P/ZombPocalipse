package com.lwjgl.Game;

public enum State {
	START("", 0, 0, 800, 600, 2), MENU("escMenu", 0, 0, 800, 600, 2), CREDITS(
			"", 0, 0, 800, 600, 2), DEATH("respawn", 0, 0, 800, 600, 2), GAME(
			null, 0, 0, 0, 0, 2);

	public final String fileLOC;
	public final int StateX;
	public final int StateY;
	public final int StateSize;
	public final int StateSizeNumberX;// Number across, 1 less than natural
	public final int StateSizeNumberY;

	State(String fileLoc, int x, int y, int sizex, int sizey, int size) {
		this.fileLOC = fileLoc;
		this.StateX = x;
		this.StateY = y;
		this.StateSizeNumberX = sizex;
		this.StateSizeNumberY = sizey;
		this.StateSize = size;
	}

}
/***
 * switch (state) { case START: glColor3f(1.0f, 0f, 0f); glRectf(0, 0, 640,
 * 480); break; case MENU: glColor3f(0f, 1.0f, 0f); glRectf(0, 0, 640, 480);
 * break; case CREDITS: glColor3f(0f, 0f, 1.0f); glRectf(0, 0, 640, 480); break;
 * case DEATH: glColor3d(0.5f, 0.5f, 0.5f); }
 * 
 * 
 * if (Keyboard.isKeyDown(Keyboard.KEY_S)) { state = State.MAIN_MENU; } if
 * (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) { Display.destroy();
 * System.exit(0); }
 * 
 * if (Keyboard.isKeyDown(Keyboard.KEY_BACK)) { state = State.MAIN_MENU; }
 * 
 * if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) { state = State.GAME; } if
 * (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) { state = State.INTRO; }
 ***/

