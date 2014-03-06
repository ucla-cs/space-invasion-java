package physics;


import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import shapes.Shape;



public class Edge extends Shape
{
	double LENGTH;
	public Vertex A, B;

	public Edge(Vertex A, Vertex B)
	{
		this.A = A;
		this.B = B;

		LENGTH = getLength();
	}

	public double getLength()
	{
		double Ax = A.getNewX(), Ay = A.getNewY(), Bx = B.getNewX(), By = B.getNewY();
		
		double dx = Bx - Ax, dy = By - Ay;

		return Math.sqrt((dx*dx) + (dy*dy));
	}



	@Override
	public void draw(Graphics2D g) 
	{
		A.draw(g);
		B.draw(g);

		Line2D.Double tempLine = new Line2D.Double(A.getNewX(), A.getNewY(), B.getNewX(), B.getNewY());
		
		g.draw(tempLine);

	}

	@Override
	public void update()
	{
		
			A.update();
			B.update();
			
		
			double Ax = A.getNewX(), Ay = A.getNewY(), Bx = B.getNewX(), By = B.getNewY();
	
			double dx = Bx - Ax, dy = By - Ay;
	
			double d = getLength()-LENGTH;

			double n = getLength();
	
			d = d/n;
	
			dx = dx/n;
			dy = dy/n;
	
			double newXB = Bx- (dx*d*0.5);
			double newYB = By- (dy*d*0.5);
	
			double newXA = Ax + (dx*d*0.5);
			double newYA = Ay + (dy*d*0.5);
	
			B.set(newXB, newYB);
			A.set(newXA, newYA);
		


	}
	
	public void strictupdate()
	{
		


	}
}
