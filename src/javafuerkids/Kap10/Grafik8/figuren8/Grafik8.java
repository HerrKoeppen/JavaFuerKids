package figuren8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik8 extends JFrame implements ActionListener
{
  private JButton Knopf;
  final int FMax = 9;
  private Color[] Farbe =
    {Color.black, Color.gray, Color.white,
     Color.cyan, Color.magenta, Color.yellow,
     Color.red, Color.green, Color.blue};

  public void drawImage()
  {
    Graphics2D Stift = (Graphics2D) getGraphics();
    Dimension Groesse = getSize();
    int Breite = Groesse.width;
    int Hoehe = Groesse.height;
    // Schottenmuster
   	for (int i = 1; i < 50; i++)
   	{
      Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
      Stift.drawLine (10+8*i,30, 10+8*i,Hoehe-10);
      Stift.drawLine (10,30+6*i, Breite-10,30+6*i);
   	}
  }  	

  public Grafik8 ()
  {
    super ("Grafik8");
    JPanel Platte = new JPanel ();
    // Platte.setBackground (Color.black);
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton("Mal mal!");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.BOLD, 20));
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(400,100));
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
    Grafik8 Rahmen = new Grafik8 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

