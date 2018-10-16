package scroll1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prozent1 extends JFrame implements AdjustmentListener
{
  // Attribute
  private JScrollBar Schieber;
  private JLabel Anzeige;
  private Box Oben, Unten;
  
  public void createComponents ()
  {
    // Komponenten erzeugen
    Anzeige  = new JLabel ("0 %");
    Schieber = new JScrollBar (Adjustable.HORIZONTAL, 0,1,0,101);
    Oben     = Box.createHorizontalBox();
    Unten    = Box.createHorizontalBox();
  }

  public void setFormLayout ()
  {
    // Größe, Umrandung und Schrift festlegen
    Anzeige.setFont (new Font ("Arial", Font.PLAIN, 24));
    Schieber.setPreferredSize (new Dimension (360,40));
    Oben.setPreferredSize (new Dimension (430,30));
    Unten.setPreferredSize (new Dimension (430,20));
 }
  
  // Konstruktor
  public Prozent1 ()
  {
    super ("Prozente");
    // Komponenten erstellen
    createComponents ();
    setFormLayout ();
    JPanel Platte  = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Komponenten mit Ereignissen verknüpfen   
    Schieber.addAdjustmentListener(this);
    // Alles einsetzen
    Platte.add (Oben);
    Platte.add (Schieber);
    Platte.add (Unten);
    Platte.add (Anzeige);
    setContentPane (Platte);
  }

   public void adjustmentValueChanged (AdjustmentEvent Ereignis)
  {
    int Nr = Schieber.getValue();
    Anzeige.setText(Integer.toString(Nr)+" %");
  }
  
  public static void main(String[] args)
  {
    Prozent1 Rahmen = new Prozent1 ();
    Rahmen.setSize (400,200);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

