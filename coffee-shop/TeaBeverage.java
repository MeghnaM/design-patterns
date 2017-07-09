
public class TeaBeverage extends Beverage
{
	Beverage beverage;
	public TeaBeverage() {}
	
	public TeaBeverage(String size) 
	{
		beverage = new Beverage(new TeaBased(size), size);
	}
	
	@Override
	public double cost() 
	{
		return cost;
	}

}
