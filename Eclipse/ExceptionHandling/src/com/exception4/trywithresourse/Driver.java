package com.exception4.trywithresourse;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Driver {

	public static void main(String[] args) {

		/*
		 * this is try with Resources in this we don't need to Write finally cuz the in
		 * try smallBreaket() is Written is must implemented closeable or autoclosable
		 */

		// Still we can have finally with try and Resourse
		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Dak.ary"));) {

		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException | IOException exceptionObject) {

			exceptionObject.printStackTrace();
		}
		// -> Should maintain Hierchery if parent came like RuntimeException | IOException then child is not allowed like FileNotFoundException | ArrayIndexOfOutOfBoundException
//		catch (FileNotFoundException | IOException e) {
//			
//					e.printStackTrace();
//				} 
		/*
		 * we can write multiple catch block |
		 */

//		catch (FileNotFoundException | IOException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
	}

}
