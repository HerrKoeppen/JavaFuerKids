package noten4;
import javax.swing.*;

public class Zensur4
{
  public static void main(String[] args)
  {
    String Note = "";
    try
    {
      Note = 
        JOptionPane.showInputDialog ("Gib deine Punktzahl ein:");
      int Wert = Integer.parseInt (Note);
      if ((Wert >= 90) && (Wert <= 100)) Note = "sehr gut (1)";
      if ((Wert >= 75) && (Wert <   90)) Note = "gut (2)";
      if ((Wert >= 60) && (Wert <   75)) Note = "befriedigend (3)";
      if ((Wert >= 40) && (Wert <   60)) Note = "ausreichend (4)";
      if ((Wert >= 20) && (Wert <   40)) Note = "mangelhaft (5)";
      if ((Wert >=  0) && (Wert <   20)) Note = "ungenügend (6)";
      if ((Wert <   0) || (Wert >  100)) Note = "Quatsch!";
    }
    catch (Exception x)
      {Note = "Quatsch!";}
    JOptionPane.showMessageDialog (null, "Das ist " + Note);
  }
}
