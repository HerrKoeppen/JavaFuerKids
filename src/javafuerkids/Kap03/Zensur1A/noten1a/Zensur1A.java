package noten1a;
import javax.swing.*;

public class Zensur1A 
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    int Wert = Integer.parseInt (Note);
    if (Wert == 1) Note = "sehr gut";
    if (Wert == 2) Note = "gut";
    if (Wert == 3) Note = "befriedigend";
    if (Wert == 4) Note = "ausreichend";
    if (Wert == 5) Note = "mangelhaft";
    if (Wert == 6) Note = "ungenügend";
    JOptionPane.showMessageDialog (null, "Das ist " + Note);
  }
}
