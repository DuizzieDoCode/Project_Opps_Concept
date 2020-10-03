package Project_OP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Project_OP.Frame;

class register extends JFrame implements ActionListener{
	
	
	JLabel head,l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4;
	JRadioButton male,female,other ;
	JComboBox date,month,year,exp;
	JTextArea ta1,screen;
	JButton submit,update,logout;
	JCheckBox term;
	String us = "",ps = "";
	
	register()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,480);
		setLocationRelativeTo(null);
		setTitle("Registration Form");
		setResizable(false);
		
		Container c = getContentPane();
		c.setLayout(null);

		head = new JLabel("User Registration Form");
		head.setBounds(98,14,400,50);
		c.add(head);
		head.setFont(new Font("Bodoni MT Black",Font.BOLD,30));
		head.setForeground(Color.MAGENTA);
		
		l1 = new JLabel("First Name");
		l1.setBounds(20,90,80,20);
		c.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(130,90,150,20);
		c.add(t1);
		
		l2 = new JLabel("Last Name");
		l2.setBounds(330,90,80,20);
		c.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(410,90,150,20);
		c.add(t2);
		
		l3 = new JLabel("Mobile Number");
		l3.setBounds(20,130,90,20);
		c.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(130,130,150,20);
		c.add(t3);
		
		l4 = new JLabel("Achievements");
		l4.setBounds(20,170,90,20);
		c.add(l4);
		
		ta1 = new JTextArea();
		ta1.setBounds(130,170,150,66);
		c.add(ta1);
		ta1.setLineWrap(true);
		
		l5 = new JLabel("Gender");
		l5.setBounds(20,245,60,20);
		c.add(l5);
		
		male = new JRadioButton("Male");
		male.setBounds(100,245,55,20);
		c.add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(160,245,70,20);
		c.add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(230,245,60,20);
		c.add(other);
		
		ButtonGroup gen = new ButtonGroup();
		gen.add(male);
		gen.add(female);
		gen.add(other);
		male.setSelected(true);
		
		l4 = new JLabel("D.O.B");
		l4.setBounds(330,245,60,20);
		c.add(l4);
		
		String[] days = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] months = {"Jan","Feb","Mar","Apr","May","June","Jul","Aug","Sept","Oct","Nov","Dec"};
		String[] years = {"2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991"};
		
		
		date = new JComboBox(days);
		month = new JComboBox(months);
		year = new JComboBox(years);
		
		date.setBounds(380,245,50,20);
		month.setBounds(438,245,60,20);
		year.setBounds(505,245,60,20);
		
		c.add(date);
		c.add(month);
		c.add(year);

		l5 = new JLabel("Experience Level");
		l5.setBounds(20,280,150,20);
		c.add(l5);
		
		String[] EXP = {"Fundamental","Novice","Intermediate","Advanced","Expert"};
		exp = new JComboBox(EXP);
		exp.setBounds(150,280,120,20);
		c.add(exp);
		
		l6 = new JLabel("TEAM Name");
		l6.setBounds(325,280,150,20);
		c.add(l6);
		
		t4 = new JTextField();
		t4.setBounds(410,280,150,20);
		c.add(t4);
		

		term = new JCheckBox("I accept the Terms and Conditons.");
		term.setBounds(30,320,250,30);
		c.add(term);
		
		submit = new JButton("SUBMIT");
		submit.setBounds(90,380,100,30);
		c.add(submit);
		
		update = new JButton("UPDATE");
		update.setBounds(245,380,100,30);
		c.add(update);
		
		logout = new JButton("LOG OUT");
		logout.setBounds(400,380,100,30);
		c.add(logout);
		logout.setEnabled(false);

		
		
		submit.addActionListener(this);
		update.addActionListener(this);
		logout.addActionListener(this);

		update.setEnabled(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			if(term.isSelected()) {
				
				String fname= "",lname= "",mob= "",achv= "",gen= "",dob= "",Exp= "",team_name= "",userID,userPASS;
				fname = t1.getText();
				lname = t2.getText();
				mob = t3.getText();
				achv = ta1.getText();
				dob = date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
				Exp = (String) exp.getSelectedItem();
				team_name = t4.getText();
				if(male.isSelected()) {gen = "Male";}
				else if(female.isSelected()) {gen = "Female";}
				else {gen = "Other";}
				
				if(fname.isEmpty() || lname.isEmpty() || mob.isEmpty() || achv.isEmpty() || dob.isEmpty() || Exp.isEmpty() || team_name.isEmpty() || gen.isEmpty() ) {
					JOptionPane.showMessageDialog(this, "All Fields are Necessary\nPlease fill all the fields ", "Warning", JOptionPane.ERROR_MESSAGE);
					
				}
				else
				{
					int sel = JOptionPane.showConfirmDialog(this,"Are you sure?","Confirm Dailogue",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					if(sel == JOptionPane.YES_OPTION) {
					
				
				try {

					
					String url = "jdbc:mysql://localhost:3306/cooldude?autoReconnect=true&useSSL=false";
					String uname ="root";
					String pass ="password@1234";
					String query =  "insert into cooldude.user_form(first_name,last_name,mobile,achv,dob,gender,exp,team_name) values('" + fname + "','" + lname + "','" + mob + "','" + achv + "','" + dob + "','" + gen + "','" + Exp + "','" + team_name + "')";
					String quer1 = "select ID from cooldude.user_form where first_name = '"+fname+"' and last_name = '"+lname+"'" ;
					
					Class.forName("com.mysql.jdbc.Driver");
				
					Connection con = DriverManager.getConnection(url,uname,pass);
					Statement st = con.createStatement();
					int count = st.executeUpdate(query);
					ResultSet rs = st.executeQuery(quer1);
					rs.next();
					userID = rs.getString("ID") + fname;
					userPASS = dob ;
					
					String quer2 = "update cooldude.user_form set userID = '"+userID+"', userPASS = '"+userPASS+"' WHERE ID = "+rs.getString("ID");
					int count1 = st.executeUpdate(quer2);
					
					st.close();
					con.close();
				
					JOptionPane.showMessageDialog(this, "Registration Successful", "Successful", JOptionPane.INFORMATION_MESSAGE);
					
					JOptionPane.showMessageDialog(this, "Please note your credentials! \nYour Username : "+ userID +"\nYour User Password :"+userPASS, "Credentials", JOptionPane.INFORMATION_MESSAGE);
					
					ta1.setEditable(false);
					update.setEnabled(true);
					logout.setEnabled(true);
					submit.setVisible(false);
					
			}catch (Exception E) {
				E.printStackTrace();
				}
				
					}
					else if(sel == JOptionPane.NO_OPTION) { }

				
				
			}
			}
			else {
				JOptionPane.showMessageDialog(this, "Please accept our Terms and Conditions", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == update) {
			

			String fname= "",lname= "",mob= "",achv= "",gen= "",dob= "",Exp= "",team_name= "";
			fname = t1.getText();
			lname = t2.getText();
			mob = t3.getText();
			achv = ta1.getText();
			dob = date.getSelectedItem() + "/" + month.getSelectedItem() + "/" + year.getSelectedItem();
			Exp = (String) exp.getSelectedItem();
			team_name = t4.getText();
			if(male.isSelected()) {gen = "Male";}
			else if(female.isSelected()) {gen = "Female";}
			else {gen = "Other";}
			
			String url = "jdbc:mysql://localhost:3306/cooldude?autoReconnect=true&useSSL=false";
			String uname ="root";
			String pass ="password@1234";
			
			String quer2 = "update cooldude.user_form set first_name = '"+fname+"', last_name = '"+lname+"' , mobile = '"+mob +"' , achv = '"+achv +"' , exp = '"+Exp +"' , dob = '"+dob +"' , team_name = '"+ team_name +"' ,  gender = '"+gen +"'  WHERE  userID = '"+us+"' and userPASS = '"+ps+"'";
			try {
				Connection con = DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				int c = st.executeUpdate(quer2);
				JOptionPane.showMessageDialog(this, "Your Data has been updated !", "UPDATED", JOptionPane.INFORMATION_MESSAGE);

				
				
			} catch (SQLException ea) {
				ea.printStackTrace();
			}
		}
		if(e.getSource() == logout)
		{
			this.dispose();
			JOptionPane.showMessageDialog(this, "You have successfully Logged out", "Logged Out", JOptionPane.INFORMATION_MESSAGE);

			Frame aa = new Frame();
		}

	}

}


public class Registration_form_user {

	public static void main(String[] args) {
		register f = new register();
	}

}
