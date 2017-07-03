package maze;

public interface MazeFactory 
{
	public Maze makeMaze();
	public Room makeRoom(int id);
	public Wall makeWall();
	public Door makeDoor(Room room_0, Room room_1);
	
}
