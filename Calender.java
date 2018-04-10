
/** 
 *	  Author:  Alexandre Dagher
 *    Date: November 27, 2017
 *    Section: CST8130
 *    Purpose: Handle my events/arrayList and all methods that deal with my events
 *   
 *	  Data fields: ArrayList<Events>: list - used to the all my objects of events
 *                                            
 *    Methods:  constructor- used to create my arrayList
 *              createEvent (int, OurDate, OurTime, String, String, int, String) - used to create my object of event and store it inside the arrayList
 *              sort- used to sort my arrayList of Events using insertion sort
 *              insert (int, int) - used to insert the event in the right location after checking where to put the event in the sort() method
 *              displayEvents - used to go through the arrayList and print the values of each event
 *				openFile:Scanner- opens the file for reading and created a object of it to be read
 *				readingFromFile(Scanner) - reads text of the object and stores them in their appropriate variable
 *              closeFile(Scanner tempfile)- closes the file
 *              eventsOfDay(OurDate) - searches to find a events in your arrayList of events based on user input
 *              eventsOfWeek(OurDate) - searches to find events on a weekly bases
 *              checkEvent(int, OurDate, OurTime):int - checks to find where a events date is located in the arrayList
 *              deleteEvent(int) - deletes a event based on the location given
 *              
 */

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Calender {

	private ArrayList<Events> list;

	public Calender() {
		list = new ArrayList<Events>();
	}

	public void createEvent(int type, OurDate date, OurTime time, String description, String location, int shiftHours,
			String workName) {

		if (list.size() > 200) {
			System.out.print("Event cannot be added because the event planner is full \n \n");
			return;
		}

		switch (type) {
		case 1:
			list.add(new Meetings(type, date, time, description, location));
			break;

		case 2:
			list.add(new School(type, date, time, description));
			break;

		case 3:
			list.add(new Work(type, date, time, description, workName, shiftHours));
			break;
			
		case 4:
			list.add(new Gym(type, date, time, description));
			break;

		case 5:
			list.add(new Social(type, date, time, description));
			break;

		default:
			System.out.println("Invalid Event Type");
			break;
		}
	}

	public void sort() {
		for (int i = 1; i < list.size(); i++) {
			int j;
			for (j = (i - 1); j >= 0; j--) {
				if (list.get(i).getDate().isGreater(list.get(j).getDate())) {
					break;
				}
				if (list.get(i).getDate().isEqual(list.get(j).getDate())) {
					if (list.get(i).getTime().isGreater(list.get(j).getTime())) {
						break;
					}
				}
			}
			insert(i, j);
		}

	}

	public void insert(int i, int j) {
		list.add(j + 1, list.get(i));
		list.remove(i + 1);
	}

	public void displayEvents() {

		if (list.size() == 0) {
			System.out.println("There are currently no events created.");
		} else {
			System.out.print("\n     *** Events *** \n");
			System.out.print("Amount of events: " + list.size() + "\n");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}

		System.out.print("\n");
	}

	public Scanner openFile() {

		try {
			File a = new File("Events.txt");
			Scanner file = new Scanner(a);
			System.out.println("File has been found and has been opened.");
			return file;
		}

		catch (IOException ioException) {
			System.out.println("Error: File cannot be found.\n");
			return null;
		}

	}

	public void ReadingFromFile(Scanner tempfile) {

		int times = 0;

		try {
			while (tempfile.hasNext()) {

				OurTime time;
				OurDate date;
				int type, hoursPerShift = 0, day, month, year, hour, minute;
				String description, location = " ", nameOfWork = " ";
				type = tempfile.nextInt();

				month = tempfile.nextInt();
				day = tempfile.nextInt();
				year = tempfile.nextInt();
				hour = tempfile.nextInt();
				minute = tempfile.nextInt();
				date = new OurDate(day, month, year);
				time = new OurTime(hour, minute);
				description = tempfile.next();
				if (type == 1) {
					location = tempfile.next();
				}
				if (type == 3) {
					nameOfWork = tempfile.next();
					hoursPerShift = tempfile.nextInt();
				}

				createEvent(type, date, time, description, location, hoursPerShift, nameOfWork);
				times++;
			}
			if (times > 0) {
				System.out.print(times + " events have been created.\n\n");
			}
		} catch (InputMismatchException InputMismatch) {
			System.out.print("File is not formated correctly. \nNo events have been created.\n \n");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeFile(Scanner tempfile) {
		if (tempfile != null)
			tempfile.close();
	}

	public void eventsOfDay(OurDate date) {

		int count = 0;
		System.out.print("\n");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDate().isEqual(date)) {
				count++;
				if (count == 1) {
					System.out.print("   *** EVENTS for  ***\n");
				}
				System.out.println(list.get(i).toString());
			}
		}

		if (count == 0) {
			System.out.println("There are no events on that day.\n");

		}
	}

	public void eventsOfWeek(OurDate date) {

		int count = 0;

		System.out.print("\n");

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getDate().isEqual(date)) {
					count++;
					if (count == 1) {
						System.out.print("*** Events for the week of " + date.getYear() + "/" + date.getMonth() + "/"
								+ date.getDay() + " ***\n");
					}
					System.out.println(list.get(j).toString());
					count++;
				}
			}
			date.addOne();
		}
		System.out.print("\n");

		if (count == 0) {
			System.out.println(
					"There were no events for the week of " + date.getYear() + "/" + date.getMonth() + "/" + date.getDay());
		}
	}

	public int checkEvent(int type, OurDate date, OurTime time) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).type == type && list.get(i).getDate().isEqual(date) && list.get(i).getTime().isEqual(time))
				return i;
		}
		return -1;
	}

	public void deleteEvent(int i) {
		list.remove(i);
	}
}
