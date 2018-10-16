package einaus2a;
import javax.swing.*;

public class Hallo2A 
{
  public static void main(String[] args) 
  {
    String Name = 
      JOptionPane.showInputDialog ("Hallo wer bist du?");
    String Antwort = 
      JOptionPane.showInputDialog (Name + " wie geht es?");
    if (Antwort.equals ("gut"))
      JOptionPane.showMessageDialog (null, "Das freut mich!");
    if (Antwort.equals ("schlecht")) 
      JOptionPane.showMessageDialog (null, "Das tut mir leid!");
  }
}
