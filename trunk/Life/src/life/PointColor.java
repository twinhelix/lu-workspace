package life;
import java.awt.*;

@SuppressWarnings("serial")
public class PointColor extends Point{
	public Color color;
	
	public PointColor(int x, int y, Color color){
		super(x,y);
		this.color = color;
	}
}
