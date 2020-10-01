import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.ListSelectionModel;
import java.io.File;

public class DownloadDialog extends JDialog implements ActionListener, ListSelectionListener
{
  // Singleton design pattern
  private static DownloadDialog instance = null;

  // GUI Components
  private JList maps;
  private JList types;
  private JList data;
  private JTable table;
  private JButton save;
  private JButton cancel;
  private JButton browse;
  private JButton selectAll;
  private JTextField file;
  private JFileChooser fileChooser;
  
  // Strings
  private String[] annotStrings = 
  {
    "QTL data",
    "SNPs"
  };

  String[] mapsStrings = 
  {
    "Human - NCBI Build 30.0, May 1st, 2008",
    "Mouse - NCBI Build 37.1, April 29th, 2008",
    "Rat - MCW v3.0, June 7th, 2008",
    "Cow - ISU Build 5, May 31st, 2008",
    "Pig - ISU Build 10, June 7th, 2008"
  };
  
 private String[] dataStrings =
  {
    "Body Weight",
    "Heart Weight",
    "Hair Growth",
    "Abnormal Fat Percentage",
    "Other"
  };

  
  private String[] columnStrings =
  {
    "C1",
    "C2",
    "C3",
    "C4",
    "C5"
  };
  
  private Object[][] tableData = 
  {
    {
      "1", "2",
      "3", "4", "5"
    },
    {
      "111", "122",
      "213", "411", "115"
    },
    {
      "Mt. Dew", "Mello Yellow",
      "Dr. Pepper", "sprite", "pepsi"
    },
    {
      "Sharon", "Zakhour",
      "Speed reading", "hello", "goodbye"
    },
    {
      "Roger", "Josh",
      "Pool", "Green", "simple"
    }
  };

