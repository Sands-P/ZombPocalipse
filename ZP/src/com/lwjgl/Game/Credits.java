package com.lwjgl.Game;

public class Credits {
	public static int CreditedNumber = 2;
	public static String creditNames[] = new String[CreditedNumber];
	public static String creditReason[] = new String[CreditedNumber];

	public static void setCredits(String name, String reason, int current) {
		creditNames[current] = name;
		creditReason[current] = reason;
	}
}
