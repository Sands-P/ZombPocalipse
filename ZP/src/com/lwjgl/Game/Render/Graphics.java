package com.lwjgl.Game.Render;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.lwjgl.Game.Main;
import com.lwjgl.Game.Time;
import com.lwjgl.Game.Stats.Lives;
import com.lwjgl.Game.Stats.tempWood;
import com.lwjgl.Game.Texture.Textures;

public class Graphics {

	public static Texture texLives[] = new Texture[11];
	public static String texLivesLoc[] = new String[11];
	public static Texture woodDamage[] = new Texture[10];
	public static int woodTakenDamage;
	public static Texture bulletHole;
	public static Texture cross;
	public static Texture texEscMenu;
	public static boolean openMENU = false;

	public static void initTexture() {
		try {

			Main.pistol = Textures.loadTexture("pistol");
			cross = Textures.loadTexture("cursor");
			texEscMenu = Textures.loadTexture("escMenu");
			GraphicsStates.stateMENU = Textures.loadTexture("escMenu");
			bulletHole = Textures.loadTexture("bulletHole");

			for (int i = 0; i < 11; i++) {
				if (i < 10) {
					texLivesLoc[i] = "lives_0" + i;
				}
				if (i == 10) {
					texLivesLoc[i] = "lives_" + i;
				}
			}
			for (int i = 0; i < 11; i++) {
				texLives[i] = Textures.loadTexture(texLivesLoc[i]);
			}

			for (int i = 0; i < 10; i++) {
				try {
					woodDamage[i] = Textures.loadTexture("wood_" + i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

		}
	}

	public static void Render() {
		System.out.println(Time.getDelta());
		glClear(GL11.GL_COLOR_BUFFER_BIT);
		// R,G,B,A
		// GL11.glColor4f(0.070f,0.097f,0.207f, 0.0f);
		glColor3f(1f, 1f, 1f);
		woodDamage[tempWood.woodDamage].bind();
		// draw quad
		glPushMatrix();
		glTranslatef(Main.quadX, Main.quadY, 0);
		glRotatef(Main.rotation, 0f, 0f, 1f);
		glTranslatef(-Main.quadX, -Main.quadY, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i((int) Main.quadX - 50 + Main.z, (int) Main.quadY - 50
				+ Main.z);
		glTexCoord2f(0, 1);
		glVertex2i((int) Main.quadX + 50 - Main.z, (int) Main.quadY - 50
				+ Main.z);
		glTexCoord2f(1, 1);
		glVertex2i((int) Main.quadX + 50 - Main.z, (int) Main.quadY + 50
				- Main.z);
		glTexCoord2f(1, 0);
		glVertex2i((int) Main.quadX - 50 + Main.z, (int) Main.quadY + 50
				- Main.z);

		glEnd();

		glPopMatrix();

		glColor4f(1f, 1f, 1f, 1f);
		Main.pistol.bind();
		int pistolX = 650;
		int pistolY = 650;
		int pistolAdditive = 275;
		glPushMatrix();

		glTranslatef(400, 300, 0);
		glRotatef(-90f, 0f, 0f, 1f);
		glTranslatef(-400, -300, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i(pistolX - pistolAdditive, pistolY - pistolAdditive);
		glTexCoord2f(0, 1);
		glVertex2i(pistolX + pistolAdditive, pistolY - pistolAdditive);
		glTexCoord2f(1, 1);
		glVertex2i(pistolX + pistolAdditive, pistolY + pistolAdditive);
		glTexCoord2f(1, 0);
		glVertex2i(pistolX - pistolAdditive, pistolY + pistolAdditive);
		glEnd();

		/*
		 * glBegin(GL_QUADS); GL11.glTexCoord2f(0, 0); GL11.glVertex2f(0, 0);
		 * GL11.glTexCoord2f(0, pistol.getHeight()); GL11.glVertex2f(0, 600);
		 * GL11.glTexCoord2f(pistol.getWidth(), pistol.getHeight());
		 * GL11.glVertex2f(800,600); GL11.glTexCoord2f(pistol.getWidth(), 0);
		 * GL11.glVertex2f(800,0); glEnd();
		 */

		glPopMatrix();

		glColor4f(1f, 1f, 1f, 1f);
		texLives[Lives.LIVES].bind();
		int livesX = 650;// x = y
		int livesY = 75;// y = x
		int livesAdditiveX = 30;
		int livesAdditiveY = 150;
		glPushMatrix();

		glTranslatef(400, 300, 0);
		glRotatef(-90f, 0f, 0f, 1f);
		glTranslatef(-400, -300, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i(livesX - livesAdditiveX, livesY - livesAdditiveY);
		glTexCoord2f(0, 1);
		glVertex2i(livesX + livesAdditiveX, livesY - livesAdditiveY);
		glTexCoord2f(1, 1);
		glVertex2i(livesX + livesAdditiveX, livesY + livesAdditiveY);
		glTexCoord2f(1, 0);
		glVertex2i(livesX - livesAdditiveX, livesY + livesAdditiveY);
		glEnd();

		/*
		 * glBegin(GL_QUADS); GL11.glTexCoord2f(0, 0); GL11.glVertex2f(0, 0);
		 * GL11.glTexCoord2f(0, pistol.getHeight()); GL11.glVertex2f(0, 600);
		 * GL11.glTexCoord2f(pistol.getWidth(), pistol.getHeight());
		 * GL11.glVertex2f(800,600); GL11.glTexCoord2f(pistol.getWidth(), 0);
		 * GL11.glVertex2f(800,0); glEnd();
		 */

		glPopMatrix();

		glColor4f(1f, 1f, 1f, 1f);
		cross.bind();
		glPushMatrix();

		int crossX = 400;
		int crossY = 300;
		int crossAdditive = 15;

		glTranslatef(400, 300, 0);
		glRotatef(-90f, 0f, 0f, 1f);
		glTranslatef(-400, -300, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2i(crossX - crossAdditive, crossY - crossAdditive);
		glTexCoord2f(0, 1);
		glVertex2i(crossX + crossAdditive, crossY - crossAdditive);
		glTexCoord2f(1, 1);
		glVertex2i(crossX + crossAdditive, crossY + crossAdditive);
		glTexCoord2f(1, 0);
		glVertex2i(crossX - crossAdditive, crossY + crossAdditive);
		glEnd();

		/*
		 * glBegin(GL_QUADS); GL11.glTexCoord2f(0, 0); GL11.glVertex2f(0, 0);
		 * GL11.glTexCoord2f(0, pistol.getHeight()); GL11.glVertex2f(0, 600);
		 * GL11.glTexCoord2f(pistol.getWidth(), pistol.getHeight());
		 * GL11.glVertex2f(800,600); GL11.glTexCoord2f(pistol.getWidth(), 0);
		 * GL11.glVertex2f(800,0); glEnd();
		 */

		glPopMatrix();

		if (openMENU) {
			try {
				glColor4f(1f, 1f, 1f, 1f);
				GraphicsStates.stateMENU.bind();
				glPushMatrix();

				// int menuY = 0;
				// int menuX = 0;
				// int menuYA = 600;
				// int menuXA = 800;

				glTranslatef(400, 300, 0);
				glRotatef(-90f, 0f, 0f, 1f);
				glTranslatef(-400, -300, 0);

				glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2i(100, 0);
				glTexCoord2f(0, 1);
				glVertex2i(1125, 0);
				glTexCoord2f(1, 1);
				glVertex2i(1125, 765);
				glTexCoord2f(1, 0);
				glVertex2i(100, 765);
				glEnd();

				glPopMatrix();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
