/** 
 *	  Author:  Alexandre Dagher
 *    Date: November 27, 2017
 *    Section: CST8130
 *    Purpose: My Social object, which is used to create my social events and store values of them
 *                                            
 *    Methods:  constructor(int, OurDate, OurTime, String)- used to create the Social Event              
 *              
 */
public class Social extends Events{

	public Social(int type, OurDate date, OurTime time, String description){
		super(5, date, time, description);
	}

}
