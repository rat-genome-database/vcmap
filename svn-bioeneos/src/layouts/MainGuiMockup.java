import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class MainGuiMockup extends JFrame implements ActionListener
{
  // Constant revision #
  private static final int REVISION = 1;

  private MapNavigator mainWindow;
  private JScrollBar zoomBar;
  private JMenuBar menu;
  private Vector<Feature> dataModel = null;

  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new Thread()
        {
          public void run() { new MainGuiMockup(); }
        });
  }

  public MainGuiMockup()
  {
    // Component setup
    mainWindow = new MapNavigator(this);
    JScrollPane mainScroll = new JScrollPane(mainWindow);
    zoomBar = new JScrollBar(JScrollBar.VERTICAL, 0, 1, 0, 10);
    zoomBar.setAlignmentX(Component.CENTER_ALIGNMENT);
    JLabel zoomL = new JLabel("Zoom");
    zoomL.setFont(new Font("default", Font.PLAIN, 10));
    zoomL.setAlignmentX(Component.CENTER_ALIGNMENT);
    StatusBar status = new StatusBar(this);

    // Component layout
    JPanel zoom = new JPanel();
    BoxLayout box = new BoxLayout(zoom, BoxLayout.Y_AXIS);
    zoom.setLayout(box);
    zoom.add(zoomL);
    zoom.add(Box.createVerticalStrut(5));
    zoom.add(zoomBar);
    zoom.setBorder(new javax.swing.border.EmptyBorder(15, 5, 15, 5));
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(status, "North");
    mainPanel.add(mainScroll, "Center");
    mainPanel.add(zoom, "West");
    setContentPane(mainPanel);

    // Setup Main Menubar
    setupMenu();

    // Final setup
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setTitle("VCMap GUI Mockup");
    pack();
    setVisible(true);
  }

  public void setupMenu()
  {
    menu = new JMenuBar();

    // File menu
    JMenu file = new JMenu("File");
    if (System.getProperty("os.name").toLowerCase().indexOf("mac") == -1)
      file.setMnemonic('F');
    JMenuItem fileSave = new JMenuItem("Export Image...");
    fileSave.setEnabled(false);
    fileSave.setActionCommand("Save");
    fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    fileSave.addActionListener(this);
    fileSave.setMnemonic('E');
    file.add(fileSave);
    JMenuItem fileDownload = new JMenuItem("Download...");
    fileDownload.setEnabled(true);							//changed this to true for debugging purposes
    fileDownload.setActionCommand("Download");
    fileDownload.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    fileDownload.addActionListener(this);
    fileDownload.setMnemonic('D');
    file.add(fileDownload);
    file.add(new JSeparator());
    JMenuItem filePrefs = new JMenuItem("Edit Preferences...");
    filePrefs.setActionCommand("Preferences");
    filePrefs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_COMMA
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    filePrefs.addActionListener(this);
    filePrefs.setMnemonic('P');
    file.add(filePrefs);
    file.add(new JSeparator());
    JMenuItem fileQuit = new JMenuItem("Quit");
    fileQuit.setActionCommand("Quit");
    fileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    fileQuit.addActionListener(this);
    fileQuit.setMnemonic('Q');
    file.add(fileQuit);
    menu.add(file);

    // Map menu
    JMenu map = new JMenu("Map");
    if (System.getProperty("os.name").toLowerCase().indexOf("mac") == -1)
      map.setMnemonic('M');
    JMenuItem mapLoad = new JMenuItem("Load...");
    mapLoad.setActionCommand("Load");
    mapLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    mapLoad.addActionListener(this);
    mapLoad.setMnemonic('L');
    map.add(mapLoad);
    map.add(new JSeparator());
    JMenuItem mapSwap = new JMenuItem("Swap Backbones...");
    mapSwap.setActionCommand("SwapBB");
    mapSwap.addActionListener(this);
    mapSwap.setMnemonic('B');
    map.add(mapSwap);
    map.add(new JSeparator());
    JMenuItem mapHide = new JMenuItem("Hide Selected");
    mapHide.setActionCommand("HideMaps");
    mapHide.addActionListener(this);
    mapHide.setMnemonic('H');
    map.add(mapHide);
    JMenuItem mapShow = new JMenuItem("Show All");
    mapShow.setActionCommand("ShowMaps");
    mapShow.addActionListener(this);
    mapShow.setMnemonic('S');
    map.add(mapShow);
    menu.add(map);

    // Annotation menu
    JMenu annot = new JMenu("Annotation");
    if (System.getProperty("os.name").toLowerCase().indexOf("mac") == -1)
      annot.setMnemonic('A');
    JMenuItem annotLoad = new JMenuItem("Load Annotation...");
    annotLoad.setActionCommand("LoadAnnot");
    annotLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    annotLoad.addActionListener(this);
    annotLoad.setMnemonic('L');
    annot.add(annotLoad);
    annot.add(new JSeparator());
    JMenuItem annotHide = new JMenuItem("Hide Selected");
    annotHide.setActionCommand("HideAnnots");
    annotHide.addActionListener(this);
    annotHide.setMnemonic('H');
    annot.add(annotHide);
    JMenu annotShow = new JMenu("Show");
    annotShow.setMnemonic('S');
    JMenuItem annotShowAll = new JMenuItem("All");
    annotShowAll.setActionCommand("ShowAnnotsAll");
    annotShowAll.addActionListener(this);
    annotShowAll.setMnemonic('A');
    annotShow.add(annotShowAll);
    JMenuItem annotShowInterval = new JMenuItem("All for Selected Interval");
    annotShowInterval.setActionCommand("ShowAnnotsInterval");
    annotShowInterval.addActionListener(this);
    annotShowInterval.setMnemonic('I');
    annotShow.add(annotShowInterval);
    JMenuItem annotShowType = new JMenuItem("All of Type *foo*");
    annotShowType.setActionCommand("ShowAnnotsType");
    annotShowType.addActionListener(this);
    annotShowType.setMnemonic('T');
    annotShow.add(annotShowType);
    annot.add(annotShow);
    menu.add(annot);

    // Search menu
    JMenu search = new JMenu("Search");
    if (System.getProperty("os.name").toLowerCase().indexOf("mac") == -1)
      search.setMnemonic('S');
    JMenuItem searchFind = new JMenuItem("Find...");
    searchFind.setActionCommand("Find");
    searchFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F
          , Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
    searchFind.addActionListener(this);
    searchFind.setMnemonic('F');
    search.add(searchFind);
    menu.add(search);

    // Help menu
    JMenu help = new JMenu("Help");
    if (System.getProperty("os.name").toLowerCase().indexOf("mac") == -1)
      help.setMnemonic('H');
    JMenuItem helpAbout = new JMenuItem("About...");
    helpAbout.setActionCommand("About");
    helpAbout.addActionListener(this);
    helpAbout.setMnemonic('A');
    help.add(helpAbout);
    menu.add(help);

    setJMenuBar(menu);
  }

  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals("Quit"))
    {
      System.exit(0);
    }
    else if (ae.getActionCommand().equals("Load"))
    {
      // Open a JDialog to display choices for a species and map type to load
      MapDialog.showLoadDialog(this);

      // Load some dummy data to display in the interface
      try
      {
        File map = new File(getClass().getResource("dummyData.txt").toURI());
        if (!map.exists()) throw new IOException("Missing File");

        FileMapReader read = new FileMapReader(map);
        dataModel = read.getFeatures();
      }
      catch (Exception e)
      {
        JOptionPane.showMessageDialog(this, "Cannot find the map file...", "File missing",
            JOptionPane.ERROR_MESSAGE);
      }
    }
    else if (ae.getActionCommand().equals("Preferences"))
    {
      PreferencesDialog.showLoadDialog(this);
    }
    else if (ae.getActionCommand().equals("Download"))
    {
      DownloadDialog.showLoadDialog(this);
    }
    else if (ae.getActionCommand().equals("LoadAnnot"))
    {
      AnnotationDialog.showLoadDialog(this);
    }
    else if (ae.getActionCommand().equals("SwapBB"))
    {
      SwingUtilities.invokeLater(new Thread()
          {
            public void run() { new MainGuiMockup(); }
          });
    }
    else if (ae.getActionCommand().equals("Find"))
    {
      SearchDialog.showDialog(this);
    }
    else if (ae.getActionCommand().equals("About"))
    {
      String text = "<html><p><center><font size='+1'><b>VCMap GUI Mockup</b></font><br>";
      text += "Revision <b>"+REVISION+"</b></center></p>";
      text += "<p>This application is intended to demonstrate the layout of the main<br>";
      text += "Graphical User Interface for the VCMap client application.  It is not<br>";
      text += "intended to demonstrate the final functionality or any of the proposed<br>";
      text += "features for the application.  All data displayed by this application<br>";
      text += "is either hard coded or dummy data.";
      JOptionPane.showMessageDialog(this, text, "About VCMap GUI Mockup", 
          JOptionPane.INFORMATION_MESSAGE);
    }
  }
}
