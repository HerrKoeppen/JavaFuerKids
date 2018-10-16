package rechnen4a;
import javax.swing.*;

public class JCalc1 
{
  static float Gegenzahl (float Zahl)
  {
    return -Zahl;
  }
  
  static float Kehrwert (float Zahl)
  {
    return 1/Zahl;
  }
  
  static void anzeigen (String Text, float Zahl)
  {
    JOptionPane.showMessageDialog (null, Text + " ist " + Zahl); 
  }
  
  public static void main(String[] args)
  {
    String Eingabe = JOptionPane.showInputDialog ("Gib eine Zahl ein:");
    float Zahl = Float.parseFloat (Eingabe);
    anzeigen ("Gegenzahl", Gegenzahl (Zahl));
    anzeigen ("Kehrwert", Kehrwert (Zahl));
  }
}
