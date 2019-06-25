package com.ofaul.business.ui.forms.login.view;

import org.springframework.stereotype.Component;

import com.ofaul.business.util.Borders;
import com.ofaul.business.util.ConstMessagesEN;
import com.ofaul.business.util.LookAndFeelUtils;

import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class LoginFrame extends JFrame {

	private JLabel usernameLabel; 
	private JLabel passwordLabel; 
	private JLabel jLabel3;
	private JTextField usernameField; 
	private JPasswordField passwordField; 
	private JButton loginButton; 
	private JButton registrationButton; 
	private JPanel loginPanel;
	private JPanel contentPane;
	
    private JButton formsBtn;
    private JButton reportsBtn;

    public LoginFrame() {
		super();
		setFrameUp();
		initializeComponent();
    }

    private void setFrameUp() {
		contentPane = (JPanel)this.getContentPane(); 
		contentPane.setLayout(null); 
		contentPane.setBackground(new Color(48,213,200));

        setTitle(ConstMessagesEN.Labels.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setResizable(false);
    }

    private void initComponents() {
        formsBtn = new JButton(ConstMessagesEN.Labels.FORMS);
        reportsBtn = new JButton(ConstMessagesEN.Labels.REPORTS);

        add(formsBtn);
        add(reportsBtn);
    }

    public JButton getFormsBtn() {
        return formsBtn;
    }

    public JButton getReportsBtn() {
        return reportsBtn;
    }
    
	private void initializeComponent() 
	{ 
		usernameLabel = new JLabel(); 
		passwordLabel = new JLabel(); 
//		jLabel3 = new JLabel();
		usernameField = new JTextField(); 
		passwordField = new JPasswordField(); 

		loginButton = new JButton(); 
		registrationButton = new JButton(); 
		loginPanel = new JPanel();
		addComponent(contentPane, loginPanel, 0,0,400,400);
		
//		addComponent(contentPane, jLabel3, 100, 150, 650, 330);

		usernameLabel.setText(ConstMessagesEN.Labels.USERNAM1E);
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Forte",Font.BOLD,20));

		passwordLabel.setText(ConstMessagesEN.Labels.PASSWORD); 
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Forte",Font.BOLD,20));
		
//		jLabel3.setIcon(new ImageIcon("E:/ProjectModule/images/one-edit.jpg"));

		usernameField.setBackground(new Color(255, 255,255)); 

		passwordField.setBackground(new Color(255,255,255)); 


		loginButton.setText("LOGIN"); 
		loginButton.setFont(new Font("Forte",Font.BOLD,14));
		loginButton.addActionListener((ActionEvent e) -> {
			loginHandler(e);
		});

		registrationButton.setText("NEW USER"); 
		registrationButton.setFont(new Font("Forte",Font.BOLD,14));
		registrationButton.addActionListener((ActionEvent e) -> {
			registrationHandler(e);
		});

		loginPanel.setBackground(new Color(56,56,56));
		loginPanel.setLayout(null);
		loginPanel.add(usernameLabel);
		usernameLabel.setBounds(50,100,150,20);
		loginPanel.add(usernameField);
		usernameField.setBounds(250, 100, 120, 20);
		loginPanel.add(passwordLabel);
		passwordLabel.setBounds(50, 150, 150, 20);
		loginPanel.add(passwordField);
		passwordField.setBounds(250, 150, 120, 20);
		loginPanel.add(loginButton);
		loginButton.setBounds(150, 200, 80, 30);
		loginPanel.add(registrationButton);
		registrationButton.setBounds(130, 250, 120, 30);
		loginPanel.setLocation(850, 100);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
	}


	private void addComponent(Container container,java.awt.Component c,int x,int y,int width,int height) 
	{  
		c.setBounds(x,y,width,height); 
		container.add(c); 
	} 
	
	private void registrationHandler(ActionEvent e)
	{
//		new SignUp();
		this.setVisible(false);
	}
	
	private void loginHandler(ActionEvent e)
	{     
		try{
			String u=usernameField.getText();
			String p=passwordField.getText();
			String usr= null;
			String pwd= null;
			//System.out.println("try");
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/emp";
			String uname="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,uname,pass);
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("Select * From empDet where USERNAME='"+usernameField.getText()+"'");
			while(rs.next())
			{
				usr=rs.getString("USERNAME");
				pwd=rs.getString("PASSWORD");
			}
			//System.out.println(u);
			//System.out.println(usr);
			//System.out.println(p);
			//System.out.println(pwd);
			if(u.equals(usr)&&p.equals(pwd))
		    {   
				String s=usernameField.getText();
//		    	new Profile(s);
		    }
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Invalid data");
			}
			con.close();
			//System.out.println("try close");
			}
		    
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		
	}

}
