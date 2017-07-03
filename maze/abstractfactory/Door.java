package maze;

import java.awt.Color;

public class Door extends MapSite
{
	private final Room[] rooms = new Room[2];
	private boolean open;

	public Door(final Room r1, final Room r2)
	{
		open = false;
		rooms[0] = r1;
		rooms[1] = r2;
	}
	
	public final boolean isOpen()
	{
		return open;
	}
	
	public final void setOpen(boolean open)
	{
		this.open = open;
	}
	
	public final Room getOtherSide(final Room r)
	{
		if (rooms[0] == r)
			return rooms[1];
		else if (rooms[1] == r)
			return rooms[0];
		else
			return null;
	}
	
	@Override
	public void enter()
	{
		if (!open) {
			System.out.println("Opened the door.");
			open = true;
		}

		super.notifyEntryListeners();
	}
	
	@Override
	public Color getColor()
	{
		return Color.LIGHT_GRAY;
	}
}
