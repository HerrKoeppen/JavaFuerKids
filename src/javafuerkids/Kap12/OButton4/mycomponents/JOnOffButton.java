package javafuerkids.Kap12.OButton4.mycomponents;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class JOnOffButton extends JButton
{
  protected boolean OnOff = false;
  protected Color[] Farbe =
    {Color.black, Color.gray, Color.lightGray, Color.white};

  public JOnOffButton (String Text)
  {
    super (Text);
    // Rechteckform von OButton unsichtbar machen
    setContentAreaFilled (false);
  }

  protected void paintComponent (Graphics Grafik)
  {
    ButtonModel Status = getModel(); 
    if (Status.isPressed()) OnOff = !OnOff;
    if (OnOff)	
	  Grafik.setColor (Farbe[1]);
    else
	  Grafik.setColor (Farbe[2]);
    Grafik.fillOval
      (0,0, getSize().width-1, getSize().height-1);
    super.paintComponent (Grafik);
  }

  protected void paintBorder (Graphics Grafik)
  {
    ButtonModel Status = getModel(); 
    if (OnOff)
      Grafik.setColor (Farbe[3]);
    else
      Grafik.setColor (Farbe[0]);
    Grafik.drawOval
      (0,0, getSize().width-1, getSize().height-1);
  }
  
  public boolean getOnOffState ()
  {
    return OnOff;
  }
}
