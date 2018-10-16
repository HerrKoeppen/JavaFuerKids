package kohle2a;
import javax.swing.*;

public class Million2A 
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
    for (int Nr = 0; Nr < Laufzeit; Nr++,
      Zinsen = Kapital * Prozent / 100,
      Kapital = Kapital + Zinsen) ;
    JOptionPane.showMessageDialog 
      (null, "Du hast nun " + Kapital + " Euro auf dem Konto.");
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


