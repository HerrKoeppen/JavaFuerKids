package pword1;
import javax.swing.*;

public class KWort1 
{
  public static void main(String[] args) 
  {
    String Kennwort = "qwertz";
    String Eingabe = JOptionPane.showInputDialog
      ("Gib dein Kennwort (Password) ein:");
    if (Eingabe.equals(Kennwort)) 
      JOptionPane.showMessageDialog (null, "Alles OK");
    else 
      JOptionPane.showMessageDialog (null,"Zugriff verweigert");
  }
}
