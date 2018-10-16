package noten2a;
import javax.swing.*;

public class Zensur2A 
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    int Wert = Integer.parseInt (Note);
    switch (Wert)
    {
      case 1: System.out.println ("sehr gut");
      case 2: System.out.println ("gut");
      case 3: System.out.println ("befriedigend");
      case 4: System.out.println ("ausreichend");
      case 5: System.out.println ("mangelhaft");
      case 6: System.out.println ("ungenügend");
    }
  }
}
