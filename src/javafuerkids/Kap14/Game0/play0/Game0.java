package play0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game0 extends JFrame implements ActionListener
{
  private JButton Knopf;
  private int x = 370;
  private int y = 250;
  private boolean OnOff;
  private Graphics Grafik;
  private Image Bild;
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public Game0 ()
  {
    super ("Game 0");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(790,490));
    Platte.add (Oben); 
    // Buttons erzeugen, verknüpfen, layouten
    Knopf = new JButton (" Start ");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.PLAIN, 20));
    Platte.add (Knopf);
    Platte.setBackground (Color.green);
    setContentPane (Platte); 
	Init();
  }
  
  public void Init ()
  {   
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
	OnOff = false;
  }
  
  public void Run ()
  {
	Grafik = getGraphics();
	Grafik.drawImage (Bild, x,y, null);  
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf)
    {
      OnOff = !OnOff;
      if (OnOff) {Knopf.setText(" Stop "); Run ();}
      else {Knopf.setText(" Start "); repaint();}    
    }
  }
  
  public static void main(String[] args)
  {
	Game0 Spiel = new Game0 ();
	Spiel.setSize (800,600);
	Spiel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	Spiel.setVisible(true);
  }
}

