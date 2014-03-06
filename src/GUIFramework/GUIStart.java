package GUIFramework;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/*
 * @MEKI 
 * THIS CLASS STARTS THE GUI
 */

public class GUIStart extends JApplet implements KeyListener
{
	/*
	final static JButton restart1a = new JButton("Question 1a");
	final static JButton restart1b = new JButton("Question 1b");
	final static JButton restart2 = new JButton("Question 2");
	final static JButton restart3 = new JButton("Question 3");
	final static JButton restart4 = new JButton("Question 4 Random");
	final static JButton restart5 = new JButton("Question 4 West-East Acceleration");
	*/
	
	static JButton restart1a; //= new JButton("Question1");
	static JButton restart1b; //= new JButton("Question2");
	static JButton restart2; //= new JButton("Question3");
	static JButton restart3; //= new JButton("Question4");
	static JButton restart4;
	//final static JButton restart4 = new JButton("Dude trying to pass a wall");
	//static JButton restart5 = new JButton("Passing through a hole");
	
	//final static JFrame frame = new JFrame("Meki Cherkaoui COMP 521 ASS2");
	static JPanel total = new JPanel();
	static GraphicsPanel mygp = new GraphicsPanel(1);
	
	static Applet me;
	
	public void destroy(){
		super.destroy();
	}
	
	
	public void init() {
		
	    restart1a = new JButton("(1)");
		restart1b = new JButton("(2)");
		restart2 = new JButton("(3)");
		restart3 = new JButton("(4)");
		restart4 = new JButton("(5)new game");
		
		restart1a.setEnabled(false);
		restart1b.setEnabled(false);
		restart2.setEnabled(false);
		restart3.setEnabled(false);
		restart4.setEnabled(false);
		//final static JButton restart4 = new JButton("Dude trying to pass a wall");
		//restart5 = new JButton("Passing through a hole");
		
		//final static JFrame frame = new JFrame("Meki Cherkaoui COMP 521 ASS2");
		
		//System.out.println("LOADING...");
		try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                	total = new JPanel();
            		mygp = new GraphicsPanel(5);
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }

    }
    
	
	public void start(){
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(550,550));
		me=this;
		/*restart1a.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				//me.setFocusable(true);
				//total.removeAll();
				
				repaintAll(1);
				
				setVisible(true);
				me.setFocusable(true);
				me.addKeyListener((KeyListener) me);
				
			}
			
		});
		restart1b.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				repaintAll(2);
				setVisible(true);
			}
			
		});
		restart2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				

				repaintAll(3);
				
				setVisible(true);
			}
			
		});
		restart3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				

				repaintAll(4);
				
				setVisible(true);
			}
			
		});
		restart4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				
				//total.removeAll();
				
				repaintAll(5);
				
				setVisible(true);
				
			}
			
		});
		
		
		*/
		
		
		this.setFocusable(true);   
		this.addKeyListener((KeyListener) this);
		total.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		
		
		total.add(north,BorderLayout.NORTH);
		
		//north.add(restart1a,BorderLayout.NORTH);
		//north.add(restart1b,BorderLayout.NORTH);
		//north.add(restart2,BorderLayout.NORTH);
		//north.add(restart3,BorderLayout.NORTH);
		//north.add(restart4,BorderLayout.NORTH);
		
		//north.add(restart4,BorderLayout.NORTH);
		//north.add(restart5,BorderLayout.NORTH);
		
		total.add(mygp,BorderLayout.CENTER);
		
		add(total);
		
		repaint();
		setVisible(true);
		
		//frame.getContentPane().add(total);
		
		//frame.pack();
		
		//frame.setVisible(true);
	}
	
	/*public static void main(String[] args)
	{
		
		new GUIStart().start();
	}*/
	
	//public void start(){
		
	//}
	
	public void paint(Graphics g){
		super.paint( g );
		this.setFocusable(true);   
		//this.addKeyListener((KeyListener) this);
		//start();
	}
	
	
	public void repaintAll(int question){
		
		//System.out.println("painted all" +question);
		
		//mygp.removeAll();
		
		//total.remove(mygp);
		
		//mygp = new GraphicsPanel(question);
		
		total.add(new GraphicsPanel(question),BorderLayout.CENTER);
		this.setFocusable(true);   
		this.addKeyListener((KeyListener) this);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		
		//System.out.println(mygp.control +" "+ mygp.shape.player);
		if( mygp.control && mygp.shape.player !=null){
			//System.out.println(c);
			if( c == KeyEvent.VK_RIGHT ){
				mygp.shape.player.right = true;
			}
			if( c == KeyEvent.VK_LEFT ){
				mygp.shape.player.left = true;
			}
			if( c == KeyEvent.VK_DOWN ){
				mygp.shape.player.down = true;
			}
			if( c == KeyEvent.VK_UP ){
				mygp.shape.player.up = true;
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		
		if( c == KeyEvent.VK_1 ){
			repaintAll(1);
			
			setVisible(true);
		}
		if( c == KeyEvent.VK_2 ){
			repaintAll(2);
			
			setVisible(true);
		}
		if( c == KeyEvent.VK_3 ){
			repaintAll(3);
			
			setVisible(true);
		}
		if( c == KeyEvent.VK_4 ){
			repaintAll(4);
			
			setVisible(true);
		}
		if( c == KeyEvent.VK_5 || c == KeyEvent.VK_N ){
			mygp.control =true;
			repaintAll(5);
			
			setVisible(true);
		}
		
		
		//System.out.println(mygp.control +" "+ mygp.shape.player);
		if( mygp.control && mygp.shape.player!=null){
			//System.out.println("HELLO");
			if( c == KeyEvent.VK_RIGHT ){
				mygp.shape.player.right = false;
			}
			if( c == KeyEvent.VK_LEFT ){
				mygp.shape.player.left = false;
			}
			if( c == KeyEvent.VK_UP ){
				mygp.shape.player.up = false;
			}
			if( c == KeyEvent.VK_DOWN ){
				mygp.shape.player.down = false;
			}
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
			}
}
