package com.exception3.checkedexception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


// Checked And unchecked exception handle its runtime
// but for checked exception complier forced us to handle it

public class CheckedExceptionExample {
	
	

	
	void fileNotFoundException() {
		try {
		FileInputStream fos = new FileInputStream("New1.txt");
		}
		catch(FileNotFoundException exceptionObject) {
			exceptionObject.printStackTrace();;
		}
		
		
		//iOException(fos);
	}
	
	public void iOException() {
//		try {
//	//	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fds.arya"));
//		}catch(IOException e) {
//			
//		}
		
	}
	
	void classCastException() {
		// static class loading 
		CheckedExceptionExample cee = new CheckedExceptionExample();
		
		//Dyanmaic class loading
		try {
			Class.forName("com.exception3.checkedexception.DoSOmething");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CheckedExceptionExample cee = new CheckedExceptionExample();
		cee.fileNotFoundException();
	}

}
