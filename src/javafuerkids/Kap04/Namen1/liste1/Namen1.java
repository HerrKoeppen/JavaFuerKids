package liste1;
import javax.swing.*;
import java.util.*;

public class Namen1
{
  public static void main(String[] args) 
  {
    // Vereinbarungen
    final int MAX = 10;  // oder mehr
    String[] Name = new String[MAX+1];
    // Intialisierung
    for (int Nr = 0; Nr < Name.length; Nr++)
      Name[Nr] = "";
    // Eingabe
    for (int Nr = 0; Nr < Name.length; Nr++)
    {
      Name[Nr] = JOptionPane.showInputDialog ("Dein Name:");
      if (Name[Nr].equals("")) break;
    }
    // Sortierte Ausgabe
    Arrays.sort (Name);
    for (int Nr = 0; Nr < Name.length; Nr++)
    {
      System.out.println (Name[Nr]);
    }  
  }
}
