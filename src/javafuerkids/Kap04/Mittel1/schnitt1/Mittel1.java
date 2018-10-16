package javafuerkids.Kap04.Mittel1.schnitt1;
import javax.swing.*;

public class Mittel1 
{
  public static void main(String[] args)
  {
    String Eingabe = "";
    int Anzahl = 0; float Zahl = 0; float Ergebnis = 0;
    while (1==1)  // oder: while (true)
    {
      Eingabe = 
        JOptionPane.showInputDialog ("Gib eine Zahl ein (x= Exit):");
      if (Eingabe.equals("x")) break;
      Zahl = Float.parseFloat (Eingabe);
      Ergebnis += Zahl; Anzahl++;
    }
    Ergebnis = Ergebnis / Anzahl;
    JOptionPane.showMessageDialog (null, "Durchschnitt ist " + Ergebnis);
  }
}
