package eckig1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movie1A extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[3];
  private int x = 30, y = 60, Dicke = 200;
  private int Strecke;
  private Graphics Grafik;
  final int FMax = 9;
  private Color[] Farbe =
    {Color.black, Color.gray, Color.white,
     Color.cyan, Color.magenta, Color.yellow,
     Color.red, Color.green, Color.blue};

  public void showImage ()
  {
    Grafik = getGraphics();
    Grafik.setColor (Farbe[(int)(Math.random()*FMax)]);
    Grafik.fillRect (x, y, Dicke, Dicke);
    Grafik.setColor (Color.black);
    Grafik.drawRect (x, y, Dicke, Dicke);
  }

  public void moveImage ()
  {
    Strecke = getWidth ();
    for (int i = x-1; i < Strecke-Dicke-x-1; i++)
    {
      Grafik.copyArea (i,y, Dicke+2,Dicke+2, 1,0);
      try
      {
        Thread.sleep (10);
      }
      catch (InterruptedException x)
      {
        setTitle ("Schlafstörung");
      }
    }  
  }

  public void hideImage ()
  {
    repaint ();
  }

  public Movie1A ()
  {
    super ("Movie1");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(440,250));
    Platte.add (Oben); 
    // Buttons erzeugen, verknüpfen, layouten
    Knopf[0] = new JButton ("Erscheinen");
    Knopf[1] = new JButton (" Bewegen ");
    Knopf[2] = new JButton ("Verschwinden");
    for (int i = 0; i < 3; i++)
    {
      Knopf[i].addActionListener (this);
      Knopf[i].setFont (new Font ("Arial", Font.PLAIN, 20));
      Platte.add (Knopf[i]);
    }
    setContentPane (Platte);
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf[0]) showImage ();
    if (Quelle == Knopf[1]) moveImage ();
    if (Quelle == Knopf[2]) hideImage ();
  }
  
  public static void main(String[] args)
  {
    Movie1A Rahmen = new Movie1A ();
    Rahmen.setSize (460,360);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

