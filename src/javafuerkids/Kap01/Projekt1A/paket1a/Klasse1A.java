package paket1a;
import java.io.*;

public class Klasse1A
{
  public static void main (String[] args)
  {
    try
    {
      BufferedReader Eingabe = 
      new BufferedReader (new InputStreamReader(System.in));
      System.out.println ("Hallo wer bist du?");
      String Name = Eingabe.readLine();
      System.out.println ("Du bist also " + Name);
    }
    catch (IOException x)
    {
      System.out.println ("Versteh ich nicht!");
    }
  }
}
