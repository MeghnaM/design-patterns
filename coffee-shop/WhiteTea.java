
public class WhiteTea extends TeaBeverage
{
	public WhiteTea(String size)	
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
