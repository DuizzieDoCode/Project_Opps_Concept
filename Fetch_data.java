package Project_OP;

import java.sql.*;

class data_fetched{
	public String us = "user",ps = "1234";
	String fname= "",lname= "",mob= "",achv= "",gen= "",dob= "",Exp= "",team_name= "",userID,userPASS;
	
	data_fetched(){
	
			
			String url = "jdbc:mysql://localhost:3306/cooldude?autoReconnect=true&useSSL=false";
			String uname ="root";
			String pass ="password@1234";
			String querf = "select * from user_form where userID = '"+us+"' and userPASS = '"+ ps + "'";
			try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(querf);
			
			rs.next();
			fname= rs.getString(2);
			lname= rs.getString(3);
			mob= rs.getString(4);
			achv= rs.getString(5);
			gen= rs.getString(7);
			dob= rs.getString(6);
			Exp= rs.getString(8);
			team_name= rs.getString(11);
			
			
			
		}catch (Exception E) {
			E.printStackTrace();
			}	
		
	}
}

public class Fetch_data {

	public static void main(String[] args) {
		
		data_fetched obj = new data_fetched();

	}

}
