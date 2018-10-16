package rechnen5b;
import javax.swing.*;

public class JZins
{
  float Kapital;
  float Prozent;
  float Zinsen;
  
  JZins ()
  {
    Kapital = 0;
    Prozent = 0;
    Zinsen  = 0;
  }
 
  void setKapital (String Text)
  {
    Kapital = Float.parseFloat (Text);
  }
  
  void setProzent (String Text)
  {
    Prozent = Float.parseFloat (Text);
  }

  void setZinsen (String Text)
  {
    Zinsen = Float.parseFloat (Text);
  }

  String getKapital ()
  {
    Kapital = Zinsen * 100 / Prozent;
    return (Float.toString (Kapital) + " Euro");
  }

  String getProzent ()
  {
    Prozent = Zinsen * 100 / Kapital;
    return (Float.toString (Prozent) + " Prozent");
  }

  String getZinsen ()
  {
    Zinsen = Kapital * Prozent / 100;
    return (Float.toString (Zinsen) + " Euro");
  }

  String getDaten (String Text)
  {
    return (JOptionPane.showInputDialog
      ("Gib " + Text + " ein (0=gesucht):"));
  }
  
  public static void main(String[] args) 
  {
    // Startwerte
	String Eingabe = ""; int Modus = 0;
    JZins Zins1 = new JZins ();
   // Daten einsammeln
    Eingabe = Zins1.getDaten ("das Kapital");
    if (Eingabe.equals("0")) Modus++;
    else Zins1.setKapital (Eingabe);
    Eingabe = Zins1.getDaten ("den Zinssatz");
    if (Eingabe.equals("0")) Modus+=10;
    else Zins1.setProzent (Eingabe);
    Eingabe = Zins1.getDaten ("die Zinsen");
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
