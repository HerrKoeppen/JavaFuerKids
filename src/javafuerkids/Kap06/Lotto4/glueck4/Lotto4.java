package glueck4;
import java.util.*;

public class Lotto4 
{
  public static void main(String[] args)
  {
    // Startwerte, Lottozahlzahlenfeld  
    final int ANZAHL = 6; final int MAX = 49;
    boolean[] Lottozahl = new boolean[MAX+1];
    int[] Zufall = new int[ANZAHL+1];
    // Alle Zahlen im "Lottozahlpott" auf "noch nicht gezogen"
    for (int i = 1; i < Lottozahl.length; i++) Lottozahl[i] = false;
    // Sechs Zahlen "ziehen"
    for (int Nr = 1; Nr < Zufall.length; Nr++)
    {
      // noch nicht verwendete Zufallszahl suchen
      do
      {  
    	Zufall[Nr] = (int)(Math.random()*MAX)+1;
      } 
      while (Lottozahl[Zufall[Nr]]);
      // Benutzte Zahl als "gezogen" markieren
      Lottozahl[Zufall[Nr]] = true;     
      // System.out.println (Nr + ". Ziehung: " + Zufall[Nr]);
    }
    // Sortieren und anzeigen
    Arrays.sort (Zufall);
    for (int Nr = 1; Nr < Zufall.length; Nr++) 
      System.out.println (Nr + ". Zahl: " + Zufall[Nr]);
  }
}
