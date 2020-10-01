import java.util.* ;
import java.io.* ;

public class FileMapReader
{
  private File map ;
  private Vector<Feature> features = null ;

  public FileMapReader(String fileName)
  {
    this(new File(fileName)) ;
  }

  public FileMapReader(File file)
  {
    map = file ;
    features = new Vector<Feature>() ;

    // Open our file & read the fake data
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(file)) ;
      String line = "" ;
      while((line = reader.readLine()) != null)
      {
        String[] specs = line.split(";") ;

        // Something wrong with this fake entry, should be 4 entities
        if(specs.length != 4) continue ;
        Feature feature = new Feature(specs[0]) ;
        for(int i = 1 ; i < specs.length ; i++)
        {
          // There was no marker at this species
          if(specs[i] == "-") continue ;
          String[] marks = specs[i].split(",") ;

          // If not three, something is messed up again with this fake synteny feature
          if(marks.length != 3) continue ;
          Marker marker = new Marker(marks[0], marks[1], marks[2]) ;
          feature.addPosition(marker) ;
        }

        features.add(feature) ;
      }
      
      reader.close() ;
      reader = null ;
    }
    catch (FileNotFoundException fnfe)
    {
      System.out.println("The file "+file+" could not be found, please ensure the path is correct: "+fnfe) ;
    }
    catch (IOException io)
    {
      System.out.println("This file could not be read: "+io) ;
    }
  }

  public Vector<Feature> getFeatures()
  {
    return features ;
  }
}
