package players;

import java.awt.Graphics2D;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import shapes.Shape;

public class Coin extends Shape{
	
	public int x;
	public int y;
	
	public boolean taken;
	
	public static Image image;
	
	static{
		
		try {
			image = new ImageIcon(new URL("http://www.cs.mcgill.ca/~mcherk3/spacequest/images/coin.gif")).getImage();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Coin( int x, int y){
		this.x = x;
		this.y = y;
		taken = false;
	}
	public void taken(){
		this.taken = true;
	}
	
	public boolean intersect(int i, int j){
		
		double distx = Math.abs(x-i);
		
		double disty = Math.abs(y-j);
		
		if( Math.sqrt(distx*distx+disty*disty) < 15){
			return true;
		}		
		return false;
	}

	public void draw(Graphics2D g){
		
		if(taken == false){
			g.drawImage(image, x-15 , y-15, null);
		}
	}
}
