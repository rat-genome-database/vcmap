package bioneos.vcmap.mac;

import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent;
import com.apple.eawt.Application;

import bioneos.vcmap.gui.MainGUI;
import bioneos.vcmap.gui.dialogs.AboutDialog;

public class MacAboutHandler implements AboutHandler
{
  private MainGUI app;
  
  public MacAboutHandler(MainGUI gui) 
  {
    app = gui;
    Application.getApplication().setAboutHandler(this);
  }

  public void handleAbout(AppEvent.AboutEvent event) 
  {
    AboutDialog.showAboutDialog(app);
  }
}
