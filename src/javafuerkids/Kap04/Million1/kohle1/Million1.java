package kohle1;
import javax.swing.*;

public class Million1
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
    int Laufzeit = 0;
    while (Kapital < 1000000)
    {
      Zinsen = Kapital * Prozent / 100;
      Kapital = Kapital + Zinsen;
      Laufzeit++;
    }
    if (Laufzeit > 0)
      JOptionPane.showMessageDialog (null,
        "Dein Geld muss " + Laufzeit + " Jahre auf der Bank braten");
    else
      JOptionPane.showMessageDialog 
        (null,  "Willkommen im Club der Millionäre!");
  }
}
