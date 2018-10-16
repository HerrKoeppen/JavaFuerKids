package figuren3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik3 extends JFrame implements ActionListener
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
    // Bunte Rechtecke
    for (int i = 0; i < 50; i++)
    {
      Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
      Stift.drawRect (i*4, i*3+10, Breite-i*8, Hoehe-i*6);
    }
  }

  public Grafik3 ()
  {
    super ("Grafik3");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton("Mal mal!");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.BOLD, 24));
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
    Grafik3 Rahmen = new Grafik3 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

