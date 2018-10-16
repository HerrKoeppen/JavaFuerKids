package rahmen2;
import javax.swing.*;

public class Fenster2
{
  public static void main(String[] args)
  {
    JFrame Rahmen = new JFrame("Hallo, wie geht es?");
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JPanel Platte = new JPanel ();
    Platte.add (new JButton ("Gut"));
    Platte.add (new JButton ("Schlecht"));
    Rahmen.setContentPane (Platte);
    Rahmen.setVisible(true);
  }
}
