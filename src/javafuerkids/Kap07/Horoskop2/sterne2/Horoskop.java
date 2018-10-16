package sterne2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Horoskop extends JFrame implements ActionListener
{
  // Attribute
  private JComboBox Liste;
  private String Sterne[] =
  {"Steinbock", "Wassermann", "Fische", "Widder",
   "Stier", "Zwillinge", "Krebs", "L�we",
   "Jungfrau", "Waage", "Skorpion", "Sch�tze"};
  private String Prognose[] = new String[12];  // Hier m�ssen deine Texte hin!
  
  // Konstruktor
  public Horoskop ()
  {
    super ("W�hle dein Sternzeichen!");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Liste erzeugen, mit Ereignis verkn�pfen und einsetzen
    Liste = new JComboBox (Sterne);
    Liste.addActionListener (this);
    Platte.add (Liste);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle != Liste) return;
    for (int i = 0; i < 12; i++)
      if (Liste.getSelectedIndex() == i) 
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

