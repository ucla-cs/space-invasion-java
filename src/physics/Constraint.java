package physics;

import java.awt.geom.Point2D;

import shapes.Shape;


public class Constraint 
{
	
	Vertex a;
	Vertex b;
	Vertex c;
	
	public Constraint(Vertex A, Vertex B, Vertex C)
	{
		this.a = A;
		this.b = B;
		this.c= C;
		
	}

	private void applyConstraint(Vertex a, Vertex b, Vertex c) 
	{
		
		double ab = Point2D.Double.distanceSq(a.getNewX(), a.getNewY(),b.getNewX(), b.getNewY());
		double bc = Point2D.Double.distanceSq(b.getNewX(), b.getNewY(), c.getNewX(), c.getNewY());
		
		double ac = Point2D.Double.distance(a.getNewX(), a.getNewY(), c.getNewX(), c.getNewY());
		
		double min = Math.sqrt(ab+bc);
		
		if(ac < min)
		{
			double d = -Math.abs(ac - min);
			
			double rX = c.getNewX() -a.getNewX();
			double rY = c.getNewY() - a.getNewY();
			
			double n = Math.sqrt( (rX*rX) + (rY*rY) );
			
			d = d/n;
			
			rX = rX/n;
			rY = rY/n;
			
			a.set(a.getNewX() + (rX*d*0.5), a.getNewY() + (rY*d*0.5));
			c.set(c.getNewX() - (rX*d*0.5), c.getNewY() - (rY*d*0.5));
			
			
		}
		
		
		
	}
	
	public void update(boolean a, boolean b)
	{
			applyConstraint(this.a, this.b, c);
	}

}
