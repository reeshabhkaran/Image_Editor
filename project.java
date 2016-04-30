import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class project
{
	private JLabel JLabel1, JLabel2, JLabel3, JLabel4, JLabel5, JLabel6, JLabel7, JLabel8;
	private JTextField text1, text2, text3, text4, text5;
	private JPasswordField password;
	private JFrame jfrm1;
	String name,phone,username,pass1,s;
	String a[] = new String[10];
	
	void userlogin()
	{
		jfrm1 = new JFrame("User");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.setVisible(true);
		jfrm1.setSize(300,350);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
		c.insets = new Insets(10,0,0,10);
		JLabel6 = new JLabel("Choose...");
		JLabel6.setBounds(100, 30, 400, 30);
		JLabel6.setForeground(Color.blue);
		panel.add(JLabel6, c);
		c.gridy++;
		
		c.insets = new Insets(20,0,0,0);
		JButton jbtn1 = new JButton("Sign Up");
		panel.add(jbtn1, c);
		c.gridy++;
		
		JButton jbtn2 = new JButton("Login");
		panel.add(jbtn2, c);
		c.gridy++;
		
		JButton jbtn3 = new JButton("Back");
		panel.add(jbtn3, c);
				
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				signup();
			}
		});
		
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				login();
			}
		});
		
		jbtn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				welcome();
			}
		});
	}
	
	void signup()
	{
		jfrm1 = new JFrame("Sign Up");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.setVisible(true);
		jfrm1.setSize(375,500);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
			
		c.insets = new Insets(10,0,0,10);
		JLabel6 = new JLabel("Enter Details !!!");
		JLabel6.setBounds(100, 30, 400, 30);
		JLabel6.setForeground(Color.blue);
		panel.add(JLabel6, c);
		c.gridy++;
									
		JLabel1 = new JLabel("Name:");
		panel.add(JLabel1, c);
		c.gridy++;				
							
		JLabel2 = new JLabel("Phone no:");
		panel.add(JLabel2, c);
		c.gridy++;
					
		JLabel3 = new JLabel("User id:");
		panel.add(JLabel3, c);
		c.gridy++;
		
		JLabel4 = new JLabel("Password:");
		panel.add(JLabel4, c);
		c.gridy++;
	
		c.insets = new Insets(20,0,0,0);
		JButton jbtn1 = new JButton("Submit");
		panel.add(jbtn1, c);
		c.gridy++;
		
		c.insets = new Insets(30,0,0,0);
		JLabel5 = new JLabel("");
		panel.add(JLabel5, c);
	
		c.gridx++;
		c.gridy = 0;
		
		c.gridy++;
		text1 = new JTextField(10);
		panel.add(text1, c);
		c.gridy++;
		
		text2 = new JTextField(10);
		panel.add(text2, c);
		c.gridy++;
		
		text3 = new JTextField(10);
		panel.add(text3, c);
		c.gridy++;
		
		password = new JPasswordField(10);
		panel.add(password, c);
		c.gridy++;
		
		c.insets = new Insets(20,0,0,0);
		JButton jbtn2 = new JButton("Cancel");
		panel.add(jbtn2, c);		
		
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{		
				name = text1.getText();
				phone = text2.getText();
				username = text3.getText();
				pass1 = password.getText();				
						
				if( name.length()==0 || phone.length()==0 || username.length()==0 || pass1.length()==0 )
				{
					jfrm1 = new JFrame("Sorry");
					jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jfrm1.setVisible(true);
					jfrm1.setSize(375,150);
								
					JPanel panel = new JPanel();
					panel.setLayout(new GridBagLayout()); 
					GridBagConstraints c = new GridBagConstraints();
					jfrm1.add(panel);
					
					c.gridx = 0;
					c.gridy = 0;
					c.anchor = GridBagConstraints.CENTER;
								
					JLabel1 = new JLabel("Incomplete information. Enter again.");
					panel.add(JLabel1, c);
					c.gridy++;

					c.insets = new Insets(20,0,0,0);
					JButton jbtn = new JButton("OK");
					panel.add(jbtn, c);
					
					jbtn.addActionListener( new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							signup();
						}
					});
				}
				
				else if(phone.length()<10)
				{
					JLabel5.setText("Enter Phone no. again: (10 digits)");
					JLabel5.setForeground(Color.red);
				}
				else if(!pass1.matches("^([0-9]+[a-zA-Z]+|[a-zA-Z]+[0-9]+)[0-9a-zA-Z]*"))
				{
					JLabel5.setText("Enter Password Again: (alphanumeric)");
					JLabel5.setForeground(Color.red);
				}
				else
				{					
					jfrm1 = new JFrame("Congratulations");
					jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jfrm1.setVisible(true);
					jfrm1.setSize(375,150);
								
					JPanel panel = new JPanel();
					panel.setLayout(new GridBagLayout()); 
					GridBagConstraints c = new GridBagConstraints();
					jfrm1.add(panel);
				
					c.gridx = 0;
					c.gridy = 0;
					c.anchor = GridBagConstraints.CENTER;
							
					JLabel jlab1 = new JLabel("You are successfully Signed Up.");
					panel.add(jlab1, c);
					c.gridy++;
					
					c.insets = new Insets(20,0,0,0);					
					JButton jbtn = new JButton("OK");
					panel.add(jbtn, c);							
													
					jbtn.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							userlogin();
						}
					});
				}
							
			}
		});
			
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				userlogin();
			}
		});
	
	}
	
	void login()
	{		
		jfrm1 = new JFrame("Login");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.setVisible(true);
		jfrm1.setSize(500,300);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
		
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
			
		c.insets = new Insets(10,0,0,20);
		JLabel1 = new JLabel("User id:");
		panel.add(JLabel1, c);
		c.gridy++;

		JLabel2 = new JLabel("Password:");
		panel.add(JLabel2, c);
		c.gridy++;
		
		c.insets = new Insets(20,0,0,0);
		JButton jbtn1 = new JButton("Login");
		panel.add(jbtn1, c);
		c.gridy++;
		
		c.insets = new Insets(20,0,0,0);
		JLabel7 = new JLabel("");
		panel.add(JLabel7, c);
		
		c.gridx++;
		c.gridy = 0;
		text1 = new JTextField(10);
		panel.add(text1, c);
		c.gridy++;
		
		password = new JPasswordField(10);
		panel.add(password, c);	
		c.gridy++;

		c.insets = new Insets(20,0,0,0);
		JButton jbtn2 = new JButton("Cancel");
		panel.add(jbtn2, c);		
		
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				String use = text1.getText();
				String pass = password.getText();	

				String admin = "admin";
				String adpass = "admin";
				String dev = "developer";
				String devpass = "developer";
				username = "user";
				pass1 = "user1";
		
				if(use.equals(admin) && pass.equals(adpass))
				{	
					admin();
				}
				else if(use.equals(dev) && pass.equals(devpass))
				{
					developer();
				}
				else if(use.equals(username) && pass.equals(pass1))
				{
					user();
				}
				else
				{
					JLabel7.setText("Invalid Account details...Enter again");
					JLabel7.setForeground(Color.red);
				}		
				
			}
		});

		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				welcome();
			}
		});
	}
	
	void welcome()
	{	
		jfrm1 = new JFrame("Image Editor");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.pack();
		jfrm1.setVisible(true);
		jfrm1.setSize(550,300);	
			
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
			
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
		c.insets = new Insets(15,0,0,0);
		JLabel1 = new JLabel("Welcome to the Image Editor. Select your option.", JLabel1.CENTER);
		JLabel1.setForeground(Color.blue);
		panel.add(JLabel1, c);
		c.gridy++;
			
		JButton jbtn1 = new JButton("User");
		panel.add(jbtn1, c);
		c.gridy++;
	
		JButton jbtn2 = new JButton("Admin");
		panel.add(jbtn2, c);
		c.gridy++;
		
		JButton jbtn3 = new JButton("Developer");
		panel.add(jbtn3, c);
		c.gridy++;
		
		JButton jbtn4 = new JButton("Exit");
		panel.add(jbtn4,c);
			
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				userlogin();
			}
		});
			
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				login();
			}
		});
		
		jbtn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				login();
			}
		});
		
		jbtn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});
	}
	
	void user()
	{
		jfrm1 = new JFrame("User");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.pack();
		jfrm1.setVisible(true);
		jfrm1.setSize(625,450);	
			
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
			
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
		c.insets = new Insets(10,0,0,20);
		JLabel1 = new JLabel("Enter Requirements...");
		JLabel1.setForeground(Color.blue);
		panel.add(JLabel1, c);
		c.gridy++;
		
		JCheckBox resize = new JCheckBox("Resize");
		JCheckBox brightness = new JCheckBox("Change Brightness");
		JCheckBox text = new JCheckBox("Add Text");
		JCheckBox rotate = new JCheckBox("Rotate");
		JCheckBox transparent = new JCheckBox("Change Transperency");
		
		panel.add(resize, c);
		c.gridy++;
		panel.add(brightness, c);
		c.gridy++;
		panel.add(text, c);
		c.gridy++;
		panel.add(rotate, c);
		c.gridy++;
		panel.add(transparent, c);
		c.gridy++;
		
		JLabel2 = new JLabel("");
		JLabel2.setForeground(Color.red);
		panel.add(JLabel2, c);
		
		c.gridy++;
		
		JLabel3 = new JLabel("");
		JLabel3.setForeground(Color.red);
		panel.add(JLabel3, c);
		
		
		c.gridx++; c.gridy = 1;
		JButton jbtn = new JButton("Add Image");
		panel.add(jbtn, c);
		c.gridy++;
		
		JButton jbtn1 = new JButton("View Feedback");
		panel.add(jbtn1, c);
		c.gridy++;
		
		JButton jbtn3 = new JButton("Submit");
		jbtn3.setForeground(Color.red);
		panel.add(jbtn3, c);
		c.gridy++;
		
		// JButton jbtn4 = new JButton("View Edited Image");
		// panel.add(jbtn4, c);
		// c.gridy++;
		
		JButton jbtn2 = new JButton("Log Out");
		panel.add(jbtn2, c);
				
		jbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{ 				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					JLabel2.setText(fileChooser.getSelectedFile().getName());					
					JLabel3.setText(fileChooser.getCurrentDirectory().toString());
				}
				if (result == JFileChooser.CANCEL_OPTION) 
				{
					JLabel2.setText("You pressed cancel");
					JLabel3.setText("");
				}	
				
				a[0] = fileChooser.getSelectedFile().getName();
				a[1] = fileChooser.getCurrentDirectory().toString();				
			}
		});
		
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{			
				if(a[2] == null)
				{
					jfrm1 = new JFrame("Feedback");
					jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jfrm1.pack();
					jfrm1.setVisible(true);
					jfrm1.setSize(350,150);	
						
					JPanel panel = new JPanel();
					panel.setLayout(new GridBagLayout()); 
					GridBagConstraints c = new GridBagConstraints();
					jfrm1.add(panel);
						
					c.gridx = 0;
					c.gridy = 0;
					c.anchor = GridBagConstraints.CENTER;
					
					c.insets = new Insets(10,0,0,20);
					JLabel1 = new JLabel("No Feedbacks at this moment.");				
					panel.add(JLabel1, c);
					c.gridy++;
					
					JButton jbtn = new JButton("OK");
					panel.add(jbtn, c);
					
					jbtn.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							user();
						}
					});
				}
				else
				{
					jfrm1 = new JFrame("Feedback");
					jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jfrm1.pack();
					jfrm1.setVisible(true);
					jfrm1.setSize(400,200);	
						
					JPanel panel = new JPanel();
					panel.setLayout(new GridBagLayout()); 
					GridBagConstraints c = new GridBagConstraints();
					jfrm1.add(panel);
						
					c.gridx = 0;
					c.gridy = 0;
					c.anchor = GridBagConstraints.CENTER;
					
					c.insets = new Insets(10,0,0,20);
					JLabel1 = new JLabel("");
					JLabel1.setText(a[2]);
					panel.add(JLabel1, c);
					c.gridy++;
					
					JButton jbtn = new JButton("OK");
					panel.add(jbtn, c);
					c.gridy++;
										
					jbtn.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent ae)
						{
							jfrm1 = new JFrame("Feedback");
							jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jfrm1.pack();
							jfrm1.setVisible(true);
							jfrm1.setSize(350,150);	
								
							JPanel panel = new JPanel();
							panel.setLayout(new GridBagLayout()); 
							GridBagConstraints c = new GridBagConstraints();
							jfrm1.add(panel);
								
							c.gridx = 0;
							c.gridy = 0;
							c.anchor = GridBagConstraints.CENTER;
							
							c.insets = new Insets(10,0,0,20);
							JLabel1 = new JLabel("Thank You.");				
							panel.add(JLabel1, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);
							
							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									user();
								}
							});
						}
					});					
				}
			}
		});
		
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				userlogin();
			}
		});	

		jbtn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(resize.isSelected() || brightness.isSelected() || text.isSelected() || transparent.isSelected() || rotate.isSelected())
				{	
					if(resize.isSelected())
						a[3] = resize.getText();
					if(brightness.isSelected())
						a[4] = brightness.getText();
					if(text.isSelected())
						a[5] = text.getText();
					if(rotate.isSelected())
						a[6] = rotate.getText();
					if(transparent.isSelected())
						a[7] = transparent.getText();
										
					if(a[0] == null && a[1] == null)
					{
						jfrm1 = new JFrame("Sorry");
						jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						jfrm1.pack();
						jfrm1.setVisible(true);
						jfrm1.setSize(300,150);	
							
						JPanel panel = new JPanel();
						panel.setLayout(new GridBagLayout()); 
						GridBagConstraints c = new GridBagConstraints();
						jfrm1.add(panel);
							
						c.gridx = 0;
						c.gridy = 0;
						c.anchor = GridBagConstraints.CENTER;
						
						c.insets = new Insets(10,0,0,20);
						JLabel1 = new JLabel("Not Submitted. Try again.");				
						panel.add(JLabel1, c);
						c.gridy++;
						
						JButton jbtn = new JButton("OK");
						panel.add(jbtn, c);
						
						jbtn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae)
							{
								user();
							}
						});
					}
					else
					{					
						jfrm1 = new JFrame("Submit");
						jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						jfrm1.pack();
						jfrm1.setVisible(true);
						jfrm1.setSize(300,150);	
									
						JPanel panel = new JPanel();
						panel.setLayout(new GridBagLayout()); 
						GridBagConstraints c = new GridBagConstraints();
						jfrm1.add(panel);
									
						c.gridx = 0;
						c.gridy = 0;
						c.anchor = GridBagConstraints.CENTER;
								
						c.insets = new Insets(10,0,0,20);
						JLabel1 = new JLabel("Successfully submitted. Check back later.");				
						panel.add(JLabel1, c);
						c.gridy++;
								
						JButton jbtn = new JButton("OK");
						panel.add(jbtn, c);
								
						jbtn.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae)
							{
								user();
							}
						});						
					}
				}
				else
				{
					JLabel2.setText("Check requirements please.");
					JLabel3.setText("");
				}
			}
		});
		
		// jbtn4.addActionListener(new ActionListener()
		// {
			// public void actionPerformed(ActionEvent ae)
			// {				
				// jfrm1 = new JFrame("Edited Image");
				// jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// jfrm1.pack();
				// jfrm1.setVisible(true);
				// jfrm1.setSize(550,300);	
					
				// JPanel panel = new JPanel();
				// panel.setLayout(new GridBagLayout()); 
				// GridBagConstraints c = new GridBagConstraints();
				// jfrm1.add(panel);
					
				// c.gridx = 0;
				// c.gridy = 0;
				// c.anchor = GridBagConstraints.CENTER;
				
				// text1 = new JTextField();
				// text1.setText(a[9]+"\\"+a[8]);
				
				// try
				// {
					// BufferedImage myPicture = ImageIO.read(new File(text1.getText()));
					// JLabel picLabel = new JLabel(new ImageIcon(myPicture));
					// panel.add(picLabel, c);
					// c.gridy++;
					
					// JButton jbtn1 = new JButton("OK");
					// panel.add(jbtn, c);				
					
					// jbtn1.addActionListener(new ActionListener()
					// {
						// public void actionPerformed(ActionEvent ae)
						// {
							// user();
						// }
					// });
				// }	
				// catch(IOException ex)
				// {				
					// JLabel1 = new JLabel("Edited Image not available now.");
					// panel.add(JLabel1, c);
					// c.gridy++;
					
					// JButton jbtn = new JButton("OK");
					// panel.add(jbtn, c);
					
					// jbtn.addActionListener(new ActionListener()
					// {
						// public void actionPerformed(ActionEvent ae)
						// {
							// user();
						// }
					// });
				// }
			// }
		// });	
	}
	
	void admin()
	{
		jfrm1 = new JFrame("Admin");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.pack();
		jfrm1.setVisible(true);
		jfrm1.setSize(550,300);	
			
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
			
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		
		c.insets = new Insets(10,0,0,20);
		JLabel1 = new JLabel("Choose...!!!");
		JLabel1.setForeground(Color.blue);
		panel.add(JLabel1, c);
		c.gridy++;
		
		JButton jbtn4 = new JButton("View Requirements and Image.");
		panel.add(jbtn4, c);
		c.gridy++;
		
		JButton jbtn = new JButton("Give Feedback");
		panel.add(jbtn, c);
		c.gridy++;
		
		JButton jbtn1 = new JButton("Forward Developer");
		panel.add(jbtn1, c);
		c.gridy++;
		
		// JButton jbtn2 = new JButton("Forward User");
		// panel.add(jbtn2, c);
		// c.gridy++;
		
		JButton jbtn3 = new JButton("Log Out");
		panel.add(jbtn3, c);
		
		jbtn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				jfrm1 = new JFrame("Validate");
				jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jfrm1.pack();
				jfrm1.setVisible(true);
				jfrm1.setSize(600,200);	
						
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout()); 
				GridBagConstraints c = new GridBagConstraints();
				jfrm1.add(panel);
						
				c.gridx = 0;
				c.gridy = 0;
				c.anchor = GridBagConstraints.WEST;
					
				c.insets = new Insets(10,0,0,20);
				JLabel1 = new JLabel("Reguirements :");
				JLabel1.setForeground(Color.blue);
				panel.add(JLabel1, c);
				c.gridy++;
				
				JButton jbtn = new JButton("View Image");
				panel.add(jbtn, c);				
				
				c.gridx++; c.gridy = 0;
				JTextArea ta = new JTextArea(2,40);		
				ta.setText(a[3]+","+a[4]+","+a[5]+","+a[6]+","+a[7]);
				panel.add(ta, c);
				c.gridy++;
				
				JButton jbtn1 = new JButton("OK");
				panel.add(jbtn1, c);
				
				jbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{						
						jfrm1 = new JFrame("Validate");
						jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						jfrm1.pack();
						jfrm1.setVisible(true);
						jfrm1.setSize(600,200);	
								
						JPanel panel = new JPanel();
						panel.setLayout(new GridBagLayout()); 
						GridBagConstraints c = new GridBagConstraints();
						jfrm1.add(panel);
								
						c.gridx = 0;
						c.gridy = 0;
						c.anchor = GridBagConstraints.CENTER;
						
						text1 = new JTextField();
						text1.setText(a[1]+"\\"+a[0]);
						
						
						try
						{
							BufferedImage myPicture = ImageIO.read(new File(text1.getText()));
							JLabel picLabel = new JLabel(new ImageIcon(myPicture));
							panel.add(picLabel, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);
							
							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									admin();
								}
							});
						}
						catch(IOException ex)
						{
							JLabel1 = new JLabel("Sorry no Image to display.");
							panel.add(JLabel1, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);
							
							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									developer();
								}
							});
						}
					}
				});
				
				jbtn1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						admin();
					}
				});
			}
		});
		
		jbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				jfrm1 = new JFrame("Feedback");
				jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jfrm1.pack();
				jfrm1.setVisible(true);
				jfrm1.setSize(500,200);	
						
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout()); 
				GridBagConstraints c = new GridBagConstraints();
				jfrm1.add(panel);
						
				c.gridx = 0;
				c.gridy = 0;
				c.anchor = GridBagConstraints.CENTER;
					
				c.insets = new Insets(10,0,0,20);
				JLabel1 = new JLabel("Give Feedback");
				JLabel1.setForeground(Color.blue);
				panel.add(JLabel1, c);
				c.gridy++;
				
				JButton jbtn = new JButton("OK");
				panel.add(jbtn, c);				
				
				c.gridx++; c.gridy = 0;
				JTextArea ta = new JTextArea(2,30);				
				panel.add(ta, c);
				
				jbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						a[2] = ta.getText();
						
						if(a[2].length() == 0)
						{
							jfrm1 = new JFrame("Feedback");
							jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jfrm1.pack();
							jfrm1.setVisible(true);
							jfrm1.setSize(450,200);	
									
							JPanel panel = new JPanel();
							panel.setLayout(new GridBagLayout()); 
							GridBagConstraints c = new GridBagConstraints();
							jfrm1.add(panel);
									
							c.gridx = 0;
							c.gridy = 0;
							c.anchor = GridBagConstraints.CENTER;
								
							c.insets = new Insets(10,0,0,20);
							JLabel1 = new JLabel("Text area empty. Cannot submit feedback.");						
							panel.add(JLabel1, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);		

							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									admin();
								}
							});
						}
						else
						{
							jfrm1 = new JFrame("Feedback");
							jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jfrm1.pack();
							jfrm1.setVisible(true);
							jfrm1.setSize(450,200);	
									
							JPanel panel = new JPanel();
							panel.setLayout(new GridBagLayout()); 
							GridBagConstraints c = new GridBagConstraints();
							jfrm1.add(panel);
									
							c.gridx = 0;
							c.gridy = 0;
							c.anchor = GridBagConstraints.CENTER;
								
							c.insets = new Insets(10,0,0,20);
							JLabel1 = new JLabel("Feedback Submitted.");						
							panel.add(JLabel1, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);		

							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									admin();
								}
							});
						}
					}
				});	
				
			}
		});
		
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				jfrm1 = new JFrame("Forward Developer");
				jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jfrm1.pack();
				jfrm1.setVisible(true);
				jfrm1.setSize(500,200);	
						
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout()); 
				GridBagConstraints c = new GridBagConstraints();
				jfrm1.add(panel);
						
				c.gridx = 0;
				c.gridy = 0;
				c.anchor = GridBagConstraints.CENTER;
					
				c.insets = new Insets(10,0,0,20);
				JLabel1 = new JLabel("Image and requirements successfully forwarded to developer.");				
				panel.add(JLabel1, c);
				c.gridy++;
				
				JButton jbtn = new JButton("OK");
				panel.add(jbtn, c);		

				jbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						admin();
					}
				});					
			}
		});
		
		// jbtn2.addActionListener(new ActionListener()
		// {
			// public void actionPerformed(ActionEvent ae)
			// {
				
			// }
		// });
		
		jbtn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				welcome();
			}
		});		
	}
	
	void developer()
	{
		jfrm1 = new JFrame("Developer");
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm1.pack();
		jfrm1.setVisible(true);
		jfrm1.setSize(550,300);	
			
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		jfrm1.add(panel);
			
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		
		c.insets = new Insets(10,0,0,20);
		JLabel1 = new JLabel("Choose...!!!");
		JLabel1.setForeground(Color.blue);
		panel.add(JLabel1, c);
		c.gridy++;
		
		JButton jbtn = new JButton("View requirement and Image");
		panel.add(jbtn, c);
		c.gridy++;
		
		JButton jbtn1 = new JButton("Edit Image");
		panel.add(jbtn1, c);
		c.gridy++;
		
		JButton jbtn2 = new JButton("Log Out");
		panel.add(jbtn2, c);
		c.gridy++;
		
		jbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				jfrm1 = new JFrame("Validate");
				jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jfrm1.pack();
				jfrm1.setVisible(true);
				jfrm1.setSize(600,200);	
						
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout()); 
				GridBagConstraints c = new GridBagConstraints();
				jfrm1.add(panel);
						
				c.gridx = 0;
				c.gridy = 0;
				c.anchor = GridBagConstraints.WEST;
					
				c.insets = new Insets(10,0,0,20);
				JLabel1 = new JLabel("Reguirements :");
				JLabel1.setForeground(Color.blue);
				panel.add(JLabel1, c);
				c.gridy++;
				
				JButton jbtn = new JButton("View Image");
				panel.add(jbtn, c);				
				
				c.gridx++; c.gridy = 0;
				JTextArea ta = new JTextArea(2,40);		
				ta.setText(a[3]+","+a[4]+","+a[5]+","+a[6]+","+a[7]);
				panel.add(ta, c);
				c.gridy++;
				
				JButton jbtn1 = new JButton("OK");
				panel.add(jbtn1, c);
				
				jbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{						
						jfrm1 = new JFrame("Validate");
						jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						jfrm1.pack();
						jfrm1.setVisible(true);
						jfrm1.setSize(600,200);	
								
						JPanel panel = new JPanel();
						panel.setLayout(new GridBagLayout()); 
						GridBagConstraints c = new GridBagConstraints();
						jfrm1.add(panel);
								
						c.gridx = 0;
						c.gridy = 0;
						c.anchor = GridBagConstraints.CENTER;
						
						text1 = new JTextField();
						text1.setText(a[1]+"\\"+a[0]);
						
						try
						{
							BufferedImage myPicture = ImageIO.read(new File(text1.getText()));
							JLabel picLabel = new JLabel(new ImageIcon(myPicture));
							panel.add(picLabel, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);
							
							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									developer();
								}
							});
						}
						catch(IOException ex)
						{
							JLabel1 = new JLabel("Sorry no Image to display.");
							panel.add(JLabel1, c);
							c.gridy++;
							
							JButton jbtn = new JButton("OK");
							panel.add(jbtn, c);
							
							jbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent ae)
								{
									developer();
								}
							});
						}						
					}
				});	

				jbtn1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						developer();
					}
				});
			}
		});
		
		jbtn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				ImageEditor.main(new String[0]);
			}
		});
		
		jbtn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				welcome();
			}
		});
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				new project().welcome();
			}
		});
	}
}