package maze;

import maze.ui.MazeViewer;
import java.io.*;
import java.util.*;

public class SimpleMazeGameCreator
{
	/**
	 * Creates a small maze.
	 */
	
	private static Map<Room, String[]> roomSides = new HashMap<Room, String[]>();
	private static Map<String, Door> doors = new HashMap<String, Door>();
	private static ArrayList<Room> rooms = new ArrayList<Room>();
	private static SimpleMazeGameCreator myMazeGame = new SimpleMazeGameCreator();
	private static final int COLOR_INDEX = 0;
	private static final int PATH_INDEX = 1;
	private static final int NO_OF_ARGS = 2;
	
	public Maze createMaze(final String path) throws IOException
	{
		Maze maze = myMazeGame.makeMaze();
		
		if (!path.equals("default"))
		{
			maze = myMazeGame.loadMaze(path);
		}
		
		else if (path.equals("default"))
		{
			Room room_0, room_1;
			room_0 = myMazeGame.makeRoom(0);
			room_1 = myMazeGame.makeRoom(1);
			Door door = myMazeGame.makeDoor(room_0, room_1);
			maze = myMazeGame.makeMaze();
						
			room_0.setSide(Direction.North, myMazeGame.makeWall());
			room_0.setSide(Direction.East, door);
			room_0.setSide(Direction.South, myMazeGame.makeWall());
			room_0.setSide(Direction.West, myMazeGame.makeWall());
			room_1.setSide(Direction.North, myMazeGame.makeWall());
			room_1.setSide(Direction.West, door);
			room_1.setSide(Direction.South, myMazeGame.makeWall());
			room_1.setSide(Direction.East, myMazeGame.makeWall());
	
			maze.addRoom(room_0);
			maze.addRoom(room_1);
			
			maze.setCurrentRoom(room_0);
		}

		else if (maze.getNumberOfRooms() == 0)
		{
			System.out.println("The maze does not have any rooms yet!");
		}
		
		return maze;
	}

	public static Maze loadMaze(final String path) throws IOException
	{
		Maze maze = myMazeGame.makeMaze();
		File file = new File(path);
		Scanner input = new Scanner(file);

		Direction[] dirs = Direction.values();
		
		while (input.hasNext())   
		{
			String first = input.next();
			if (first.equals("room"))
			{
				Room newRoom = myMazeGame.makeRoom(input.nextInt());
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
				Door newDoor = myMazeGame.makeDoor(rooms.get(roomOne), rooms.get(roomTwo));
				
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
			mapSite = myMazeGame.makeWall();
		}
		
		else if (side.substring(0,1).equals("d"))
		{
			mapSite = doors.get(side);
		}
		
		else 
		{
			mapSite = rooms.get(Integer.parseInt(side));
		}
		
		return mapSite;
	}

	public Maze makeMaze()
	{
		return new Maze();
	}
	
	public Room makeRoom(int id)
	{
		return new Room(id);
	}
	
	public Wall makeWall()
	{
		return new Wall();
	}
	
	public Door makeDoor(Room room_0, Room room_1)
	{
		return new Door(room_0, room_1);
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Add the color of the maze as the first argument to the Run Configuration of this program. \n" +
				"Add input file name as the second argument to the Run Configuration of this program. \n" +
				"If you would like to see the default maze in the default colors, you may leave one or both of the argument fields empty.");
			
		String path = "default";
		String mazeColor = "simple";
		
		if (args.length > 0)
		{
			try
			{
				if (args.length == NO_OF_ARGS)
				{
					mazeColor = args[COLOR_INDEX];
					path = args[PATH_INDEX];
				}
				else if (args.length == 1)
				{
					mazeColor = args[COLOR_INDEX];
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		if (mazeColor.equals("simple"))
			myMazeGame = new SimpleMazeGameCreator();
		
		else if (mazeColor.equals("red"))
			myMazeGame = new RedMazeGameCreator();
		
		else if (mazeColor.equals("blue"))
			myMazeGame = new BlueMazeGameCreator();
		
		// Creates a maze by reading input from the given file
		Maze maze = myMazeGame.createMaze(path);
		
		// Displays maze
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}
