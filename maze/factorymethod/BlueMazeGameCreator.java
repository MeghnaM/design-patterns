package maze;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlueMazeGameCreator extends SimpleMazeGameCreator
{
	public Room makeRoom(int id)
	{
		return new LightGreyRoom(id);
	}
	
	public Wall makeWall()
	{
		return new BlueWall();
	}
	
	public Door makeDoor(Room room_0, Room room_1)
	{
		return new YellowDoor(room_0, room_1);
	}

}

