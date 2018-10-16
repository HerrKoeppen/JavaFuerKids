package einaus4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JButton Knopf1;
  private JButton Knopf2;
  private JButton Knopf3;
  private JButton Knopf4;
  private JButton Knopf5;
  private JButton Knopf6;

  // Konstruktor
  public HalloFenster ()
  {
    super ("Hallo wie geht es?");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout(6,1));
    // Buttons erzeugen
    Knopf1 = new JButton ("Prima");
    Knopf2 = new JButton ("Gut");
    Knopf3 = new JButton ("Mäßig");
    Knopf4 = new JButton ("Schlecht");
    Knopf5 = new JButton ("Miserabel");
    Knopf6 = new JButton ("Sag ich nicht");
    // Schriftart und -größe
    Knopf1.setFont(new Font("Arial", 0, 20));
    Knopf2.setFont(new Font("Arial", 0, 20));
    Knopf3.setFont(new Font("Arial", 0, 20));
    Knopf4.setFont(new Font("Arial", 0, 20));
    Knopf5.setFont(new Font("Arial", 0, 20));
    Knopf6.setFont(new Font("Arial", 0, 20));
    // Buttons mit Ereignissen verknüpfen
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
    Knopf3.addActionListener (this);
    Knopf4.addActionListener (this);
    Knopf5.addActionListener (this);
    Knopf6.addActionListener (this);
    // Alles einsetzen
    Platte.add (Knopf1);
    Platte.add (Knopf2);  
    Platte.add (Knopf3);
    Platte.add (Knopf4);  
    Platte.add (Knopf5);
    Platte.add (Knopf6);  
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf1) 
      JOptionPane.showMessageDialog (null, "Das ist ja toll!");
    if (Quelle == Knopf2) 
      JOptionPane.showMessageDialog (null, "Das freut mich!");	
    if (Quelle == Knopf3) 
      JOptionPane.showMessageDialog (null, "Das geht ja noch!");
    if (Quelle == Knopf4) 
      JOptionPane.showMessageDialog (null, "Das tut mir leid!");
    if (Quelle == Knopf5) 
      JOptionPane.showMessageDialog (null, "Das ist ja schlimm!");
    if (Quelle == Knopf6) 
      JOptionPane.showMessageDialog (null, "Wenn du meinst ...");
  }
  
  public static void main(String[] args)
  {
    HalloFenster Rahmen = new HalloFenster ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

