package maze;

import java.awt.Color;

public class Room extends MapSite
{
	private final MapSite[] sides = new MapSite[4];
	private final int number;
	
	public Room(int num)
	{
		number = num;
	}

	public final MapSite getSide(Direction dir)
	{
		return sides[dir.ordinal()];
	}
	
	public final void setSide(Direction dir, MapSite site)
	{
		sides[dir.ordinal()] = site;
	}
	
	public final int getNumber()
	{
		return number;
	}

	@Override
	public void enter()
	{
		super.notifyEntryListeners();
	}

	@Override
	public Color getColor()
	{
		return Color.WHITE;
	}
}
