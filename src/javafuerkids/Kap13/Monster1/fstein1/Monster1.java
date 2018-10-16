package fstein1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Monster1 extends JFrame implements ActionListener
{
  private JButton  Knopf;
  private JLabel[] Anzeige = new JLabel[2];
  private JMonster Frank = new JMonster ("Frankie", "ungewöhnlich");

  public Monster1 ()
  {
    super ("MonsterShow");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben  = Box.createHorizontalBox();
    Box Mitte = Box.createVerticalBox();
    Oben.setPreferredSize (new Dimension(350,60));
    Mitte.setPreferredSize (new Dimension(350,140));
    // Komponenten erzeugen, verknüpfen, layouten
    Knopf = new JButton ("Monster");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.PLAIN, 20));
    for (int i = 0; i < 2; i++)
    {
      Anzeige[i] = new JLabel();
      Anzeige[i].setFont (new Font ("Courier", Font.BOLD, 20));
      Mitte.add (Anzeige[i]);
    }
    Platte.add (Oben); 
    Platte.add (Mitte);
    Platte.add (Knopf);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Frank.erscheinen (Anzeige);
  }
  
  public static void main(String[] args)
  {
    Monster1 Rahmen = new Monster1();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}
