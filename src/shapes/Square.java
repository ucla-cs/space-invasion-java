package shapes;
import java.awt.Graphics2D;
import java.util.ArrayList;

import physics.Acceleration;
import physics.Edge;
import physics.Vertex;




public class Square extends Shape
{
	public Square(Vertex topLeft, int width)
	{
		this.controlPoint=topLeft;
		
		Vertex bottomRight = new Vertex(topLeft.getNewX()-width, topLeft.getNewY()-width, new Acceleration(0,0));
		Vertex topRight = new Vertex(bottomRight.getNewX(), topLeft.getNewY(), new Acceleration(0,0));
		Vertex bottomLeft = new Vertex(topLeft.getNewX(), bottomRight.getNewY(), new Acceleration(0,0));
		
		Edge tlbl = new Edge(topLeft, bottomLeft);
		Edge tltr = new Edge(topLeft, topRight);
		Edge trbr = new Edge(topRight, bottomRight);
		Edge blbr = new Edge(bottomLeft, bottomRight);
		
		
		//INVISIBLE edges
		Edge tlbr = new Edge(topLeft, bottomRight);
		Edge trbf = new Edge(topRight, bottomLeft);
		
		//iedges.add(tlbr );
		//iedges.add(trbf);
		
		edges.add(tlbl);
		edges.add(tltr);
		edges.add(trbr);
		edges.add(blbr);
	}
}
