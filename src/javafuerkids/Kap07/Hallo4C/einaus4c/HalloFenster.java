package einaus4c;
import java.awt.*;
import java.awt.event.*;

// Hallo nur mit AWT

public class HalloFenster extends Frame implements ActionListener
{
  // Attribute
  private Button[] Knopf = new Button[6];
  private String[] Text = 
    {"Prima", "Gut", "Mäßig", "Schlecht", "Miserabel", "Sag ich nicht"};
  private String[] Diagnose = 
    {"Das ist ja toll!", "Das freut mich!", "Das geht ja noch!",
     "Das tut mir leid!", "Das ist ja schlimm!", "Wenn du meinst ..."};

  // Konstruktor
  public HalloFenster ()
  {
    super ("Hallo wie geht es?");
    Panel Platte = new Panel ();
    Platte.setLayout (new GridLayout(6,1));
    // Buttons erzeugen, mit Ereignissen verknüpfen, einsetzen
    for (int i = 0; i < 6; i++)
    {
      Knopf[i] = new Button (Text[i]);
      Knopf[i].addActionListener (this);
      Platte.add (Knopf[i]);
    }
    add (Platte);
    addWindowListener (new WindowAdapter()
    {
      public void WindowClosing (WindowEvent e)
      {
         System.exit(0);
      }
    });	    
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    for (int i = 0; i < 6; i++)
      if (Quelle == Knopf[i]) 
        System.out.println (Diagnose[i]);
  }
  
  public static void main(String[] args)
  {
    HalloFenster Rahmen = new HalloFenster ();
    Rahmen.setSize (400,300);
    Rahmen.setVisible(true);
  }
}

