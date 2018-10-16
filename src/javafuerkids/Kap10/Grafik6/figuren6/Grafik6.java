package figuren6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik6 extends JFrame implements ActionListener
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
    // Bunte Kreise
   	int x,y, Dicke;
   	for (int i = 1; i < 300; i++)
   	{
   	  x = (int)(Math.random()*Breite);
   	  y = (int)(Math.random()*Hoehe);
   	  Dicke = (int)(Math.random()*30);
   	  // mit Farbe gefüllte Kreise zeichnen
   	  Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
   	  Stift.fillOval (x, y, Dicke, Dicke);
   	  // Stift.setColor (Farbe[0]);
   	  // Stift.drawOval (x, y, Dicke, Dicke);
   	}
  }

  public Grafik6 ()
  {
    super ("Grafik6");
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
    Grafik6 Rahmen = new Grafik6 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

