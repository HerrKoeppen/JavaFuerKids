package poly4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mycomponents.JOnOffButton;

public class OButton4 extends JFrame implements ActionListener
{
  private JOnOffButton Knopf;
  
  public OButton4 ()
  {
    super ("On-Off-Button");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize(new Dimension(380,50));
    Platte.add (Oben); 
    // OnOff-Button erzeugen, verknüpfen, layouten
    Knopf = new JOnOffButton ("Drück mich!");
    Knopf.addActionListener (this);
    Knopf.setPreferredSize (new Dimension(200,150));
    Knopf.setFont (new Font("Arial", Font.PLAIN, 24));
    Platte.add (Knopf);
    setContentPane (Platte);
  }

  public void actionPerformed (ActionEvent Ereignis)
  {
    if (Knopf.getOnOffState())
	  setTitle ("Autsch!");
    else
  	  setTitle ("Aaaah!");
    try {Thread.sleep (1000);}
    catch (InterruptedException x) {}
    setTitle ("On-Off-Button");
  }

  public static void main(String[] args)
  {
    OButton4 Rahmen = new OButton4();
    Rahmen.setSize (400,300);
    Rahmen.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    Rahmen.setVisible (true);
  }
}
