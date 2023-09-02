package com.scsi.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl implements Dao {
	Connection connection = null;

	public DaoImpl() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "neha@2000");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

		try {
			String q = "insert into user(empid,empname,empsalary) values(?,?,?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(q);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("enter id");
			int empId = Integer.parseInt(bufferedReader.readLine());

			System.out.println("enter name");
			String empName = bufferedReader.readLine();

			System.out.println("enter Salary");
			double empSalary = Double.parseDouble(bufferedReader.readLine());   

			preparedStatement.setInt(1, empId);
			preparedStatement.setString(2, empName);
			preparedStatement.setDouble(3, empSalary);
			preparedStatement.executeUpdate();
			System.out.println("inserted sucessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		try {
			String q = "select * from user ";
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			

			
			ResultSet resultSet=preparedStatement.executeQuery(q);
			while(resultSet.next())
			{
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				double salary=resultSet.getDouble(3);
				System.out.println(id+" "+name+" "+salary);
			}
			
			//preparedStatement.execute();
			//System.out.println("Updated sucessfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		try {
			String q = "update user set empname=? where empid=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(q);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			

			System.out.println("enter name");
			String empName = bufferedReader.readLine();
			
			System.out.println("enter id");
			int empId = Integer.parseInt(bufferedReader.readLine());

			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, empId);
			// preparedStatement.setDouble(3, empSalary);
			preparedStatement.executeUpdate();
			System.out.println("Updated sucessfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		try {
			String q = "delete from user where empid=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(q);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("enter id");
			int empId = Integer.parseInt(bufferedReader.readLine());

			

			preparedStatement.setInt(1, empId);
			
			preparedStatement.executeUpdate();
			System.out.println("deleted sucessfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
