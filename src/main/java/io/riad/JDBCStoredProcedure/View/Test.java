package io.riad.JDBCStoredProcedure.View;

import java.sql.SQLException;

import io.riad.JDBCStoredProcedure.DBUtil.DBOperation;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Boolean b=DBOperation.showAllCustomerName();

		//DBOperation.showAllBranchNameFromLoan();
		//DBOperation.showBranchInformation();
		//DBOperation.findAccountNumberAccordingToSalaryInput(700);
		
		//DBOperation.findAccountNumberAndBalance(100);
		
		//DBOperation.displayBranchNameAndAsset();
		
		//DBOperation.findAllBranchWithAsset(1000000,4000000);
		//DBOperation.showNameAccountNumberAndBalanceOfAllCustomers();
		
		DBOperation.showNameAccountNumberAndBalanceOfAllCustomersWithBalanceOf(1000);
		
	}

}
