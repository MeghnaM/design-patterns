
public class Decaf extends CoffeeBeverage
{	
	public Decaf(String size) 
	{
		super(size);
		cost = 0.5;
	}

	@Override
	public double cost() 
	{
		return cost + beverage.calculateSizeCost();
	}
}
