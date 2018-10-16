package fstein3A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import fstein.*;

public class Monster3A extends JFrame implements ActionListener
{
  private JButton[] Knopf   = new JButton[3];
  private JLabel[]  Anzeige = new JLabel[3];
  private JMonster  Frank =
    new JMonster ("Frankie", "ungewöhnlich", "Frank.jpg");
  private JGMonster Albert =
    new JGMonster ("Bertie", "nachdenklich", "Albert.jpg");
  private JSMonster Sigmund =
    new JSMonster ("Sigi", "mitfühlend", "Sigmund.jpg");
  private Graphics Grafik;
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public void collectImage (JMonster Monster)
  {
    Toolkit Werkzeug = Toolkit.getDefaultToolkit();
    MediaTracker Transporter = new MediaTracker (this);
    Monster.Bild = Werkzeug.getImage (Pfad + Monster.Datei);
    Transporter.addImage (Monster.Bild, 0);
    try {Transporter.waitForID (0);}
    catch (InterruptedException x) {}
  }
  
  public Monster3A ()
  {
    super ("MonsterShow");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben  = Box.createHorizontalBox();
    Box Mitte = Box.createVerticalBox();
    Box Unten = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(430,210));
    Mitte.setPreferredSize (new Dimension(350,80));
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
    Grafik = getGraphics();
    if (Quelle == Knopf[0])
    {
      collectImage (Albert);
      Albert.erscheinen (Anzeige, Grafik, 100,40);
    }
    if (Quelle == Knopf[1])
    {
      collectImage (Frank);
      Frank.erscheinen (Anzeige, Grafik, 100,40);
    }
    if (Quelle == Knopf[2])
    {
      collectImage (Sigmund);
      Sigmund.erscheinen (Anzeige, Grafik, 100,40);
    }
  }
  
  public static void main(String[] args)
  {
    Monster3A Rahmen = new Monster3A();
    Rahmen.setSize (400,410);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}
