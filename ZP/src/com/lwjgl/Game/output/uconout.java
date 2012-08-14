package com.lwjgl.Game.output;

import java.net.*;
import java.util.Properties;
import java.io.*;

public class uconout {
	public static String numS;
	public static int num;
	public static String numSA;
	public static int numA;
	public static String unb;

	public static void ucono() throws Exception {

		URL urlin = new URL(
				"http://www.scope.escratch.org/minefront/userData.properties");
		URLConnection connect = urlin.openConnection();
		Properties config = new Properties();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect.getInputStream()));
		if (in.ready()) {
			for (int i = 0; i < num + 1; i++) {
				String una = "user" + i;
				String unb = "user" + (i++);
				String unP = in.readLine();
				while (!unP.contains("user")) {
					unP = in.readLine();
				}
				unP = encdec.decrypt(unP);
				if (!unP.equals(login.reguser)) {

				}
				if (unP.equals(login.reguser)) {
					login.taken = true;
				}
			}

		}
		in.close();
	}

	public static void ucono2() throws Exception {
		URL urlout = new URL(
				"http://www.scope.escratch.org/minefront/userData.properties");
		URLConnection connection = urlout.openConnection();
		connection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream());
		out.write(unb + "=" + login.reguser);
		// out.write()
		// out.write();
		out.close();
	}

	public static void inputReg(String un) {
		try {

			Properties regPropI = new Properties();
			File regFileI = new File(gameUpdater.getLoc()
					+ "/SCOPE/wbtminefront/userData.properties");
			InputStream inI;
			inI = new FileInputStream(regFileI);
			regPropI.load(inI);

			numS = regPropI.getProperty("num");
			num = Integer.parseInt(numS);

			for (int i = 0; i < num + 1; i++) {
				String una = "user" + i;
				String unP = regPropI.getProperty(una);
				unP = encdec.decrypt(unP);
				if (!unP.equals(un)) {

				}
				if (unP.equals(un)) {
					login.taken = true;
				}
			}
			inI.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void outputReg(String un, String pd, String e) {
		Properties regProp;
		try {
			regProp = new Properties();
			File regFile2 = new File(gameUpdater.getLoc()
					+ "/SCOPE/wbtminefront/userData.properties");
			InputStream in;
			in = new FileInputStream(regFile2);
			regProp.load(in);
			if (regFile2.exists()) {
				numSA = regProp.getProperty("num");
				numA = Integer.parseInt(numSA);
				numA += 1;
			}
			if (!regFile2.exists()) {
				numA = 1;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			regProp = new Properties();
			File regFile = new File(gameUpdater.getLoc()
					+ "/SCOPE/wbtminefront/userData.properties");
			regProp.load(new FileInputStream(regFile));
			String KEY1 = "user" + numA;
			String KEY2 = "pass" + numA;
			String KEY3 = "email" + numA;
			regProp.setProperty(KEY1, un);
			regProp.setProperty(KEY2, pd);
			regProp.setProperty(KEY3, e);
			regProp.setProperty("num", "" + numA);

			FileOutputStream outstream = new FileOutputStream(regFile);
			System.out.println(regProp.getProperty(KEY1));
			regProp.save(outstream, "");
			outstream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}