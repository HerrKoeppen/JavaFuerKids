package rahmen3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenster3
{
  public static void main(String[] args)
  {
    JFrame Rahmen = new JFrame("Hallo, wie geht es?");
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout());
    // Buttons erzeugen
    JButton Knopf1 = new JButton("Gut");
    JButton Knopf2 = new JButton ("Schlecht");
    // Schriftart und -größe
    Knopf1.setFont(new Font("Arial", 1, 20));
    Knopf2.setFont(new Font("Arial", 1, 20));
    // Buttons mit Ereignissen verknüpfen
    Knopf1.addActionListener (new ActionListener()
    {
      public void actionPerformed (ActionEvent x)
      {JOptionPane.showMessageDialog (null, "Das freut mich!");}
    });
    Knopf2.addActionListener (new ActionListener()
    {
      public void actionPerformed (ActionEvent x)
      {JOptionPane.showMessageDialog (null, "Das tut mir leid!");}
    });
    // Alles einsetzen und sichtbar machen 	    
    Platte.add (Knopf1);
    Platte.add (Knopf2);  
    Rahmen.setContentPane (Platte);
    Rahmen.setVisible(true);
  }
}
