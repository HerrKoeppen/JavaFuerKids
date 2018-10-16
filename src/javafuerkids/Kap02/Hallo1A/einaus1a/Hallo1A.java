package einaus1a;
import javax.swing.*;

public class Hallo1A 
{
  public static void main(String[] args) 
  {
    String Name = 
      JOptionPane.showInputDialog ("Hallo wer bist du?");
    String Antwort = 
      JOptionPane.showInputDialog (Name + " wie geht es?");
    System.out.println ("Dir geht es also " + Antwort);
  }
}
