package noten2b;
import javax.swing.*;

public class Zensur2B 
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    int Wert = Integer.parseInt (Note);
    switch (Wert)
    {
      case 1:  System.out.println ("sehr gut");     break;
      case 2:  System.out.println ("gut");          break;
      case 3:  System.out.println ("befriedigend"); break;
      case 4:  System.out.println ("ausreichend");  break;
      case 5:  System.out.println ("mangelhaft");   break;
      case 6:  System.out.println ("ungenügend");   break;
      default: System.out.println ("Quatsch!");
    }
  }
}
