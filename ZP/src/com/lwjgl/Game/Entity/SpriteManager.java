package com.lwjgl.Game.Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpriteManager {

	public static ArrayList<BufferedImage> spritesImages = new ArrayList<BufferedImage>(
			10);
	public static ArrayList<Sprite> sprites = new ArrayList<Sprite>(10);

	public static void makeSprite_spritesImages(int index,
			BufferedImage spriteImage) {
		spritesImages.add(index, spriteImage);
	}

	public static void killSprite_spritesImages(int index) {
		spritesImages.remove(index);
	}

}
