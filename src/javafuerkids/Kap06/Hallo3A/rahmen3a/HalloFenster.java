package rahmen3a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JButton Knopf1;
  private JButton Knopf2;

  // Konstruktor
  public HalloFenster (String Text)
  {
    super (Text);
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout());
    // Buttons erzeugen
    Knopf1 = new JButton("Gut");
    Knopf2 = new JButton ("Schlecht");
    // Schriftart und -größe
    Knopf1.setFont(new Font("Arial", 1, 20));
    Knopf2.setFont(new Font("Arial", 1, 20));
    // Buttons mit Ereignissen verknüpfen
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
    // Alles einsetzen 	    
    Platte.add (Knopf1);
    Platte.add (Knopf2);  
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
	Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf1) 
      JOptionPane.showMessageDialog (null, "Das freut mich!");	
    if (Quelle == Knopf2) 
      JOptionPane.showMessageDialog (null, "Das tut mir leid!");
  }
  
  public static void main(String[] args)
  {
    HalloFenster Rahmen = new HalloFenster ("Hallo wie geht es?");
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

