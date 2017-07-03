package maze;

import maze.ui.MazeViewer;
import java.io.*;
import java.util.*;

public class SimpleMazeGame
{
	/**
	 * Creates a small maze.
	 */
	
	private static Map<Room, String[]> roomSides = new HashMap<Room, String[]>();
	private static Map<String, Door> doors = new HashMap<String, Door>();
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public Maze createMaze(final String path) throws IOException
	{
		Maze maze = new Maze();
		
		// If we are given an input file, then use that to create the maze
		if (!path.equals("default"))
		{
			maze = SimpleMazeGame.loadMaze(path);
		}
		
		// Otherwise create a simple maze with two rooms
		else if (path.equals("default"))
		{
			// Create Room
			Room room_0, room_1;
			room_0 = new Room(0);
			room_1 = new Room(1);
			Door door = new Door(room_0, room_1);
			maze = new Maze();
						
			room_0.setSide(Direction.North, new Wall());
			room_0.setSide(Direction.East, door);
			room_0.setSide(Direction.South, new Wall());
			room_0.setSide(Direction.West, new Wall());
			room_1.setSide(Direction.North, new Wall());
			room_1.setSide(Direction.West, door);
			room_1.setSide(Direction.South, new Wall());
			room_1.setSide(Direction.East, new Wall());
	
			maze.addRoom(room_0);
			maze.addRoom(room_1);
			
			maze.setCurrentRoom(room_0);
		}

		// If maze has more than 0 rooms, then print the following
		else if (maze.getNumberOfRooms() == 0)
		{
			System.out.println("The maze does not have any rooms yet!");
		}
		
		return maze;
	}

	// Can edit this method to create more methods - to make it more modularized
	public static Maze loadMaze(final String path) throws IOException
	{
		Maze maze = new Maze();
		File file = new File(path);
		Scanner input = new Scanner(file);

		Direction[] dirs = Direction.values();
		
		while (input.hasNext())   
		{
			String first = input.next();
			if (first.equals("room"))
			{
				Room newRoom = new Room(input.nextInt());
				rooms.add(newRoom);
				maze.setCurrentRoom(newRoom);
				
				String[] sides = new String[dirs.length];
				for (int i=0; i < dirs.length; i ++)
				{
					sides[i] = input.next();
				}
				
				roomSides.put(newRoom, sides);
			}
			
			else if (first.equals("door"))
			{
				String doorId = input.next();
				int roomOne = input.nextInt();
				int roomTwo = input.nextInt();
				Door newDoor = new Door(rooms.get(roomOne), rooms.get(roomTwo));
				
				newDoor.setOpen(input.next().equals("open"));
				doors.put(doorId, newDoor);
			}
		}
		
		for (Room aroom: rooms)
		{	
			String[] sides = roomSides.get(aroom);
			
			for (Direction dir: dirs)
			{
				MapSite side = parseSide(sides[dir.ordinal()]);
				aroom.setSide(dir, side);
			}
			
			maze.addRoom(aroom);
		}
		
		System.out.println("Loading maze from file: " + path);
		return maze;
	}
	

	public static MapSite parseSide(String side)
	{
		MapSite mapSite = null;
		
		if (side.equals("wall"))
		{
			// Create a new Wall
			mapSite = new Wall();
		}
		
		// If the first character of the field = "d"
		else if (side.substring(0,1).equals("d"))
		{
			// Get the value from the HashMap doors, by using the field number as the key
			mapSite = doors.get(side);
		}
		
		else 
		{
			mapSite = rooms.get(Integer.parseInt(side));
		}
		
		return mapSite;
	}

	public static void main(String[] args) throws IOException
	{
		System.out.println("Add input file name as an argument to the Run Configuration of this program.");
		String path = "default";
		if (args.length > 0)
		{
			try
			{
				path = args[0];
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		SimpleMazeGame myMazeGame = new SimpleMazeGame();
		// Creates a maze by reading input from the given file
		Maze maze = myMazeGame.createMaze(path);
		
		// Displays maze
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}
