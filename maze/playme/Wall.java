package maze;

import java.awt.Color;

public class Wall extends MapSite
{
	@Override
	public void enter()
	{
		System.out.println("Ouch! Ran into a wall.");
	}

	@Override
	public Color getColor()
	{
		return Color.BLACK;
	}
}
