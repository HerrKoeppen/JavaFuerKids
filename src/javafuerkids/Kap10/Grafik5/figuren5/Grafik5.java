package figuren5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik5 extends JFrame implements ActionListener
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
    // Bunter Text
    for (int i = 0; i < 100; i++)
    {
      Stift.setColor (Farbe[(int)(Math.random()*FMax)]);
      Stift.setFont
        (new Font("Arial", Font.PLAIN, (int)(Math.random()*40)));
      Stift.drawString ("Hallo",
        (int)(Math.random()*Breite),(int)(Math.random()*Hoehe));
    }
  }

  public Grafik5 ()
  {
    super ("Grafik5");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton("Schreib mal!");
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
    Grafik5 Rahmen = new Grafik5 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

