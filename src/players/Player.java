package players;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import physics.Edge;
import physics.Traject;
import players.Q1Guard.Dir;
import shapes.Box;
import GUIFramework.GraphicsPanel;

public class Player {
	
	int n=2;
	
	double x;
	double y;
	double speed = 15;
	
	Box box;
	
	public enum Dir{l,r,t,b};
	
	public enum Clock{c,r};
	
	public static boolean guardaware = false;
	
	
	public static Image image;
	
	static{
		/*
		try {
			image = new ImageIcon(new URL("http://www.cs.mcgill.ca/~mcherk3/spacequest/images/spaceship.gif")).getImage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			image = new ImageIcon("images/spaceship.gif").getImage();

	}
	
	public Dir orientation;
	
	public int radius ;
	
	public Dir side;
	
	
	public double l;
	
	public double r;
	
	public double t;
	
	public double b;
	
	public Dir going;
	
	
	public boolean stopped;
	
	public long currtime;
	
	public long starttime;
	
	public long threshole = 2000;
	
	public int gx;
	
	public int gy;
	
	public Player( int x, int y ){
		
		side = Dir.b;
		
		side = Dir.b;
		
		radius = n*60;
		
		//System.out.println("x,y:" + x + " + " +y);
		
		gx = x;
		gy = y;
		
		this.x=x;
		this.y=y;
		
		//System.out.println("i"+i);
		//side = getSide();
		goingforward = true;
	}
	
	
	public boolean intersect(int i, int j){
		int dx = 0;
		int dy = 0;
		if( going == Dir.b){
			dy -= 25;
		}
		else if(going ==Dir.t){
			dy += 25;
		}
		else if(going ==Dir.r){
			dx += 25;
		}
		else if(going ==Dir.l){
			dx -= 25;
		}
		
		double distx = Math.abs(x-i+dx);
		
		double disty = Math.abs(y-j+dy);
		
		if( Math.sqrt(distx*distx+disty*disty) < radius){
			return true;
		}		
		return false;
	}
	
	public void draw(Graphics2D g){
		    
			//AffineTransform at = new AffineTransform();
		
			double angle = getAngle();
		
			/*g.rotate(Math.PI,x , y);
			
			if( going == Dir.b){
				g.drawImage(image, (int)x-20 , (int)y-10, null);
			}
			else if(going ==Dir.t){
				g.drawImage(image, (int)x-25 , (int)y-15, null);
			}
			else if(going ==Dir.r){
				g.drawImage(image, (int)x-20 , (int)y-17, null);
			}
			else if(going ==Dir.l){
				g.drawImage(image, (int)x-25 , (int)y-13, null);
			}
			g.rotate(1);*/
			//g.rotate(1 );
			g.drawImage(image,(int)x-15 , (int)y-10,null);
			//g.rotate(-1 );
			
			int dx = 0;
			int dy = 0;
			if( going == Dir.b){
				dy -= 25;
			}
			else if(going ==Dir.t){
				dy += 25;
			}
			else if(going ==Dir.r){
				dx += 25;
			}
			else if(going ==Dir.l){
				dx -= 25;
			}
			
			Ellipse2D.Double circle = new Ellipse2D.Double(x-radius+dx, y-radius+dy, 2*radius, 2*radius);
			
			
			if(guardaware==true){
				boolean intersect = false;
				
				for( Q1Guard gu : GraphicsPanel.shape.guards){
					if(this.intersect((int)gu.x, (int)gu.y)) 
							intersect = true;
				}
				if(intersect==true){
					g.setPaint(Color.red);
				}
			}
			//CHECK IF INTERSECT WITH
			
			g.draw(circle);
			g.setColor(Color.WHITE);
			
			
			
			Ellipse2D.Double tempPoint = new Ellipse2D.Double(x, y, 5, 5);
	
			g.fill(tempPoint);
			
	}
	
