 package Project_OP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Project_OP.register;
import Project_OP.data_fetched;

@SuppressWarnings("serial")
class Frame extends JFrame implements ActionListener{
	
	Container c;
	JLabel label1,label2;
	JTextField user;
	JPasswordField password;
	JButton btn,btn1;
	
	Frame()
	{
		setTitle("Login Form");
		setSize(350,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setLayout(null);
		
		
		label1 = new JLabel("User ID");
		label2 = new JLabel("Password");
		
		label1.setBounds(10,50,100,20);
		label2.setBounds(10,100,100,20);
		
		c.add(label1);
		c.add(label2);
		
		user = new JTextField();
		user.setBounds(120,50,120,20);
		c.add(user);
		user.setFont(new Font("Arial",Font.PLAIN,15));

		
		password = new JPasswordField();
		password.setBounds(120,100,120,20);
		c.add(password);
		password.setFont(new Font("Arial",Font.BOLD,25));
		
		btn = new JButton("Login");
		btn.setBounds(50,150,110,30);
		c.add(btn);
		
		btn1 = new JButton("Sign Up");
		btn1.setBounds(190,150,110,30);
		c.add(btn1);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
		setVisible(true);             
	}
	
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == btn) {
			
			try {

				
				String url = "jdbc:mysql://localhost:3306/cooldude?autoReconnect=true&useSSL=false";
				String uname ="root";
				String pass ="password@1234";
				String query =  "select userID,userPASS from user_form where userID = '"+user.getText()+"' and userPASS = '"+ password.getText() + "'" ;
				
				
				
				Class.forName("com.mysql.jdbc.Driver");
			
				Connection con = DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				// To check whether the credentials are correct or not
				if(rs.isBeforeFirst()) {
					JOptionPane.showMessageDialog(this, "Login Successful ", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					
					this.dispose();

					
					register ob = new register();
					ob.submit.setVisible(false);
					ob.logout.setEnabled(true);
					
					//fetching data to show after login page
					ob.head.setText("User Details");
					ob.head.setBounds(190,14,400,50);
					ob.term.setSelected(true);
					ob.term.setEnabled(false);
					
					data_fetched ak = new data_fetched();

					ob.us = user.getText();
					ob.ps = password.getText();
					ak.us = user.getText();
					ak.ps = password.getText();
					
					
					ob.t1.setText(ak.fname);
					ob.t2.setText(ak.lname);
					ob.t3.setText(ak.mob);
					ob.ta1.setText(ak.fname);
					ob.t4.setText(ak.team_name);
//					if(ak.gen == "Male") {ob.male.setSelected(true);}
//					else if(ak.gen == "Female"){ob.female.setSelected(true);}
//					else if(ak.gen == "Other")ob.other.setSelected(true);
//					ob.exp.setSelectedItem(ak.Exp);
					
					

					ob.update.setEnabled(true);
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Login Failed !\nInvalid User ID or password !", "INVALID INPUT", JOptionPane.ERROR_MESSAGE);

				}
				
				st.close();
				con.close();	
				
		}catch (Exception E) {
			E.printStackTrace();
			}

			
		}
		
		else if (e.getSource() == btn1){
			
			this.dispose();
			register ob = new register();
			ob.update.setEnabled(false);
			
		}
		
	}
	
}



public class LoginPage {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);

	}

}
