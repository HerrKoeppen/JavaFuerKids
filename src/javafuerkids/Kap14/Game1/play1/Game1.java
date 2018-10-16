package play1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game1 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[2];
  private int x = 370, xDiff = 5;
  private int y = 260, yDiff = 5;
  private int Breite, Hoehe;
  private boolean OnOff;
  private Timer timer;
  private Graphics Grafik;
  private Image Bild;
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";
 
  public Game1 ()
  {
    super ("Game 1");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(790,490));
    Platte.add (Oben); 
    // Buttons erzeugen, verknüpfen, layouten
    Knopf[0] = new JButton (" Start ");
    Knopf[1] = new JButton (" Turn ");
    for (int i = 0; i < 2; i++)
    {
      Knopf[i].addActionListener (this);
      Knopf[i].setFont (new Font ("Arial", Font.PLAIN, 20));
      Platte.add (Knopf[i]);
    }
    Platte.setBackground (Color.green);
    setContentPane (Platte); 
    Init();
  }

  public void Init ()
  {   
    // Spielfigur "einbinden"	
	Toolkit Werkzeug = Toolkit.getDefaultToolkit();
	Bild = Werkzeug.getImage (Pfad + "Ball1.jpg");
	MediaTracker Transporter = new MediaTracker (this);
	Transporter.addImage (Bild, 1);
	try
	{
	  Transporter.waitForID (1);
	}
	catch (InterruptedException x)
	{
	  setTitle ("Bildstörung");
	}
	// Timer "einbinden"
	timer = new Timer(10, new ActionListener()
	{ 
	  public void actionPerformed (ActionEvent e)
	  { 
        Run(); 
	  } 
	});
	OnOff = false;
  }
  
  public void Run ()
  {
    // Position ändern 
	x+=xDiff; y+=yDiff;
 	// Rand links und rechts kontrollieren
    Breite = getWidth();
	if (x < 0)  xDiff = -xDiff;
	if (x > Breite-65) xDiff = -xDiff;
	// Rand oben und unten kontrollieren
	Hoehe  = getHeight();
	if (y < 30)  yDiff = -yDiff;
	if (y > Hoehe-65) yDiff = -yDiff;
	// Ball bewegen
    Grafik = getGraphics();
	Grafik.drawImage (Bild, x,y, null);
  }
 
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf[0])
    {
      OnOff = !OnOff;
      if (OnOff) {timer.start(); Knopf[0].setText(" Stop ");}
      else {timer.stop(); Knopf[0].setText(" Start ");}
      Run ();
    }
    if (Quelle == Knopf[1]) 
    {
      xDiff =- xDiff;
      yDiff =- yDiff;
    }
  }
  
  public static void main(String[] args)
  {
	Game1 Spiel = new Game1 ();
	Spiel.setSize (800,600);
	Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Spiel.setVisible(true);
  }
}

