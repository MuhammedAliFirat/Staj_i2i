package com.HazelcastHomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;



public class OracleInsert {
	
	
	public static void main(String[] args) throws InterruptedException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","system","oracle");
			Statement statement = connection.createStatement();
			
			Random random = new Random();
			long startTime= System.nanoTime();
			
			for(int i=0;i<20000;i++) {
				statement.executeUpdate("Insert into  HR.test values("+i+","+random.nextInt(20000)+")");
			}
			long endTime = System.nanoTime()-startTime;
			double second =(double)endTime/1000000000.0;
			System.out.print("Oracle ýnsert time = " +second);
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}
/*package com.HazelcastHomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;



public class OracleInsert {
	
	
	public static void main(String[] args) throws InterruptedException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:49161:xe","system","oracle");
			Statement statement = connection.createStatement();
			
			Random random = new Random();
			long startTime= System.nanoTime();
			
			for(int i=0;i<100000;i++) {
				statement.executeUpdate("Insert into  HR.test values("+i+","+random.nextInt(20000)+")");
			}
			long endTime = System.nanoTime()-startTime;
			double second =(double)endTime/100000000.0;
			System.out.print("Oracle ýnsert time = " +second);
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}
*/