package noten2c;
import javax.swing.*;

public class Zensur2C
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    int Wert = Integer.parseInt (Note);
    switch (Wert)
    {
      case 1: Note = "sehr gut";     break;
      case 2: Note = "gut";          break;
      case 3: Note = "befriedigend"; break;
      case 4: Note = "ausreichend";  break;
      case 5: Note = "mangelhaft";   break;
      case 6: Note = "ungenügend";
    }
    JOptionPane.showMessageDialog (null, "Das ist " + Note);
  }
}
