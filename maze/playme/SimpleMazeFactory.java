package maze;

import maze.ui.MazeViewer;

import java.io.*;
import java.util.*;

public class SimpleMazeFactory implements MazeFactory
{
	/**
	 * Creates a small maze.
	 */

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
	
	
}
