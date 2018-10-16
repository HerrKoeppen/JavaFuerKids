package zufall5;
import javax.swing.*;

public class JGuess
{
  private String Eingabe = ""; 
  private int Zufall = 0;
  private int Zahl = 0;
  
  JGuess ()
  {
    Zufall = (int)(Math.random()*1000)+1;
  }

  public void eingeben ()
  {
    Eingabe = JOptionPane.showInputDialog ("Rate mal:");
    Zahl = Integer.parseInt(Eingabe);
  }
 
  public int Ungeloest ()
  {
    if (Zahl != Zufall) return 1; else return 0;
    // besser: return (Zahl != Zufall);
  }
  public void auswerten ()
  {
    if (Zahl <  Zufall)  Eingabe = Eingabe + " ist zu klein";
    if (Zahl >  Zufall)  Eingabe = Eingabe + " ist zu groﬂ";
    if (Zahl == Zufall) Eingabe = Eingabe + " ist richtig!";
    JOptionPane.showMessageDialog (null, "Die Zahl " + Eingabe);
  }
  
  public static void main(String[] args)
  {
    JGuess Spiel = new JGuess();
    do
    {
      Spiel.eingeben ();
      Spiel.auswerten ();
    }
    while (Spiel.Ungeloest() == 1);
  }
}
