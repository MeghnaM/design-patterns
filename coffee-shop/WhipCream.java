
public class WhipCream extends BeverageWithIngredient
{
	Beverage decoratedDrink;
	public WhipCream(Beverage drink) 
	{
		super(drink);
		this.decoratedDrink = drink;
		cost = 0.3;
	}

	@Override
	public double cost() 
	{
		return cost + decoratedDrink.cost();
	}
}
