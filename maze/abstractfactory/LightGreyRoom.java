package maze;

import java.awt.Color;

public class LightGreyRoom extends Room
{

	public LightGreyRoom(int num) 
	{
		super(num);
	}
	

	@Override
	public Color getColor()
	{
		return Color.LIGHT_GRAY;
	}
	

}
