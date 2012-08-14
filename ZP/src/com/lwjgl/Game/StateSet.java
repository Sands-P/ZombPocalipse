package com.lwjgl.Game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

import com.lwjgl.Game.State;
import com.lwjgl.Game.Texture.Textures;

public class StateSet {
	private State state = State.START;
	private Texture texture = null;
	private float x;
	private float y;

	public StateSet(State state, float x, float y) {
		this.state = state;
		this.x = x;
		this.y = y;
		this.texture = Textures.loadTexture(state.fileLOC);
	}

	public void bind() {
		texture.bind();
	}

	public void draw() {
		texture.bind();
		glLoadIdentity();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(state.StateSize, 0);
		glTexCoord2f(1, 1);
		glVertex2f(state.StateSize, state.StateSize);
		glTexCoord2f(0, 1);
		glVertex2f(0, state.StateSize);
		glEnd();
		glLoadIdentity();
	}

	public State getType() {
		return state;
	}

	public void setType(State state) {
		this.state = state;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
