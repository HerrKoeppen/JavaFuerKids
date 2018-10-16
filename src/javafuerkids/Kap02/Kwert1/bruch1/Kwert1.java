package bruch1;
import javax.swing.*;

public class Kwert1
{
  public static void main(String[] args)
  {
    String Eingabe = 
      JOptionPane.showInputDialog ("Gib eine Zahl ein:");
    float Zahl = Float.parseFloat (Eingabe);
    if (Zahl != 0) 
    {
      Zahl = 1/Zahl;
      JOptionPane.showMessageDialog (null, "Kehrwert ist " + Zahl);
    }
    else
      JOptionPane.showMessageDialog (null, "Kein Kehrwert");
  }
}
