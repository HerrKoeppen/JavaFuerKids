package javafuerkids.Kap12.OButton2A.poly2a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafuerkids.Kap12.OButton2A.mycomponents.JOButton;


public class OButton2A extends JFrame implements ActionListener
{
  public OButton2A ()
  {
    super ("O-Button 2");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize(new Dimension(380,50));
    Platte.add (Oben); 
    // O-Button erzeugen, verkn�pfen, layouten
    JOButton Knopf = new JOButton ("Dr�ck mich!", false);
    Knopf.addActionListener (this);
    Knopf.setPreferredSize (new Dimension(200,150));
    Knopf.setFont (new Font("Arial", Font.PLAIN, 24));
    Platte.add (Knopf);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    JOptionPane.showMessageDialog (null, "Autsch!");
  }

  public static void main(String[] args)
  {
    OButton2A Rahmen = new OButton2A();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible (true);
  }
}
