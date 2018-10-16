package fstein3;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;

public class JMonster
{
  protected String[] Text = {" Name : ", " Wesen: ", " Typ  : "};
  protected String   Name, Wesen;
  public String Datei;
  public Image  Bild;

  public JMonster ()
  {
    Name = "Niemand"; Wesen = "monströs"; Datei = "";
  }
  
  public JMonster (String N, String W)
  {
    Name = N; Wesen = W; Datei = "";
  }

  public JMonster (String N, String W, String D)
  {
    Name = N; Wesen = W; Datei = D;
  }
  
  public String Typ ()
  {
    return "Monster";  
  }
  
  public void Typ (JLabel Info, String Charakter)
  {
    Info.setText ("Ich habe " + Charakter); 
  }

  public void erscheinen (JLabel[] Info)
  {
    Info[0].setText  (Text[0] + Name);
    Info[1].setText  (Text[1] + Wesen);
    Info[2].setText  (Text[2] + Typ());
  }

  public void erscheinen (JLabel[] Info, Graphics Grafik, int x, int y)
  {
    Info[0].setText  (Text[0] + Name);
    Info[1].setText  (Text[1] + Wesen);
    Info[2].setText  (Text[2] + Typ());
    Grafik.drawImage (Bild, x,y, null);
  }
}
