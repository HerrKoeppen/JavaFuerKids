package zinscalc;

public class JZins
{
  private float Kapital;
  private float Prozent;
  private float Zinsen;
  
  public JZins ()
  {
    Kapital = 0;
    Prozent = 0;
    Zinsen  = 0;
  }
 
  public void setKapital (String Text)
  {
    Kapital = Float.parseFloat (Text);
  }
  
  public void setProzent (String Text)
  {
    Prozent = Float.parseFloat (Text);
  }

  public void setZinsen (String Text)
  {
    Zinsen = Float.parseFloat (Text);
  }

  public String getKapital ()
  {
    Kapital = Zinsen * 100 / Prozent;
    return (Float.toString (Kapital) + " Euro");
  }

  public String getProzent ()
  {
    Prozent = Zinsen * 100 / Kapital;
    return (Float.toString (Prozent) + " Prozent");
  }

  public String getZinsen ()
  {
    Zinsen = Kapital * Prozent / 100;
    return (Float.toString (Zinsen) + " Euro");
  }
}
