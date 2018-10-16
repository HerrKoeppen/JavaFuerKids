package fstein2a;
import javax.swing.JLabel;

public class JMonster
{
  protected String[] Text = {" Name : ", " Wesen: ", " Typ  : "};
  protected String   Name, Wesen;

  public JMonster (String N, String W)
  {
    Name = N; Wesen = W; 	  
  }
  
  public String Typ ()
  {
    return "Monster";  
  }
  
  public void erscheinen (JLabel[] Info)
  {
    Info[0].setText (Text[0] + Name);
    Info[1].setText (Text[1] + Wesen);
    Info[2].setText (Text[2] + Typ());
  }
}
