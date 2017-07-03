package maze;

public class MazeMoveCommand implements UndoableCommand
{
	Maze maze = new Maze();
	Direction direction;
	
	public MazeMoveCommand()
	{}
	
	public MazeMoveCommand(Maze _maze, Direction _dir) 
	{
		maze = _maze;
		direction = _dir;
	}

	private void move(Direction dir) 
	{
		Room curRoom = maze.getCurrentRoom(); 
		MapSite side = curRoom.getSide(dir); 
		side.enter();
		
		if (side instanceof Room)
		maze.setCurrentRoom((Room)side);
		
		else if (side instanceof Door) 
		{ 
			maze.setCurrentRoom(((Door)side).getOtherSide(curRoom)); 
			maze.getCurrentRoom().enter();
		} 
	}
	
	@Override
	public void execute() 
	{
		move(direction);
	}

	@Override
	public void undo() 
	{
		if (direction == Direction.East)
		{
			direction = Direction.West;
		}
		
		else if (direction == Direction.West)
		{
			direction = Direction.East;
		}
		
		else if (direction == Direction.North)
		{
			direction = Direction.South;
		}
		
		else if (direction == Direction.South)
		{
			direction = Direction.North;
		}
		
		move(direction);
	}

}
