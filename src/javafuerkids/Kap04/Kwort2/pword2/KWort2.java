package pword2;
import javax.swing.*;

public class KWort2 
{
  public static void main(String[] args) 
  {
    String Kennwort = "qwertz"; 
    String Eingabe = ""; int Versuche = 0;
    do
    {
      Eingabe = JOptionPane.showInputDialog
        ("Gib dein Kennwort (Password) ein:");
      Versuche++;
      if (Eingabe.equals(Kennwort))
      {
        JOptionPane.showMessageDialog (null, "Alles OK");
        break;
      }
      else 
        JOptionPane.showMessageDialog (null,"Zugriff verweigert");
    }
    while (Versuche < 3);
  }
}