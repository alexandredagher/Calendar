/**
 * Author: Alexandre Dagher Date: November 27, 2017 Section: CST8130 Purpose: My
 * Event objects, which is used to create my events and retrive information on
 * them.
 * 
 * Data fields: type:int - used to store the type of Event description: String -
 * used to hold the description of what this event is date: OurDate - a object
 * used to store (hour, minute ) of the Event object time: OurTime - a object
 * used to store (year, month, day) of the Event object
 * 
 * Methods: constructor(int, OurDate, OurTime, String)- used to store the values
 * that correspond to each event type toString:String - returns values that are
 * similar to all events to be printed getDate:OurDate- used to return the
 * OurDate object getTime:OurTime - used to return the OurTime object
 * 
 */
public class Events {
	
	protected int type;
	protected String description;
	protected OurDate date;
	protected OurTime time;
	
	public Events(int type, OurDate date, OurTime time, String description ) {
		this.type = type;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return date.toString() + time.toString() + description;
	}
	
	public OurDate getDate() {
		return date;
	}
	
	public OurTime getTime() {
		return time;
	}

}
