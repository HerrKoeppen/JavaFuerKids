package rund2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movie2 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[3];
  private int x = 30, xBreite = 180;
  private int y = 50, yHoehe  = 270;
  private int Strecke;
  private Graphics Grafik;
  private Image Bild;
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public void showImage ()
  {
    Toolkit Werkzeug = Toolkit.getDefaultToolkit();
    Bild = Werkzeug.getImage (Pfad + "Figur01.jpg");
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
    Grafik = getGraphics();
    Grafik.drawImage (Bild, x,y, null);
  }

  public void moveImage ()
  {
    Strecke = getWidth ();
    for (int i = x-1; i < Strecke-xBreite-x-1; i++)
    {
      Grafik.copyArea (i,y, xBreite+2,yHoehe+2, 1,0);
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

  public Movie2 ()
  {
    super ("Movie2");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(440,300));
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
    Platte.setBackground (Color.white);
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
    Movie2 Rahmen = new Movie2 ();
    Rahmen.setSize (460,410);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

