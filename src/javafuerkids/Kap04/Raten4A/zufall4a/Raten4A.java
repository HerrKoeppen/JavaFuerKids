package zufall4a;
import javax.swing.*;

public class Raten4A 
{
  public static void main(String[] args)
  {
    int Zufall = (int)(Math.random()*1000)+1; 
    String Eingabe = ""; int Zahl = 0; 
    int Versuche = 0;
    do
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
    while (Zahl != Zufall);
    JOptionPane.showMessageDialog 
      (null, "Das waren " + Versuche + " Versuche");
  }
}
