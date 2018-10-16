package javafuerkids.Kap12.OButton3.mycomponents;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import mycomponents.JOButton;

public class JOOButton extends JOButton
{
  final int FMax = 13;
  protected Color[] FPalette = {Color.black,
    Color.darkGray, Color.gray, Color.lightGray, Color.white,
    Color.cyan, Color.magenta, Color.yellow, Color.orange,
    Color.red, Color.green, Color.blue, Color.pink};

  public JOOButton (String Text)
  {
    super (Text);
    for (int i = 0; i < 4; i++)
      Farbe[i] = FPalette[(int)(Math.random()*FMax-1)+1];
  }

  public void setColor (Color PFarbe, Color NFarbe)
  {
    Farbe[1] = PFarbe;
    Farbe[2] = NFarbe;
  }

  public void setColor (int Nr, int Red, int Green, int Blue)
  {
    if ((Nr >= 0) && (Nr < 4))
      Farbe[Nr] = new Color (Red, Green, Blue);
  }

  public void setAllColors (Color FF[])
  {
    for (int i = 0; i < 4; i++) Farbe[i] = FF[i];
  }

  public void setAllColors ()
  {
    for (int i = 0; i < 4; i++)
      Farbe[i] = FPalette[(int)(Math.random()*FMax-1)+1];
  }
}