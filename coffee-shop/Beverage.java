
public class Beverage 
{
	private SizeFactor sizeCost;
	public double cost;
	public String size;
	
	public Beverage() {}
	
	public Beverage(SizeFactor sizeCost, String _size)
	{
		this.sizeCost = sizeCost;
		size = _size;
	}

	public double calculateSizeCost() 
	{
		return sizeCost.sizeCost(size);
	}
	
	public double cost() 
	{
		return cost;
	}
}
