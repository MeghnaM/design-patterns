import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class StarBuzzClient 
{
	private static HashMap<String, List<String>> menu = new HashMap<String, List<String>>();
	static StarBuzzClient client = new StarBuzzClient();

	public static void main(String [] args)
	{
		int n = 0;
		
		client.initMenu();
		System.out.println("Following are the item and item decriptions on our menu.\n"
				+ "If you haven't entered one of these items as the first argument on the command line, please change your input.\n");
		
		for (Entry<String, List<String>> entry: menu.entrySet())
		{
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		String bev_name = null;
		String size = null;
		ArrayList<String> ingredients = new ArrayList<String>();
		
		if (menu.containsKey(args[n]))
		{
			bev_name = args[n++];
		}
		
		else
		{
			System.out.println("\nOur menu does not contain the beverage you have chosen, please chose another one.");
			System.exit(0);
		}
		
		size = args[n++];
		for (int i = n; i < args.length; i ++)
		{
			ingredients.add(args[i]);
		}
		
		System.out.println("\nWe have received your order of a " + size + " " + 
							bev_name + " with the following ingredients: " 
							+ ingredients + ". \nYour order is being processed now :)\n");
		
		client.calculateDrinkCost(bev_name, size, ingredients);
	}

	private HashMap initMenu()
	{
		menu.put("Espresso", Arrays.asList("Espresso"));
		menu.put("Decaf", Arrays.asList("Decaf"));
		menu.put("HouseBlend", Arrays.asList("Houseblend"));
		menu.put("Mocha", Arrays.asList("Espresso", "Chocolate"));
		menu.put("Latte", Arrays.asList("Espresso", "Milk"));
		menu.put("Cappuccino", Arrays.asList("Espresso", "WhipCream"));
		menu.put("Decaf_Mocha", Arrays.asList("Decaf", "Chocolate"));
		menu.put("Decaf_Latte", Arrays.asList("Decaf", "Milk"));
		menu.put("Decaf_Cappuccino", Arrays.asList("Decaf", "WhipCream"));
		menu.put("Green_Tea", Arrays.asList("GreenTea"));
		menu.put("Red_Tea", Arrays.asList("RedTea"));
		menu.put("White_Tea", Arrays.asList("WhiteTea"));
		menu.put("Flower_Tea", Arrays.asList("GreenTea", "Jasmine"));
		menu.put("Ginger_Tea", Arrays.asList("GreenTea", "Ginger"));
		menu.put("Tea_Latte", Arrays.asList("RedTea", "Milk"));
		return menu;
	}
	
	private void calculateDrinkCost(String _bev_name, String _size, List<String> _ingredients)
	{
		Beverage drink = null;
		
		switch (_bev_name)
		{
			case "Espresso": drink = new Espresso(_size);
							 break;
							 
			case "Decaf": drink = new Decaf(_size);
						  break;
							 
			case "HouseBlend": drink = new HouseBlend(_size);
							   break;
							   
			case "Mocha": drink = new Chocolate(new Espresso(_size));
								  break;
								  
			case "Latte": drink = new Milk(new Espresso(_size));
						  break;
						  
			case "Cappuccino": drink = new WhipCream(new Espresso(_size));
							   break;
							   
			case "Decaf_Mocha": drink = new Chocolate(new Decaf(_size));
							    break;
							    
			case "Decaf_Latte": drink = new Milk(new Decaf(_size));
								break;
								
			case "Decaf_Cappuccino": drink = new WhipCream(new Decaf(_size));
									 break;
									 
			case "Green_Tea": drink = new GreenTea(_size);
							  break;
							  
			case "Red_Tea": drink = new RedTea(_size);
							break;
							
			case "White_Tea": drink = new WhiteTea(_size);
							  break;
							  
			case "Flower_Tea": drink = new Jasmine(new GreenTea(_size));
							   break;
							   
			case "Ginger_Tea": drink = new Ginger(new GreenTea(_size));
							   break;
							   
			case "Tea_Latte": drink = new Milk(new RedTea(_size));
							  break;
							  
			default: System.out.println("Incorrect Choice. Please start over.");
					 System.exit(0);
		}
		
		// switch case that matches against the ingredient strings and decorates accordingly
		for (String ingredient: _ingredients)
		{
			switch (ingredient)
			{
				case "milk": drink = new Milk(drink);
							 break;
							 
				case "ginger": drink = new Ginger(drink);
							   break;
							   
				case "jasmine": drink = new Jasmine(drink);
								break;
								
				case "whipcream": drink = new WhipCream(drink);
								  break;
								  
				case "chocolate": drink = new Chocolate(drink);
								  break;
				
				default: System.out.println("Incorrect Ingredient.");
			}
		}
		
		System.out.println("The total cost of your drink is: $" + (float) drink.cost());
	}
}
