package rechnen4;
import javax.swing.*;

public class Mathe4 
{
  public static void main(String[] args)
  {
    String Eingabe = JOptionPane.showInputDialog ("Gib eine Zahl ein:");
    float Zahl = Float.parseFloat (Eingabe);
    float Ergebnis = -Zahl;
    JOptionPane.showMessageDialog (null, "Gegenzahl ist " + Ergebnis);
    Ergebnis = 1/Zahl;
    JOptionPane.showMessageDialog (null, "Kehrwert ist " + Ergebnis);      
  }
}
