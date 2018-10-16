package rechnen6;
import javax.swing.*;
import zinscalc.*;

public class Mathe6
{
  public static void main(String[] args) 
  {
    // Startwerte
    String Eingabe = ""; int Modus = 0;
    JZins Zins1 = new JZins ();
   // Daten einsammeln
    Eingabe = JOptionPane.showInputDialog
      ("Gib das Kapital ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus++;
    else Zins1.setKapital (Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Gib den Zinssatz ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus+=10;
    else Zins1.setProzent (Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Gib die Zinsen ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus+=100;
    else Zins1.setZinsen (Eingabe);
    // Gesuchtes berechnen
    switch (Modus)
    {
      case 1:
        Eingabe = Zins1.getKapital ();
        break;
      case 10:
        Eingabe = Zins1.getProzent ();
        break;
      case 100:
        Eingabe = Zins1.getZinsen ();
        break;
      default:
        Eingabe = "Keine oder zu viele Nullen!";
    }
    // Ergebnis anzeigen
    JOptionPane.showMessageDialog (null, "Ergebnis: " + Eingabe);
  }
}
