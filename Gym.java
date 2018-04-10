/**
 * Author: Alexandre Dagher 
 * Date: November 27, 2017 
 * Section: CST8130 
 * Purpose: My gym Object, used to create my Gym object and store values of them
 * 
 * Methods: constructor(int, OurDate, OurTime, String)- used to create the Gym
 * Event
 * 
 */
public class Gym extends Events {

	public Gym(int type, OurDate date, OurTime time, String description) {
		super(4, date, time, description);
	}
}
