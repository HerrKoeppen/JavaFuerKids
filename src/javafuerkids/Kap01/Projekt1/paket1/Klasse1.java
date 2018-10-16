package paket1;
import java.util.*;

public class Klasse1
{
  public static void main ( String[] args )
  {
    Scanner Eingabe = new Scanner (System.in);
    System.out.println ("Hallo wer bist du?");
    String Name = Eingabe.next();
    System.out.println ("Du bist also " + Name);
  }
}
