package figuren9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik9 extends JFrame implements ActionListener
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
    GradientPaint Verlauf = new GradientPaint
      (0,0,Farbe[(int)(Math.random()*FMax)],
       Breite-50,0, Farbe[(int)(Math.random()*FMax)]);
    Stift.setPaint(Verlauf);
    Stift.fill (new Rectangle(15,40,Breite-30,Hoehe-55));
  }  	

  public Grafik9 ()
  {
    super ("Grafik9");
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
    Grafik9 Rahmen = new Grafik9 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

