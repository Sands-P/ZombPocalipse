package com.lwjgl.Game.Minecraft2D.Terrain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class TerrainGrid {
	private TerrainSet[][] blocks = new TerrainSet[World.BLOCKS_WIDTH][World.BLOCKS_HEIGHT];

	public TerrainGrid(File loadFile) {
	}

	public TerrainGrid() {
		for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
			for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
				blocks[x][y] = new TerrainSet(Terrain.AIR,
						x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
			}
		}
	}

	public void load(File loadFile) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(loadFile);
			Element root = document.getRootElement();
			for (Object block : root.getChildren()) {
				Element e = (Element) block;
				int x = Integer.parseInt(e.getAttributeValue("x"));
				int y = Integer.parseInt(e.getAttributeValue("y"));
				blocks[x][y] = new TerrainSet(Terrain.valueOf(e
						.getAttributeValue("type")), x * World.BLOCK_SIZE, y
						* World.BLOCK_SIZE);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void save(File saveFile) {
		Document document = new Document();
		Element root = new Element("blocks");
		document.setRootElement(root);
		for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
			for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
				Element block = new Element("block");
				block.setAttribute("x", String.valueOf((int) (blocks[x][y]
						.getX() / World.BLOCK_SIZE)));
				block.setAttribute("y", String.valueOf((int) (blocks[x][y]
						.getY() / World.BLOCK_SIZE)));
				block.setAttribute("type",
						String.valueOf(blocks[x][y].getType()));
				root.addContent(block);
			}
		}
		XMLOutputter output = new XMLOutputter();
		try {
			output.output(document, new FileOutputStream(saveFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setAt(int x, int y, Terrain b) {
		blocks[x][y] = new TerrainSet(b, x * World.BLOCK_SIZE, y
				* World.BLOCK_SIZE);
	}

	public TerrainSet getAt(int x, int y) {
		return blocks[x][y];
	}

	public void draw() {
		for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
			for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
				blocks[x][y].draw();
			}
		}
	}

	public void clear() {
		for (int x = 0; x < World.BLOCKS_WIDTH - 1; x++) {
			for (int y = 0; y < World.BLOCKS_HEIGHT - 1; y++) {
				blocks[x][y] = new TerrainSet(Terrain.AIR,
						x * World.BLOCK_SIZE, y * World.BLOCK_SIZE);
			}
		}
	}
}
