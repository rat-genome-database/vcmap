import java.util.Vector;
import java.util.Iterator;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AnnotationDialog 
  extends JDialog 
  implements ActionListener, ItemListener, ListSelectionListener
{
  // Singleton design pattern
  private static AnnotationDialog instance = null;

  // GUI Components
  private JComboBox annotTypes;
  private JComboBox ontology;
  private JLabel ontologyL;
  private JList maps;
  private JButton load;

  // Variables
  private Vector<String> ontologyTree = new Vector<String>();

  // Strings
  private String[] annotStrings = 
  {
    "",
    "QTL data",
    "SNPs"
  };
  private String[] ontologyFirst = 
  {
    "",
    "All",
    "Behavior",
    "Growth",
    "Metabolic Disorder",
    "Other"
  };
  private String[] ontologySecond =
  {
    "",
    "All",
    "Body Weight",
    "Heart Weight",
    "Hair Growth",
    "Abnormal Fat Percentage",
    "Other"
  };

  private AnnotationDialog(JFrame parent)
  {
    super(parent, true);

    // Component setup
    annotTypes = new JComboBox(annotStrings);
    annotTypes.addItemListener(this);
    String[] items = { "Please select a type of annotation..." };
    maps = new JList(items);
    maps.addListSelectionListener(this);
    maps.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    maps.setVisibleRowCount(5);
    JScrollPane mapsScroll = new JScrollPane(maps);
    ontologyL = new JLabel("All Data");
    ontologyL.setFont(new Font("default", Font.PLAIN, 10));
    ontologyL.setEnabled(false);
    ontology = new JComboBox(ontologyFirst);
    ontology.addItemListener(this);
    ontology.setEnabled(false);
    JLabel annotTypesL = new JLabel("Choose a Type of Annotation:");
    JLabel mapsL = new JLabel("Select the Maps to load this data for:");
    load = new JButton("Load");
    load.addActionListener(this);
    load.setEnabled(false);

    // Component Layout
    SpringLayout s = new SpringLayout();
    JPanel main = new JPanel(s);
    s.putConstraint(SpringLayout.NORTH, annotTypesL, 5, SpringLayout.NORTH, main);
    s.putConstraint(SpringLayout.WEST, annotTypesL, 5, SpringLayout.WEST, this);
    s.putConstraint(SpringLayout.NORTH, annotTypes, 10, SpringLayout.SOUTH, annotTypesL);
    s.putConstraint(SpringLayout.WEST, annotTypes, 10, SpringLayout.WEST, annotTypesL);
    s.putConstraint(SpringLayout.NORTH, mapsL, 20, SpringLayout.SOUTH, annotTypes);
    s.putConstraint(SpringLayout.WEST, mapsL, 0, SpringLayout.WEST, annotTypesL);
    s.putConstraint(SpringLayout.NORTH, mapsScroll, 10, SpringLayout.SOUTH, mapsL);
    s.putConstraint(SpringLayout.WEST, mapsScroll, 0, SpringLayout.WEST, annotTypes);
    s.putConstraint(SpringLayout.NORTH, ontologyL, 10, SpringLayout.SOUTH, mapsScroll);
    s.putConstraint(SpringLayout.WEST, ontologyL, 0, SpringLayout.WEST, annotTypesL);
    s.putConstraint(SpringLayout.NORTH, ontology, 5, SpringLayout.SOUTH, ontologyL);
    s.putConstraint(SpringLayout.WEST, ontology, 10, SpringLayout.WEST, ontologyL);
    s.putConstraint(SpringLayout.NORTH, load, 20, SpringLayout.SOUTH, ontology);
    s.putConstraint(SpringLayout.EAST, load, 0, SpringLayout.EAST, mapsScroll);
    s.putConstraint(SpringLayout.SOUTH, main, 5, SpringLayout.SOUTH, load);
    s.putConstraint(SpringLayout.EAST, main, 15, SpringLayout.EAST, load);
    main.add(annotTypesL);
    main.add(annotTypes);
    main.add(mapsL);
    main.add(mapsScroll);
    main.add(ontologyL);
    main.add(ontology);
    main.add(load);
    setContentPane(main);

    // Final setup
    setTitle("Load Annotation");
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    pack();
  }

  public static void showLoadDialog(JFrame parent)
  {
    if (instance == null) instance = new AnnotationDialog(parent);

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
    if (ie.getStateChange() == ItemEvent.SELECTED && ie.getSource() == annotTypes)
    {
      if (annotTypes.getSelectedIndex() == 0)
      {
        String[] items = { "Please select a type of annotation..." };
        maps.setListData(items);
        maps.setSelectedIndex(-1);
      }
      else if (annotTypes.getSelectedIndex() == 1)
      {
        // Setup the maps for QTL data
        String[] items = 
        {
          "Human - NCBI Build 30.0, May 1st, 2008",
          "Mouse - NCBI Build 37.1, April 29th, 2008",
          "Rat - MCW v3.0, June 7th, 2008",
          "Cow - ISU Build 5, May 31st, 2008",
          "Pig - ISU Build 10, June 7th, 2008"
        };
        maps.setListData(items);
        maps.setSelectedIndices(new int[] { 0, 1, 2 });
      }
      else if (annotTypes.getSelectedIndex() == 2)
      {
        // Setup the maps for SNP data
        String[] items = 
        {
          "Human - NCBI Build 32.0, May 30th, 2008",
          "Mouse - NCBI Build 37.2, April 3rd, 2008",
          "Rat - MCW v3.1, June 7th, 2008",
          "Cow - ISU Build 4, May 31st, 2008"
        };
        maps.setListData(items);
        maps.setSelectedIndices(new int[] { 0, 1, 2 });
      }

      // Update ontology section
      ontologyTree = new Vector<String>();
      ontology.removeAllItems();
      for (int i = 0; i < ontologyFirst.length; i++)
        ontology.addItem(ontologyFirst[i]);
      ontology.setSelectedIndex(0);
      ontologyL.setEnabled(annotTypes.getSelectedIndex() == 1);
      ontology.setEnabled(annotTypes.getSelectedIndex() == 1);
      // Enable / disable load button
      load.setEnabled(annotTypes.getSelectedIndex() != 0 && 
          maps.getSelectedIndex() != -1);
    }
    else if (ie.getStateChange() == ItemEvent.SELECTED && ie.getSource() == ontology)
    {
      // Add the term onto the ontology tree
      // TODO - need a way to go back
      if (!ie.getItem().equals(""))
      {
        if (ontologyTree.size() < 2)
        {
          ontologyTree.addElement(ie.getItem().toString());
        }
        else
        {
          ontologyTree.removeElementAt(1);
          ontologyTree.addElement(ie.getItem().toString());
        }

        if (ontologyTree.size() < 2)
        {
          ontology.removeAllItems();
          for (int i = 0; i < ontologySecond.length; i++)
            ontology.addItem(ontologySecond[i]);
        }
      }

      // Build label for ontologyL from ontologyTree Vector
      String label = "All Data";
      for (Iterator i = ontologyTree.iterator(); i.hasNext();)
        label += " >> " + i.next().toString();
      ontologyL.setText(label);
    }
  }

  public void valueChanged(ListSelectionEvent lse)
  {
  }
}
