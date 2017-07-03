package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import maze.ui.MazeViewer;

public class RedMazeFactory implements MazeFactory
{
	
	
	public Maze makeMaze()
	{
		return new Maze();
	}
	
	public Room makeRoom(int id)
	{
		return new PinkRoom(id);
	}
	
	public Wall makeWall()
	{
		return new RedWall();
	}
	
	public Door makeDoor(Room room_0, Room room_1)
	{
		return new GreenDoor(room_0, room_1);
	}

	
}
