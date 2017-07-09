
public class CoffeeBased implements SizeFactor
{
	private String size;

	public CoffeeBased(String size)
	{
		this.size = size;
	}
	
	@Override
	public double sizeCost(String size) 
	{
		if (size.equalsIgnoreCase("small"))
			return 1;
		
		else if (size.equalsIgnoreCase("medium"))
			return 0.7;
		
		else if (size.equalsIgnoreCase("large"))
			return 0.4;
		
		else
			return 0;
	}

}
