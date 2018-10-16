package knopfA;

import java.awt.event.*;
import javax.swing.*;

public class AutschA
{
  public static void main(String[] args)
  {
	JFrame Fenster = new JFrame();
	Fenster.setSize (300,100);
	Fenster.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    JPanel Platte = new JPanel ();
    // Button erzeugen
	final JButton Knopf1 = new JButton("Drück mich!");
 	// Button mit Ereignissen verknüpfen
	Knopf1.addActionListener (new ActionListener()
	{
	  public void actionPerformed (ActionEvent x)
	    {Knopf1.setText ("AUTSCH!");}
	});
	 // Einsetzen und sichtbar machen 	    
	 Platte.add (Knopf1);
	 Fenster.setContentPane (Platte);
	 Fenster.setVisible(true);
  }
}
