package glueck1;
// import javax.swing.*;

public class Lotto1 
{
  public static void main(String[] args) 
  {
    int Zufall = 0;
    for (int Nr = 1; Nr <= 6; Nr++) 
    {
      Zufall = (int)(Math.random()*49)+1; 
      System.out.println (Nr + ". Ziehung: " + Zufall);
      // JOptionPane.showMessageDialog (null, Nr + ". Ziehung: " + Zufall);
    }
  }
}
