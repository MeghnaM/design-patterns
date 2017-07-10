import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class AlarmClockRadio 
{
	public static void helpMenu() 
	{
		System.out.println("Enter the number of the task you wish to perform: ");
		System.out.println("0: Enter 0 to Exit");
		System.out.println("1: Display Time");
		System.out.println("2: Display Radio Station");
		System.out.println("3: Display Alarm Time");
		System.out.println("4: Set Time");
		System.out.println("5: Set Alarm");
		System.out.println("6: Turn Alarm Off");
		System.out.println("7: Snooze Alarm for 9 minutes");
		System.out.println("8: Set Radio Station");
		System.out.println("9: Set Volume");
		System.out.println("10: Turn Radio On");
		System.out.println("11: Turn Radio Off");
		System.out.println("12: Display Help Menu.");
	}

	public Calendar setClockTime(Scanner sc, Clock clock)
	{
		int hours, minutes, seconds;
		Calendar newTime = clock.getTime();
		
		System.out.println("Please enter the Time:");
		System.out.print("Hour (24hr time): ");
		hours = sc.nextInt();
		
		System.out.print("Minute: ");
		minutes = sc.nextInt();

		System.out.print("Second: ");
		seconds = sc.nextInt();
		
		newTime.set(Calendar.HOUR_OF_DAY, hours);
		newTime.set(Calendar.MINUTE, minutes);
		newTime.set(Calendar.SECOND, seconds);
		
		return newTime;
	}
	
	public Calendar setAlarmTime(Scanner sc, Alarm alarm)
	{
		int hours, minutes, seconds;
		Calendar alarmTime = alarm.getAlarm();
		
		System.out.println("Please enter the Time:");
		System.out.print("Hour (24hr time): ");
		hours = sc.nextInt();
		
		System.out.print("Minute: ");
		minutes = sc.nextInt();
		
		System.out.print("Second: ");
		seconds = sc.nextInt();
		
		alarmTime.set(Calendar.HOUR_OF_DAY, hours);
		alarmTime.set(Calendar.MINUTE, minutes);
		alarmTime.set(Calendar.SECOND, seconds);
		
		return alarmTime;
	}
	
	public void displayClockTime(Clock clock)
	{
		String clockTime = clock.getTime().getTime().toString();
		int index = clockTime.indexOf(":");
		System.out.println(clockTime.substring(index - 2, index + 6));
	}
	
	public void displayAlarmTime(Alarm alarm)
	{
		String alarmTime = alarm.getAlarm().getTime().toString();
		int index = alarmTime.indexOf(":");
		System.out.println(alarmTime.substring(index - 2, index + 6));
	}
	
	public static void main(String [] args) 
	{	
		AlarmClockRadio amFm = new AlarmClockRadio();
		Scanner sc  = new Scanner(System.in);
		Clock clock = new Clock(Calendar.getInstance());
		Radio radio = new Radio("101.1");
		Alarm alarm = new Alarm();
		
		Calendar currentTime = Calendar.getInstance();
		Calendar prevTime = currentTime;
		
		System.out.println("Welcome to Alarm Clock Radio!");
		helpMenu();
		int ch = sc.nextInt();
		boolean clockRunning = true;
		
		while (clockRunning)
		{	
			if (alarm.getAlarm().before(clock.getTime()) && alarm.isEnabled())
			{
				System.out.println("Buzz! Buzz! Buzz!");
				System.out.println("Remember: Enter 7 to snooze alarm or 6 to turn alarm off.");
			}
			
			prevTime = currentTime;
			currentTime = Calendar.getInstance();
			
			// calculate elapsed time since last loop
			int elapsedHours = currentTime.get(Calendar.HOUR_OF_DAY) - prevTime.get(Calendar.HOUR_OF_DAY);
			int elapsedMinutes = currentTime.get(Calendar.MINUTE) - prevTime.get(Calendar.MINUTE);
			int elapsedSeconds = currentTime.get(Calendar.SECOND) - prevTime.get(Calendar.SECOND);
			clock.ClockTime(elapsedHours, elapsedMinutes, elapsedSeconds);
			
			switch (ch) 
			{
				case 0: clockRunning = false;
						System.exit(0);
						break;
						
				case 1: System.out.print("The current clock time is: ");
						amFm.displayClockTime(clock);
						System.out.println();
						break;
						
				case 2: System.out.println("The currrent Radio Station is: " + radio.getRadioStation());
						break;
				
				case 3: System.out.print("The current alarm time is: ");
						amFm.displayAlarmTime(alarm);
						System.out.println();
						break;
						
				case 4: Calendar newTime = amFm.setClockTime(sc, clock);
						clock.setTime(newTime);
						System.out.println("The clock time has been set to: " + newTime.getTime().toString());
						break;
						
				case 5: Calendar alarmTime = amFm.setAlarmTime(sc, alarm);
						alarm.setAlarm(alarmTime);
						alarm.setIsEnabled(true);
						System.out.println("The alarm time has been set to: " + alarmTime.getTime().toString());
						break;
						
				case 6: alarm.setIsEnabled(false);
					    System.out.println("The alarm is disabled.");
						break;
						
				case 7: alarm.snoozeAlarm();
						break;
						
				case 8: radio.setRadioStation();
						break;
						
				case 9: radio.setVolume();
						break;
						
				case 10: radio.turnRadioOn(true);
						 System.out.println("The radio is on.");
						 break;
						 
				case 11: radio.turnRadioOn(false);
						 System.out.println("The radio is off.");
					     break;
					     
				case 12: helpMenu();
						 break;
					     
				default: System.out.println("Incorrect number entered! Please start over.");
						 System.exit(0);		
			}			
			
			System.out.println();
			System.out.println("Please enter the next number:");
			ch = sc.nextInt();
		}

	}
	
}