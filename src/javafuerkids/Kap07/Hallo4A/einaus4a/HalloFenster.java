package einaus4a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JButton[] Knopf = new JButton[6];
  private String[] Text = 
    {"Prima", "Gut", "M��ig", "Schlecht", "Miserabel", "Sag ich nicht"};
  private String[] Diagnose = 
    {"Das ist ja toll!", "Das freut mich!", "Das geht ja noch!",
     "Das tut mir leid!", "Das ist ja schlimm!", "Wenn du meinst ..."};

  // Konstruktor
  public HalloFenster ()
  {
    super ("Hallo wie geht es?");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout(6,1));
    // Buttons erzeugen, mit Ereignissen verkn�pfen, einsetzen
    for (int i = 0; i < 6; i++)
    {
      Knopf[i] = new JButton (Text[i]);
      Knopf[i].setFont(new Font("Arial", 0, 20));
      Knopf[i].addActionListener (this);
      Platte.add (Knopf[i]);
    }
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    for (int i = 0; i < 6; i++)
      if (Quelle == Knopf[i]) 
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

