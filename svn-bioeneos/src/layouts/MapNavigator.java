import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;

public class MapNavigator extends JPanel
{
  private MainGuiMockup vcmap;
  private Image image = null;

  public MapNavigator(MainGuiMockup m)
  {
    vcmap = m;
    setMinimumSize(new Dimension(864, 780));
    setPreferredSize(new Dimension(864, 780));

    // Pre-Load the placeholder image
    try
    {
      image = new ImageIcon(getClass().getResource("vcmap-ex2.png")).getImage();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    // Safe to assume we are using Java > 1.2
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        RenderingHints.VALUE_FRACTIONALMETRICS_ON);

    // Placeholder image
    g.setColor(Color.BLACK);
    if (image == null)
      g.drawString("MapNavigator", 25, 25);
    else
      g.drawImage(image, 0, 0, this);
  }
}
