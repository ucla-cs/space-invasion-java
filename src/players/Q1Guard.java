package players;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;

import GUIFramework.GraphicsPanel;

import shapes.Box;
import shapes.Shape;

public class Q1Guard extends Shape{
	double x;
	double y;
	double speed = 10;
	
	Box box;
	
	public enum Dir{l,r,t,b};
	
	public enum Clock{c,r};
	
	public static boolean guardaware = false;
	
	public static Image image ;
	
	static{
		
			image = new ImageIcon("images/alien.gif").getImage();

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
	
	
	public Q1Guard( int x, int y ){
		
		Random generator = new Random();
		//int i = generator.nextInt(60) + 20;
		radius = 60;
		
		int i = generator.nextInt(2) + 15;
		speed = i;
		
		i = generator.nextInt(40) + 0;
		//System.out.println("x,y:" + x + " + " +y);
		
		this.l= x + i;
		this.r = x+ 5*40 +i ; 
		this.t = y+ 5*40  +i;
		this.b = y + i;
		
		//System.out.println("i"+i);
		side = getSide();
		
		if(side==Dir.l){
			this.x = l;
			int k = generator.nextInt((int)t -(int)b) + (int)b;
			this.y = k;		
			
		}
		if(side==Dir.r){
			this.x = r;
			int k = generator.nextInt((int)t - (int)b) + (int)b;
			this.y = k;
		}
		if(side==Dir.b){
			this.y = b;
			int k = generator.nextInt((int)r - (int)l) + (int)l;
			this.x = k;
		}
		
		if( generator.nextBoolean()==true){
			if( side == Dir.l || side == Dir.r){
				going = Dir.t;
			}
			else
			{
				going = Dir.r;
			}
		}
		else{
			if( side == Dir.l || side == Dir.r){
				going = Dir.b;
			}
			else
			{
				going = Dir.l;
			}
		}
		
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
		double distx = Math.abs(x-i + dx);
		
		double disty = Math.abs(y-j + dy);
		
		if( Math.sqrt(distx*distx+disty*disty) < radius){
			return true;
		}		
		return false;
	}
	
	public void draw(Graphics2D g){
		    
			//AffineTransform at = new AffineTransform();
		
			double angle = getAngle();
		
			g.rotate(angle ,x , y);
			
			int dx = 0;
			int dy = 0;
			
			if( going == Dir.b){
				g.drawImage(image, (int)x-20 , (int)y-10, null);
				dy -= 25;
			}
			else if(going ==Dir.t){
				g.drawImage(image, (int)x-25 , (int)y-15, null);
				dy += 25;
			}
			else if(going ==Dir.r){
				g.drawImage(image, (int)x-20 , (int)y-17, null);
				dx += 25;
			}
			else if(going ==Dir.l){
				g.drawImage(image, (int)x-25 , (int)y-13, null);
				dx -= 25;
			}
			g.rotate(-angle ,x , y);
			
			
			
			
			Ellipse2D.Double circle = new Ellipse2D.Double(x-radius+dx, y-radius+dy, 2*radius, 2*radius);
			
			
			//g.rotate(Math.PI);
			if(guardaware==true){
				boolean intersect = false;
				
				for( Q1Guard gu : GraphicsPanel.shape.guards){
					if(gu.x!=this.x && gu.y!=this.y)
						if(this.intersect((int)gu.x, (int)gu.y)) 
							intersect = true;
					
				}
				if(intersect==true){
					g.setColor(Color.green);
				}
			}
			//CHECK IF INTERSECT WITH 
			g.draw(circle);
			g.setColor(Color.WHITE);
			
			
			
			Ellipse2D.Double tempPoint = new Ellipse2D.Double(x, y, 5, 5);
	
			g.fill(tempPoint);
	}
	
	public void update(){
	
		
		
		if(stopped){
			if(System.currentTimeMillis() - starttime > threshole){
				stopped = false;
			}
			
		}
		if(!stopped){
			
			if(GraphicsPanel.shape.player !=null){
				if(this.intersect((int)GraphicsPanel.shape.player.x, (int)GraphicsPanel.shape.player.y)) 
					GraphicsPanel.loose();
			}
			
			double dt = 0.02;
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
			Random generator = new Random();

			int chance = generator.nextInt(3000);
			
			if(chance == 3){
				stopped = true;
				starttime = System.currentTimeMillis();
			    currtime = starttime;
				
			}
			
		}
		
	}
	
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
}
