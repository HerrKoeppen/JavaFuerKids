package javafuerkids.Kap12.AutschS.knopfS;

import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class AutschS 
{
  public static void main(String[] args)
  {
    Display Manager = new Display ();  
    Shell Fenster = new Shell (Manager);
    Fenster.setSize (300,100);
    // Button erzeugen
    final Button Knopf1 = new Button (Fenster, 0);
    Knopf1.setBounds (100, 10, 100, 50);
    Knopf1.setText ("Dr�ck mich!"); 	      
    // Button mit Ereignissen verkn�pfen
    SelectionAdapter Adapter = new SelectionAdapter() 
    {
      public void widgetSelected(SelectionEvent Ereignis) 
  	    {Knopf1.setText("AUTSCH!");}
    };
    Knopf1.addSelectionListener(Adapter);
    Knopf1.pack();
    Fenster.open();
	//Ereignisschleife 
    while (!Fenster.isDisposed())
      if (!Manager.readAndDispatch()) 
        Manager.sleep();
  }
}
