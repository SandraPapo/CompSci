/*
Implement a class Clock whose getHours and getMinutes methods return the current time at
your location. (Call java.time.Instant.now().toString() or, if you are not using Java 8, new
java.util.Date().toString() and extract the time from that string.) Also, provide a getTime
method that returns a string with the hours and minutes by calling the getHours and getMinutes
methods. Provide a subclass WorldClock whose constructor accepts a time offset. For example, if you live
in Windsor, a new WorldClock(-3) should show the time in Vancouver, three time zones behind, and a
new WorldClock(1.5) should show the time in St. John’s, NewFoundland, 1.5 time zones ahead. Which
methods did you override? (You should not override getTime method.)
*/

import java.util.Date;

class Clock {
	public int getHours() {
		return Date.getHours();
	}

}

public class Activity2 {
	public static void main(String[] args) {
		Clock myClock = new Clock();
		System.out.println(myClock.getHours());
	}
}