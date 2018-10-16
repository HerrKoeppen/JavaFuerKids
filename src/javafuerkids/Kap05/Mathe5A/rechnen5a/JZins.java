package rechnen5a;
import javax.swing.*;

public class JZins
{
  static float Kapital;
  static float Prozent;
  static float Zinsen;
  
  JZins ()
  {
    Kapital = 0;
    Prozent = 0;
    Zinsen  = 0;
  }
 
  static void setKapital (String Text)
  {
    Kapital = Float.parseFloat (Text);
  }
  
  static void setProzent (String Text)
  {
    Prozent = Float.parseFloat (Text);
  }

  static void setZinsen (String Text)
  {
    Zinsen = Float.parseFloat (Text);
  }

  static String getKapital ()
  {
    Kapital = Zinsen * 100 / Prozent;
    return (Float.toString (Kapital) + " Euro");
  }

  static String getProzent ()
  {
    Prozent = Zinsen * 100 / Kapital;
    return (Float.toString (Prozent) + " Prozent");
  }

  static String getZinsen ()
  {
    Zinsen = Kapital * Prozent / 100;
    return (Float.toString (Zinsen) + " Euro");
  }

  public static void main(String[] args) 
  {
    String Eingabe = ""; int Modus = 0;
    Eingabe = JOptionPane.showInputDialog
      ("Gib das Kapital ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus++;
    else setKapital (Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Gib den Zinssatz ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus+=10;
    else setProzent (Eingabe);
    Eingabe = JOptionPane.showInputDialog
      ("Gib die Zinsen ein (0=gesucht):");
    if (Eingabe.equals("0")) Modus+=100;
    else setZinsen (Eingabe);

    switch (Modus)
    {
      case 1:
        Eingabe = getKapital ();
        break;
      case 10:
        Eingabe = getProzent ();
        break;
      case 100:
        Eingabe = getZinsen ();
        break;
      default:
        Eingabe = "Keine oder zu viele Nullen!";
    }
    JOptionPane.showMessageDialog (null,
      "Ergebnis: " + Eingabe);
  }
}
