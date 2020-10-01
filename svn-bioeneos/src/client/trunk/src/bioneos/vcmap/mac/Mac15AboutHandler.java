package bioneos.vcmap.mac;

import bioneos.vcmap.gui.MainGUI;
import bioneos.vcmap.gui.dialogs.AboutDialog;

import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;
import com.apple.eawt.Application;

@SuppressWarnings("deprecation")
public class Mac15AboutHandler extends Application
{
  private MainGUI parent;
  public Mac15AboutHandler(MainGUI gui)
  {
    parent = gui;
    
    addApplicationListener(new AboutHandler());
  }
  
  public class AboutHandler extends ApplicationAdapter
  {
    public void handleAbout(ApplicationEvent event) 
    {
      AboutDialog.showAboutDialog(parent);
      event.setHandled(true);
    }
    
    public void handleQuit(ApplicationEvent event)
    {
      parent.getVCMap().quit(true);
    }
    
    public void handleReOpen(ApplicationEvent event)
    {
      parent.getVCMap().showWindow();
    }
  }
}
