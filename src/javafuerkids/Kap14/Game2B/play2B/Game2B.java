package play2B;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game2B extends JFrame implements KeyListener
{
  private int x = 370, xDiff = 10;
  private int y = 260, yDiff = 10;
  private int Breite, Hoehe, Nr;
  private Graphics Grafik;
  private Image[] Bild = new Image[5];
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";
  private Robot robot;
  
  public Game2B ()
  {
    super ("Game 2");
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
    // "Lauscher" für Tasten einfügen
    addKeyListener(this);
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
  
  public void Run ()
  {
    Breite = getWidth();
    Hoehe  = getHeight();
    // Position ändern, je nach Lage
    switch (Nr)
    {
      case 4: if (x > 0)          x -= xDiff; break;
      case 2: if (x < Breite-100) x += xDiff; break;
      case 1: if (y > 30)         y -= yDiff; break;
      case 3: if (y < Hoehe-100)  y += yDiff; break;
    }
    // Figur bewegen
    Grafik = getGraphics();
    Grafik.drawImage (Bild[Nr], x,y, null);
  }

  public static void main(String[] args)
  {
    Game2B Spiel = new Game2B ();
    Spiel.setSize (800,600);
    Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Spiel.setVisible(true);
    //Taste simulieren um Bild sichtbar zu machen
    Spiel.robot.keyPress(KeyEvent.VK_UP);
  }
}
