package swingui1;
import javax.swing.*;
import javax.swing.UIManager.*;
import java.awt.*;
import java.awt.event.*;

public class Look1 extends JFrame implements ActionListener
{
  private JButton[] Knopf = new JButton[5];
  private LookAndFeelInfo[] Erscheinung = 
    UIManager.getInstalledLookAndFeels();
  private String[] UIname = 
	{" Metal ", " Nimbus ", " Motif ", "Windows", "Classic"};
   
  public Look1 ()
  {
    super (" Metal ");
    JPanel Platte = new JPanel ();
    Platte.setLayout (new FlowLayout());
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize (new Dimension(380,50));
    Platte.add (Oben); 
    for (int i = 0; i < 5; i++)
    {
      Knopf[i] = new JButton (UIname[i]);
      Knopf[i].addActionListener (this);
      Knopf[i].setFont (new Font("Arial", Font.PLAIN, 20));
      Platte.add (Knopf[i]);
    }
    Box Mitte = Box.createHorizontalBox();
    Mitte.setPreferredSize (new Dimension(380,20));
    JRadioButton Option = new JRadioButton ("Optionsfeld");
    Option.setFont (new Font("Arial", Font.PLAIN, 20));
    JCheckBox Kontrolle = new JCheckBox ("Kontrollfeld");
    Kontrolle.setFont (new Font("Arial", Font.PLAIN, 20));
    Platte.add (Mitte); 
    Platte.add (Option); 
    Platte.add (Kontrolle); 
    setContentPane (Platte);
  }
  
  public void actionPerformed (ActionEvent Ereignis)
  {
    Object Quelle = Ereignis.getSource(); 
    for (int i = 0; i < 5; i++)
      if (Quelle == Knopf[i])
        try
        {
          UIManager.setLookAndFeel (Erscheinung[i].getClassName());
          this.setTitle (UIname[i]);
        }
        catch (Exception x){}
    SwingUtilities.updateComponentTreeUI (this.getContentPane());
  }
  
  public static void main(String[] args)
  {
    Look1 Rahmen = new Look1 ();
    Rahmen.setSize (400,300);
    Rahmen.setVisible (true);
  }
}
