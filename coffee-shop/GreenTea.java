
public class GreenTea extends TeaBeverage
{
	public GreenTea(String size)
	{
		super(size);
		cost = 1;
	}

	@Override
	public double cost() 
	{
		return cost + beverage.calculateSizeCost();
	}

}
