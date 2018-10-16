package rahmen2a;
import java.awt.*;
import javax.swing.*;

public class Fenster2A
{
  public static void main(String[] args)
  {
    JFrame Rahmen = new JFrame("Hallo, wie geht es?");
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JPanel Platte = new JPanel ();
    Platte.setLayout (new GridLayout());
    Platte.add (new JButton ("Gut"));
    Platte.add (new JButton ("Schlecht"));
    Rahmen.setContentPane (Platte);
    Rahmen.setVisible(true);
  }
}
