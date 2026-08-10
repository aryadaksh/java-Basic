package com.exception2.multiplecatchblock;

public class ExceptionHierechry {

	public static void main(String[] args) {

		try {

			int value = 5 / 0;
			//***********************correct Flow of Exception***********************
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		//***********************Incorrect Flow of Exception**************************
		
//		catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		catch(RuntimeException e) {
//			e.printStackTrace();
//		}
//		catch(ArithmeticException e) {
//			e.printStackTrace();
//		}
	}

}
