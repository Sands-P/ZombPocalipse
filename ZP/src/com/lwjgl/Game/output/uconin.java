package com.lwjgl.Game.output;

import java.net.*;
import java.util.Properties;
import java.io.*;

public class uconin {
	public static String replaceTXT = "";
	public static String n;
	public static String n2;
	public static String n3;
	public static String n4;
	public static String n5;
	public static String n6;
	public static String n7;
	public static String n8;
	public static String n9;
	public static String n10;
	static Thread newsThread;

	public static void uconi() throws Exception {
		URL urlin = new URL("http://www.WEBSITE.org/data.properties");
		URLConnection connect = urlin.openConnection();
		Properties config = new Properties();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect.getInputStream()));
		config.load(in);

		in.close();
	}

	public static void news() throws Exception {
		URL urlin = new URL(
				"http://www.scope.escratch.org/minefront/news.properties");
		URLConnection connect = urlin.openConnection();
		Properties config = new Properties();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect.getInputStream()));
		if (in.ready()) {
			System.out.println("news loading started");
			n = in.readLine();
			n = n.replaceAll("newsItem1=", "");
			n2 = in.readLine();
			n2 = n2.replaceAll("newsItem2=", "");
			n3 = in.readLine();
			n3 = n3.replaceAll("newsItem3=", "");
			n4 = in.readLine();
			n4 = n4.replaceAll("newsItem4=", "");
			n5 = in.readLine();
			n5 = n5.replaceAll("newsItem5=", "");
			n6 = in.readLine();
			n6 = n6.replaceAll("newsItem6=", "");
			n7 = in.readLine();
			n7 = n7.replaceAll("newsItem7=", "");
			n8 = in.readLine();
			n8 = n8.replaceAll("newsItem8=", "");
			n9 = in.readLine();
			n9 = n9.replaceAll("newsItem9=", "");
			n10 = in.readLine();
			n10 = n10.replaceAll("newsItem10=", "");
			System.out.println("news loading done");
			login.NEWS[0] = n;
			login.NEWS[1] = n2;
			login.NEWS[2] = n3;
			login.NEWS[3] = n4;
			login.NEWS[4] = n5;
			login.NEWS[5] = n6;
			login.NEWS[6] = n7;
			login.NEWS[7] = n8;
			login.NEWS[8] = n9;
			login.NEWS[9] = n10;
		}

		/*
		 * try { File file = new File(login.adDir +
		 * "/SCOPE/wbtminefront/news.properties"); //location of news file
		 * (should on final version be on a website) config.load(new
		 * FileInputStream(file)); if(file.exists()) { login.NEWS[0] =
		 * config.getProperty("newsItem1"); login.NEWS[1] =
		 * config.getProperty("newsItem2"); login.NEWS[2] =
		 * config.getProperty("newsItem3"); login.NEWS[3] =
		 * config.getProperty("newsItem4"); login.NEWS[4] =
		 * config.getProperty("newsItem5"); login.NEWS[5] =
		 * config.getProperty("newsItem6"); login.NEWS[6] =
		 * config.getProperty("newsItem7"); login.NEWS[7] =
		 * config.getProperty("newsItem8"); login.NEWS[8] =
		 * config.getProperty("newsItem9"); login.NEWS[9] =
		 * config.getProperty("newsItem10"); }
		 * 
		 * //in.close(); } catch(Exception e) {
		 * System.out.println("news file is missing or access is denied"); //op
		 * pane }
		 */
	}
}