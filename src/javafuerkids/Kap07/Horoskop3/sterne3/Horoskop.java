package sterne3;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Horoskop extends JFrame implements ActionListener
{
  // Attribute
  private JRadioButton[] Option = new JRadioButton[12];
  private String Sterne[] =
  {"Steinbock", "Wassermann", "Fische", "Widder",
   "Stier", "Zwillinge", "Krebs", "Löwe",
   "Jungfrau", "Waage", "Skorpion", "Schütze"};
  private String Prognose[] = new String[12];  // Hier müssen deine Texte hin!
  
  // Konstruktor
  public Horoskop ()
  {
    super ("Wähle dein Sternzeichen!");
    ButtonGroup Gruppe = new ButtonGroup();
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout(4,3));
    // Radiobuttons erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 12; i++)
    {
      Option[i] = new JRadioButton (Sterne[i]);
      Option[i].addActionListener (this);
      Gruppe.add (Option[i]);
      Platte.add (Option[i]);
    }
    // Alles einsetzen
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    for (int i = 0; i < 12; i++)
      if (Quelle == Option[i])
        JOptionPane.showMessageDialog (null, Prognose[i]);
  }
  
  public static void main(String[] args)
  {
    Horoskop Rahmen = new Horoskop ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

