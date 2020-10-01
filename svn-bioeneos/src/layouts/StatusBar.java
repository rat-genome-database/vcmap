import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class StatusBar extends JPanel
{
  private JFrame parent;
  private JLabel status;
  private JLabel extended;

  public StatusBar(JFrame frame)
  {
    parent = frame;

    // Component setup
    status = new JLabel("3 elements");
    status.setFont(new Font("default", Font.ITALIC, 12));
    status.setCursor(new Cursor(Cursor.HAND_CURSOR));
    extended = new JLabel("<html>PSMB8 (position: 42946930 bp)<br>" + 
        "CLPS (position: 35870737 bp)<br>TAPBP (position: 33375451 bp)</html>");
    extended.setOpaque(true);
    extended.setBackground(Color.WHITE);
    extended.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));
    parent.getGlassPane().addMouseListener(new MouseAdapter()
        {
          public void mouseReleased(MouseEvent me)
          {
            extended.setVisible(false);
            parent.getGlassPane().setVisible(false);
          }
        });

    // Layout
    BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
    setLayout(box);
    JLabel select = new JLabel("Selected:");
    select.setFont(new Font("default", Font.PLAIN, 10));
    add(select);
    add(Box.createHorizontalStrut(5));
    add(status);
    add(Box.createHorizontalGlue());
    add(new JButton("Hide"));
    parent.getLayeredPane().add(extended, JLayeredPane.POPUP_LAYER);
    setBorder(new javax.swing.border.EmptyBorder(5, 15, 5, 15));

    // Final setup
    status.addMouseListener(new MouseAdapter()
        {
          public void mouseEntered(MouseEvent me)
          {
            status.setFont(new Font("default", Font.BOLD, 12));
          }
          public void mouseExited(MouseEvent me)
          {
            status.setFont(new Font("default", Font.ITALIC, 12));
          }
          public void mouseClicked(MouseEvent me)
          {
            extended.setVisible(true);
            int x = getX() + status.getX() + parent.getContentPane().getX();
            int y = getY() + status.getY() + parent.getContentPane().getY();
            extended.setBounds(x, y, 200, 50);
            parent.getGlassPane().setVisible(true);
          }
        });
  }
}
