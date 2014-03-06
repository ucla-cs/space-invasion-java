package GUIFramework;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import physics.Acceleration;
import physics.Vertex;
import players.Player;
import players.Q1Guard;

import shapes.BigMap;
import shapes.MapGame;
import shapes.MapQ1;
import shapes.MapQ2;
import shapes.MapQ3;
import shapes.MapQ4;
import shapes.SmallMap;
import shapes.Square;
import shapes.Shape;

/*
 * @MEKI
 * 
 * Graphics Panel Class
 * 
 */

public class GraphicsPanel extends JPanel// implements KeyListener  //implements MouseInputListener
{
	private final static int WIDTH = 550;
	
	private final static int HEIGHT = 500;
	
	public final static int DEFAULTSIZE = 50;
	
	public final static int MINX = 0, MAXX = WIDTH, MINY = 0, MAXY = HEIGHT;
	
	private final static int THREADSLEEP = 30;
	
	private Rectangle2D.Double container = new Rectangle2D.Double(MINX+Vertex.POINTSIZE/2, MINY+Vertex.POINTSIZE/2, MAXX-Vertex.POINTSIZE, MAXY-Vertex.POINTSIZE);
	
	public static Acceleration tempAcc;
	
	public static Shape shape;
	
	public boolean dragging;
	
	public static Image bgImage;
	
	public static Frame f;
	

	public boolean control;
	
	public void setFrame(Frame f){
		this.f= f;
	}
	
	public GraphicsPanel(int choice)
	{
		
		control =false;
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		//this.addMouseListener(this);
	    //this.addMouseMotionListener(this);
		
	    dragging =true;
	    
			bgImage = new ImageIcon("images/galaxy.gif").getImage();

	    
	    //System.out.println(bgImage == null);
	    
		//setBackground(new ImageIcon("images/galaxy.jpg").getImage());
		
		switch(choice)
		{
			case 1: question1(); break;
			case 2: question2(); break;
			case 3: question3(); break;
			case 4: question4(); break;
			case 5: questiongame(); break;
		}
		this.setFocusable(true);   // Allow this panel to get focus.
	    
	}
	
	public double getRandomFrom0to1()
	{
		int sign;
		
		if(Math.random()>0.5) sign = 1;
		else sign = -1;
		
		return sign*Math.random();
	}

	public void question1()
	{	
		control =false;
		Q1Guard.guardaware = false;
		MapQ1 m = new MapQ1(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;
		//shape = new Square(topleft,DEFAULTSIZE);

	}

	
	private void question2() 
	{
		control =false;
		Q1Guard.guardaware = true;
		MapQ2 m = new MapQ2(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;
	}
	
	private void question3(){
		control =false;
		Q1Guard.guardaware = false;
		Player.guardaware = true;
		MapQ3 m = new MapQ3(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;
	}
	
	private void question4(){
		control =false;
		Q1Guard.guardaware = true;
		Player.guardaware = true;
		MapQ4 m = new MapQ4(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;

	}
	
	private void questiongame(){
		control =true;
		Q1Guard.guardaware = true;
		MapGame m = new MapGame(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;

	}
	
	public static void win(){
		BigMap m = new BigMap(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;
		
			bgImage = new ImageIcon("images/galaxywin.gif").getImage();

	}
	
	public static void loose(){
		SmallMap m = new SmallMap(40, 40, 40);
		//Vertex topleft = new Vertex(WIDTH/2-DEFAULTSIZE/2, HEIGHT/2-DEFAULTSIZE/2,new Acceleration(getRandomFrom0to1(), getRandomFrom0to1()));
		shape = m;
		
			bgImage = new ImageIcon("images/galaxyloose.gif").getImage();

	}
	
	public void paintComponent(Graphics g)
	{
		
		
		
		
		clear(g);
		Graphics2D g2D = (Graphics2D) g;
		
		
		g2D.drawImage(bgImage, 0, 0, null);
		
		g2D.draw(container);
		
	   	shape.draw(g2D);
		
		try 
		{
			Thread.sleep(THREADSLEEP); 
		} 
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		shape.update();
		
		repaint();
	}
	
	

	public void clear(Graphics g)
	{
		super.paintComponent(g);
	}
	
	/*public void mouseClicked(MouseEvent arg0) {
		
		
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mouseDragged(MouseEvent e) {
		//shape.controlPoint.setNewX(e.getX());
		//shape.controlPoint.setNewY(e.getY());
		//shape.controlPoint.setOldX(e.getX());
		//shape.controlPoint.setOldY(e.getY());
	}

	public void mouseMoved(MouseEvent e) {
		
		//shape.controlPoint.update();
	}
	
	public void mousePressed(MouseEvent e) {
		//shape.controlPoint.setNewX(e.getX());
		//shape.controlPoint.setNewY(e.getY());
		//shape.controlPoint.setOldX(e.getX());
		//shape.controlPoint.setOldY(e.getY());
		
		//tempAcc = shape.controlPoint.getA();
		
		//shape.controlPoint.setA(new Acceleration(0,0));
		
		//dragging = false;
	}

	public void mouseReleased(MouseEvent e) {
		shape.controlPoint.setA(tempAcc);
		
		dragging = true;
		
	}
	/*
	@Override
	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		
		if( c == KeyEvent.VK_RIGHT ){
			System.out.println("up");
		}
		if( c == KeyEvent.VK_LEFT ){
			System.out.println("down");
		}
		if( c == KeyEvent.VK_UP ){
			System.out.println("left");
		}
		if( c == KeyEvent.VK_DOWN ){
			System.out.println("right");
		}
		
	}
*/

}
