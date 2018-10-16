package zufall4;
import javax.swing.*;

public class Raten4 
{
  public static void main(String[] args)
  {
    int Zufall = (int)(Math.random()*1000)+1; 
    String Eingabe = ""; int Zahl = 0; 
    int Versuche = 0;
    while (Zahl != Zufall)
    {
      try
      {
        Eingabe = JOptionPane.showInputDialog ("Rate mal:");
        Zahl = Integer.parseInt(Eingabe);
        if (Zahl == 0) break;
        Versuche++;
        if (Zahl < Zufall) Eingabe  = Eingabe + " ist zu klein";
        if (Zahl > Zufall) Eingabe  = Eingabe + " ist zu groﬂ";
        if (Zahl == Zufall) Eingabe = Eingabe + " ist richtig!";
        JOptionPane.showMessageDialog (null, "Die Zahl " + Eingabe);
      }
      catch (Exception x)
      {
        JOptionPane.showMessageDialog (null, "Das ist falsch!");
      }
    } 
    JOptionPane.showMessageDialog 
      (null, "Das waren " + Versuche + " Versuche");
  }
}
