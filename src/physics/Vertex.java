package physics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import GUIFramework.GraphicsPanel;

import shapes.Box;
import shapes.Shape;


public class Vertex extends Shape
{
	
	private static final double DELTATIME=0.05;
	
	public static int POINTSIZE =1;
	
	private double newX, newY;
	private double oldX, oldY;
	
	private double xmin, xmax;
	private double ymin, ymax;

	private Acceleration a;
	
	public Vertex(double x, double y, Acceleration a)
	{
		this.oldX = x;
		this.oldY = y;
		
		this.newX = x;
		this.newY = y;
		
		this.a = a;

		this.xmin = GraphicsPanel.MINX +POINTSIZE; //+POINTSIZE;
		this.xmax = GraphicsPanel.MAXX -POINTSIZE; //-POINTSIZE;
		
		this.ymin = GraphicsPanel.MINY +POINTSIZE;  //+POINTSIZE;
		this.ymax = GraphicsPanel.MAXY -POINTSIZE;// -POINTSIZE;
	}
	
	public Vertex(double x, double y)
	{
		this.oldX = x;
		this.oldY = y;
		
		this.newX = x;
		this.newY = y;
		
		this.a = new Acceleration(0,0);

		this.xmin = GraphicsPanel.MINX+POINTSIZE;
		this.xmax = GraphicsPanel.MAXX-POINTSIZE;
		
		this.ymin = GraphicsPanel.MINY+POINTSIZE;
		this.ymax = GraphicsPanel.MAXY-POINTSIZE;
	}
	
	@Override
	public void update()
	{
			double tX = newX, tY = newY;
			
			newX = newX + (newX - oldX) + (a.x*Math.pow(DELTATIME,2));
			newY = newY + (newY - oldY) - (a.y*Math.pow(DELTATIME,2));
			
			oldX = tX;
			oldY = tY;
			
			
			//PUSHING BACK TO THE BORDER TO CREATE A BOUNCING EFFECT
			if(newX > xmax) newX = xmax;
			if(newX < xmin) newX = xmin;
			if(newY > ymax) newY = ymax;
			if(newY < ymin) newY = ymin;
			
			//System.out.println(GraphicsPanel.shape.box.size());
			
			/*for(Box b: GraphicsPanel.shape.box){
				//System.out.println(newX+","+newY);
				
				if(newX > b.l && newX < b.r && newY <b.b && newY >b.t ) {
					//System.out.println(newX+","+newY+"INDSIDE"+b.name);
					double max = 2000;
					int is = 0;
					
					if(newX-b.l<max){
						max = newX-b.l;
						is = 1;
					}
					if(b.r-newX<max){
						max = b.r-newX;
						is = 2;
					}
					if(newY-b.t<max){
						max = newY-b.t;
						is = 3;
					}
					if(b.b-newY<max){
						max =b.b-newY;
						is = 4;
					}
					
					if(is==1){
						newX = b.l;
						oldX = b.l;
					}
					else if(is==2){
						newX = b.r;
						oldX = b.r;
					}
					else if(is==3){
						newY=b.t;
						oldY = b.t;
					}
					else if(is==4){
						newY=b.b;
						oldY = b.b;
					}
				}
			}*/

	}
	
	public double getNewX()
	{
		return newX;
	}
	
	public double getNewY()
	{
		return newY;
	}
	
	public void setNewX(double n)
	{
		newX=n;
	}
	
	public void setNewY(double n)
	{
		newY=n;
	}
	
	public void setOldX(double n)
	{
		oldX=n;
	}
	
	public void setOldY(double n)
	{
		oldY=n;
	}
	
	
	
	public Acceleration getA()
	{
		return a;
	}
	
	public void setA(Acceleration a)
	{
		this.a =a;
	}
	
	
	public double getXmin()
	{
		return xmin;
	}
	
	public double getXmax()
	{
		return xmax;
	}
	
	public double getYmin()
	{
		return ymin;
	}
	
	public double getYmax()
	{
		return ymax;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		Ellipse2D.Double tempPoint = new Ellipse2D.Double(newX-POINTSIZE/2, newY-POINTSIZE/2, POINTSIZE, POINTSIZE);
		g.setColor(Color.WHITE);
		g.fill(tempPoint);
	}
	
	public void set(double x, double y)
	{
		newX = x;
		newY = y;
	}
	
}
