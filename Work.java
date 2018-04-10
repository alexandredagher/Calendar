/** 
 *	  Author:  Alexandre Dagher
 *    Date: November 27, 2017
 *    Section: CST8130
 *    Purpose: My work object, which is used to create my work events and store values of them
 *                                            
 *    Methods:  constructor(int, OurDate, OurTime, String)- used to create the work Event              
 *              
 */
public class Work extends Events {
	
	private String nameOfWork;
	private int numbOfHours;

	public Work(int type, OurDate date, OurTime time, String description, String nameOfWork, int numbOfHours) {
		super(3, date, time, description);
		this.nameOfWork= nameOfWork;
		this.numbOfHours = numbOfHours;
		}
	
	@Override
	public String toString() {
		return super.toString() + " " + nameOfWork + " " + numbOfHours;
	}
}

