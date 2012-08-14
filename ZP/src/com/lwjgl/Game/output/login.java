package com.lwjgl.Game.output;

import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import net.miginfocom.*;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.jar.JarInputStream;

import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;

import net.java.games.input.*;

public class login { // no longer platform specific

	public static String Title = "Minefront";
	public static double CV = 0.15;
	public static String TYPE = "alpha";
	public static String TITLE = Title + " " + TYPE + " " + CV;
	public static JFrame frmLoginregister; // to update the game program, just
											// modify the display.java and
											// replace the others
	public static JFrame frmLogin;
	public static JFrame frmRegister;
	public static JFrame frmGame;
	public static JFrame frmFPS;
	public static boolean hdTexturing = false;
	public static boolean ready = false;
	private Thread thread;
	JTextField loginuser;
	JPasswordField loginpass;
	JLabel lblUsername; // notice that it hasn't been initialized this yet. I
						// will later
	JLabel lblPassword;
	private static FileOutputStream fos;
	static boolean bypass = false; // Only a temporary bypass for my login
									// system
	public static String[] os = new String[7];
	{
		os[0] = "Solaris";
		os[1] = "Windows 7";
		os[2] = "Mac OS X";
		os[3] = "Linux";
		os[4] = "Windows XP";
		os[5] = "Mac OS";
		os[6] = "Sun OS";
	}
	public static String[] filesD = new String[2];
	{
		filesD[0] = "";// link to first file
		filesD[1] = "";// link to second file
	}
	public static String[] filesL = new String[2];
	{
		filesL[0] = "";
		filesL[1] = "";
	}
	public static String[] NEWS = new String[10];
	{
		NEWS[0] = "";
		NEWS[1] = "";
		NEWS[2] = "";
		NEWS[3] = "";
		NEWS[4] = "";
		NEWS[5] = "";
		NEWS[6] = "";
		NEWS[7] = "";
		NEWS[8] = "";
		NEWS[9] = "";
	}
	public static String userOS = "windows";
	private JPanel regcontentPane;
	private JTextField usern;
	private JTextField email;
	private JPasswordField wpass;
	private JPasswordField cpass;
	public static String userStatus;
	static String reguser;
	static String regwpass;
	static String regcpass;
	static String regemail;
	public static String regpass;
	static String Fps;
	public static boolean taken = false;

	public static String adDir; // this is the location of the windows user's
								// %appdata% folder "roaming"

