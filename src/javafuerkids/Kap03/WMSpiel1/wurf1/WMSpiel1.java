package wurf1;
import javax.swing.*;

public class WMSpiel1 
{
  public static void main(String[] args) 
  {
    int Zufall = 0;
    String Eingabe = 
      JOptionPane.showInputDialog ("Willst du (1) Würfel (2) Münze?");
    if (Eingabe.equals ("1"))
    {
      Zufall = (int)(Math.random()*6)+1;
      Eingabe = Zufall + " Auge(n)";
    }
    if (Eingabe.equals ("2"))
    {
      Zufall = (int)(Math.random()*2); 
      if (Zufall == 0) Eingabe = " Zahl";
      if (Zufall == 1) Eingabe = " Wappen";
    }
    JOptionPane.showMessageDialog (null, "Dein Wurf " + Eingabe);
  }
}
