package rechnen4b;
import javax.swing.*;

public class JCalc2 
{
  float Gegenzahl (float Zahl)
  {
    return -Zahl;
  }
  
  float Kehrwert (float Zahl)
  {
    return 1/Zahl;
  }
  
  void anzeigen (String Text, float Zahl)
  {
    JOptionPane.showMessageDialog (null, Text + " ist " + Zahl); 
  }
  
  public static void main(String[] args)
  {
    JCalc2 Rechner = new JCalc2(); 
    String Eingabe = JOptionPane.showInputDialog ("Gib eine Zahl ein:");
    float Zahl = Float.parseFloat (Eingabe);
    Rechner.anzeigen ("Gegenzahl", Rechner.Gegenzahl (Zahl));
    Rechner.anzeigen ("Kehrwert", Rechner.Kehrwert (Zahl));
  }
}
