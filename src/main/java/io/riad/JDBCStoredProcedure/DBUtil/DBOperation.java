package io.riad.JDBCStoredProcedure.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.riad.JDBCStoredProcedure.Model.Account;
import io.riad.JDBCStoredProcedure.Model.Borrower;
import io.riad.JDBCStoredProcedure.Model.Branch;
import io.riad.JDBCStoredProcedure.Model.Customer;
import io.riad.JDBCStoredProcedure.Model.Depositor;
import io.riad.JDBCStoredProcedure.Model.Loan;



public class DBOperation {
	
	
	public static boolean showAllCustomerName() throws SQLException {
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		String sql = "a_t1_allCustomerName";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		
		Customer customer=new Customer();
		
		int check=0;
		while (result.next()){
		   
			customer.setCustomerName(result.getString(1));
			
			System.out.println(customer.getCustomerName());
			//System.out.println("\n");
			check++;
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;
	}
	
	
	
	//#############################################################################
	
	
	
	public static boolean showAllBranchNameFromLoan() throws SQLException {
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		String sql = "a_t2_allBranchName";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		Loan loan=new Loan();
		
		int check=0;
		while (result.next()){
		   loan.setBranchName(result.getString(1));
			System.out.println(loan.getBranchName());
			check++;
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;
		
	}
	
	

	//#############################################################################
	
	
	
	public static boolean showBranchInformation() throws SQLException  {
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		String sql = "a_t3_fullBranchDetails";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		
		Branch branch= new Branch();
		
		int check=0;
		while (result.next()){
		   
			branch.setBranchName(result.getString(1));
			branch.setBranchCity(result.getString(2));
			branch.setAssets(result.getInt(3));
			
			System.out.println(branch);
			check++;
			
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;

	}
	
	
	//#############################################################################
	
	
	public static boolean findAccountNumberAccordingToSalaryInput(int balance) throws SQLException {
		
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		String sql = "a_t4_acNumAccordingToSalaryInput @balance="+balance+"";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		
		Account account=new Account();
		
		int check=0;
		while (result.next()){
		   
			account.setAccountNumber(result.getString(1));
			System.out.println(account.getAccountNumber());
			check++;
			
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;

		
	}
	
	//#############################################################################
	
	
	public static boolean findAccountNumberAndBalance(int balance) throws SQLException {
		
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		
		String sql = "a_t5_acNumBalanceFromBringtonAccordingToBalanceInput @balance="+balance+"";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		Account account=new Account();
		
		int check=0;
		while (result.next()){
		   
			account.setAccountNumber(result.getString(1));
			account.setBalance(result.getInt(2));
			System.out.println(account.getAccountNumber()+"\t"+account.getBalance());
			check++;
			
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;

		
	}
	
	
	
	//#############################################################################
	
	public static boolean displayBranchNameAndAsset() throws SQLException {
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		
		String sql = "a_t6_bracnchNameAssetRenameColumnNameOfAssetAsAssetsInThousands";
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		Branch branch=new Branch();
		
		int check=0;
		while (result.next()){
		   
			branch.setBranchName(result.getString(1));
			branch.setAssets(result.getInt(2));
			System.out.println(branch.getBranchName()+"\t"+branch.getAssets());
			check++;
			
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;

		
	}
	
	

	//#############################################################################
	
	public static boolean findAllBranchWithAsset(int min,int max) throws SQLException {
		
		DBConnection.getInstance();
		Connection con=DBConnection.getConnection();
		
		String sql = "a_t7_bracnchNameWithAssetBetween1M4M @val1="+min+",@val2="+max+"";
		
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(sql);
		Branch branch=new Branch();
		
		int check=0;
		while (result.next()){
		   
			branch.setBranchName(result.getString(1));
			System.out.println(branch.getBranchName());
			check++;
			
		}
		con.close();
		
		if (check>0) 
			return true;
		else 
			return false;

		
	}
	
	
	
	//#############################################################################
		
		public static boolean  showNameAccountNumberAndBalanceOfAllCustomers() throws SQLException {
			
			DBConnection.getInstance();
			Connection con=DBConnection.getConnection();
			
			String sql = "a_t8_customerNameAcNumBalanceAccordingTOAccount";
			
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			Depositor depositor=new Depositor();
			Account account=new Account();
			
			int check=0;
			while (result.next()){
			   
				depositor.setCustomerName(result.getString(1));
				account.setAccountNumber(result.getString(2));
				account.setBalance(result.getInt(3));
				
				System.out.println(depositor.getCustomerName()+"\t"+account.getAccountNumber()+"\t"+account.getBalance());
				
				check++;
				
			}
			con.close();
			
			if (check>0) 
				return true;
			else 
				return false;

			
		}
		
		
		//#############################################################################
		
				public static boolean  showNameAccountNumberAndBalanceOfAllCustomersWithBalanceOf(int balance) throws SQLException {
					
					DBConnection.getInstance();
					Connection con=DBConnection.getConnection();
					
					String sql = "a_t9_customerNameAcNumBalanceAccordingTOAccountBalanceInput @userinput="+balance+"";
					
					Statement statement = con.createStatement();
					ResultSet result = statement.executeQuery(sql);
					Depositor depositor=new Depositor();
					Account account=new Account();
					
					int check=0;
					while (result.next()){
					   
						depositor.setCustomerName(result.getString(1));
						account.setAccountNumber(result.getString(2));
						account.setBalance(result.getInt(3));
						
						System.out.println(depositor.getCustomerName()+"\t"+account.getAccountNumber()+"\t"+account.getBalance());
						
						check++;
						
					}
					con.close();
					
					if (check>0) 
						return true;
					else 
						return false;

					
				}
		

}
