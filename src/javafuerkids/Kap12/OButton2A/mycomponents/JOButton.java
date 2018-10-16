package javafuerkids.Kap12.OButton2A.mycomponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class JOButton extends JButton
{
  private Color[] Farbe =
    {Color.black, Color.gray, Color.lightGray, Color.white};
  private boolean Modus = true;
  
  public JOButton (String Text)
  {
    super (Text);
    // Rechteckform von OButton unsichtbar machen
    setContentAreaFilled (false);
  }

  public JOButton (String Text, boolean MM)
  {
    super (Text);
    // Rechteckform von OButton unsichtbar machen
    setContentAreaFilled (false);
    Modus = MM;
  }

  protected void paintComponent (Graphics Grafik)
  {
    ButtonModel Status = getModel();
    
    if (Status.isPressed())
    	if (Modus) Grafik.setColor (Farbe[1]);
    	else Grafik.setColor (getForeground());
    else
   	  if (Modus) Grafik.setColor (Farbe[2]);
      else Grafik.setColor (getBackground());
    Grafik.fillOval
      (0,0, getSize().width-1, getSize().height-1);
    super.paintComponent (Grafik);
  }
  
  protected void paintBorder (Graphics Grafik)
  {
    ButtonModel Status = getModel(); 
    if (Status.isPressed())
   	  if (Modus) Grafik.setColor (Farbe[3]);
      else Grafik.setColor (getBackground());
    else
   	  if (Modus) Grafik.setColor (Farbe[0]);
   	  else Grafik.setColor (getForeground());
    Grafik.drawOval
      (0,0, getSize().width-1, getSize().height-1);
  }
}