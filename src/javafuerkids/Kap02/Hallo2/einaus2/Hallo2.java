package einaus2;
import javax.swing.*;

public class Hallo2 
{
  public static void main(String[] args) 
  {
    String Name = 
      JOptionPane.showInputDialog ("Hallo wer bist du?");
    String Antwort = 
      JOptionPane.showInputDialog (Name + " wie geht es?");
    if (Antwort.equals ("gut"))
      System.out.println ("Das freut mich!");
    if (Antwort.equals ("schlecht")) 
      System.out.println ("Das tut mir leid!");
  }
}
