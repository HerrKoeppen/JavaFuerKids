package rechnen1a;
import javax.swing.*;

public class Mathe1A
{
  public static void main(String[] args)
  {
    int Ergebnis = 0;
    String Eingabe1 = 
      JOptionPane.showInputDialog ("Gib eine Zahl ein:");
    String Eingabe2 = 
      JOptionPane.showInputDialog ("Gib noch eine Zahl ein:");
    String Operator = 
      JOptionPane.showInputDialog ("Und jetzt den Operator:");
    int Zahl1 = Integer.parseInt (Eingabe1);
    int Zahl2 = Integer.parseInt (Eingabe2);
    if (Operator.equals("+")) Ergebnis = Zahl1 + Zahl2;
    if (Operator.equals("-")) Ergebnis = Zahl1 - Zahl2;
    if (Operator.equals("*")) Ergebnis = Zahl1 * Zahl2;
    if (Operator.equals("/"))
      if (Zahl2 != 0) Ergebnis = Zahl1 / Zahl2;
      else System.out.println ("Division durch Null");
    JOptionPane.showMessageDialog (null, "Ergebnis ist " + Ergebnis);
    // System.out.println ("Ergebnis ist " + Ergebnis);
  }
}
