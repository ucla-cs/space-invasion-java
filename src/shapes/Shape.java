package shapes;
import java.awt.Graphics2D;
import java.util.ArrayList;

import physics.Constraint;
import physics.Edge;
import physics.Vertex;
import players.Coin;
import players.Q1Guard;
import players.Player;





public abstract class Shape
{
	
	
	public ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public ArrayList<Q1Guard> guards = new ArrayList<Q1Guard>();
	
	public ArrayList<Coin> coins = new ArrayList<Coin>();
	
	public Player player = null;
	
	//public ArrayList<Box> box = new ArrayList<Box>();
	
	
	public Vertex controlPoint;
	
	public  static int SHAPEUPDATES = 10;
	
	
	public void draw(Graphics2D g) 
	{
		for(Edge e: edges)
		{
			e.draw(g);
		}
		for(Coin c: coins)
		{
			c.draw(g);
		}
		for(Q1Guard c: guards)
		{
			c.draw(g);
		}
		if(player!=null)
			player.draw(g);
	}
	
	public void update() 
	{
		for(int i =0; i<SHAPEUPDATES ; i++)
		{	
			for(Q1Guard e: guards)
			{
				e.update();
			}
			if(player!=null)
				player.update();
		}
		
		
		
	}
}
