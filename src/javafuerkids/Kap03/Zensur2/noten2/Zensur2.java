package noten2;
import javax.swing.*;

public class Zensur2
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    int Wert = Integer.parseInt (Note);
    switch (Wert)
    {
      case 1: Note = "sehr gut";
      case 2: Note = "gut";
      case 3: Note = "befriedigend";
      case 4: Note = "ausreichend";
      case 5: Note = "mangelhaft";
      case 6: Note = "ungenügend";
    }
    JOptionPane.showMessageDialog (null, "Das ist " + Note);
  }
}