	/**
	 * Launch the application.
	 */
	public static void startNext() {
		System.out.println("STARTED");
		System.out.println("Systems check is STARTED");
		gameUpdater.propNNUOS();
		gameUpdater.getLoc();
		gameUpdater.propCheck();
		System.out.println("STARTED2");
		if (userStatus == "new") {

			adDir = gameUpdater.getLoc();
			boolean success = (new File(adDir + "/SCOPE/wbtMinefront"))
					.mkdirs();
			if (success) {
				System.out.println("Directories: " + "SCOPE/wbtMinefront"
						+ " created");

			}
			success = (new File(adDir + "/SCOPE/wbtMinefront/bin")).mkdirs();
			if (success) {
				System.out.println("Directories: " + "SCOPE/wbtMinefront/bin"
						+ " created");

			}
			success = (new File(adDir + "/SCOPE/wbtMinefront/res/sounds"))
					.mkdirs();
			if (success) {
				System.out.println("Directories: "
						+ "SCOPE/wbtMinefront/res/sounds" + " created");

			}
			success = (new File(adDir + "/SCOPE/wbtMinefront/res/textures"))
					.mkdirs();
			if (success) {
				System.out.println("Directories: "
						+ "SCOPE/wbtMinefront/res/textures" + " created");

			}
			success = (new File(adDir + "/SCOPE/wbtMinefront/res/3dtextures"))
					.mkdirs();
			if (success) {
				System.out.println("Directories: "
						+ "SCOPE/wbtMinefront/res/3dtextures" + " created");

			}
			/*
			 * File exportNative; InputStream is; is = new
			 * FileInputStream(getResourceAsStream("")); JarInputStream jarIS =
			 * new JarInputStream(is); jarIS.
			 * 
			 * is= new FileInputStream(login.getResourceAsStream("file"));
			 * OutputStream os = new FileOutputStream("dest_file"); byte[]
			 * buffer = new byte[4096]; int length; while ((length =
			 * is.read(buffer)) > 0) { os.write(buffer, 0, length); }
			 * os.close(); is.close();
			 */

			// File newLOCFILE = new File("userStatus.properties");
			// File dir = new File(adDir +
			// "/SCOPE/wbtMinefront/userStatus.properties");
			// success = newLOCFILE.renameTo(new File(adDir +
			// "/SCOPE/wbtMinefront/userStatus.properties"));
			// if (!success) {
			// System.out.println("unsuccessful movement");
			// }

		}
		if (userStatus == "notnew") {
			gameUpdater.propNNUOS();
			adDir = gameUpdater.getLoc();
			System.out.println(adDir);

		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {

					login window = new login();

					window.frmLoginregister.setVisible(true); // Set only the
																// JFrame that
																// is wanted
																// visible as
																// being true
																// while the
																// others are
																// false
					window.frmLoginregister.setSize(800, 600); // Set the size
																// of the JFrame
																// like this:
																// YOUR_JFRAME.setSize(int
																// x, int y);
					window.frmLoginregister.setResizable(false); // By setting
																	// this as
																	// false,
																	// you make
																	// it
																	// impossible
																	// to change
																	// the
																	// dimensions
																	// of the
																	// JFrame
					window.frmLogin.setVisible(false);
					window.frmLogin.setSize(800, 600);
					window.frmLogin.setResizable(false);
					window.frmRegister.setVisible(false);
					window.frmRegister.setSize(800, 600);
					window.frmRegister.setResizable(false);
					window.frmGame.setVisible(false);
					window.frmGame.setSize(800, 600);
					window.frmGame.setResizable(false);

					window.frmLoginregister.setLocationRelativeTo(null);
					window.frmLogin.setLocationRelativeTo(null);
					window.frmRegister.setLocationRelativeTo(null);
					window.frmGame.setLocationRelativeTo(null);
					// WeaponPistol wp = new WeaponPistol();

				} catch (Exception e) {
					e.printStackTrace();
				}
				startNext();
				try {
					uconin.news();

					JPanel newspanel = new JPanel();
					JTextArea txtnews = new JTextArea(">>" + NEWS[0] + "    "
							+ ">>" + NEWS[1] + "    " + ">>" + NEWS[2] + "\n"
							+ ">>" + NEWS[3] + "    " + ">>" + NEWS[4] + "    "
							+ ">>" + NEWS[5] + "\n" + ">>" + NEWS[6] + "    "
							+ ">>" + NEWS[7] + "    " + ">>" + NEWS[8] + "    "
							+ ">>" + NEWS[9]);
					txtnews.setEditable(false);
					txtnews.setLineWrap(false);
					newspanel.add(txtnews);
					frmLoginregister.getContentPane().add(newspanel,
							BorderLayout.NORTH);

					/*
					 * JFrame frame = new JFrame(); int n =
					 * JOptionPane.showConfirmDialog( frame,
					 * "Would you like to use the higher quality textures?",
					 * "HD Textures?", JOptionPane.YES_NO_OPTION); if(n == 1) {
					 * //no hdTexturing = false;
					 * 
					 * } if(n == 0) { //yes hdTexturing = true;
					 * 
					 * }
					 */
					hdTexturing = true;

					/*
					 * for (Controller controller :
					 * ControllerEnvironment.getDefaultEnvironment
					 * ().getControllers()) {
					 * System.out.println(controller.getName());
					 * if(controller.getName().equals("Logitech Dual Action") ||
					 * controller.getName().equals("Controller (Gamepad F310)"))
					 * {
					 * System.out.println("Compatible joystick/gamepad found");
					 * System.out.println(controller.getRumblers());
					 * System.out.println(controller.getComponents());
					 * System.out.println(controller.getType());
					 * 
					 * } controller.poll(); net.java.games.input.EventQueue
					 * eventQueue = controller.getEventQueue(); //Event event =
					 * new Event(); Controllers.create();
					 * System.out.println(Controllers.isCreated());
					 * 
					 * 
					 * while (eventQueue.getNextEvent(event)) {
					 * System.out.println(event); }
					 * 
					 * }
					 */

					// joystick.getJoystick();
					// joystick.refreshJoystick();
				} catch (Exception e) {

					// e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {

		initialize(); // this is saying it will run the method/function
						// "initialize" which is a little below
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void regcheck() {

	}

	private boolean isTaken() {
		taken = false;
		uconout.inputReg(reguser);

		return taken;
	}

	private void regadd() {
		uconout.outputReg(reguser, regpass, regemail);

	}

	public void initialize() {
		frmLoginregister = new JFrame(); // now i am initializing the JFrames
											// hence the name of the method
		frmLogin = new JFrame();
		frmRegister = new JFrame();
		frmGame = new JFrame();
		frmLoginregister.setIconImage(Toolkit.getDefaultToolkit().getImage(
				login.class.getResource("/login/rifle.png")));
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(
				login.class.getResource("/login/rifle.png")));
		frmRegister.setIconImage(Toolkit.getDefaultToolkit().getImage(
				login.class.getResource("/login/rifle.png")));
		frmGame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				login.class.getResource("/login/rifle.png")));
		frmLoginregister.setTitle("LOGIN/REGISTER");
		frmLogin.setTitle("Login System");
		frmRegister.setTitle("Register System");
		frmLoginregister.setBounds(100, 100, 450, 300);
		frmLogin.setBounds(100, 100, 450, 300);
		frmRegister.setBounds(100, 100, 450, 300);
		frmLoginregister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnLogin = new JButton("  Login  ");
		btnLogin.addActionListener(new ActionListener() { // by adding an action
															// listener, i make
															// it so that if the
															// button is
															// pressed, it does
															// the following
															// code
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.setVisible(true); // i make all but the wanted JFrame
											// not visible
				frmLoginregister.setVisible(false);
				frmRegister.setVisible(false);
				frmGame.setVisible(false);
			}
		});
		frmLoginregister.getContentPane().add(btnLogin, BorderLayout.WEST); // by
																			// using
																			// getcontentpane().add(btnlogin,
																			// borderlayout.west);
																			// it
																			// gets
																			// everything
																			// in
																			// it
																			// already
																			// and
																			// adds
																			// the
																			// btnlogin
																			// in
																			// the
																			// location
																			// "west"

