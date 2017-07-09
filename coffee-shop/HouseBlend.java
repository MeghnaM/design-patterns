
public class HouseBlend extends CoffeeBeverage
{
	public HouseBlend(String size) 
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
