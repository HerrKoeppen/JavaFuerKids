package glueck2;

public class Lotto2 
{
  public static void main(String[] args) 
  {
    // Startwerte, Lottozahlenfeld  
    final int ANZAHL = 6; final int MAX = 49;
    int[] Lotto = new int[MAX+1];
    int Zufall = 0;
    // Alle Zahlen im "Lottopott" auf "noch nicht gezogen"
    for (int i = 1; i < Lotto.length; i++) Lotto[i] = 0;
    // Sechs Zahlen "ziehen"
    for (int Nr = 1; Nr <= ANZAHL; Nr++) 
    {
      // noch nicht verwendete Zufallszahl suchen
      do 
      {  
    	Zufall = (int)(Math.random()*MAX)+1;
      } 
      while (Lotto[Zufall] == 1);
      // Benutzte Zahl als "gezogen" markieren
      Lotto[Zufall] = 1;     
      System.out.println (Nr + ". Ziehung: " + Zufall);
    }
  }
}
