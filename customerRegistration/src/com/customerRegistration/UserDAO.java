package com.customerRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;



public class UserDAO {
	Connection con;
	
	public UserDAO(Connection con) {
		this.con = con;
	}
public  boolean registerUser(User user) {
	
		
		
		
		boolean flag = false;
		try {
		
		
		
		String query = "INSERT INTO party(firstName,lastName,address,zip,city,state,country,phone) VALUES(?,?,?,?,?,?,?,?)";
		
		//Prepared Statement
		PreparedStatement preparedStatement =this.con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		
		// Set values of parameters
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3, user.getAddress());
		preparedStatement.setString(4, user.getZip());
		preparedStatement.setString(5, user.getCity());
		preparedStatement.setString(6, user.getState());
		preparedStatement.setString(7, user.getCountry());
		preparedStatement.setString(8, user.getPhone());
		
		//execute query
	
		int rowAffected = preparedStatement.executeUpdate();
		int partyID = 0;
		ResultSet resultSet;
        if(rowAffected == 1)
        {
            // get candidate id
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next())
                partyID = resultSet.getInt(1);
            query = "INSERT INTO userlogin(userLoginId,password,partyid) VALUES(?,?,?)";
            PreparedStatement preparedStatement2 = con.prepareStatement(query);
            preparedStatement2.setString(1, user.getUserID());
    		preparedStatement2.setString(2, user.getPassword());
    		preparedStatement2.setInt(3, partyID);
    		preparedStatement2.executeUpdate();
    		flag = true;
    		//
        }
		
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
}
