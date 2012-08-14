package com.lwjgl.Game.Minecraft2D.Terrain;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Mouse;

public class Selection {
	private float x, y;
	private float size;
	private Terrain selection;
	private TerrainSet temp_selection;

	public Selection(float x, float y, float size, Terrain selection) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.selection = selection;
		this.temp_selection = new TerrainSet(selection, -1, -1);
	}

	public boolean isMouseHover() {
		int mouse_x = Mouse.getX();
		int mouse_y = 480 - Mouse.getY() - 1;
		return mouse_x >= x && mouse_y >= y && mouse_x <= x + size
				&& mouse_y <= y + size;
	}

	public void draw() {
		glLoadIdentity();
		temp_selection.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(size, 0);
		glTexCoord2f(1, 1);
		glVertex2f(size, size);
		glTexCoord2f(0, 1);
		glVertex2f(0, size);
		glEnd();
		glLoadIdentity();
		glEnd();
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

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public Terrain getSelection() {
		return selection;
	}

	public void setSelection(Terrain selection) {
		this.selection = selection;
	}
}
