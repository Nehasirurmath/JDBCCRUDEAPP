package com.csi.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.csi.service.ServiceImpl;

public class CrudApp {
	//public static void insert()
	public static void main(String[] args) {
		System.out.println("**********WELCOME***************");
		ServiceImpl serviceImpl=new ServiceImpl();
		boolean isRunning=true;
		while(isRunning)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("\n Enter ur choice \n1. insert \n2. show \n3.update \n 4.delete");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1: {
				serviceImpl.insert();
				break;
			}
			case 2:
			{
				serviceImpl.show();
				break;
			}
			case 3:
			{
				serviceImpl.update();
				break;
			}
			case 4:
			{
				serviceImpl.delete();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
	}

}
