package com.HazelcastHomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public class OracleSelect {
	public static void main(String[] args) throws InterruptedException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","system","oracle");
			Statement statement = connection.createStatement();
			
			int number;
			long startTime = System.nanoTime();
			for(int i=0;i<100000;i++) {
				ResultSet r = statement.executeQuery("Select COLUMN2 from HR.test where COLUMN1 ="+i+" ");
				r.next();
				number= r.getInt("COLUMN2");
			}
			long endTime = System.nanoTime()-startTime;
			double second =(double)endTime/1000000000.0;
			System.out.print("Oracle 100000 select Time = " +second);
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}


