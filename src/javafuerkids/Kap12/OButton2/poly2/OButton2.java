package poly2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mycomponents.JOButton;

public class OButton2 extends JFrame implements ActionListener
{
  public OButton2 ()
  {
    super ("O-Button 2");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize(new Dimension(380,50));
    Platte.add (Oben); 
    // O-Button erzeugen, verknüpfen, layouten
    JOButton Knopf = new JOButton ("Drück mich!");
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
    OButton2 Rahmen = new OButton2();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible (true);
  }
}
