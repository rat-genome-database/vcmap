import java.util.* ;

public class Marker
{
  private String species = "";
  private String chromosome = "";
  private String position = "";

  public Marker(String spc, String chrom, String pos)
  {
    species = spc;
    chromosome = chrom;
    position = pos;
  }

  public String getSpecies()
  {
    return species;
  }

  public String getChromosome()
  {
    return chromosome;
  }

  public String getPosition()
  {
    return position;
  }
}
