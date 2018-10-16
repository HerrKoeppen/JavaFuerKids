package rechnen3;
import javax.swing.*;

public class Mathe3 
{
  public static void main(String[] args) 
  {
    float Ergebnis = 0;
    String Text = "Ergebnis ist ";
    try 
    {
      String Eingabe1 = 
        JOptionPane.showInputDialog ("Gib eine Zahl ein:");
      String Eingabe2 = 
        JOptionPane.showInputDialog ("Gib noch eine Zahl ein:");
      String Operator = 
        JOptionPane.showInputDialog ("Und jetzt den Operator:");
      float Zahl1 = Float.parseFloat(Eingabe1);
      float Zahl2 = Float.parseFloat(Eingabe2);
      if (Operator.equals("+")) Ergebnis = Zahl1 + Zahl2;
      if (Operator.equals("-")) Ergebnis = Zahl1 - Zahl2;
      if (Operator.equals("*")) Ergebnis = Zahl1 * Zahl2;
      if (Operator.equals("/"))
        if (Zahl2 != 0) Ergebnis = Zahl1 / Zahl2;
        else Text = "Division durch Null ";
    }
    catch (Exception x) 
    {
      Text = "Versteh ich nicht! ";
    }
    if (Text.equals("Ergebnis ist ")) Text = Text + Ergebnis;
    JOptionPane.showMessageDialog (null, Text);
  }
}
