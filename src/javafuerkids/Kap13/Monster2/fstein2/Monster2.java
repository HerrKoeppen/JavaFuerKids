package fstein2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import fstein.*;

public class Monster2 extends JFrame implements ActionListener
{
  private JButton[] Knopf   = new JButton[3];
  private JLabel[]  Anzeige = new JLabel[3];
  private JMonster  Frank   = new JMonster  ("Frankie", "ungewöhnlich");
  private JGMonster Albert  = new JGMonster ("Bertie", "nachdenklich");
  private JSMonster Sigmund = new JSMonster ("Sigi", "mitfühlend");

  public Monster2 ()
  {
    super ("MonsterShow");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben  = Box.createHorizontalBox();
    Box Mitte = Box.createVerticalBox();
    Box Unten = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(350,50));
    Mitte.setPreferredSize (new Dimension(350,130));
    Unten.setPreferredSize (new Dimension(350,50));
    // Komponenten erzeugen, verknüpfen, layouten
    Knopf[0] = new JButton ("GMonster");
    Knopf[1] = new JButton ("Monster");
    Knopf[2] = new JButton ("SMonster");
    for (int i = 0; i < 3; i++)
    {
      Anzeige[i] = new JLabel();
      Anzeige[i].setFont (new Font ("Courier", Font.BOLD, 20));
      Mitte.add (Anzeige[i]);
      Knopf[i].addActionListener (this);
      Knopf[i].setFont (new Font ("Arial", Font.PLAIN, 20));
      Unten.add (Knopf[i]);
    }
    Platte.add (Oben); 
    Platte.add (Mitte);
    Platte.add (Unten);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    if (Quelle == Knopf[0])
    {
      Albert.erscheinen (Anzeige);
    }
    if (Quelle == Knopf[1])
    {
      Frank.erscheinen (Anzeige);
    }
    if (Quelle == Knopf[2])
    {
      Sigmund.erscheinen (Anzeige);
    }
  }
  
  public static void main(String[] args)
  {
    Monster2 Rahmen = new Monster2();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}
