package shapes;

import java.util.ArrayList;

import physics.Edge;
import physics.Traject;
import physics.Vertex;
import players.Coin;
import players.Q1Guard;
import players.Player;

public class MapQ4 extends Shape{
	
	
	public int numberOfCoins = 8;
	
	public MapQ4(int width, int height, int blocksize )
	{
		edges = new ArrayList<Edge>();
		
		//Vertex hc = new Vertex(width, height);
		int x = width;
		int y = height;
		int d = blocksize;

		Vertex a = new Vertex(x+2*d,y);
		Vertex b = new Vertex(x+2*d,y+d);
		edges.add(new Edge(a,b));
		
		Vertex c = new Vertex(x+4*d, y);
		edges.add(new Edge(a,c));
		
		Vertex h = new Vertex(x+3*d,y+d);
		
		edges.add(new Edge(b,h));
		
		Vertex e1 = new Vertex(x+3*d, y+2*d);
		Vertex e2 = new Vertex(x+4*d, y+2*d);
		
		edges.add(new Edge(h,e1));
		
		edges.add(new Edge(c,e2));
		
		Vertex tc1 = new Vertex(x+2*d,y+2*d);
		
		edges.add(new Edge(e1, tc1));
		
		Vertex tc2 = new Vertex(x+9*d, y+2*d);
		
		Vertex tc3 = new Vertex(x+9*d, y+9*d);
		
		Vertex tc4 = new Vertex(x+2*d, y+9*d);
		
		Vertex cc1 = new Vertex(x+4*d, y+4*d);
		
		Vertex cc2 = new Vertex(x+7*d, y+4*d);
		
		Vertex cc3 = new Vertex(x+7*d, y+7*d);
		
		Vertex cc4 = new Vertex(x+4*d, y+7*d);
		
		edges.add(new Edge(cc1, cc2));
		
		edges.add(new Edge(cc2, cc3));
		
		edges.add(new Edge(cc3, cc4));
		
		edges.add(new Edge(cc4, cc1));
		
		Vertex e3 = new Vertex(x+7*d, y+2*d);
		
		Vertex e4 = new Vertex(x+8*d, y+2*d);
		
		Vertex e5 = new Vertex(x+9*d, y+3*d);
		
		Vertex e6 = new Vertex(x+9*d, y+4*d);
		
		Vertex e7 = new Vertex(x+9*d, y+7*d);
		
		Vertex e8 = new Vertex(x+9*d, y+8*d);
		
		Vertex e9 = new Vertex(x+8*d, y+9*d);
		
		Vertex e10 = new Vertex(x+7*d, y+9*d);
		
		Vertex e11 = new Vertex(x+4*d, y+9*d);
		
		Vertex e12 = new Vertex(x+3*d, y+9*d);
		
		Vertex e13 = new Vertex(x+2*d, y+8*d);
		
		Vertex e14 = new Vertex(x+2*d, y+7*d);
		
		Vertex e15 = new Vertex(x+2*d, y+4*d);
		
		Vertex e16 = new Vertex(x+2*d, y+3*d);
		
		edges.add(new Edge(e2, e3));
		
		edges.add(new Edge(e6, e7));
		
		edges.add(new Edge(e10, e11));
		
		edges.add(new Edge(e14, e15));
		
		edges.add(new Edge(tc1,e16));
		
		edges.add(new Edge(e4,tc2));
		
		edges.add(new Edge(e5,tc2));
		
		edges.add(new Edge(e8,tc3));
		
		edges.add(new Edge(e9,tc3));
		
		edges.add(new Edge(e12,tc4));
		
		edges.add(new Edge(e13,tc4));
		
		Vertex a2 = new Vertex(x+9*d,y+d);
		Vertex b2 = new Vertex(x+9*d,y);
		Vertex c2 = new Vertex(x+8*d,y+d);
		Vertex h2 = new Vertex(x+7*d,y);
		
		edges.add(new Edge(e3,h2));
		
		edges.add(new Edge(e4,c2));
		
		edges.add(new Edge(c2,a2));
		
		edges.add(new Edge(a2,b2));
		
		edges.add(new Edge(b2,h2));
		
		
		Vertex a3 = new Vertex(x+10*d,y+2*d);
		Vertex b3 = new Vertex( x+11*d,y+2*d );
		Vertex c3 = new Vertex( x+10*d,y+3*d );
		Vertex h3 = new Vertex(x+11*d,y+4*d);
		
		edges.add(new Edge(e6,h3));
		
		edges.add(new Edge(e5,c3));
		
		edges.add(new Edge(c3,a3));
		
		edges.add(new Edge(a3,b3));
		
		edges.add(new Edge(b3,h3));
		
		Vertex a4 = new Vertex(x+10*d,y+9*d);
		Vertex b4 = new Vertex(x+11*d,y+9*d);
		Vertex c4 = new Vertex(x+10*d,y+8*d);
		Vertex h4 = new Vertex(x+11*d,y+7*d);
		
		edges.add(new Edge(e7,h4));
		
		edges.add(new Edge(e8,c4));
		
		edges.add(new Edge(c4,a4));
		
		edges.add(new Edge(a4,b4));
		
		edges.add(new Edge(b4,h4));
		//edges.add(new Edge())
		
		Vertex a5 = new Vertex(x+9*d,y+10*d);
		Vertex b5 = new Vertex(x+9*d,y+11*d);
		Vertex c5 = new Vertex(x+8*d,y+10*d);
		Vertex h5 = new Vertex(x+7*d,y+11*d);
		
		edges.add(new Edge(e10,h5));
		
		edges.add(new Edge(e9,c5));
		
		edges.add(new Edge(c5,a5));
		
		edges.add(new Edge(a5,b5));
		
		edges.add(new Edge(b5,h5));
		
		Vertex a6 = new Vertex(x+2*d,y+10*d);
		Vertex b6 = new Vertex(x+2*d,y+11*d);
		Vertex c6 = new Vertex(x+3*d,y+10*d);
		Vertex h6 = new Vertex(x+4*d,y+11*d);
		
		edges.add(new Edge(e11,h6));
		
		edges.add(new Edge(e12,c6));
		
		edges.add(new Edge(c6,a6));
		
		edges.add(new Edge(a6,b6));
		
		edges.add(new Edge(b6,h6));
		
		
		Vertex a7 = new Vertex(x+1*d,y+9*d);
		Vertex b7 = new Vertex(x+0*d,y+9*d);
		Vertex c7 = new Vertex(x+1*d,y+8*d);
		Vertex h7 = new Vertex(x+0*d,y+7*d);
		
		edges.add(new Edge(e14,h7));
		
		edges.add(new Edge(e13,c7));
		
		edges.add(new Edge(c7,a7));
		
		edges.add(new Edge(a7,b7));
		
		edges.add(new Edge(b7,h7));
		
		Vertex a8 = new Vertex(x+1*d,y+2*d);
		Vertex b8 = new Vertex(x+0*d,y+2*d);
		Vertex c8 = new Vertex(x+1*d,y+3*d);
		Vertex h8 = new Vertex(x+0*d,y+4*d);
		
		edges.add(new Edge(e15,h8));

		edges.add(new Edge(e16,c8));
		
		edges.add(new Edge(c8,a8));
		
		edges.add(new Edge(a8,b8));
		
		edges.add(new Edge(b8,h8));
		
		// 1, 3, 7,9,  12, 14, 18, 20, 23 , 25, 29, 31, 34, 36, 40, 42
		
		int i = d/2;
		
		coins.add(new Coin(x+2*d+i,y+0*d+i));
		coins.add(new Coin(x+8*d+i,y+0*d+i));
		coins.add(new Coin(x+10*d+i,y+2*d+i));
		coins.add(new Coin(x+10*d+i,y+8*d+i));
		coins.add(new Coin(x+8*d+i,y+10*d+i));
		coins.add(new Coin(x+2*d+i,y+10*d+i));
		coins.add(new Coin(x+0*d+i,y+8*d+i));
		coins.add(new Coin(x+0*d+i,y+2*d+i));

		player = new Player(x+5*d +i, y+8*d+i);
		
		player.path.add(new Traject(x+7*d +i, y+8*d+i,Player.Dir.r));
		player.path.add(new Traject(x+7*d +i, y+10*d+i,Player.Dir.t));
		player.path.add(new Traject(x+8*d +i, y+10*d+i,Player.Dir.r));
		player.path.add(new Traject(x+7*d +i, y+10*d+i,Player.Dir.l));
		player.path.add(new Traject(x+7*d +i, y+8*d+i,Player.Dir.b));
		
		player.path.add(new Traject(x+8*d +i, y+8*d+i,Player.Dir.r));
		
		player.path.add(new Traject(x+8*d +i, y+7*d+i,Player.Dir.b));
		player.path.add(new Traject(x+10*d +i, y+7*d+i,Player.Dir.r));
		player.path.add(new Traject(x+10*d +i, y+8*d+i,Player.Dir.t));
		player.path.add(new Traject(x+10*d +i, y+7*d+i,Player.Dir.b));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+8*d +i, y+7*d+i,Player.Dir.l));
		
		player.path.add(new Traject(x+8*d +i, y+3*d+i,Player.Dir.b));
		player.path.add(new Traject(x+10*d +i, y+3*d+i,Player.Dir.r));
		player.path.add(new Traject(x+10*d +i, y+2*d+i,Player.Dir.b));
		player.path.add(new Traject(x+10*d +i, y+3*d+i,Player.Dir.t));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+8*d +i, y+3*d+i,Player.Dir.l));
		
		player.path.add(new Traject(x+8*d +i, y+2*d+i,Player.Dir.b));
		
		player.path.add(new Traject(x+7*d +i, y+2*d+i,Player.Dir.l));
		player.path.add(new Traject(x+7*d +i, y+0*d+i,Player.Dir.b));
		player.path.add(new Traject(x+8*d +i, y+0*d+i,Player.Dir.r));
		player.path.add(new Traject(x+7*d +i, y+0*d+i,Player.Dir.l));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+7*d +i, y+2*d+i,Player.Dir.t));
				
		player.path.add(new Traject(x+3*d +i, y+2*d+i,Player.Dir.l));
		player.path.add(new Traject(x+3*d +i, y+0*d+i,Player.Dir.b));
		player.path.add(new Traject(x+2*d +i, y+0*d+i,Player.Dir.l));
		player.path.add(new Traject(x+3*d +i, y+0*d+i,Player.Dir.r));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+3*d +i, y+2*d+i,Player.Dir.t));
		
		player.path.add(new Traject(x+2*d +i, y+2*d+i,Player.Dir.l));
		
		player.path.add(new Traject(x+2*d +i, y+3*d+i,Player.Dir.t));
		player.path.add(new Traject(x+0*d +i, y+3*d+i,Player.Dir.l));
		player.path.add(new Traject(x+0*d +i, y+2*d+i,Player.Dir.b));
		player.path.add(new Traject(x+0*d +i, y+3*d+i,Player.Dir.t));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+2*d +i, y+3*d+i,Player.Dir.r));
		
		player.path.add(new Traject(x+2*d +i, y+7*d+i,Player.Dir.t));
		player.path.add(new Traject(x+0*d +i, y+7*d+i,Player.Dir.l));
		player.path.add(new Traject(x+0*d +i, y+8*d+i,Player.Dir.t));
		player.path.add(new Traject(x+0*d +i, y+7*d+i,Player.Dir.b));
		//player.path.add(new Traject());
		player.path.add(new Traject(x+2*d +i, y+7*d+i,Player.Dir.r));

		player.path.add(new Traject(x+2*d +i, y+8*d+i,Player.Dir.t));
		
		player.path.add(new Traject(x+3*d +i, y+8*d+i,Player.Dir.r));
		player.path.add(new Traject(x+3*d +i, y+10*d+i,Player.Dir.t));
		player.path.add(new Traject(x+2*d +i, y+10*d+i,Player.Dir.l));
		
		
		guards.add(new Q1Guard(x+3*d -i, y+3*d-i));
		guards.add(new Q1Guard(x+3*d -i, y+3*d-i));
		guards.add(new Q1Guard(x+3*d -i, y+3*d-i));
		
		
		//gards.add(new Guard(x+3*d , y+3*d));
		//gards.add(new Guard(x+3*d , y+3*d));
		
		/*
		Vertex hl = new Vertex(hc.getNewX()-20, hc.getNewY()+20);
		Vertex hr = new Vertex(hc.getNewX()+20, hc.getNewY()+20);
		
		Vertex hll = new Vertex(hc.getNewX()-15, hc.getNewY()+40);
		Vertex hrr = new Vertex(hc.getNewX()+15, hc.getNewY()+40);
		Vertex chin = new Vertex(hc.getNewX(), hc.getNewY()+40);
		
		Vertex neck = new Vertex(hc.getNewX(), hc.getNewY()+60);
		
		Vertex e1 = new Vertex(hc.getNewX()+50, hc.getNewY()+100);
		
		Vertex e2 = new Vertex(hc.getNewX()-50, hc.getNewY()+100);
		
		Vertex h1 = new Vertex(hc.getNewX()+50, hc.getNewY()+200);
		
		Vertex h2 = new Vertex(hc.getNewX()-50, hc.getNewY()+200);
		
		Vertex d = new Vertex(hc.getNewX(), hc.getNewY()+200);
		
		Vertex l1 = new Vertex(hc.getNewX()+50, hc.getNewY()+300);
		
		Vertex l2 = new Vertex(hc.getNewX()-50, hc.getNewY()+300);
		
		Vertex f1 = new Vertex(hc.getNewX()+50, hc.getNewY()+400);
		
		Vertex f2 = new Vertex(hc.getNewX()-50, hc.getNewY()+400);
		
		Vertex ey1 = new Vertex(hc.getNewX()+10, hc.getNewY()+20);
		
		Vertex ey2 = new Vertex(hc.getNewX()-10, hc.getNewY()+20);
		
		

		edges.add(new Edge(ey1, ey2));
		
		edges.add(new Edge(hc, hl));
		edges.add(new Edge(hc, hr));
		edges.add(new Edge(hl, hll));
		edges.add(new Edge(hll, chin));
		edges.add(new Edge(hr, hrr));
		edges.add(new Edge(hrr, chin));

		
		edges.add(new Edge(neck, chin));
		edges.add(new Edge(neck, e1));
		edges.add(new Edge(neck, e2));
		
		edges.add(new Edge(e1, h1));
		
		edges.add(new Edge(e2, h2));
		
		edges.add(new Edge(neck, d ));
		
		edges.add(new Edge( d,l1 ));
		edges.add(new Edge( d,l2 ));

		edges.add(new Edge(l2, f2 ));
		edges.add(new Edge(l1, f1 ));
		*/
	}
}
