package fstein2a;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import fstein.*;

public class Monster2A extends JFrame implements ActionListener
{
  private JButton[] Knopf   = new JButton[3];
  private JLabel[]  Anzeige = new JLabel[3];
  private JMonster  Frank   = new JMonster  ("Frankie", "ungewöhnlich");
  private JGMonster Albert  = new JGMonster ("Bertie", "nachdenklich");
  private JSMonster Sigmund = new JSMonster ("Sigi", "mitfühlend");
  private Graphics Grafik;
  private Image[] Bild = new Image[3];
  private String[] Dateiname = {"Albert.jpg", "Frank.jpg", "Sigmund.jpg"};
  final String Pfad = "d:\\Java\\Projekte\\Bilder\\";

  public void collectImages ()
  {
    Toolkit Werkzeug = Toolkit.getDefaultToolkit();
    MediaTracker Transporter = new MediaTracker (this);
    for (int i = 0; i < 3; i++)
    {
      Bild[i] = Werkzeug.getImage (Pfad + Dateiname[i]);
      Transporter.addImage (Bild[i], i);
      try
      {
        Transporter.waitForID (i);
      }
      catch (InterruptedException x)
      {
        setTitle ("Bildstörung");
      }
    }
  }
  
  public Monster2A ()
  {
    super ("MonsterShow");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben  = Box.createHorizontalBox();
    Box Mitte = Box.createVerticalBox();
    Box Unten = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(350,210));
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
    collectImages ();
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource();
    Grafik = getGraphics();
    if (Quelle == Knopf[0])
    {
      Albert.erscheinen (Anzeige);
      Grafik.drawImage (Bild[0], 100,40, null);
    }
    if (Quelle == Knopf[1])
    {
      Frank.erscheinen (Anzeige);
      Grafik.drawImage (Bild[1], 100,40, null);
    }
    if (Quelle == Knopf[2])
    {
      Sigmund.erscheinen (Anzeige);
      Grafik.drawImage (Bild[2], 100,40, null);
    }
  }
  
  public static void main(String[] args)
  {
    Monster2A Rahmen = new Monster2A();
    Rahmen.setSize (400,400);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}
