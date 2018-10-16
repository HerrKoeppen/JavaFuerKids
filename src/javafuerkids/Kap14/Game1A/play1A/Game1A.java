package play1A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game1A extends JFrame implements KeyListener, ActionListener
{
  private JButton[] Knopf = new JButton[2];
  private int x = 370, xDiff = 5;
  private int y = 260, yDiff = 5;
  private int Breite, Hoehe;
  private boolean OnOff;
  private Timer timer;
  private Robot robot; 
  private Graphics Grafik;
  private Image Bild;
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";
 
  public Game1A ()
  {
    super ("Game 1");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(790,490));
    Platte.add (Oben); 
    // Buttons erzeugen, verkn�pfen, layouten
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
	Bild = Werkzeug.getImage (Pfad + "Eck1.jpg");
	MediaTracker Transporter = new MediaTracker (this);
	Transporter.addImage (Bild, 1);
	try
	{
	  Transporter.waitForID (1);
	}
	catch (InterruptedException x)
	{
	  setTitle ("Bildst�rung");
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
	// "Lauscher" f�r Maus einf�gen
    addKeyListener(this);
  	 // Simulator initalisieren
    try {robot = new Robot();} catch(AWTException e) {}
  }
  
  public void keyPressed (KeyEvent Taste)
  {
	Grafik = getGraphics();
	Grafik.drawImage (Bild, x,y, null);
  }
  public void keyReleased (KeyEvent Taste) {}
  public void keyTyped (KeyEvent Taste) {}
  
  public void Run ()
  {
    // Position �ndern 
	x+=xDiff; y+=yDiff;
 	// Rand links und rechts kontrollieren
    Breite = getWidth();
	if (x < 0)  xDiff = -xDiff;
	if (x > Breite-99) xDiff = -xDiff;
	// Rand oben und unten kontrollieren
	Hoehe  = getHeight();
	if (y < 30)  yDiff = -yDiff;
	if (y > Hoehe-99) yDiff = -yDiff;
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
	Game1A Spiel = new Game1A ();
	Spiel.setSize (800,600);
	Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Spiel.setVisible(true);
    //Mausklick simulieren um Bild sichtbar zu machen
    Spiel.robot.keyPress(KeyEvent.VK_ENTER);
  }
}

