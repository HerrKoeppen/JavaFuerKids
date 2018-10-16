package noten1;
import javax.swing.*;

public class Zensur1
{
  public static void main(String[] args)
  {
    String Note = 
      JOptionPane.showInputDialog ("Gib eine Note von 1 bis 6 ein:");
    if (Note.equals("1")) Note = "sehr gut";
    if (Note.equals("2")) Note = "gut";
    if (Note.equals("3")) Note = "befriedigend";
    if (Note.equals("4")) Note = "ausreichend";
    if (Note.equals("5")) Note = "mangelhaft";
    if (Note.equals("6")) Note = "ungenügend";
    JOptionPane.showMessageDialog (null, "Das ist " + Note);
  }
}
