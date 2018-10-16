package rund4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movie4 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[4];
  private int x = 30, y = 50, z = x;
  private int Strecke;
  private Graphics Grafik;
  private Image[] Bild = new Image[9];
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public void collectImages ()
  {
    Toolkit Werkzeug = Toolkit.getDefaultToolkit();
    MediaTracker Transporter = new MediaTracker (this);
    for (int i = 0; i <= 8; i++)
    {
      Bild[i] = Werkzeug.getImage 
       (Pfad + "Figur0" + Integer.toString(i) + ".jpg");
      Transporter.addImage (Bild[i], i);
      try
      {
        Transporter.waitForID (i);
      }
      catch (InterruptedException x)
      {
        setTitle ("Bildstörung");
      }
    }
  }
  
  public void showImage (int Nr, int xPos)
  {
    Grafik = getGraphics();
    Grafik.drawImage (Bild[Nr], xPos,y, null);
  }

  public void moveImage (int Nr, int xDiff)
  {
    Strecke = getWidth ();
    int xStart = x - xDiff*4;
    int xZiel  = Strecke/2/xDiff+10;
    for (int i = xStart; i < xZiel; i++)
    {
      if (Nr == 2) Nr = 6; else Nr = 2;
      showImage (Nr, xDiff*i);
      try
      {
        Thread.sleep (100);
      }
      catch (InterruptedException x)
      {
        setTitle ("Schlafstörung");
      }
    }
    z = 5*xZiel;
    showImage (1, z);
  }

  public void turnImage (int Nr, int xPos)
  {
    for (int i = Nr; i < Nr+4; i++)
    {
      showImage (i, xPos);
      try
      {
        Thread.sleep (200);
      }
      catch (InterruptedException x)
      {
        setTitle ("Schlafstörung");
      }
    }
    showImage (1, xPos);
  }

  public void hideImage ()
  {
    showImage (0, z);
  }

  public Movie4 ()
  {
    super ("Movie4");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben   = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(530,300));
    Platte.add (Oben); 
    // Buttons erzeugen, verknüpfen, layouten
    Knopf[0] = new JButton ("Erscheinen");
    Knopf[1] = new JButton ("Bewegen");
    Knopf[2] = new JButton ("Drehen");
    Knopf[3] = new JButton ("Verschwinden");
    for (int i = 0; i < 4; i++)
    {
      Knopf[i].addActionListener (this);
      Knopf[i].setFont (new Font ("Arial", Font.PLAIN, 20));
      Platte.add (Knopf[i]);
    }
    Platte.setBackground (Color.white);
    setContentPane (Platte);
    collectImages ();
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf[0])
    {
      showImage (0, z); 
      showImage (1, x); 
      z = x;
    }
    if (Quelle == Knopf[1]) moveImage (2, 5);
    if (Quelle == Knopf[2]) turnImage (1, z);
    if (Quelle == Knopf[3]) hideImage ();
  }
  
  public static void main(String[] args)
  {
    Movie4 Rahmen = new Movie4 ();
    Rahmen.setSize (550,410);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

