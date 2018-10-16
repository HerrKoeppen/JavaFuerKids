package diagnose7;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.print.*;

public class Klempner extends JFrame
  implements ActionListener, AdjustmentListener
{
  // Attribute
  private JMenuBar Menuleiste;
  private JMenu Menu;
  private JMenuItem[] Eintrag = new JMenuItem[4];
  private JButton Knopf1, Knopf2;
  private JTextField Eingabe;
  private JLabel Anzeige;
  private JScrollBar Schieber;
  private JPanel Gruppe1, Gruppe2, Gruppe3;
  private Box Oben, Unten, Knoepfe;
  // Diagnoselisten
  final String Pfad = "d:\\Java\\Projekte\\";
  private String Dateiname  = "Diagnose.txt";
  private String Sammelname = "PsychoX.txt";
  private int Max = 0, Nr = 0;
  private ArrayList Diagnose = new ArrayList();
  private ArrayList Psychose = new ArrayList();
  private JFileChooser DateiSucher;
  private boolean Sicher;
  
  public WindowListener Fensterwaechter = new WindowAdapter()
  {
    public void windowClosing (WindowEvent Ereignis)
    {
      if (!Sicher)
      {
        int Wahl = JOptionPane.showConfirmDialog
          (null, "Daten speichern?", "Ende der Therapie",
           JOptionPane.YES_NO_OPTION);
        if (Wahl == JOptionPane.YES_OPTION)
        {
          Sammelname = "PsychoX.txt";
          writeDiagnoseText (Pfad + Sammelname);
        }
      }
      System.exit(0); 
    }
  };
  
  public void readDiagnoseText (String DName) 
  {
    // Datei öffnen und auslesen
    try
    {
      BufferedReader Datei = new BufferedReader (new FileReader(DName));
      boolean Dateiende = false;
      while (!Dateiende)  // while (Datei.ready())
      {
        String Zeile = Datei.readLine();
        if (Zeile == null) Dateiende = true;
        else Diagnose.add (Zeile);
        Nr++;
      }
      Datei.close();
    }
    catch (IOException x)
    {
      Diagnose.add ("Keine Sprechstunde");
      Diagnose.add ("Praxis geschlossen");
      Diagnose.add ("Hilf dir selbst!");
      Nr = 4;
    }
    Max = Nr-1;
  }
 
  public void writeDiagnoseText (String DName) 
  {
    // Datei öffnen und "füllen"
    try
    {
      BufferedWriter Datei = new BufferedWriter (new FileWriter(DName));
      for (int i = 0; i < Psychose.size(); i++)
        Datei.write(Psychose.get(i).toString()+"\r\n");
      Datei.close();
      Sicher = true;
    }
    catch (IOException x)
    {
      JOptionPane.showMessageDialog (null, "Kann Daten nicht speichern!");
      Sicher = false;
    }
  }
 
  public void printDiagnoseText (String DName)
  {
    // Datei öffnen und drucken
    try
    {
      FileInputStream Datei = new FileInputStream (DName);
      DocFlavor Druckformat = DocFlavor.INPUT_STREAM.AUTOSENSE;
      Doc Dokument = new SimpleDoc (Datei, Druckformat, null);
      PrintService Drucker =
        PrintServiceLookup.lookupDefaultPrintService();
      DocPrintJob Druckauftrag = Drucker.createPrintJob ();
      Druckauftrag.print(Dokument, null);
      Datei.close ();
      JOptionPane.showMessageDialog (null, "Diagnose wurde gedruckt!");
    }
    catch (IOException x)
    {
      JOptionPane.showMessageDialog (null, "Kann Daten nicht laden!");
    }
    catch (PrintException x)
    {
      JOptionPane.showMessageDialog (null, "Kann Daten nicht drucken!");
    }
  }

  public void createComponents ()
  {
    // Komponenten erzeugen
    Knopf1   = new JButton (" Neu ");
    Knopf2   = new JButton ("Fertig");
    Eingabe  = new JTextField ("",28);
    Anzeige  = new JLabel ("");
    Schieber = new JScrollBar (Adjustable.HORIZONTAL, 0,1,0,Max);
    Gruppe1  = new JPanel ();
    Gruppe2  = new JPanel ();
    Gruppe3  = new JPanel ();
    Oben     = Box.createHorizontalBox();
    Knoepfe  = Box.createHorizontalBox();
    Unten    = Box.createHorizontalBox();
    // Komponenten mit Ereignissen verknüpfen   
    Knopf1.addActionListener (this);
    Knopf2.addActionListener (this);
    Schieber.addAdjustmentListener(this);
  }

  public void createMenu ()
  {
    Menuleiste = new JMenuBar();
    Menu = new JMenu ("Datei");
    Eintrag[0] = new JMenuItem ("Öffnen");
    Eintrag[1] = new JMenuItem ("Speichern");
    Eintrag[2] = new JMenuItem ("Drucken");
    Eintrag[3] = new JMenuItem ("Ende");  
    setJMenuBar (Menuleiste);
    Menuleiste.add (Menu);
    for (int i = 0; i < 4; i++)
    {
      Menu.add (Eintrag[i]);
      Eintrag[i].addActionListener(this);
    }
    DateiSucher = new JFileChooser();
    DateiSucher.setCurrentDirectory (new File(Pfad));
  }
  
  public void setFormLayout ()
  {
    // Größe, Umrandung und Schrift festlegen
    Menu.setFont (new Font ("Tahoma", Font.BOLD, 16));
    for (int i = 0; i < 4; i++)
      Eintrag[i].setFont (new Font ("Tahoma", Font.BOLD, 16));
    Knopf1.setFont (new Font ("Arial", Font.PLAIN, 20));
    Knopf2.setFont (new Font ("Arial", Font.PLAIN, 20));
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
    readDiagnoseText (Pfad + Dateiname);
    createComponents ();
    createMenu ();
    setFormLayout ();
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
    addWindowListener(Fensterwaechter);
    Sicher = false;
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf1)
    {
      Eingabe.setText (""); 
      Anzeige.setText ("");
      Eingabe.requestFocus();
    } 
    if (Quelle == Knopf2)
    {
      Nr = (int)(Math.random()*Max);
      Anzeige.setText(Diagnose.get(Nr).toString());
      Psychose.add (Eingabe.getText());
      Psychose.add (Anzeige.getText());
      Sicher = false;
    }
    if (Quelle == Eintrag[0])  // Öffnen
    {
      int Wahl = DateiSucher.showOpenDialog (this);
      if (Wahl == JFileChooser.APPROVE_OPTION)  
      {
        Dateiname = DateiSucher.getSelectedFile().getName();
        Diagnose.clear(); Nr = 0;
        readDiagnoseText (Pfad + Dateiname);
        Schieber.setMaximum(Nr-1);
      }
    }
    if (Quelle == Eintrag[1])  // Speichern
    {
      int Wahl = DateiSucher.showSaveDialog (this);
      if (Wahl == JFileChooser.APPROVE_OPTION)
      {
        Sammelname = DateiSucher.getSelectedFile().getName();
        writeDiagnoseText (Pfad + Sammelname);
      }
    }
    if (Quelle == Eintrag[2])  // Drucken
    {
      printDiagnoseText (Pfad + Sammelname);
    }
    if (Quelle == Eintrag[3])  // Ende
    {
      if (!Sicher)
      {
        int Wahl = JOptionPane.showConfirmDialog
          (null, "Daten speichern?", "Ende der Therapie",
           JOptionPane.YES_NO_CANCEL_OPTION);
        if (Wahl == JOptionPane.YES_OPTION)
        {
          Sammelname = "PsychoX.txt";
          writeDiagnoseText (Pfad + Sammelname);
        }
        if (Wahl != JOptionPane.CANCEL_OPTION)
          System.exit (0);
      }
      else  // wenn schon gesichert
        System.exit (0);
    }
  }
  public void adjustmentValueChanged (AdjustmentEvent Ereignis)
  {
    Nr = Schieber.getValue();
    Anzeige.setText(Diagnose.get(Nr).toString());
  }
 
  public static void main(String[] args)
  {
    Klempner Rahmen = new Klempner ();
    Rahmen.setSize (450,390);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

