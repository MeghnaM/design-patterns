
public class TeaBased implements SizeFactor
{
	private String size;

	public TeaBased(String size)
	{
		this.size = size;
	}
	
	@Override
	public double sizeCost(String size) 
	{
		if (size.equalsIgnoreCase("small"))
			return 0.7;
		
		else if (size.equalsIgnoreCase("medium"))
			return 0.5;
		
		else if (size.equalsIgnoreCase("large"))
			return 0.2;
		
		else
			return 0;
	}

}
