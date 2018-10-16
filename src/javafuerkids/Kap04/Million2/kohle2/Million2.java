package kohle2;
import javax.swing.*;

public class Million2 
{
  public static void main(String[] args)
  {
    String Eingabe = ""; float Zinsen = 0;
    Eingabe = JOptionPane.showInputDialog
      ("Wie viel Geld willst du anlegen?");
    float Kapital = Float.parseFloat(Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Wie hoch soll der Zinssatz sein?");
    float Prozent = Float.parseFloat(Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Und wie lange willst du warten?");
    int Laufzeit = Integer.parseInt(Eingabe);
    /**
     * TODO: Codezeilen ergänzen
     * for-Schleife
     * 
     */
    JOptionPane.showMessageDialog (null,
      "Du hast nun " + Kapital + " Euro auf dem Konto.");
  }
}

    /* while (Laufzeit > 0)
    {
    Zinsen = Kapital * Prozent / 100;
    Kapital = Kapital + Zinsen;
    Laufzeit--;
    } */
    
    /* do
    {
    Zinsen = Kapital * Prozent / 100;
    Kapital = Kapital + Zinsen;
    Laufzeit--;
    }
    while (Laufzeit > 0); */


