package fstein4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import fstein.*;

public class Monster4 extends JFrame implements ActionListener
{
  private JButton Knopf;
  private JLabel[] Anzeige = new JLabel[3];
  private JMonster WerWohl;
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
  
  public Monster4 ()
  {
    super ("MonsterShow");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben  = Box.createHorizontalBox();
    Box Mitte = Box.createVerticalBox();
    Oben.setPreferredSize (new Dimension(430,210));
    Mitte.setPreferredSize (new Dimension(350,90));
    // Komponenten erzeugen, verknüpfen, layouten
    for (int i = 0; i < 3; i++)
    {
      Anzeige[i] = new JLabel();
      Anzeige[i].setFont (new Font ("Courier", Font.BOLD, 20));
      Mitte.add (Anzeige[i]);
    }
    Knopf = new JButton ("Erscheinen");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.PLAIN, 20));
    Platte.add (Oben); 
    Platte.add (Mitte);
    Platte.add (Knopf);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Grafik = getGraphics();
    int Zufall = (int)(Math.random()*3);
    switch (Zufall)
    {
      case 0:
        WerWohl = new JMonster
        ("Frankie", "ungewöhnlich", "Frank.jpg");
      break;
    case 1:
      WerWohl = new JGMonster
        ("Berti", "nachdenklich", "Albert.jpg");
      break;
    case 2:
      WerWohl = new JSMonster
        ("Sigi", "mitfühlend", "Sigmund.jpg");
    }
    collectImage (WerWohl);
    WerWohl.erscheinen (Anzeige, Grafik, 100,40);
  }
  
  public static void main(String[] args)
  {
    Monster4 Rahmen = new Monster4();
    Rahmen.setSize (400,410);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}
