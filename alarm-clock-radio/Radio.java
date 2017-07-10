import java.util.Scanner;

public class Radio 
{
	private String currentStation;
	private Scanner sc = new Scanner(System.in);
	private boolean radioOn = true;
	private int volume;
	
	public Radio(String currentStation) 
	{
		this.currentStation = currentStation;
		volume = 10;
	}
	
	public void setRadioStation() 
	{
		System.out.println("Please enter the name of the current Radio Station.");
		currentStation = sc.nextLine();
	}
	
	public String getRadioStation() 
	{
		 return currentStation;
	}

	public void turnRadioOn(boolean isOn) 
	{
		this.radioOn = isOn;
	}	
	
	public boolean isRadioOn()
	{
		return radioOn;
	}
	
	public void setVolume() 
	{
		System.out.println("Enter volume: ");
		volume = sc.nextInt();
	}
	
	public int getVolume() 
	{
		return volume;
	}
}