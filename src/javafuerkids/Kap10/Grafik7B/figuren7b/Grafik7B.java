package figuren7b;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik7B extends JFrame implements ActionListener
{
  private JButton Knopf;
  final int FMax = 9;
  private Color[] Farbe =
    {Color.black, Color.gray, Color.white,
     Color.cyan, Color.magenta, Color.yellow,
     Color.red, Color.green, Color.blue};

  public void drawImage()
  {
    Graphics Stift = getGraphics();
    Dimension Groesse = getSize();
    int Breite = Groesse.width;
    int Hoehe = Groesse.height;
    // Viele Punkte tauchen auf ...
   	final int PMax = 5000;
   	int[] x = new int[PMax], y = new int[PMax];
   	for (int i = 0; i < PMax; i++)
   	{
   	  x[i] = (int)(Math.random()*Breite);
   	  y[i] = (int)(Math.random()*Hoehe);
   	  Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
   	  Stift.fillOval (x[i], y[i], 1, 1);
      // Verzögerung
   	  try {Thread.sleep (1);}
      catch (InterruptedException ix) {}
   	}
   	// ... und verschwinden wieder
    Stift.setColor (Color.black);
   	for (int i = 0; i < PMax; i++)
   	{
   	  Stift.fillOval (x[i], y[i], 1, 1);
   	  try {Thread.sleep (1);}
      catch (InterruptedException ix) {}
   	}
  }

  public Grafik7B ()
  {
    super ("Grafik7");
    JPanel Platte = new JPanel ();
    Platte.setBackground (Color.black);
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton("Lass funkeln!");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.BOLD, 20));
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(400,210));
    // Alles einsetzen 	    
    Platte.add (Oben); 
    Platte.add (Knopf);
    setContentPane (Platte);
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    drawImage ();
  }
  
  public static void main(String[] args)
  {
    Grafik7B Rahmen = new Grafik7B ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

