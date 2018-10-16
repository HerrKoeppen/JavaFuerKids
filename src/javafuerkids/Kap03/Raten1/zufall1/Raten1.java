package zufall1;
import javax.swing.*;

public class Raten1
{
  public static void main(String[] args)
  {
    int Zufall = (int)(Math.random()*1000)+1;
    String Eingabe = 
      JOptionPane.showInputDialog ("Rate mal:");
    int Zahl = Integer.parseInt(Eingabe);
    if (Zahl < Zufall)  Eingabe = Eingabe + " ist zu klein";
    if (Zahl > Zufall)  Eingabe = Eingabe + " ist zu groﬂ";
    if (Zahl == Zufall) Eingabe = Eingabe + " ist richtig!";
      JOptionPane.showMessageDialog (null, "Die Zahl " + Eingabe);
  }
}
