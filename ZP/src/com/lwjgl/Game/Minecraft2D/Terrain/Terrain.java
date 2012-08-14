package com.lwjgl.Game.Minecraft2D.Terrain;

public enum Terrain {

	STONE("stone"), AIR("air"), DIRT("dirt");

	public final String fileLOC;

	Terrain(String fileLOC) {
		this.fileLOC = fileLOC;
	}

}