  private DownloadDialog(JFrame parent)
  {
    super(parent, true);
    
    // Sets edges for all borders
    Border paneEdge = BorderFactory.createEmptyBorder(0,0,0,0);
    
    // Set up file chooser
    //   NOTE: User can select specific file or directory
    fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

   
    // Component setup
    JLabel fileL = new JLabel("File Name:");
    JLabel mapsL = new JLabel("Select Maps:");
    JLabel typesL = new JLabel("Type:");
    JLabel dataL = new JLabel("Data:");
    JLabel numAnnotationsL = new JLabel("Number of Annotations:");
    //JLabel selectAllL = new JLabel("Select All");

    table = new JTable(tableData, columnStrings);
    table.setAutoResizeMode(4);
    table.setEnabled(false);
    JScrollPane tableScroll = new JScrollPane(table);
    
    maps = new JList(mapsStrings);
    maps.addListSelectionListener(this);
    maps.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    maps.setVisibleRowCount(5);
    maps.setSelectedIndex(-1);
    JScrollPane mapsScroll = new JScrollPane(maps);
    
    types = new JList(annotStrings);
    types.addListSelectionListener(this);
    types.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    types.setVisibleRowCount(5);
    types.setEnabled(false);
    JScrollPane typesScroll = new JScrollPane(types);
    
    data = new JList(dataStrings);
    data.addListSelectionListener(this);
    data.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    data.setVisibleRowCount(5);
    data.setEnabled(false);
    JScrollPane dataScroll = new JScrollPane(data);
    
    file = new JTextField();
    
    selectAll = new JButton("select all");
    selectAll.addActionListener(this);
    selectAll.setBorderPainted(false);
    selectAll.setMargin(new Insets(0,0,0,0));
    selectAll.setEnabled(false);
    
    browse = new JButton("Browse...");
    browse.addActionListener(this);
    browse.setEnabled(true);
    
    save = new JButton("Save");
    save.addActionListener(this);
    save.setEnabled(false);

    cancel = new JButton("Cancel");
    cancel.addActionListener(this);
    cancel.setEnabled(true);
    
    /*
     * TODO
     * - Of course make everything else functional
     */

    // Construct Panel 'main' panel
    SpringLayout s = new SpringLayout();
    JPanel main = new JPanel(s);
    
    // Construct Panel and Layout for 'Annotation Selection' portion
    JPanel annotSelBorder = new JPanel();
    annotSelBorder.setBorder(paneEdge);
    annotSelBorder.setLayout(new BoxLayout(annotSelBorder, BoxLayout.Y_AXIS));
    
    SpringLayout aL = new SpringLayout();
    JPanel aComp = new JPanel(aL, false);
    
    // Set up layout of 'Annotation Selection' portion
    int jListSpacing = 7;
    aL.putConstraint(SpringLayout.SOUTH, dataScroll, 0, SpringLayout.SOUTH, typesScroll);
    aL.putConstraint(SpringLayout.SOUTH, mapsScroll, 0, SpringLayout.SOUTH, typesScroll);
    aL.putConstraint(SpringLayout.WEST, mapsL, 5, SpringLayout.WEST, aComp);
    aL.putConstraint(SpringLayout.NORTH, mapsL, 5, SpringLayout.NORTH, aComp);
    aL.putConstraint(SpringLayout.WEST, mapsScroll, 0, SpringLayout.WEST, mapsL );
    aL.putConstraint(SpringLayout.NORTH, mapsScroll, 5, SpringLayout.SOUTH, mapsL);
    aL.putConstraint(SpringLayout.WEST, typesScroll, jListSpacing, SpringLayout.EAST, mapsScroll);
    aL.putConstraint(SpringLayout.NORTH, typesScroll, 0, SpringLayout.NORTH, mapsScroll);
    aL.putConstraint(SpringLayout.NORTH, typesL, 0, SpringLayout.NORTH, mapsL);
    aL.putConstraint(SpringLayout.WEST, typesL, 0, SpringLayout.WEST, typesScroll);
    aL.putConstraint(SpringLayout.WEST, dataScroll, jListSpacing, SpringLayout.EAST, typesScroll);
    aL.putConstraint(SpringLayout.NORTH, dataScroll, 0, SpringLayout.NORTH, typesScroll);
    aL.putConstraint(SpringLayout.WEST, dataL, 0, SpringLayout.WEST, dataScroll);
    aL.putConstraint(SpringLayout.NORTH, dataL, 0, SpringLayout.NORTH, mapsL);
    aL.putConstraint(SpringLayout.EAST, selectAll, 0, SpringLayout.EAST, dataScroll);
    aL.putConstraint(SpringLayout.NORTH, selectAll, 0, SpringLayout.SOUTH, dataScroll);
    aL.putConstraint(SpringLayout.EAST, aComp, 5, SpringLayout.EAST, selectAll);
    aL.putConstraint(SpringLayout.SOUTH, aComp, 5, SpringLayout.SOUTH, selectAll);
       
    // Add components to 'Annotation Selection' panel
    aComp.add(mapsL);
    aComp.add(dataScroll);
    aComp.add(mapsScroll);
    aComp.add(typesScroll);
    aComp.add(typesL);
    aComp.add(dataL);
    aComp.add(selectAll);
    aComp.setBorder( BorderFactory.createTitledBorder("Annotation Selection:") );
  
    // Finalize 'Annotation Selection' panel
    annotSelBorder.add(Box.createRigidArea(new Dimension(0, 10)));
    annotSelBorder.add(aComp);
    
    // Construct Panel and Layout for 'Preview' portion
    JPanel previewBorder = new JPanel();
    previewBorder.setBorder(paneEdge);
    previewBorder.setLayout(new BoxLayout(previewBorder, BoxLayout.Y_AXIS));
    
    SpringLayout pL = new SpringLayout();
    JPanel pComp = new JPanel(pL, false);
    
    // Set up layout of 'Preview' portion
    pL.putConstraint(SpringLayout.EAST, browse, -5, SpringLayout.EAST, pComp);
    pL.putConstraint(SpringLayout.SOUTH, tableScroll, 95, SpringLayout.NORTH, tableScroll);
    pL.putConstraint(SpringLayout.WEST, numAnnotationsL, 5, SpringLayout.WEST, pComp);
    pL.putConstraint(SpringLayout.NORTH, numAnnotationsL, 5, SpringLayout.NORTH, pComp);
    pL.putConstraint(SpringLayout.NORTH, tableScroll, 2, SpringLayout.SOUTH, numAnnotationsL);
    pL.putConstraint(SpringLayout.WEST, tableScroll, 0, SpringLayout.WEST, numAnnotationsL);
    pL.putConstraint(SpringLayout.WEST, fileL, 0, SpringLayout.WEST, tableScroll);
    pL.putConstraint(SpringLayout.NORTH, fileL, 4, SpringLayout.SOUTH, tableScroll);
    pL.putConstraint(SpringLayout.NORTH, file, 2, SpringLayout.SOUTH, fileL);
    pL.putConstraint(SpringLayout.NORTH, browse, 0, SpringLayout.NORTH, file);
    pL.putConstraint(SpringLayout.EAST, file, -1, SpringLayout.WEST, browse);
    pL.putConstraint(SpringLayout.WEST, file, 0, SpringLayout.WEST, fileL);
    pL.putConstraint(SpringLayout.EAST, save, -5, SpringLayout.EAST, pComp);
    pL.putConstraint(SpringLayout.NORTH, save, 5, SpringLayout.SOUTH, browse);
    pL.putConstraint(SpringLayout.EAST, pComp, 5, SpringLayout.EAST, tableScroll);
    pL.putConstraint(SpringLayout.SOUTH, pComp, 5, SpringLayout.SOUTH, save);
    pL.putConstraint(SpringLayout.EAST, cancel, -7, SpringLayout.WEST, save);
    pL.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, save);
    
