package einaus7A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JRadioButton[] Option = new JRadioButton[6];
  private JCheckBox[] Wahl = new JCheckBox[3];
  private String[] Text = 
    {"Prima", "Gut", "Mäßig", "Schlecht", "Miserabel", "Sag ich nicht"};
  private String[] Diagnose = 
    {"Das ist ja toll!", "Das freut mich!", "Das geht ja noch!",
     "Das tut mir leid!", "Das ist ja schlimm!", "Wenn du meinst ..."};
  private String[] Bereich = {"Seele", "Geist", "Körper"};
  
  // Konstruktor
  public HalloFenster ()
  {
    super ("Hallo wie gehts?");
    ButtonGroup Gruppe = new ButtonGroup();
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Radiobuttons erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 6; i++)
    {
      Option[i] = new JRadioButton (Text[i]);
      Option[i].setFont(new Font("Arial", 0, 20));
      Option[i].addActionListener (this);
      Gruppe.add (Option[i]);
      Platte.add  (Option[i]);
    }
    Option[0].setSelected (true);
    // Checkboxen erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 3; i++)
    {
      Wahl[i] = new JCheckBox (Bereich[i]);
      Wahl[i].setFont(new Font("Arial", 0, 20));
      Wahl[i].addActionListener (this);
      Platte.add (Wahl[i]);
    }
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    String Titel = "Hallo, wie gehts? ";
    for (int i = 0; i < 3; i++)
      if (Wahl[i].isSelected())
        Titel = Titel + "(" + Bereich[i] + ")";
    setTitle (Titel);
    for (int i = 0; i < 6; i++)
      if (Quelle == Option[i])
        JOptionPane.showMessageDialog (null, Diagnose[i]);
  }
  
  public static void main(String[] args)
  {
    HalloFenster Rahmen = new HalloFenster ();
    Rahmen.setSize (420,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

