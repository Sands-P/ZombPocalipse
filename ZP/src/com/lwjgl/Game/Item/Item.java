package com.lwjgl.Game.Item;

public class Item {

	static int damageAbsorption;
	static int damageTransfer;
	static int damageTaken;
	static boolean broken;

	static boolean brokenStatus() {
		if ((damageAbsorption - damageTaken) <= 0) {
			broken = true;

		}
		if ((damageAbsorption - damageTaken) > 0) {
			broken = false;

		}
		return broken;

	}

}
