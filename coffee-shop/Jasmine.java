
public class Jasmine extends BeverageWithIngredient
{
	Beverage decoratedDrink;
	public Jasmine(Beverage drink) 
	{
		super(drink);
		this.decoratedDrink = drink;
		cost = 0.5;
	}

	@Override
	public double cost() 
	{
		return cost + decoratedDrink.cost();
	}
}
