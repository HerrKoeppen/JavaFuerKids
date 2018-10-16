package play3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game3 extends JFrame implements KeyListener, MouseListener
{
  private int x = 370, xDiff = 10;
  private int y = 260, yDiff = 10;
  private int Breite, Hoehe, Nr;
  private Graphics Grafik;
  private Image[] Bild = new Image[5];
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";
  private Robot robot;
  
  public Game3 ()
  {
    super ("Game 3");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Platte.setBackground (Color.green);
    setContentPane (Platte);
    Init();
  }

  public void Init ()
  {   
    // Spielfiguren "einbinden"	
	Toolkit Werkzeug = Toolkit.getDefaultToolkit();
	MediaTracker Transporter = new MediaTracker (this);
	for (int i = 1; i <= 4; i++)
    {
      Bild[i] = Werkzeug.getImage 
        (Pfad + "Insekt" + Integer.toString(i) + ".jpg");
      Transporter.addImage (Bild[i], i);
      try
      {
        Transporter.waitForID (i);
      }
	  catch (InterruptedException x)
	  {
	    setTitle ("Bildstörung");
	  }
    }
    // "Lauscher" für Tasten und Maus einfügen
    addKeyListener(this);
    addMouseListener(this);
    // Simulator initalisieren
    try {robot = new Robot();} catch(AWTException e) {}	
  }
  
  public void keyPressed(KeyEvent Taste)
  {
	if (Taste.getKeyCode() == KeyEvent.VK_UP)    Nr = 1;
	if (Taste.getKeyCode() == KeyEvent.VK_RIGHT) Nr = 2;
    if (Taste.getKeyCode() == KeyEvent.VK_DOWN)  Nr = 3;
    if (Taste.getKeyCode() == KeyEvent.VK_LEFT)  Nr = 4;
	Run();
  }

  public void keyReleased (KeyEvent Taste) {Run();}
  public void keyTyped (KeyEvent Taste) {Run();}
  
  public void mousePressed(MouseEvent Maus)
  {
	Move (Maus.getX()-50, Maus.getY()-50);
  }
  
  public void mouseClicked(MouseEvent Maus)  {}
  public void mouseEntered(MouseEvent Maus)  {}
  public void mouseExited(MouseEvent Maus)   {}
  public void mouseReleased(MouseEvent Maus) {}
  
  public void Run ()
  {
    Breite = getWidth();
	Hoehe  = getHeight();
	// Position ändern, je nach Lage
	switch (Nr)
	{
      case 4: if (x > 0)           x -= xDiff; break;
	  case 2: if (x < Breite-100)  x += xDiff; break;
	  case 1: if (y > 30)          y -= yDiff; break;
	  case 3: if (y < Hoehe-100)   y += yDiff; break;
	}
	// Figur bewegen
	Grafik = getGraphics();
	Grafik.drawImage (Bild[Nr], x,y, null);
  }
  
  public void Move (int xPos, int yPos)
  {
	Breite = getWidth();
	Hoehe  = getHeight();
    // Grenzen testen
	if (xPos < 0)          xPos = 0;
	if (xPos > Breite-100) xPos = Breite-100;
	if (yPos < 30)         yPos = 30;
	if (yPos > Hoehe-100)  yPos = Hoehe-100;
	// Wegstrecke bestimmen und Figur bewegen
	Grafik = getGraphics();
    if (x < xPos)
	{
	  do // right
	  {
	    x += xDiff;
	    Grafik.drawImage (Bild[2], x,y, null);
	    try {Thread.sleep (10);} catch (InterruptedException e) {}
	   }
	  while (x < xPos);
	}
    if (x > xPos)
	{
	  do  // left
	  {
	    x -= xDiff;
	    Grafik.drawImage (Bild[4], x,y, null);
	    try {Thread.sleep (10);} catch (InterruptedException e) {}
	   }
	  while (x > xPos);
	}
    if (y < yPos)
	{
	  do  // down
	  {
	    y += yDiff;
	    Grafik.drawImage (Bild[3], x,y, null);
	    try {Thread.sleep (10);} catch (InterruptedException e) {}
	   }
	  while (y < yPos);
	}
    if (y > yPos)
	{
	  do  // up
	  {
	    y -= yDiff;
	    Grafik.drawImage (Bild[1], x,y, null);
	    try {Thread.sleep (10);} catch (InterruptedException e) {}
	   }
	  while (y > yPos);
	}
  }

  public static void main(String[] args)
  {
	Game3 Spiel = new Game3 ();
	Spiel.setSize (800,600);
	Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 	Spiel.setVisible(true);
	// Taste simulieren um Bild sichtbar zu machen
	Spiel.robot.keyPress(KeyEvent.VK_UP);
  }
}
