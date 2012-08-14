package com.lwjgl.Game.Font;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;

@SuppressWarnings("deprecation")
public class Font {

	public static UnicodeFont uFont;
	public static TrueTypeFont font;

	@SuppressWarnings("unchecked")
	public static void setupFont() {
		java.awt.Font awtFont = new java.awt.Font("Times New Roman",
				java.awt.Font.BOLD, 18);
		uFont = new UnicodeFont(awtFont);
		uFont.getEffects().add(java.awt.Color.YELLOW);

		java.awt.Font awtfont = new java.awt.Font("Times New Roman",
				java.awt.Font.BOLD, 24);
		font = new TrueTypeFont(awtfont, false);

	}

}
