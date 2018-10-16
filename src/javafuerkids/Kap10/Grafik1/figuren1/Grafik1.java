package figuren1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik1 extends JFrame implements ActionListener
{
  private JButton Knopf;

  public void drawImage()
  {
 	Graphics Stift = getGraphics();
    Dimension Groesse = getSize();
    int Breite = Groesse.width;
    int Hoehe  = Groesse.height;
    Stift.drawRect (20,40, Breite-40,Hoehe-60);
    Stift.drawOval (30,50, Breite-60,Hoehe-80);
    Stift.drawLine (Breite/2,40, Breite/2,Hoehe-20);
    Stift.drawLine (20, Hoehe/2+10, Breite-20,Hoehe/2+10);
  }
  
  public Grafik1 ()
  {
    super ("Grafik1");
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
    Grafik1 Rahmen = new Grafik1 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

