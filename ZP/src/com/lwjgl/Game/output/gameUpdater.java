package com.lwjgl.Game.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class gameUpdater {

	public static boolean newVersion = false; // if it is true, download the new
												// jar file for the game

	public static String getLoc() {
		String adDir = "";
		if (login.userOS.equals(login.os[1])) {
			adDir = System.getenv("APPDATA"); // %appdata% folder location on
												// windows
		}

		if (login.userOS.equals(login.os[2])) {
			adDir = System.getProperty("user.home")
					+ "/Library/Application Support";
		}
		if (login.userOS.equals(login.os[3])) {
			adDir = System.getProperty("user.home");
		}
		if (login.userOS.equals(login.os[0])) {
			adDir = System.getProperty("user.home");
		}

		return adDir;
	}

	public static void propCheck() {
		try {
			System.out
					.println("Properties Check (checking for userStatus file)");
			Properties properties = new Properties();
			File file = new File(gameUpdater.getLoc()
					+ "/SCOPE/wbtminefront/userStatus.properties");
			if (file.exists()) {
				properties.load(new FileInputStream(file));
				String newuser = properties.getProperty("newuser");
				if (newuser.equals("notnewuser")) {
					login.userStatus = "notnew";
					System.out.println(login.userStatus);
				}
				if (newuser.equals("newuser")) {
					login.userStatus = "new";
					System.out.println(login.userStatus);
				}
			} else {
				File newfile = new File(gameUpdater.getLoc()
						+ "/SCOPE/wbtminefront/userStatus.properties");
				Properties newfileconfig = new Properties();
				newfileconfig.setProperty("newuser", "notnewuser");
				login.userStatus = "new";
				FileOutputStream outstream = new FileOutputStream(newfile);
				newfileconfig.store(outstream, "user status");
				System.out.println("newfile file made");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void propNNUOS() {
		try {

			String currentOS = System.getProperty("os.name");
			System.out.println(currentOS);
			login.userOS = currentOS;

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
