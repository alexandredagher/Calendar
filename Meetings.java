/**
 * Author: Alexandre Dagher Date: November 27, 2017 Section: CST8130 Purpose: My
 * meetings Object, used to store meetings extra inputs
 * 
 * Data fields: String:location - used to store the value of location in meeting
 * Events
 * 
 * Methods: constructor - used to create a Meetings object which is a child of
 * Events toString:String - calls the super toString method and adds the added
 * values of Meetings
 */
public class Meetings extends Events {

	private String location;

	public Meetings(int type, OurDate date, OurTime time, String Desctiption, String location) {
		super(type, date, time, Desctiption);
		this.location = location;
	}

	@Override
	public String toString() {
		return super.toString() + " " + location;
	}

}
