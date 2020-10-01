import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class MapDialog extends JDialog implements ActionListener, ItemListener
{
  // Singleton design pattern
  private static MapDialog instance = null;

  // GUI Components
  private JComboBox species;
  private JComboBox mapType;
  private JComboBox release;
  private JCheckBox backbone;
  private JButton load;

  // Strings
  private String[] speciesStrings = 
  {
    "",
    "Human",
    "Mouse",
    "Rat",
    "Cow",
    "Pig"
  };
  private String[] mapTypeStrings =
  {
    "",
    "Genomic",
    "Genetic",
    "RH"
  };
  private String[] releaseStrings =
  {
    "Build 36.2",
    "Build 37.0",
    "RGSC v3.3",
    "Build 3.0",
    "Build 2"
  };

  private MapDialog(JFrame parent)
  {
    super(parent, true);

    // Component setup
    species = new JComboBox(speciesStrings);
    species.addItemListener(this);
    mapType = new JComboBox(mapTypeStrings);
    mapType.setEnabled(false);
    mapType.addItemListener(this);
    release = new JComboBox(releaseStrings);
    release.insertItemAt("Current", 0);
    release.setSelectedIndex(0);
    release.setEnabled(false);
    backbone = new JCheckBox("Use this map as the Backbone");
    JLabel speciesL = new JLabel("Choose a Species:");
    JLabel mapTypeL = new JLabel("Choose a Type of Map:");
    JLabel releaseL = new JLabel("Choose a Map Release:");
    load = new JButton("Load");
    load.addActionListener(this);
    load.setEnabled(false);

    // Component Layout
    SpringLayout s = new SpringLayout();
    JPanel main = new JPanel(s);
    s.putConstraint(SpringLayout.NORTH, speciesL, 5, SpringLayout.NORTH, main);
    s.putConstraint(SpringLayout.WEST, speciesL, 5, SpringLayout.WEST, main);
    s.putConstraint(SpringLayout.NORTH, mapTypeL, 10, SpringLayout.SOUTH, speciesL);
    s.putConstraint(SpringLayout.WEST, mapTypeL, 0, SpringLayout.WEST, speciesL);
    s.putConstraint(SpringLayout.NORTH, releaseL, 10, SpringLayout.SOUTH, mapTypeL);
    s.putConstraint(SpringLayout.WEST, releaseL, 0, SpringLayout.WEST, speciesL);
    s.putConstraint(SpringLayout.SOUTH, species, 5, SpringLayout.SOUTH, speciesL);
    s.putConstraint(SpringLayout.WEST, species, 15, SpringLayout.EAST, releaseL);
    s.putConstraint(SpringLayout.SOUTH, mapType, 5, SpringLayout.SOUTH, mapTypeL);
    s.putConstraint(SpringLayout.WEST, mapType, 15, SpringLayout.EAST, releaseL);
    s.putConstraint(SpringLayout.SOUTH, release, 5, SpringLayout.SOUTH, releaseL);
    s.putConstraint(SpringLayout.WEST, release, 15, SpringLayout.EAST, releaseL);
    s.putConstraint(SpringLayout.NORTH, backbone, 10, SpringLayout.SOUTH, releaseL);
    s.putConstraint(SpringLayout.WEST, backbone, 0, SpringLayout.WEST, releaseL);
    s.putConstraint(SpringLayout.NORTH, load, 20, SpringLayout.SOUTH, backbone);
    s.putConstraint(SpringLayout.EAST, load, 0, SpringLayout.EAST, release);
    s.putConstraint(SpringLayout.SOUTH, main, 5, SpringLayout.SOUTH, load);
    s.putConstraint(SpringLayout.EAST, main, 5, SpringLayout.EAST, load);
    main.add(speciesL);
    main.add(mapTypeL);
    main.add(releaseL);
    main.add(species);
    main.add(mapType);
    main.add(release);
    main.add(backbone);
    main.add(load);
    setContentPane(main);

    // Final setup
    setTitle("Load a Map");
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    pack();
  }

  public static void showLoadDialog(JFrame parent)
  {
    if (instance == null) instance = new MapDialog(parent);

    Point center = parent.getLocation();
    center.x += parent.getWidth() / 2;
    center.y += parent.getHeight() / 2;
    center.x -= instance.getWidth() / 2;
    center.y -= instance.getHeight() / 2;
    if (center.x < 0) center.x = 0;
    if (center.y < 0) center.y = 0;
    instance.setLocation(center);
    instance.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae)
  {
    if (ae.getActionCommand().equals("Load"))
    {
      setVisible(false);
    }
  }

  public void itemStateChanged(ItemEvent ie)
  {
    if (ie.getStateChange() == ItemEvent.SELECTED)
    {
      load.setEnabled(species.getSelectedIndex() != 0 && 
          mapType.getSelectedIndex() != 0);

      // Set the Map Type drop down
      if (ie.getSource() == species) mapType.setSelectedIndex(0);
      mapType.setEnabled(species.getSelectedIndex() != 0);
      
      // Set the Release drop down
      if (ie.getSource() == species || ie.getSource() == mapType)
        release.setSelectedIndex(0);
      release.setEnabled(mapType.getSelectedIndex() == 1);
      if (ie.getSource() != release)
      {
        SwingUtilities.invokeLater(new Thread()
            {
              public void run() 
              {
                release.removeAllItems();
                release.addItem("Current");
                if (mapType.getSelectedIndex() == 1)
                  release.addItem(releaseStrings[species.getSelectedIndex()]);
              }
            });
      }
    }
  }
}
