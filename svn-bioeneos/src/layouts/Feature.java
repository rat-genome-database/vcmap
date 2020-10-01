import java.util.* ;

public class Feature
{
  private String name = "";
  private Vector<Marker> positions = null;

  public Feature(String name)
  {
    this.name = name;
    positions = new Vector<Marker>();
  }

  public void addPosition(Marker m)
  {
    positions.add(m);
  }

  public String getName()
  {
    return name;
  }

  public Vector<Marker> getPositions()
  {
    return positions;
  }
}