    // Add components to 'Preview' panel
    pComp.add(numAnnotationsL);
    pComp.add(tableScroll);
    pComp.add(fileL);
    pComp.add(file);
    pComp.add(save);
    pComp.add(browse);
    pComp.add(cancel);
    pComp.setBorder( BorderFactory.createTitledBorder("Preview:") );
    
    // Finalize 'Preview' panel
    previewBorder.add(Box.createRigidArea(new Dimension(0, 10)));
    previewBorder.add(pComp);
    
    // Set layout constraints for 'main' panel
    s.putConstraint(SpringLayout.EAST, previewBorder, 0, SpringLayout.EAST, annotSelBorder);
    s.putConstraint(SpringLayout.WEST, annotSelBorder, 5, SpringLayout.WEST, main);
    s.putConstraint(SpringLayout.NORTH, annotSelBorder, 0, SpringLayout.NORTH, main);
    s.putConstraint(SpringLayout.WEST, previewBorder, 0, SpringLayout.WEST, annotSelBorder);
    s.putConstraint(SpringLayout.NORTH, previewBorder, 0, SpringLayout.SOUTH, annotSelBorder);
    s.putConstraint(SpringLayout.SOUTH, main, 5, SpringLayout.SOUTH, previewBorder);
    s.putConstraint(SpringLayout.EAST, main, 5, SpringLayout.EAST, annotSelBorder);
    
    // Add panels and buttons to 'main' panel
    main.add(annotSelBorder);
    main.add(previewBorder);
    setContentPane(main);

    // Final setup for 'main' panel
    setTitle("Download");
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    pack();
  }

  public static void showLoadDialog(JFrame parent)
  {
    if (instance == null) instance = new DownloadDialog(parent);

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
    if (ae.getActionCommand().equals("Save"))
    {
      // check to see if file & directory are chosen
      if( file.getText().compareTo("") == 0 )
      { 
        System.out.println("Not file/directory selected");
        JOptionPane.showMessageDialog(DownloadDialog.this,
            "Please select a valid file and directory",
            "No file/directory selected",
            JOptionPane.WARNING_MESSAGE);
      }
      // close window
      setVisible(false);
    } 
    else if (ae.getActionCommand().equals("Cancel"))
    {
      // close window
      setVisible(false);
    }
    else if (ae.getActionCommand().equals("select all"))
    {
      // select all
      int upperBound = data.getModel().getSize()-1;
      if (upperBound >= 0 ) data.setSelectionInterval(0, upperBound);
    }
    else if (ae.getActionCommand().equals("Browse..."))
    {
      int returnVal = fileChooser.showOpenDialog(DownloadDialog.this);

      if (returnVal == JFileChooser.APPROVE_OPTION) {
          File chosenFile = fileChooser.getSelectedFile();
          file.setText(chosenFile.getAbsolutePath());
      }
    }
  }

  public void valueChanged(ListSelectionEvent e) 
  {
    if (e.getSource() == maps)
    {  
      types.setEnabled(true);
    }
    if (e.getSource() == data) 
    {
      save.setEnabled(true);
    }
    if (e.getSource() == types)
    {  
      data.setEnabled(true);
      selectAll.setEnabled(true);    
    }

    if (e.getValueIsAdjusting() == false && e.getSource() == maps) 
    {
      if (maps.getSelectedIndex() == -1) 
      {
        //No selection
        System.out.println("-1");
      } 
      else if (maps.getSelectedIndices().length > 1) 
      {
        //Multiple selection
        System.out.println(">1");
      } 
      else 
      {
        //Single selection
        System.out.println("1");
      }
    }
  }
}
