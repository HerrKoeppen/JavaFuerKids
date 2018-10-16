package poly1;
import javax.swing.*;
import java.awt.*;

public class OButton1 extends JButton
{
  private Color[] Farbe =
    {Color.black, Color.gray, Color.lightGray, Color.white};

  public OButton1 (String Text)
  {
    super (Text);
    // Rechteckform von OButton unsichtbar machen
    setContentAreaFilled (false);
    // setOpaque(false);
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

  public static void main(String[] args)
  {
    // O-Button
    OButton1 Knopf = new OButton1 ("Drück mich!");
    Knopf.setPreferredSize (new Dimension(200,150));
    Knopf.setFont (new Font("Arial", Font.PLAIN, 24));
    // Der ganze "Rest"
    Box Oben = Box.createHorizontalBox();
    Oben.setPreferredSize(new Dimension(380,50));
    JFrame Rahmen = new JFrame();
    Rahmen.setTitle ("O-Button 1");
    Rahmen.getContentPane().add (Oben);
    Rahmen.getContentPane().add (Knopf);
    Rahmen.getContentPane().setLayout (new FlowLayout());
    Rahmen.setSize (400,300);
    Rahmen.setVisible (true);
  }
}
