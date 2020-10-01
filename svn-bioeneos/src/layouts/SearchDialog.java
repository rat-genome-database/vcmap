import java.util.Vector;
import java.util.Iterator;
import java.awt.Font;
import java.awt.Point;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class SearchDialog 
  extends JDialog
  implements ActionListener
{
  // Singleton design pattern
  private static SearchDialog instance = null;

  // GUI Components
  private JTextField name;
  private JButton searchName;
  private JFormattedTextField start;
  private JFormattedTextField stop;
  private JComboBox maps;
  private JButton searchLoc;
  private JList hits;

  private SearchDialog(JFrame parent)
  {
    super(parent, true);

    // Component setup
    name = new JTextField(20);
    name.setActionCommand("NameSearch");
    name.addActionListener(this);
    name.setAlignmentX(Component.RIGHT_ALIGNMENT);
    searchName = new JButton("Search");
    searchName.setActionCommand("SearchName");
    searchName.addActionListener(this);
    searchName.setAlignmentX(Component.LEFT_ALIGNMENT);
    start = new JFormattedTextField(java.text.NumberFormat.getIntegerInstance());
    stop = new JFormattedTextField(java.text.NumberFormat.getIntegerInstance());
    stop.setActionCommand("LocSearch");
    stop.addActionListener(this);
    maps = new JComboBox(new String[] 
        {
          "Mouse Map - NCBI Build 38.0", "Human Map - NCBI Build 37.1", 
          "Rat Map - RGD v3.3", "All Maps"
        });
    searchLoc = new JButton("Search");
    searchLoc.setActionCommand("SearchLoc");
    searchLoc.addActionListener(this);
    JLabel startL = new JLabel("Start Position:");
    JLabel stopL = new JLabel("Stop Position:");
    hits = new JList();
    JScrollPane hitsScroll = new JScrollPane(hits);

    // Component Layout
    JTabbedPane tabs = new JTabbedPane();
    tabs.setFont(new Font("default", Font.PLAIN, 10));
    SpringLayout s = new SpringLayout();
    JPanel namePanel = new JPanel(s);
    s.putConstraint(SpringLayout.NORTH, name, 5, SpringLayout.NORTH, namePanel);
    s.putConstraint(SpringLayout.WEST, name, 5, SpringLayout.WEST, namePanel);
    s.putConstraint(SpringLayout.NORTH, searchName, 5, SpringLayout.SOUTH, name);
    s.putConstraint(SpringLayout.EAST, searchName, 0, SpringLayout.EAST, name);
    s.putConstraint(SpringLayout.SOUTH, namePanel, 5, SpringLayout.SOUTH, searchName);
    s.putConstraint(SpringLayout.EAST, namePanel, 5, SpringLayout.EAST, name);
    namePanel.add(name);
    namePanel.add(searchName);
    JPanel wrap = new JPanel(new java.awt.BorderLayout());
    wrap.add(namePanel, "North");
    tabs.addTab("Search by Name", wrap);
    s = new SpringLayout();
    JPanel locPanel = new JPanel(s);
    s.putConstraint(SpringLayout.NORTH, startL, 5, SpringLayout.NORTH, locPanel);
    s.putConstraint(SpringLayout.WEST, startL, 5, SpringLayout.WEST, locPanel);
    s.putConstraint(SpringLayout.NORTH, stopL, 10, SpringLayout.SOUTH, startL);
    s.putConstraint(SpringLayout.WEST, stopL, 0, SpringLayout.WEST, startL);
    s.putConstraint(SpringLayout.NORTH, start, 0, SpringLayout.NORTH, startL);
    s.putConstraint(SpringLayout.WEST, start, 10, SpringLayout.EAST, startL);
    s.putConstraint(SpringLayout.NORTH, stop, 0, SpringLayout.NORTH, stopL);
    s.putConstraint(SpringLayout.EAST, stop, 0, SpringLayout.EAST, start);
    s.putConstraint(SpringLayout.WEST, stop, 0, SpringLayout.WEST, start);
    s.putConstraint(SpringLayout.NORTH, maps, 5, SpringLayout.SOUTH, stop);
    s.putConstraint(SpringLayout.EAST, maps, -5, SpringLayout.EAST, start);
    s.putConstraint(SpringLayout.WEST, maps, 5, SpringLayout.WEST, startL);
    s.putConstraint(SpringLayout.NORTH, searchLoc, 5, SpringLayout.SOUTH, maps);
    s.putConstraint(SpringLayout.EAST, searchLoc, 0, SpringLayout.EAST, start);
    s.putConstraint(SpringLayout.SOUTH, locPanel, 5, SpringLayout.SOUTH, searchLoc);
    s.putConstraint(SpringLayout.EAST, locPanel, 5, SpringLayout.EAST, start);
    locPanel.add(startL);
    locPanel.add(stopL);
    locPanel.add(start);
    locPanel.add(stop);
    locPanel.add(maps);
    locPanel.add(searchLoc);
    tabs.addTab("Search by Location", locPanel);
    JPanel main = new JPanel();
    BoxLayout box = new BoxLayout(main, BoxLayout.Y_AXIS);
    main.setLayout(box);
    main.add(tabs);
    main.add(Box.createVerticalStrut(5));
    main.add(hitsScroll);
    main.setBorder(new javax.swing.border.EmptyBorder(10, 10, 10, 10));
    setContentPane(main);

    // Final setup
    setTitle("Load Annotation");
    //setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    pack();
  }

  public static void showDialog(JFrame parent)
  {
    if (instance == null) instance = new SearchDialog(parent);

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
  }
}
