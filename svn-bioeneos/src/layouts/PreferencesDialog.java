import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.JColorChooser;

public class PreferencesDialog extends JDialog implements ActionListener, ItemListener
{
  // Singleton design pattern
  private static PreferencesDialog instance = null;

  // GUI Components
  private JComboBox mrkrDisplayType;
  private JComboBox showUnitsType;
  private JComboBox selectMrkrType;
  private JComboBox mrkrShownType;
  private JComboBox priorityType;
  private JCheckBox adjConnections;
  private JCheckBox nonAdjConnections;
  private JCheckBox elementConnections;
  private JButton   currentColor;
  private JButton   apply;
  private JButton   restore;
  
  // Strings
  private String[] displayTypeStrings = 
  {
    "Accession",
    "Gene Name"
  };
  
  private String[] selectMrkrTypeStrings = 
  {
    "Unknown",
    "Flanking",
    "Gene"
  };
  
  private String[] yesNoStrings =
  {
    "Yes",
    "No"
  };
  
  private String[] priorityStrings =
  {
    "1",
    "2",
    "3",
    "4"
  };
  
  //Integer Variables
  private int borderWidth; //set after align border is created

  private PreferencesDialog(JFrame parent)
  {
    super(parent, true);
   
    // Component setup
    mrkrDisplayType = new JComboBox(displayTypeStrings);
    showUnitsType = new JComboBox(yesNoStrings);
    selectMrkrType = new JComboBox(selectMrkrTypeStrings);
    selectMrkrType.addActionListener(this);
    selectMrkrType.setActionCommand("selectMrkrType");
    priorityType = new JComboBox(priorityStrings);
    mrkrShownType = new JComboBox(yesNoStrings);

    JLabel mrkrDisplayTypeL = new JLabel("Marker Display Type:");
    JLabel showUnitsTypeL = new JLabel("Show units:");
    JLabel selectMrkrTypeL = new JLabel("Select Marker Type:");
    JLabel mrkrShownTypeL = new JLabel("Shown:");
    JLabel currentColorL = new JLabel("Current Color:");
    JLabel priorityTypeL = new JLabel("Priority:");

    adjConnections = new JCheckBox("Show connections between adjacent maps");
    nonAdjConnections = new JCheckBox("Show connections between non-adjacent maps");
    elementConnections = new JCheckBox("Show connections between visible elements only");
    
    currentColor = new JButton("color");
    currentColor.setBackground(new java.awt.Color(100, 200, 50));
    currentColor.setForeground(new java.awt.Color(100, 200, 50));
    currentColor.addActionListener(this);
    currentColor.setEnabled(true);
    
    restore = new JButton("Restore Defaults");
    restore.addActionListener(this);
    restore.setEnabled(true);
    
    apply = new JButton("Apply");
    apply.addActionListener(this);
    apply.setEnabled(true);

    /*
     * TODO
     * - of course make everything else functional
     */

    // Component Layout
    // Main panel is the final viewed panel
    SpringLayout s = new SpringLayout();
    JPanel main = new JPanel(s);
    
    // Sets edges for all borders
    Border paneEdge = BorderFactory.createEmptyBorder(0,0,0,0);
    
    // Construct Panel and Layout for Align portion
    JPanel alignBorder = new JPanel();
    alignBorder.setBorder(paneEdge);
    alignBorder.setLayout(new BoxLayout(alignBorder, BoxLayout.Y_AXIS));
    
    SpringLayout aL = new SpringLayout();
    JPanel aComp = new JPanel(aL, false);
    
    // Set up layout of 'align' portion
    aL.putConstraint(SpringLayout.WEST, adjConnections, 5, SpringLayout.WEST, aComp);
    aL.putConstraint(SpringLayout.NORTH, adjConnections, 5, SpringLayout.NORTH, aComp);
    aL.putConstraint(SpringLayout.WEST, nonAdjConnections, 0, SpringLayout.WEST, adjConnections);
    aL.putConstraint(SpringLayout.NORTH, nonAdjConnections, 2, SpringLayout.SOUTH, adjConnections);
    aL.putConstraint(SpringLayout.WEST, elementConnections, 0, SpringLayout.WEST, nonAdjConnections);
    aL.putConstraint(SpringLayout.NORTH, elementConnections, 2, SpringLayout.SOUTH, nonAdjConnections);
    aL.putConstraint(SpringLayout.EAST, aComp, 5, SpringLayout.EAST, elementConnections);
    aL.putConstraint(SpringLayout.SOUTH, aComp, 5, SpringLayout.SOUTH, elementConnections);
    
    // Add components
    aComp.add(adjConnections);
    aComp.add(nonAdjConnections);
    aComp.add(elementConnections);
    aComp.setBorder( BorderFactory.createTitledBorder("Align:") );
    
    // Finalize Align panel
    alignBorder.add(Box.createRigidArea(new Dimension(0, 10)));
    alignBorder.add(aComp);
    
    // Set border width variable to acheive same size in all panels added to main
    borderWidth = aComp.getPreferredSize().width-10; //10 pixels are removed for spacing and borders
    
    //Construct Panel and Layout for Display portion
    JPanel displayBorder = new JPanel();
    displayBorder.setBorder(paneEdge);
    displayBorder.setLayout(new BoxLayout(displayBorder, BoxLayout.Y_AXIS));
   
    SpringLayout dL = new SpringLayout();
    JPanel dComp = new JPanel(dL, false);
    
    //set up layout of 'Display' portion
    dL.putConstraint(SpringLayout.WEST, mrkrDisplayTypeL, 5, SpringLayout.WEST, dComp);
    dL.putConstraint(SpringLayout.NORTH, mrkrDisplayType, 5, SpringLayout.NORTH, dComp);
    dL.putConstraint(SpringLayout.EAST, mrkrDisplayType, -5, SpringLayout.EAST, dComp);
    dL.putConstraint(SpringLayout.NORTH, mrkrDisplayTypeL, 0, SpringLayout.NORTH, mrkrDisplayType);
    dL.putConstraint(SpringLayout.NORTH, showUnitsType, 2, SpringLayout.SOUTH, mrkrDisplayType);
    dL.putConstraint(SpringLayout.EAST, showUnitsType, 0, SpringLayout.EAST, mrkrDisplayType);
    dL.putConstraint(SpringLayout.WEST, showUnitsType, 0, SpringLayout.WEST, mrkrDisplayType);
    dL.putConstraint(SpringLayout.WEST, showUnitsTypeL, 0, SpringLayout.WEST, mrkrDisplayTypeL);
    dL.putConstraint(SpringLayout.NORTH, showUnitsTypeL, 0, SpringLayout.NORTH, showUnitsType);
    dL.putConstraint(SpringLayout.SOUTH, dComp, 5, SpringLayout.SOUTH, showUnitsType);
    dL.putConstraint(SpringLayout.EAST, dComp, borderWidth, SpringLayout.WEST, dComp);

    // Add components
    dComp.add(mrkrDisplayTypeL);
    dComp.add(mrkrDisplayType);
    dComp.add(showUnitsTypeL);
    dComp.add(showUnitsType);
    dComp.setBorder( BorderFactory.createTitledBorder("General Display") );

    // Finalize 'Display' panel
    displayBorder.add(Box.createRigidArea(new Dimension(0, 10)));
    displayBorder.add(dComp);
 
    // Construct Panel and Layout for Display portion
    JPanel markerBorder = new JPanel();
    markerBorder.setBorder(paneEdge);
    markerBorder.setLayout(new BoxLayout(markerBorder, BoxLayout.Y_AXIS));
    
    SpringLayout mL = new SpringLayout();
    JPanel mComp = new JPanel(mL, false);
    
    // set up layout of marker visibility portion
    mL.putConstraint(SpringLayout.WEST, selectMrkrTypeL, 5, SpringLayout.WEST, mComp);
    mL.putConstraint(SpringLayout.NORTH, selectMrkrType, 5, SpringLayout.NORTH, mComp);
    mL.putConstraint(SpringLayout.NORTH, selectMrkrTypeL, 0, SpringLayout.NORTH, selectMrkrType);
    mL.putConstraint(SpringLayout.EAST, selectMrkrType, -5, SpringLayout.EAST, mComp);
    mL.putConstraint(SpringLayout.EAST, mrkrShownType, 0, SpringLayout.EAST, selectMrkrType);
    mL.putConstraint(SpringLayout.WEST, mrkrShownType, 0, SpringLayout.WEST, selectMrkrType);
    mL.putConstraint(SpringLayout.NORTH, mrkrShownType, 2, SpringLayout.SOUTH, selectMrkrType);
    mL.putConstraint(SpringLayout.NORTH, mrkrShownTypeL, 0, SpringLayout.NORTH, mrkrShownType);
    mL.putConstraint(SpringLayout.WEST, mrkrShownTypeL, 0, SpringLayout.WEST, selectMrkrTypeL);
    mL.putConstraint(SpringLayout.NORTH, currentColor, 2, SpringLayout.SOUTH, mrkrShownType);
    mL.putConstraint(SpringLayout.EAST, currentColor, 0, SpringLayout.EAST, selectMrkrType);
    mL.putConstraint(SpringLayout.NORTH, currentColorL, 0, SpringLayout.NORTH, currentColor);
    mL.putConstraint(SpringLayout.WEST, currentColorL, 0, SpringLayout.WEST, selectMrkrTypeL);
    mL.putConstraint(SpringLayout.NORTH, priorityType, 2, SpringLayout.SOUTH, currentColor);
    mL.putConstraint(SpringLayout.EAST, priorityType, 0, SpringLayout.EAST, selectMrkrType);
    mL.putConstraint(SpringLayout.NORTH, priorityTypeL, 2, SpringLayout.NORTH, priorityType);
    mL.putConstraint(SpringLayout.WEST, priorityTypeL, 2, SpringLayout.NORTH, selectMrkrTypeL);
    mL.putConstraint(SpringLayout.SOUTH, mComp, 5, SpringLayout.SOUTH, priorityType);
    mL.putConstraint(SpringLayout.EAST, mComp, borderWidth, SpringLayout.WEST, mComp);
    
    // Add components
    mComp.add(selectMrkrTypeL);
    mComp.add(selectMrkrType);
    mComp.add(mrkrShownType);
    mComp.add(mrkrShownTypeL);
    mComp.add(currentColor);
    mComp.add(currentColorL);
    mComp.add(priorityTypeL);
    mComp.add(priorityType);
    mComp.setBorder(BorderFactory.createTitledBorder("Marker Visibility:"));
    
    // Finalize Marker Visibility panel
    markerBorder.add(Box.createRigidArea(new Dimension(0, 10)));
    markerBorder.add(mComp);
    
    // Set layout constraints for main panel
    s.putConstraint(SpringLayout.NORTH, displayBorder, 5, SpringLayout.NORTH, main);
    s.putConstraint(SpringLayout.WEST, displayBorder, 5, SpringLayout.WEST, main);
    s.putConstraint(SpringLayout.NORTH, markerBorder, 2, SpringLayout.SOUTH, displayBorder);
    s.putConstraint(SpringLayout.WEST, markerBorder, 0, SpringLayout.WEST, displayBorder);
    s.putConstraint(SpringLayout.NORTH, alignBorder, 2, SpringLayout.SOUTH, markerBorder);
    s.putConstraint(SpringLayout.WEST, alignBorder, 5, SpringLayout.WEST, main);
    
    s.putConstraint(SpringLayout.EAST, main, 5, SpringLayout.EAST, alignBorder);
    s.putConstraint(SpringLayout.NORTH, apply, 5, SpringLayout.SOUTH, alignBorder);
    s.putConstraint(SpringLayout.EAST, apply, -7, SpringLayout.EAST, main);
    s.putConstraint(SpringLayout.SOUTH, main, 5, SpringLayout.SOUTH, apply);
    s.putConstraint(SpringLayout.NORTH, restore, 0, SpringLayout.NORTH, apply);
    s.putConstraint(SpringLayout.EAST, restore, -5, SpringLayout.WEST, apply);
    
    // Add panels and buttons to main panel
    main.add(displayBorder);
    main.add(markerBorder);
    main.add(alignBorder);
    main.add(apply);
    main.add(restore);
    setContentPane(main);

    // Final setup
    setTitle("Preferences");
    setResizable(false);
    setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    pack();
  }

  public static void showLoadDialog(JFrame parent)
  {
    if (instance == null) instance = new PreferencesDialog(parent);

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
    if (ae.getActionCommand().equals("Apply"))
    {
      // apply the current changes made by the user  
      // close window
      setVisible(false);
    } 
    else if (ae.getActionCommand().equals("Restore Defaults"))
    {
      // restore all the defaults for the program
    }
    else if (ae.getActionCommand().equals("color"))
    {
      // get current color to display in color chooser dialog
      int ccIndex = selectMrkrType.getSelectedIndex();
      Object cc = selectMrkrType.getItemAt(ccIndex);
      Color newColor = JColorChooser.showDialog(
          PreferencesDialog.this,
          "Choose " +  cc + " Marker Color",
          Color.black);
      if (newColor != null) 
      {
        currentColor.setBackground(newColor);
        currentColor.setForeground(newColor);
      }
    }
  }

  public void itemStateChanged(ItemEvent ie)
  {
    // used when selectMrkrType is chosen to change the "sub" combo boxes 
    
  }
}
