/** 
 *	  Author:  Alexandre Dagher
 *    Date: November 27, 2017
 *    Section: CST8130
 *    Purpose: My School object, which is used to create my school events and store values of them
 *                              
 *    Methods:  constructor(int, OurDate, OurTime, String)- used to create the School Events   
 */
public class School extends Events{

	public School(int type, OurDate date, OurTime time, String description){
		super(2, date, time, description);
	}
}

