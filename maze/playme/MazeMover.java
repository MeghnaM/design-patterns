package maze;

import java.util.Stack;

public class MazeMover implements MazeMoveListener 
{
	Stack<Command> moves = new Stack<Command>();
	
	@Override
	public void moveEast(Maze maze) 
	{
		MazeMoveCommand move = new MazeMoveCommand(maze, Direction.East);
		moves.push(move);
		move.execute();
	}

	@Override
	public void moveNorth(Maze maze) 
	{
		MazeMoveCommand move = new MazeMoveCommand(maze, Direction.North);
		moves.push(move);
		move.execute();	
	}

	@Override
	public void moveSouth(Maze maze) 
	{
		MazeMoveCommand move = new MazeMoveCommand(maze, Direction.South);
		moves.push(move);
		move.execute();	
	}

	@Override
	public void moveWest(Maze maze) 
	{
		MazeMoveCommand move = new MazeMoveCommand(maze, Direction.West);
		moves.push(move);
		move.execute();
	}
	
	@Override
	public void undoMove() 
	{
		MazeMoveCommand undoMove = new MazeMoveCommand();
		
		if (!moves.isEmpty())
		{
			undoMove = (MazeMoveCommand) moves.pop();
		}
		
		undoMove.undo();
	}
}
