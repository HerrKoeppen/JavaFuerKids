package einaus5;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JComboBox Liste;
  private String[] Text = 
    {"Prima", "Gut", "Mäßig", "Schlecht", "Miserabel", "Sag ich nicht"};
  private String[] Diagnose = 
    {"Das ist ja toll!", "Das freut mich!", "Das geht ja noch!",
     "Das tut mir leid!", "Das ist ja schlimm!", "Wenn du meinst ..."};

  // Konstruktor
  public HalloFenster ()
  {
    super ("Hallo wie geht es?");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Liste erzeugen und mit Ereignissen verknüpfen
    Liste = new JComboBox(Text);
    Liste.setFont(new Font("Arial", 0, 20));
    Liste.addActionListener (this);
    // Alles einsetzen
    Platte.add (Liste);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle != Liste) return;
    for (int i = 0; i < 6; i++)
      if (Liste.getSelectedIndex() == i) 
        JOptionPane.showMessageDialog (null, Diagnose[i]);
  }
  
  public static void main(String[] args)
  {
    HalloFenster Rahmen = new HalloFenster ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

