package poly3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mycomponents.JOOButton;

public class OButton3 extends JFrame implements ActionListener
{
  private JOOButton[] Knopf = new JOOButton[4];
  
  public OButton3 ()
  {
    super ("O-Button in Farbe");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // O-Button erzeugen, verknüpfen, layouten
    for (int i = 0; i < 4; i++)
    {
      Knopf[i] = new JOOButton ("Knopf " + (i+1));
      Knopf[i].addActionListener (this);
      Knopf[i].setPreferredSize (new Dimension(150,150));
      Knopf[i].setFont (new Font("Arial", Font.BOLD, 24));
      Platte.add (Knopf[i]);
    }
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Color Bunt[] = 
      {Color.blue, Color.red, Color.yellow, Color.green};
    Knopf[(int)(Math.random()*4)].setAllColors (Bunt);
 /* for (int i = 0; i < 4; i++)
      Knopf[i].setColor (Color.red, Color.yellow); */
 /* Knopf[0].setColor (2,255,255,0);	  
    Knopf[1].setColor (2,0,255,255);	  
    Knopf[2].setColor (2,255,0,255);	  
    Knopf[3].setColor (2,255,255,255); */
  }

  public static void main(String[] args)
  {
    OButton3 Rahmen = new OButton3();
    Rahmen.setSize (400,350);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible (true);
  }
}
