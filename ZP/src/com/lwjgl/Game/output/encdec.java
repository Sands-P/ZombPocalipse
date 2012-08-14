package com.lwjgl.Game.output;

public class encdec {
	public static String encPass;
	public static String decPass;

	public static String decrypt(String str) {
		str = str.replaceAll("¶", "a");
		str = str.replaceAll("µ", "b");
		str = str.replaceAll("³", "c");
		str = str.replaceAll("²", "d");
		str = str.replaceAll("±", "e");
		str = str.replaceAll("°", "f");
		str = str.replaceAll("¯", "g");
		str = str.replaceAll("®", "h");
		str = str.replaceAll("¬", "i");
		str = str.replaceAll("«", "j");
		str = str.replaceAll("©", "k");
		str = str.replaceAll("¨", "l");
		str = str.replaceAll("§", "m");
		str = str.replaceAll("¦", "n");
		str = str.replaceAll("¥", "o");
		str = str.replaceAll("¤", "p");
		str = str.replaceAll("£", "q");
		str = str.replaceAll("¢", "r");
		str = str.replaceAll("¡", "s");
		str = str.replaceAll("Ÿ", "t");
		str = str.replaceAll("œ", "u");
		str = str.replaceAll("•", "v");
		str = str.replaceAll("—", "w");
		str = str.replaceAll("‰", "x");
		str = str.replaceAll("‡", "y");
		str = str.replaceAll("†", "z");
		str = str.replaceAll("ƒ", "1");
		str = str.replaceAll("€", "2");
		str = str.replaceAll("þ", "3");
		str = str.replaceAll("Þ", "4");
		str = str.replaceAll("Ð", "5");
		str = str.replaceAll("¿", "6");
		str = str.replaceAll("¾", "7");
		str = str.replaceAll("½", "8");
		str = str.replaceAll("¼", "9");
		str = str.replaceAll("¹", "0");
		str = str.replaceAll("º", "_");
		str = str.replaceAll("»", "-");
		str = str.replaceAll("¸", "=");
		str = str.replaceAll("™", "@");
		return str;

	}

	public static String encrypt(String str) {
		str = str.replaceAll("a", "¶");
		str = str.replaceAll("b", "µ");
		str = str.replaceAll("c", "³");
		str = str.replaceAll("d", "²");
		str = str.replaceAll("e", "±");
		str = str.replaceAll("f", "°");
		str = str.replaceAll("g", "¯");
		str = str.replaceAll("h", "®");
		str = str.replaceAll("i", "¬");
		str = str.replaceAll("j", "«");
		str = str.replaceAll("k", "©");
		str = str.replaceAll("l", "¨");
		str = str.replaceAll("m", "§");
		str = str.replaceAll("n", "¦");
		str = str.replaceAll("o", "¥");
		str = str.replaceAll("p", "¤");
		str = str.replaceAll("q", "£");
		str = str.replaceAll("r", "¢");
		str = str.replaceAll("s", "¡");
		str = str.replaceAll("t", "Ÿ");
		str = str.replaceAll("u", "œ");
		str = str.replaceAll("v", "•");
		str = str.replaceAll("w", "—");
		str = str.replaceAll("x", "‰");
		str = str.replaceAll("y", "‡");
		str = str.replaceAll("z", "†");
		str = str.replaceAll("1", "ƒ");
		str = str.replaceAll("2", "€");
		str = str.replaceAll("3", "þ");
		str = str.replaceAll("4", "Þ");
		str = str.replaceAll("5", "Ð");
		str = str.replaceAll("6", "¿");
		str = str.replaceAll("7", "¾");
		str = str.replaceAll("8", "½");
		str = str.replaceAll("9", "¼");
		str = str.replaceAll("0", "¹");
		str = str.replaceAll("_", "º");
		str = str.replaceAll("-", "»");
		str = str.replaceAll("=", "¸");
		str = str.replaceAll("@", "™");
		// not allowed: ~`+!@#$%^&*()[{]}|\"':;?/>.<,
		System.out.println(str);
		return str;

	}

	public static void ENC(String str) {
		str = str.replaceAll("a", "¶");
		str = str.replaceAll("b", "µ");
		str = str.replaceAll("c", "³");
		str = str.replaceAll("d", "²");
		str = str.replaceAll("e", "±");
		str = str.replaceAll("f", "°");
		str = str.replaceAll("g", "¯");
		str = str.replaceAll("h", "®");
		str = str.replaceAll("i", "¬");
		str = str.replaceAll("j", "«");
		str = str.replaceAll("k", "©");
		str = str.replaceAll("l", "¨");
		str = str.replaceAll("m", "§");
		str = str.replaceAll("n", "¦");
		str = str.replaceAll("o", "¥");
		str = str.replaceAll("p", "¤");
		str = str.replaceAll("q", "£");
		str = str.replaceAll("r", "¢");
		str = str.replaceAll("s", "¡");
		str = str.replaceAll("t", "Ÿ");
		str = str.replaceAll("u", "œ");
		str = str.replaceAll("v", "•");
		str = str.replaceAll("w", "—");
		str = str.replaceAll("x", "‰");
		str = str.replaceAll("y", "‡");
		str = str.replaceAll("z", "†");
		str = str.replaceAll("1", "ƒ");
		str = str.replaceAll("2", "€");
		str = str.replaceAll("3", "þ");
		str = str.replaceAll("4", "Þ");
		str = str.replaceAll("5", "Ð");
		str = str.replaceAll("6", "¿");
		str = str.replaceAll("7", "¾");
		str = str.replaceAll("8", "½");
		str = str.replaceAll("9", "¼");
		str = str.replaceAll("0", "¹");
		str = str.replaceAll("_", "º");
		str = str.replaceAll("-", "»");
		str = str.replaceAll("=", "¸");
		// not allowed: ~`+!@#$%^&*()[{]}|\"':;?/>.<,
		System.out.println(str);

	}

}
