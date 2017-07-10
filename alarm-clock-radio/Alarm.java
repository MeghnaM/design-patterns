import java.util.*;

public class Alarm 
{
	private static final int SNOOZE_MINUTES = 9;
	private Calendar alarmTime;
	private boolean isEnabled;
	private Scanner sc = new Scanner(System.in);
	
	public Alarm(Calendar alarmTime) 
	{
		this.alarmTime = alarmTime;
		isEnabled = true;
	}
	
	public Alarm() 
	{
		alarmTime = Calendar.getInstance();
		alarmTime.set(Calendar.HOUR_OF_DAY, 7);
		alarmTime.set(Calendar.MINUTE, 00);
		alarmTime.set(Calendar.SECOND, 00);
		isEnabled = false;
	}

	public Calendar getAlarm() 
	{
		return alarmTime;
	}
	
	public void setAlarm(Calendar alarmTime) 
	{
		this.alarmTime = alarmTime;
	}
	
	public void setIsEnabled(boolean isOn) 
	{
		this.isEnabled = isOn;
	}
	
	public boolean isEnabled()
	{
		return isEnabled;
	}

	public void snoozeAlarm() 
	{
		if (isEnabled)
		{
			int prevMinutes = alarmTime.get(Calendar.MINUTE);
			alarmTime.set(Calendar.MINUTE, prevMinutes + SNOOZE_MINUTES);
			System.out.println("The alarm is snoozed for 9 minutes.");
			isEnabled = false;
		}
		
		else
		{
			System.out.println("The alarm is not enabled.");
		}
	}

}

