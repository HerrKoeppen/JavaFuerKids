package zufall5a;
import javax.swing.*;

public class JGuess
{
  static String Eingabe = ""; 
  static int Zufall = 0;
  static int Zahl = 0;
  
  JGuess ()
  {
    Zufall = (int)(Math.random()*1000)+1;
  }

  static void eingeben ()
  {
    Eingabe = JOptionPane.showInputDialog ("Rate mal:");
    Zahl = Integer.parseInt(Eingabe);
  }
 
  static boolean Ungeloest ()
  {
    return (Zahl != Zufall);
	// oder int: if (Zahl != Zufall) return 1; else return 0;
  }
  static void auswerten ()
  {
    if (Zahl <  Zufall)  Eingabe = Eingabe + " ist zu klein";
    if (Zahl >  Zufall)  Eingabe = Eingabe + " ist zu groﬂ";
    if (Zahl == Zufall) Eingabe = Eingabe + " ist richtig!";
    JOptionPane.showMessageDialog (null, "Die Zahl " + Eingabe);
  }
  
  public static void main(String[] args)
  {
    do
    {
      eingeben ();
      auswerten ();
    }
    while (Ungeloest());
  }
}
