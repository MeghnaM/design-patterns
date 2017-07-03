package maze;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maze implements Iterable<Room>
{
	private final Map<Integer, Room> rooms = new HashMap<Integer, Room>();
	private Room current;
	
	public Maze()
	{
	}

	public final void addRoom(final Room r)
	{
		rooms.put(r.getNumber(), r);
	}

	public final Room getRoom(int number)
	{
		return rooms.get(number);
	}
	
	@Override
	public Iterator<Room> iterator()
	{
		return rooms.values().iterator();
	}

	public int getNumberOfRooms()
	{
		return rooms.size();
	}

	public final Room getCurrentRoom()
	{
		return current;
	}

	public final void setCurrentRoom(final Room room)
	{
		current = room;
	}
	
	public final void setCurrentRoom(int number)
	{
		current = rooms.get(number);
	}
}
