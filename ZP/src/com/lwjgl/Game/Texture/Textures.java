package com.lwjgl.Game.Texture;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {

	public static Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(
					new File("res/textures/" + key + ".png")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Texture must have even dimensions AND when you load the texture do this: Texture yourTexture = Textures.loadTexture(name of texture without file extension)");
		return null;
	}

	public static void drawTexture(Texture tex, int x, int y, int width,
			int height, int rotation) {
		glColor4f(1f, 1f, 1f, 1f);
		tex.bind();
		glPushMatrix();

		glTranslatef(400, 300, 0);
		glRotatef(rotation, 0f, 0f, 1f);
		glTranslatef(-400, -300, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i(x - width, y - height);
		glTexCoord2f(0, 1);
		glVertex2i(x + width, y - height);
		glTexCoord2f(1, 1);
		glVertex2i(x + width, y + height);
		glTexCoord2f(1, 0);
		glVertex2i(x - width, y + height);
		glEnd();

		glPopMatrix();
	}

}
