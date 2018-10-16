package figuren0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafik0 extends JFrame implements ActionListener
{
  private JButton Knopf;

  public Grafik0 ()
  {
    super ("Grafik0");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    // Button erzeugen, verknüpfen, layouten
    Knopf = new JButton("Mal mal!");
    Knopf.addActionListener (this);
    Knopf.setFont (new Font ("Arial", Font.BOLD, 24));
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(400,100));
    // Alles einsetzen 	    
    Platte.add (Oben); 
    Platte.add (Knopf); 
    setContentPane (Platte);
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
  }

  public static void main(String[] args)
  {
    Grafik0 Rahmen = new Grafik0 ();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible(true);
  }
}

