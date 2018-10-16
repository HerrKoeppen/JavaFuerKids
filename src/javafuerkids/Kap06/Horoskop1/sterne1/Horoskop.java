package sterne1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Horoskop extends JFrame implements ActionListener
{
  // Attribute
  private JButton Knopf1;
  private JButton Knopf2;
  private JButton Knopf3;
  private JButton Knopf4;
  private JButton Knopf5;
  private JButton Knopf6;
  private JButton Knopf7;
  private JButton Knopf8;
  private JButton Knopf9;
  private JButton Knopf10;
  private JButton Knopf11;
  private JButton Knopf12;

  // Konstruktor
  public Horoskop ()
  {
    super ("Wähle dein Sternzeichen!");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout(6,2));
    // Buttons erzeugen 
    Knopf1 = new JButton ("Steinbock");
    Knopf2 = new JButton ("Wassermann");
    Knopf3 = new JButton ("Fische");
    Knopf4 = new JButton ("Widder");
    Knopf5 = new JButton ("Stier");
    Knopf6 = new JButton ("Zwillinge");
    Knopf7 = new JButton ("Krebs");
    Knopf8 = new JButton ("Löwe");
    Knopf9 = new JButton ("Jungfrau");
    Knopf10 = new JButton ("Waage");
    Knopf11 = new JButton ("Skorpion");
    Knopf12 = new JButton ("Schütze");
    // Buttons mit Ereignissen verknüpfen
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
    Knopf3.addActionListener (this);
    Knopf4.addActionListener (this);
    Knopf5.addActionListener (this);
    Knopf6.addActionListener (this);
    Knopf7.addActionListener (this);
    Knopf8.addActionListener (this);
    Knopf9.addActionListener (this);
    Knopf10.addActionListener (this);
    Knopf11.addActionListener (this);
    Knopf12.addActionListener (this);
    // Alles einsetzen
    Platte.add (Knopf1);
    Platte.add (Knopf2);  
    Platte.add (Knopf3);
    Platte.add (Knopf4);  
    Platte.add (Knopf5);
    Platte.add (Knopf6);  
    Platte.add (Knopf7);
    Platte.add (Knopf8);  
    Platte.add (Knopf9);
    Platte.add (Knopf10);  
    Platte.add (Knopf11);
    Platte.add (Knopf12);  
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    // Hier must du deine eigene Vorhersagen einfügen !!!
    if (Quelle == Knopf1) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf2) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf3) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf4) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf5) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf6) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf7) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf8) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf9) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf10) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf11) 
      JOptionPane.showMessageDialog (null, "");
    if (Quelle == Knopf12) 
      JOptionPane.showMessageDialog (null, "");
  }
  
  public static void main(String[] args)
  {
    Horoskop Rahmen = new Horoskop ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

