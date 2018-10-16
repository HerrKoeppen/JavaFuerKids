package play2A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game2A extends JFrame implements KeyListener
{
  private int x = 370, xDiff = 10;
  private int y = 260, yDiff = 10;
  private int Breite, Hoehe, Nr;
  private Graphics Grafik;
  private Image[] Bild = new Image[5];
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";
  
  public Game2A ()
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
  }
  
  public void keyPressed(KeyEvent Taste)
  {
    // Pfeiltasten abfragen
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
	switch  (Nr)
	{
      case 1: if (y > -120)   y -= yDiff; else y = Hoehe;  break;
	  case 2: if (x < Breite) x += xDiff; else x = 0;      break;
	  case 3: if (y < Hoehe)  y += yDiff; else y = 0;      break;
      case 4: if (x > -100)   x -= xDiff; else x = Breite; break;
	}
	// Figur bewegen
	Grafik = getGraphics();
	Grafik.drawImage (Bild[Nr], x,y, null);
  }

  public static void main(String[] args)
  {
    Game2A Spiel = new Game2A ();
    Spiel.setSize (800,600);
    Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Spiel.setVisible(true);
  }
}
