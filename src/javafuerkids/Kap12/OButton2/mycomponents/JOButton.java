package javafuerkids.Kap12.OButton2.mycomponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class JOButton extends JButton
{
  private Color[] Farbe =
    {Color.black, Color.gray, Color.lightGray, Color.white};

  public JOButton (String Text)
  {
    super (Text);
    // Rechteckform von OButton unsichtbar machen
    setContentAreaFilled (false);
  }

  protected void paintComponent (Graphics Grafik)
  {
    ButtonModel Status = getModel(); 
    if (Status.isPressed())
	  Grafik.setColor (Farbe[1]);
    else
  	  Grafik.setColor (Farbe[2]);
      // Grafik.setColor (getBackground());
    Grafik.fillOval
      (0,0, getSize().width-1, getSize().height-1);
    super.paintComponent (Grafik);
  }
  
  protected void paintBorder (Graphics Grafik)
  {
    ButtonModel Status = getModel(); 
    if (Status.isPressed())
      Grafik.setColor (Farbe[3]);
    else
      Grafik.setColor (Farbe[0]);
      // Grafik.setColor (getForeground());
    Grafik.drawOval
      (0,0, getSize().width-1, getSize().height-1);
  }
} 