package rund3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movie3 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[3];
  private int x = 30, y = 50;
  private int Strecke;
  private Graphics Grafik;
  private Image[] Bild = new Image[9];
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public void collectImages ()
  {
    Toolkit Werkzeug = Toolkit.getDefaultToolkit();
    MediaTracker Transporter = new MediaTracker (this);
    for (int i = 1; i <= 8; i++)
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
    int xZiel  = Strecke/2/xDiff;
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
    showImage (1, 5*xZiel);
  }

  public void hideImage ()
  {
    repaint ();
  }

  public Movie3 ()
  {
    super ("Movie3");
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
    collectImages ();
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf[0]) showImage (1, x);
    if (Quelle == Knopf[1]) moveImage (2, 5);
    if (Quelle == Knopf[2]) hideImage ();
  }
  
  public static void main(String[] args)
  {
    Movie3 Rahmen = new Movie3 ();
    Rahmen.setSize (460,410);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

