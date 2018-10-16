package zufall2;
import javax.swing.*;

public class Raten2
{
  public static void main(String[] args)
  {
    int Zufall = (int)(Math.random()*1000)+1;
    String Eingabe = ""; int Zahl = 0;
    while (Zahl != Zufall)
    {
      Eingabe = JOptionPane.showInputDialog ("Rate mal:");
      Zahl = Integer.parseInt(Eingabe);
      if (Zahl < Zufall)  Eingabe = Eingabe + " ist zu klein";
      if (Zahl > Zufall)  Eingabe = Eingabe + " ist zu groﬂ";
      if (Zahl == Zufall) Eingabe = Eingabe + " ist richtig!";
      JOptionPane.showMessageDialog (null, "Die Zahl " + Eingabe);
    }
  }
}
