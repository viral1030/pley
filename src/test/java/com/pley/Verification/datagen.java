package com.pley.Verification;

import java.util.Random;

public class datagen {

	
	public int randomnagative()
	{
		 int j;
		 int min = -350;
		  int max = 250;
		  Random r = new Random();
		 
		  return r.nextInt(max - min + 1) + min;
			  
	}
	
	public int randompositive()
	{
		  Random r = new Random();
		 
		  return r.nextInt(350);
			  
	}
	//TC 20
	public int randompositivelowIncome()
	{
		  Random r = new Random();
		 
		  return r.nextInt(20);
			  
	}
	
	//TC 21
	public int randomnagativelowcredite()
	{
		 int j;
		 int min = -400;
		  int max = -300;
		  Random r = new Random();
		 
		  return r.nextInt(max - min + 1) + min;
			  
	}
	
	//TC 22
	public int randomnagativelowrate()
	{
		 int j;
		 int min = -400;
		  int max = -300;
		  Random r = new Random();
		 
		  return r.nextInt(max - min + 1) + min;
			  
	}
	
	public int randomnagativeexcectcredit()
	{
		 int j;
		 int min = -100;
		  int max = -90;
		  Random r = new Random();
		 
		  return r.nextInt(max - min + 1) + min;
			  
	}
}
