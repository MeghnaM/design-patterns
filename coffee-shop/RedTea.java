
public class RedTea extends TeaBeverage
{
	public RedTea(String size) 
	{
		super(size);
		cost = 0.8;
	}

	@Override
	public double cost() 
	{
		return cost + beverage.calculateSizeCost();
	}

}