	public ArrayList<Traject> path = new ArrayList<Traject>();
	public int current = 0;
	boolean goingforward = true;
	//public boolean halfway= false;
	public void update(){
		
		/*if(stopped){
			if(System.currentTimeMillis() - starttime > threshole){
				stopped = false;
			}
			
		}
		if(!stopped){*/
			/*double dt = 0.02;
			if( going == Dir.t){
				y += speed * dt;
				
				if(y >t){
					y = t;
					
					if( side == Dir.r ){
						going = Dir.l;
					}
					else if(side == Dir.l){
						going = Dir.r;
					}
					side = Dir.t;
					
				}
				
			}
			else if(going ==Dir.b){
				y -= speed * dt;
				
				if(y <b){
					y = b;
					
					if( side == Dir.r ){
						going = Dir.l;
					}
					else if(side == Dir.l){
						going = Dir.r;
					}
					side = Dir.b;
					
				}
			}
			else if(going ==Dir.r){
				x += speed * dt;
				
				if(x >r){
					x = r;
					
					if( side == Dir.t ){
						going = Dir.b;
					}
					else if(side == Dir.b){
						going = Dir.t;
					}
					side = Dir.r;
					
				}
			}
			else if(going ==Dir.l){
				x -= speed * dt;
				
				if(x <l){
					x = l;
					
					if( side == Dir.t ){
						going = Dir.b;
					}
					else if(side == Dir.b){
						going = Dir.t;
					}
					side = Dir.l;
					
				}
			}
			/*Random generator = new Random();

			int chance = generator.nextInt(2000);
			
			if(chance == 3){
				stopped = true;
				starttime = System.currentTimeMillis();
			    currtime = starttime;*/
				
			//}
			
		double prevx = x;
		double prevy = y;
		
			for(Coin c: GraphicsPanel.shape.coins){
				if( c.intersect((int)x, (int)y) ){
					c.taken = true;
				}
			}
			int count =0;
			for(Coin c: GraphicsPanel.shape.coins){
				
					if(c.taken){
						count++;
					}
			}
			if(count == 8){
				GraphicsPanel.win();
			}
			double dt = 0.02;
			
			if(current==-1){
				current=0;
			}
			
			if(path.size()!=0 ){
				boolean seen = false;
				for( Q1Guard gu : GraphicsPanel.shape.guards){
					if(this.intersect((int)gu.x, (int)gu.y)) 
						seen = true;
				}
				if( !path.get(current).typeWait ){
					Traject cur =path.get(current);

					if(seen  && goingforward ){
						if(current!=0) goingforward=false;
						if(!inList(current))current--;
						if(current == -1)current =0;
						cur = path.get(current);
					}
					
					else if( ! seen && goingforward){
						cur = path.get(current);
					}
					else if( seen &&!goingforward){
						cur = path.get(current);
					}
					else if(!seen &&!goingforward){
						goingforward=true;
						current++;
						cur = path.get(current);
					}
					going = path.get(current).going;
					if( cur.gx - x >0){
						x += speed * dt;
					}
					else if(cur.gx - x <0){
						x -= speed*dt;
					}
					if( cur.gy - y >0){
						y += speed * dt;
					}
					else if(cur.gy - y <0){
						y -= speed*dt;
					}
					
					if( (int)x- cur.gx ==0 && (int)y -cur.gy==0 ){
						x = cur.gx;
						y = cur.gy;
						if(goingforward || current ==0  ){
							current++;
						}
						else{
							if(!inList(current))current--;
							
						}
					}
				}
			}
			
			if(right)
				x += speed * dt;
			
			if(left)
				 x -= speed * dt;
			
			if(down)
				 y += speed * dt;
			
			if(up)
				 y -= speed * dt;
			
			
			for(Edge e: GraphicsPanel.shape.edges){
				
				Line2D.Double d = new Line2D.Double(e.A.getNewX(),e.A.getNewY(),e.B.getNewX(),e.B.getNewY());
				
				
				if((int)d.ptSegDist(x,y) ==0 ){
					x = prevx;
					y = prevy;
				}
			}
			
		}
	private boolean inList(int a) {
		if( a==0||a== 1||a== 3|| a==7||a==9||a== 12|| a==14||a== 18|| a==20||a== 23 || a==25||a== 29||a== 31||a== 34||a== 36|| a==40||a== 42)
			return true;
		return false;
	}


	//}
	
	private double getAngle(){
		double a = 0;
		
		if(going == Dir.l){
			a = 3*Math.PI/2;
		}
		if(going == Dir.r){
			a = Math.PI/2;
		}
		if(going == Dir.t){
			a= Math.PI;
		}
		if(going == Dir.b){
			a = 0;
		}
		
		return a;
		
	}
	
	private Dir getSide(){
		Random generator = new Random();

		int i = generator.nextInt(3) + 1;
		
		if(i==1){
			//System.out.println("l");
			return Dir.l;
		}
		if(i==2){
			//System.out.println("r");
			return Dir.r;
		}
		if(i==3){
			//System.out.println("b");
			return Dir.b;
		}
		System.out.println("FATAL ERROR");
		return null;
	}
	
	public boolean left=false;
	public boolean right=false;
	public boolean down=false;
	public boolean up=false;
}
