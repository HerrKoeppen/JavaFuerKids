package auswahl1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Vokabel1 extends JFrame implements ActionListener
{
  // Attribute
  private JButton Knopf1, Knopf2;
  private JLabel Anzeige;
  private JRadioButton[] Option = new JRadioButton[3];
  private ButtonGroup Gruppe;
  //private JPanel Gruppe1, Gruppe2, Gruppe3;
  private Box Oben, Mitte, Auswahl, Unten, Knoepfe;
  // Diagnoseliste
  final String Dateiname = "d:\\Projekte\\Text\\Vokabeln.txt";
  private int Max = 0, Nr = 0;
  private ArrayList Deutsch = new ArrayList();
  private ArrayList Fremd   = new ArrayList();  // z.B. Englisch
  
  public void readVokabelText () 
  {
    // Datei öffnen und auslesen
    try
    {
      BufferedReader Datei = new BufferedReader (new FileReader(Dateiname));
      boolean Dateiende = false;
      while (!Dateiende)  // while (Datei.ready())
      {
        String Zeile = Datei.readLine();
        if (Zeile == null) Dateiende = true;
        else Deutsch.add (Zeile);
        Zeile = Datei.readLine();
        if (Zeile == null) Dateiende = true;
        else Fremd.add (Zeile);
        Nr++;
      }
      Datei.close();
    }
    catch (IOException x)
    {
      JOptionPane.showMessageDialog (null, "Kann Daten nicht laden!");
      System.exit (0);
    }
    Max = Nr-2;
  }
  
  public void createComponents ()
  {
    // Komponenten erzeugen
    Knopf1  = new JButton (" Neu ");
    Knopf2  = new JButton ("Fertig");
    Anzeige = new JLabel ("Klicke auf Neu!");
    Gruppe  = new ButtonGroup ();
    Auswahl = Box.createVerticalBox();
    for (int i = 0; i < 3; i++)
   	{
      Option[i] = new JRadioButton ("???");
      Option[i].addActionListener (this);
      Gruppe.add (Option[i]);
      Auswahl.add (Option[i]);
   	}
    Oben    = Box.createHorizontalBox();
    Mitte   = Box.createHorizontalBox();
    Knoepfe = Box.createHorizontalBox();
    Unten   = Box.createHorizontalBox();
    // Komponenten mit Ereignissen verknüpfen   
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
  }

  public void setFormLayout ()
  {
    // Größe, Umrandung und Schrift festlegen
    Knopf1.setFont (new Font ("Arial", Font.PLAIN, 22));
    Knopf2.setFont (new Font ("Arial", Font.PLAIN, 22));
    Anzeige.setFont (new Font ("Arial", Font.PLAIN, 20));
    for (int i = 0; i < 3; i++)
      Option[i].setFont (new Font ("Arial", Font.PLAIN, 20));
    Oben.setPreferredSize (new Dimension (430,20));
    Auswahl.setPreferredSize (new Dimension (380,100));
    Mitte.setPreferredSize (new Dimension (380,10));
    Unten.setPreferredSize (new Dimension (380,10));
  }
  
  // Konstruktor
  public Vokabel1 ()
  {
    super ("Vokabeln Deutsch-Fremdsprache");
    // Komponenten erstellen
    readVokabelText ();
    createComponents ();
    setFormLayout ();
    JPanel Platte  = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Alles einsetzen
    Knoepfe.add (Knopf1);
    Knoepfe.add (Knopf2);
    Platte.add (Oben);
    Platte.add (Anzeige);
    Platte.add (Mitte);
    Platte.add (Auswahl);
    Platte.add (Unten);
    Platte.add (Knoepfe);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    int[] xPos = new int[3];
    if (Quelle == Knopf1)  // Neu
    {
      // Zufallsposition für richtige Lösung
      Nr = (int)(Math.random()*3);
      // drei zufällige Nummern
      xPos[0] = (int)(Math.random()*Max);
      do
    	xPos[1] = (int)(Math.random()*Max);
      while (xPos[1] == xPos[0]);
      do
    	xPos[2] = (int)(Math.random()*Max);
      while ((xPos[2] == xPos[1]) || (xPos[2] == xPos[0]));
      // deutsche Vokabel zur Abfrage
      Anzeige.setText(Deutsch.get(xPos[Nr]).toString());
      // drei fremdsprachliche Vokabeln zur Auswahl
      for (int i = 0; i < 3; i++)
        Option[i].setText (Fremd.get(xPos[i]).toString());
    } 
    if (Quelle == Knopf2)  // Fertig
    {
      for (int i = 0; i < 3; i++)
        if (Option[i].isSelected())
        {
        	if (i == Nr)	
            JOptionPane.showMessageDialog (null, "Richtig!");
          else
        	JOptionPane.showMessageDialog (null, "Falsch!");
        } 
    }
  }
  
  public static void main(String[] args)
  {
    Vokabel1 Rahmen = new Vokabel1 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

