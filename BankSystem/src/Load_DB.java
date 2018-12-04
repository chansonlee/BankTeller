import java.sql.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class Load_DB{

	public static void main (String [] args) {
		DatabaseConnection db = new DatabaseConnection(); 
		
		fill_accounts_table("input_csv/accounts.csv", db);
	}
	
	public static void fill_accounts_table(String filename, DatabaseConnection db) {
		String line="";
	      
	      try (BufferedReader buff = new BufferedReader(new FileReader(filename))){
	    	  while((line = buff.readLine()) != null) {
	    		  String[] cols = line.split(",");
	    		  
	    		  String branch_name = cols[0];
	    		  String account_id = cols[1];
	    		  String account_type = cols[2];
	    		  String balance = cols[3];
	    		  String interest_rate = cols[4];
	    		  String account_status = cols[5];
	    		  String closed_date = cols[6];
	    		  String current_month_interest_added = cols[7];
	    		  String pocket_monthly_fee = cols[8];
	    		  String pocket_linked_account_id = cols[9];
	    		  
//	    		  String query = "INSERT INTO Account (branch_name, account_id, account_type, balance, "
//	    		  		+ "interest_rate, account_status, closed_date, current_month_interest_added, pocket_monthly_fee,"
//	    		  		+ "pocket_linked_account) VALUES ('" + branch_name + "','" + account_id + "','" + account_type + "'," 
//	    		  		+ balance + "," + interest_rate + ",'" + account_status + "'," + closed_date + ",'" + 
//	    		  		current_month_interest_added + "'," + pocket_monthly_fee + ",'" + pocket_linked_account_id + ") ";
	    		  
	    		  
	    		  String query = "INSERT INTO Account (branch_name, account_id, account_type, balance, "
		    		  		+ "interest_rate, account_status, closed_date, current_month_interest_added, pocket_monthly_fee,"
		    		  		+ "pocket_linked_account_id) VALUES ('test_branch','888','student_checking', 423523.50, 1.02, 'open', NULL, 'no', 0.0, NULL)";
	    		  
	    		  db.query(query);
	    	  }
	      }
	      catch (IOException e) {
	    	  e.printStackTrace();
	      }
	}

	
	
}