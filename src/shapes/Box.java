package shapes;

import physics.Vertex;
import GUIFramework.GraphicsPanel;

public class Box {
	
	public double l;
	
	public double r;
	
	public double t; 
	
	public double b;
	
	public String name;
	
	public Box(double v1, double v2, double v3, double v4){
		 this.l= v1;
		 this.r = v2; 
		 this.t = v3;
		 this.b = v4;
	}
}
