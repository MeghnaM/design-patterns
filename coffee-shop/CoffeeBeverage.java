
public class CoffeeBeverage extends Beverage
{
	Beverage beverage;
	public CoffeeBeverage() {}
	
	public CoffeeBeverage(String size) 
	{
		beverage = new Beverage(new CoffeeBased(size), size);
	}
	
	@Override
	public double cost() 
	{
		return cost;
	}
}
