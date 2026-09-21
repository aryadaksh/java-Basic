package com.threadusing;

public class Task 
{
	public /* synchronized */ void printNumbers()
	{
		for(int i = 0; i< 10; i++)
		{
			System.out.println("  Printing :"+i+" ["+Thread.currentThread().getName()+"]");
		}
	}

}