		JButton btnRegister = new JButton("Register"); // the text "register" is
														// what will be on the
														// button
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.setVisible(false);
				frmLoginregister.setVisible(false);
				frmRegister.setVisible(true);
				frmGame.setVisible(false);
			}
		});

		frmLoginregister.getContentPane().add(btnRegister, BorderLayout.EAST);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				int n = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want to exit?", "Exit???",
						JOptionPane.YES_NO_OPTION);
				if (n == 1) {
					return;
				}
				if (n == 0) {
					System.exit(0);
				}// itemRenderer and tessalator
			}

		});
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmLogin.setContentPane(contentPane);
		// contentPane.setLayout(new MigLayout("", "[52px][86px,grow]",
		// "[20px][14px][][]"));

		lblUsername = new JLabel("Username:");
		contentPane.add(lblUsername, "cell 0 0,alignx center,aligny center");

		loginuser = new JTextField();
		contentPane.add(loginuser, "cell 1 0,alignx left,aligny top");
		loginuser.setColumns(10);

		lblPassword = new JLabel("Password:");
		contentPane.add(lblPassword, "cell 0 1,alignx trailing,aligny top");

		loginpass = new JPasswordField();
		loginpass.setColumns(10);
		contentPane.add(loginpass, "cell 1 1,alignx left");

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = loginuser.getText();
				String pass = loginpass.getText();

				if (!user.isEmpty() && !pass.isEmpty()) {

					if (bypass) {
						try {
							// Display.runGame();
							frmLogin.setVisible(false);
							frmRegister.setVisible(false);
							frmLoginregister.setVisible(false);
							frmGame.setVisible(true);
							// System.out.println("User: " + user + " " +
							// "Pass: " + pass);
							encdec.encPass = encdec.encrypt(pass);

						} catch (Exception e) {

						}
					}
					if (!bypass) {
						System.out.println("User: " + user + " " + "Pass: "
								+ pass);
						try {

							// MakeSound.playSound("D:/eclipse/workspace/wbtest/res/sounds/soundFastFootSteps.wav");

							Properties regPropI = new Properties();
							File regFileI = new File(gameUpdater.getLoc()
									+ "/SCOPE/wbtminefront/userData.properties");
							InputStream inI;
							inI = new FileInputStream(regFileI);
							regPropI.load(inI);

							if (regPropI.containsValue(encdec.encrypt(user))) {
								for (int i = 0; i < Integer.parseInt(regPropI
										.getProperty("num")) + 1; i++) {
									String c = "user" + i;
									String cuser = regPropI.getProperty(c);
									cuser = encdec.decrypt(cuser);
									if (cuser.equals(user)) {
										c = "pass" + i;
										String Cpass = regPropI.getProperty(c);
										Cpass = encdec.decrypt(Cpass);
										if (Cpass.equals(pass)) {
											try {

												// Display.runGame();
												frmLogin.setVisible(false);
												frmRegister.setVisible(false);
												frmLoginregister
														.setVisible(false);
												frmGame.setVisible(true);

												/*
												 * for(int i1 = 0; i1 <
												 * filesD.length; i1++) { URL
												 * website = new
												 * URL(filesD[i-1]);
												 * ReadableByteChannel rbc =
												 * Channels
												 * .newChannel(website.openStream
												 * ()); fos = new
												 * FileOutputStream
												 * (filesL[i-1]);
												 * fos.getChannel(
												 * ).transferFrom(rbc, 0, 1 <<
												 * 24);
												 * 
												 * } fos.close();
												 */

											} catch (Exception e) {
												e.printStackTrace();
											}
										}
										if (!Cpass.equals(pass)) {
											JFrame opframe2 = new JFrame();
											JOptionPane
													.showMessageDialog(
															opframe2,
															"I am sorry. No user with the username: "
																	+ user
																	+ " and the password: "
																	+ pass
																	+ " exists");
										}
									}
								}

							} else {
								JFrame opframe2 = new JFrame();
								JOptionPane.showMessageDialog(opframe2,
										"I am sorry. No user with the username: "
												+ user + " and the password: "
												+ pass + " exists");
							}

							inI.close();

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if (user.isEmpty() || pass.isEmpty()) {
					JFrame opframe = new JFrame();
					JOptionPane
							.showMessageDialog(
									opframe,
									"I am sorry. You are not allowed to have nothing as your username and/or password");
				}

			}

		});

		contentPane.add(btnSubmit, "cell 1 2");

		frmLoginregister.getContentPane().add(btnExit, BorderLayout.SOUTH);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(login.class.getResource("/login/mf.gif")));
		frmLoginregister.getContentPane().add(button, BorderLayout.CENTER);
		frmLoginregister.setSize(800, 600);
		frmLoginregister.setResizable(false);

		regcontentPane = new JPanel();
		regcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmRegister.setContentPane(regcontentPane);
		// regcontentPane.setLayout(new MigLayout("", "[grow][][grow]",
		// "[][][][][][][grow][][]"));

		JLabel lblWantedUsername = new JLabel("Wanted Username");
		regcontentPane.add(lblWantedUsername, "cell 0 0");

		usern = new JTextField();
		usern.setToolTipText("");
		regcontentPane.add(usern, "cell 2 0,growx");
		usern.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		regcontentPane.add(lblEmail, "cell 0 1");

		email = new JTextField();
		regcontentPane.add(email, "cell 2 1,growx");
		email.setColumns(30);

		JLabel lblWantedPassword = new JLabel("Wanted Password");
		regcontentPane.add(lblWantedPassword, "cell 0 2");

		wpass = new JPasswordField();
		wpass.setColumns(10);
		regcontentPane.add(wpass, "cell 2 2,growx");

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		regcontentPane.add(lblConfirmPassword, "cell 0 3");

		cpass = new JPasswordField();
		cpass.setColumns(10);
		regcontentPane.add(cpass, "cell 2 3,growx");

		final JTextPane regresult = new JTextPane();
		regresult.setEditable(false);

		JButton btnRegSubmit = new JButton("Submit");
		btnRegSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				boolean regsuccess = false;
				boolean regend = false;
				reguser = usern.getText();
				regwpass = wpass.getText();
				regcpass = cpass.getText();
				regemail = email.getText();

				if ((regwpass.equals(regcpass)) && (!regwpass.isEmpty())
						&& (!regcpass.isEmpty())) { // when comparing strings,
													// do
													// STRING1.equals(STRING2)
					regsuccess = true;

				} else {
					regsuccess = false;
					System.out.println("pass do not match");
					System.out.println(regwpass);
					System.out.println(regcpass);

				}
				if (isTaken()) {
					usern.setText("Username already taken");
					regsuccess = false;
					System.out.println("user taken");
				}
				if (!isTaken() && !reguser.isEmpty()) {
					if (!regsuccess) {
						regsuccess = false;
						System.out.println("fail");
					}
					if (regsuccess) {
						System.out.println("success");
					}
				}
				if (!regemail.isEmpty()) {

				} else {
					regsuccess = false;
					System.out.println("no email");
				}
				if (regsuccess) {
					regpass = regwpass;
					regpass = encdec.encrypt(regpass);
					regemail = encdec.encrypt(regemail);
					reguser = encdec.encrypt(reguser);
					regadd();
					regresult.setText("Register Successful");
					try {
						Thread.sleep(2000);
						frmRegister.setVisible(false);
						frmLoginregister.setVisible(false);
						frmLogin.setVisible(true);
						frmGame.setVisible(false);
					} catch (Exception e) {

					}
				}
				if (!regsuccess) {
					regresult.setText("Register Failed");
				}
			}

		});

		regcontentPane.add(btnRegSubmit,
				"cell 2 4,alignx trailing,aligny bottom");

		JLabel lblregResult = new JLabel("Result:");
		regcontentPane.add(lblregResult, "cell 0 5");

		regcontentPane.add(regresult, "cell 1 5 2 1,grow");

		JTextPane warning = new JTextPane();
		warning.setText("Warning: NONE of the following characters can be used in your password nor username"
				+ "\n" + "~`+!#$%^&*()[{]}|\"':;?/>.<,");
		warning.setEditable(false);
		regcontentPane.add(warning, "cell 0 6 3 3,grow");

		frmLoginregister.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { // if the [X] is clicked,
														// it does the stuff
														// instead of doing a
														// close

			};// because of this, it doesnt throw a exception when you click the
				// [X]

		});
		frmGame.addWindowListener(new WindowAdapter() {
			@SuppressWarnings("unused")
			public void WindowClosing(WindowEvent we) {
				AL.destroy();
			}
		});

	}
}