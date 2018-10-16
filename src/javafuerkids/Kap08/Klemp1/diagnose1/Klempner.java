package diagnose1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Klempner extends JFrame implements ActionListener
{
  // Attribute
  private JButton Knopf1, Knopf2;
  private JTextField Eingabe;
  private JLabel Anzeige;
  private JScrollBar Schieber;
  private JPanel Gruppe1, Gruppe2, Gruppe3;
  private Box Oben, Unten, Knoepfe;
  // Diagnosefeld
  final int Max = 10;
  private String[] Diagnose = new String[Max];
  private int Nr;
  
  public void getDiagnoseText ()
  {
    Diagnose[0] = "Hm...";
    Diagnose[1] = "Das ist ein Ding!";
    Diagnose[2] = "Sieh mal an!";
    Diagnose[3] = "Was soll ich sagen?";
    Diagnose[4] = "Tatsächlich?";
    Diagnose[5] = "So geht es dir also.";
    Diagnose[6] = "Du hast Probleme.";
    Diagnose[7] = "Das kann ich verstehen.";
    Diagnose[8] = "Ich bin sprachlos.";
    Diagnose[9] = "Naja...";
  }
  
  public void createComponents ()
  {
    // Komponenten erzeugen
    Knopf1   = new JButton (" Neu ");
    Knopf2   = new JButton ("Fertig");
    Eingabe  = new JTextField ("",28);
    Anzeige  = new JLabel ("");
    Schieber = new JScrollBar (Adjustable.HORIZONTAL);
    Gruppe1  = new JPanel ();
    Gruppe2  = new JPanel ();
    Gruppe3  = new JPanel ();
    Oben     = Box.createHorizontalBox();
    Knoepfe  = Box.createHorizontalBox();
    Unten    = Box.createHorizontalBox();
    // Komponenten mit Ereignissen verknüpfen   
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
  }

  public void setFormLayout ()
  {
    // Größe, Umrandung und Schrift festlegen
    Knopf1.setFont (new Font ("Arial", Font.PLAIN, 22));
    Knopf2.setFont (new Font ("Arial", Font.PLAIN, 22));
    Anzeige.setFont (new Font ("Arial", Font.PLAIN, 18));
    Eingabe.setFont (new Font ("Arial", Font.PLAIN, 18));
    Schieber.setPreferredSize (new Dimension (390,25));
    Gruppe1.setPreferredSize (new Dimension (430,70));
    Gruppe2.setPreferredSize (new Dimension (430,70));
    Gruppe3.setPreferredSize (new Dimension (430,70));
    Oben.setPreferredSize (new Dimension (430,10));
    Unten.setPreferredSize (new Dimension (430,10));
    Gruppe1.setBorder
      (BorderFactory.createTitledBorder("Das sagst du mir: "));
    Gruppe2.setBorder
      (BorderFactory.createTitledBorder("Das sag ich dir: "));
    Gruppe3.setBorder
      (BorderFactory.createTitledBorder("Diagnose-Manipulator: "));
  }
  
  // Konstruktor
  public Klempner ()
  {
    super ("Seelenklempner");
    // Komponenten erstellen
    createComponents ();
    setFormLayout ();
    getDiagnoseText ();
    JPanel Platte  = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Alles einsetzen
    Knoepfe.add (Knopf1);
    Knoepfe.add (Knopf2);
    Gruppe1.add (Eingabe);
    Gruppe2.add (Anzeige);
    Gruppe3.add (Schieber);
    Platte.add (Oben);
    Platte.add (Gruppe1);
    Platte.add (Gruppe2);
    Platte.add (Gruppe3);
    Platte.add (Unten);
    Platte.add (Knoepfe);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf1)  // Neu 
    {
      Eingabe.setText(""); 
      Anzeige.setText("");
      Eingabe.requestFocus();
    } 
    if (Quelle == Knopf2)  // Fertig
    {
      Nr = (int)(Math.random()*Max);
      Anzeige.setText(Diagnose[Nr]);
    } 
  }
  
  public static void main(String[] args)
  {
    Klempner Rahmen = new Klempner ();
    Rahmen.setSize (450,350);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

