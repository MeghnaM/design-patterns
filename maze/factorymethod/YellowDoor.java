package maze;

import java.awt.Color;

public class YellowDoor extends Door
{

	public YellowDoor(Room r1, Room r2) 
	{
		super(r1, r2);
	}

	@Override
	public Color getColor()
	{
		return Color.YELLOW;
	}
}
