package physics;

import players.Player;

public class Traject {
	
	
	public int gx;
	
	public int gy;
	
	public boolean typeWait = true;
	
	public Player.Dir going = null;
	
	public Traject(int x, int y, Player.Dir g){
		gx= x;
		gy= y;
		typeWait = false;
		going = g;
	}
	
	public Traject(){
		typeWait = true;
	}
	
}
