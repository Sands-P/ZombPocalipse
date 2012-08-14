package com.lwjgl.Game.Minecraft2D.Terrain;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

import com.lwjgl.Game.Texture.Textures;

public class TerrainSet {

	private Terrain type = Terrain.AIR;
	private Texture texture = null;
	private float x;
	private float y;

	public TerrainSet(Terrain type, float x, float y) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.texture = Textures.loadTexture(type.fileLOC);
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
		glVertex2f(World.BLOCK_SIZE, 0);
		glTexCoord2f(1, 1);
		glVertex2f(World.BLOCK_SIZE, World.BLOCK_SIZE);
		glTexCoord2f(0, 1);
		glVertex2f(0, World.BLOCK_SIZE);
		glEnd();
		glLoadIdentity();
	}

	public Terrain getType() {
		return type;
	}

	public void setType(Terrain type) {
		this.type = type;
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