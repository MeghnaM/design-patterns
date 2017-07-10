import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Clock 
{
	private Scanner sc = new Scanner(System.in);
	private Calendar currentTime;
	
	public Clock(Calendar currentTime) 
	{
		this.currentTime = currentTime;
	}

	public void setTime(Calendar newTime) 
	{
		currentTime = newTime;
	}
	
	public Calendar getTime() 
	{
		return currentTime;
	}
	
	public void ClockTime(int elapsedHours, int elapsedMinutes, int elapsedSeconds)
	{
		int prevHours = currentTime.get(Calendar.HOUR_OF_DAY);
		currentTime.set(Calendar.HOUR_OF_DAY, prevHours + elapsedHours);
		int prevMinutes = currentTime.get(Calendar.MINUTE);
		currentTime.set(Calendar.MINUTE, prevMinutes + elapsedMinutes);
		int prevSeconds = currentTime.get(Calendar.SECOND);
		currentTime.set(Calendar.SECOND, prevSeconds + elapsedSeconds);	
	}
	
}

