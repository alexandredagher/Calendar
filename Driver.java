
/** 
 *	  Author:  Alexandre Dagher
 *    Date: November 27, 2017
 *    Section: CST8130
 *    Purpose: Used as my driver class to call approriate methods for user inputs
 *   
 *	  Data fields: Boolean: done - checks if user quit to end
 *                 Calender: object - used to run methods and hold values
 *				   OurDate: DATE - used to run methods and hold values
 *                 OurTime: TIME - used to run methods and hold values
 *                          
 *    Methods:  Main - used to take user inputs and call other methods
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Boolean done = false;
		Calender object = new Calender();
		OurDate DATE = new OurDate();
		OurTime TIME = new OurTime();

		do {
			try {

				int choice = 0;

				System.out.println("        *** Menu *** \n" + "1 ... Add an event from keyboard\n"
						+ "2 ... Display events of a day \n" + "3 ... Display events of a week \n"
						+ "4 ... Delete an event \n" + "5 ... Add events from a file \n" + "6 ... Display all events \n"
						+ "7 ... Quit");

				System.out.print("\nEnter Your Option: ");
				choice = input.nextInt();

				switch (choice) {

				case 1:
					int type = 0;

					System.out.print("\nEvent Types:\n" + "1 ... Meeting Event\n" + "2 ... School Event \n"
							+ "3 ... Work Event \n" + "4 ... Gym Event \n" + "5 ... Social Event \n \n"
							+ "Enter the event type: ");

					type = input.nextInt();

					OurDate date = new OurDate();
					OurTime time = new OurTime();
					date.readDate(input, 'k');
					time.readTime(input, 'k');

					String description;
					String location;
					String workName;
					int shiftHours = 0;

					input.nextLine();

					if (type == 1) {
						System.out.print("Please enter the description: ");
						description = input.nextLine();
						System.out.print("Please enter the location: ");
						location = input.nextLine();
						System.out.print("\n");

						object.createEvent(type, date, time, description, location, 0, null);
					}

					else if (type == 3) {

						System.out.println("Please enter the name of the work place: ");
						workName = input.nextLine();

						System.out.println("Please enter the number of hours in the shift: ");

						shiftHours = input.nextInt();
						input.nextLine();

						System.out.print("\n");

						if (shiftHours < 0) {
							throw new Exception("random");
						}

						object.createEvent(type, date, time, "Work", null, shiftHours, workName);
					}

					else {
						System.out.println("Please Enter The Description: ");
						description = input.nextLine();
						System.out.print("\n");

						object.createEvent(type, date, time, description, null, 0, null);
					}

					break;
				case 2:
					object.sort();
					DATE.readDate(input, 'k');
					object.eventsOfDay(DATE);
					break;
				case 3:
					object.sort();
					DATE.readDate(input, 'k');
					object.eventsOfWeek(DATE);
					break;
				case 4:
					System.out.println("Enter the type, date and time of the event to be deleted");
					System.out.println(" Enter type (1 – Meeting, 2 – School, 3 – Work, 4 – Gym, 5 - Social): ");

					int type4;
					type4 = input.nextInt();

					DATE.readDate(input, 'k');
					TIME.readTime(input, 'k');

					int value;
					value = object.checkEvent(type4, DATE, TIME);
					if (value == -1) {
						System.out.println("There is no event for that time and date.");
						break;

					}
					object.deleteEvent(value);

					break;
				case 5:
					Scanner file = object.openFile();
					if (file == null) {
						break;
					}
					object.ReadingFromFile(file);
					object.closeFile(file);
					break;
				case 6:
					object.sort();
					object.displayEvents();
					break;
				case 7:
					System.out.print("\nGoodbye");
					done = true;
					break;
				default:
					System.out.print("Invalid menu option\n\n");
					break;
				}
			} catch (InputMismatchException InputMismatch) {
				System.out.print("Incorrect input, please try again:\n \n");
				input.next();
			} catch (Exception E) {
				System.out.print("Incorrect input, please try again:\n \n");
			}
		} while (done == false);
	}
}
