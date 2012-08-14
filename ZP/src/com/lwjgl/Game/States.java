package com.lwjgl.Game;

public enum States {
	START(""), MENU(""), CREDITS(""), DEATH(""), ESCMENU("");
	public final String location;

	States(String location) {
		this.location = location;
	}

}
