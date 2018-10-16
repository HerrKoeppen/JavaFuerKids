package rund0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movie0 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[3];
  private int x = 30, y = 60, Dicke = 200;
  private int Strecke;
  private Graphics Grafik;

  public Movie0 ()
  {
    super ("Movie0");
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
  }
  
  public static void main(String[] args)
  {
    Movie0 Rahmen = new Movie0 ();
    Rahmen.setSize (460,360);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

