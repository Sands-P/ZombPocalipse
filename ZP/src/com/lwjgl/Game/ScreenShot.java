package com.lwjgl.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class ScreenShot {
	public static BufferedImage image;

	public static void takeScreen(File file, String format) {
		// File file = ...; // The file to save to.
		// String format = ...; // Example: "PNG" or "JPG"
		try {
			GL11.glReadBuffer(GL11.GL_FRONT);
			int width = Display.getDisplayMode().getWidth();
			int height = Display.getDisplayMode().getHeight();
			int bpp = 4; // Assuming a 32-bit display with a byte each for red,
							// green, blue, and alpha.
			ByteBuffer buffer = BufferUtils.createByteBuffer(width * height
					* bpp);
			GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA,
					GL11.GL_UNSIGNED_BYTE, buffer);
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					int i = (x + (width * y)) * bpp;
					int r = buffer.get(i) & 0xFF;
					int g = buffer.get(i + 1) & 0xFF;
					int b = buffer.get(i + 2) & 0xFF;
					image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16)
							| (g << 8) | b);
				}

			ImageIO.write(image, format, file);
		} catch (IOException ioe) {

		}
	}

	public static void takeScreenShot(File file, String format) {
		GL11.glReadBuffer(GL11.GL_FRONT);
		int width = Display.getDisplayMode().getWidth();
		int height = Display.getDisplayMode().getHeight();
		ByteBuffer screenBuffer = BufferUtils.createByteBuffer(width * height
				* 4);
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_BYTE,
				screenBuffer);

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int bufferPlace = (i + (width * j)) * 4;
				byte red = screenBuffer.get(bufferPlace);
				byte green = screenBuffer.get(bufferPlace + 1);
				byte blue = screenBuffer.get(bufferPlace + 2);
				int color = (0xFF << 24) | // For a completely opaque image.
						(red << 16) | (green << 8) | (blue);
				image.setRGB(i, height - (j + 1), color);
			}
		try {
			ImageIO.write(image, format, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
