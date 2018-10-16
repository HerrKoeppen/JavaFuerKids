package einaus9;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
//import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class HalloFenster extends JFrame implements ActionListener
{
  // Attribute
  private JRadioButton[] Option = new JRadioButton[6];
  private JCheckBox[] Wahl = new JCheckBox[3];
  private LookAndFeelInfo[] Erscheinung = 
	    UIManager.getInstalledLookAndFeels();
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
    Box Oben   = Box.createHorizontalBox();
    Box Links  = Box.createVerticalBox();
    Box Rechts = Box.createVerticalBox();
    // Größe und Umrandung
    Oben.setPreferredSize   (new Dimension (300,20));
    Links.setPreferredSize  (new Dimension (200,200));
    Rechts.setPreferredSize (new Dimension (140,200));
    Platte.setLayout (new FlowLayout());
    // Radiobuttons erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 6; i++)
    {
      Option[i] = new JRadioButton (Text[i]);
      Option[i].addActionListener (this);
      Option[i].setFont (new Font ("Arial", Font.PLAIN, 18));
      Gruppe.add (Option[i]);
      Links.add  (Option[i]);
    }
    Option[0].setSelected (true);
    // Checkboxen erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 3; i++)
    {
      Wahl[i] = new JCheckBox (Bereich[i]);
      Wahl[i].addActionListener (this);
      Wahl[i].setFont (new Font ("Arial", Font.ITALIC, 20));
      Rechts.add (Wahl[i]);
    }
    Platte.add (Oben);
    Platte.add (Links);
    Platte.add (Rechts);
    setContentPane (Platte);
    int LnF = (int)(Math.random()*Erscheinung.length);
	try
    {
      UIManager.setLookAndFeel (Erscheinung[LnF].getClassName());
      // nur Windows
      // UIManager.setLookAndFeel (Erscheinung[2].getClassName());
    }
    catch (Exception x){}
    SwingUtilities.updateComponentTreeUI (this.getContentPane());
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

