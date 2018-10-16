package figuren7a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik7A extends JFrame implements ActionListener
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
    // Viele bunte Punkte
   	int x,y;
   	for (int i = 1; i < 5000; i++)
   	{
   	  x = (int)(Math.random()*Breite);
   	  y = (int)(Math.random()*Hoehe);
   	  Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
   	  Stift.fillOval (x, y, 1, 1);
   	}
  }

  public Grafik7A ()
  {
    super ("Grafik7");
    JPanel Platte = new JPanel ();
    Platte.setBackground (Farbe[(int)(Math.random()*FMax)]);
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
    Grafik7A Rahmen = new Grafik7A ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

