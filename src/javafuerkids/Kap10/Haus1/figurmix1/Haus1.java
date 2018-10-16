package figurmix1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Haus1 extends JFrame implements ActionListener
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
    int Diff = 0;
    Color MFarbe;
    // Umrandung
    Stift.setColor (Color.black);
    Stift.fillOval (20,40, Breite-40, Hoehe-100);
    Stift.fillRect (20,180, Breite-40, Hoehe-200);
    // Hauswand
    do
      MFarbe = (Farbe[(int)(Math.random()*FMax)]);
    while ((MFarbe == Color.cyan) || (MFarbe == Color.lightGray));
    Stift.setColor (MFarbe);
    Stift.fillOval (25,45, Breite-50, Hoehe-100);
    Stift.fillRect (25,185, Breite-50, Hoehe-210);
    // Fenster und Tür
    for (int i = 0; i < 3; i++)
    {
      if (i == 1) Diff = 50;
      else Diff = 0;
      Stift.setColor (Color.black);
      Stift.fillOval (40+i*(Breite/3-20),120, Breite/4, Hoehe/4);
      Stift.fillRect (40+i*(Breite/3-20),170, Breite/4, Hoehe/3+Diff);
      if (i == 1) Stift.setColor (Color.lightGray);
      else Stift.setColor (Color.cyan);
      Stift.fillOval (45+i*(Breite/3-20),125, Breite/4-10, Hoehe/4-10);
      Stift.fillRect (45+i*(Breite/3-20),175, Breite/4-10, Hoehe/3-10+Diff);
    }       
  }

  public Haus1 ()
  {
    super ("Java-Rundhaus");
    JPanel Platte = new JPanel ();
    Platte.setBackground (Color.WHITE);
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton(" Tritt ein! ");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.BOLD, 20));
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(460,300));
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
    Haus1 Rahmen = new Haus1 ();
    Rahmen.setSize (500,400);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

