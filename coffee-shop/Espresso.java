
public class Espresso extends CoffeeBeverage
{
	public Espresso(String size) 
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
