
public class Ginger extends BeverageWithIngredient
{
	Beverage decoratedDrink;
	public Ginger(Beverage drink) 
	{
		super(drink);
		this.decoratedDrink = drink;
		cost = 0.6;
	}

	@Override
	public double cost() 
	{
		return cost + decoratedDrink.cost();
	}
}
