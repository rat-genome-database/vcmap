<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>FAQ - VCMap hosted at AnimalGenome.org</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <link rel="stylesheet" type="text/css" href="vcmap.css">
  <!--[if lt IE 8]>
    <style>
      h1.typeface-js
      {
        top: 10px ;
      }
    </style>
  <![endif]-->
  <script src="lib/typeface-0.11.js" type="text/javascript"></script>
  <script src="lib/helvetica_neue_light_font/helvetica_neue_light.typeface.js" type="text/javascript"></script>
  <script type="text/javascript">

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-17251707-2']);
    _gaq.push(['_trackPageview']);

    (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();

  </script>
</head>

<body>
<div id="wrapper">
  <div style="float: left ; margin-left: -1px ; margin-top: -2px ;">
    <a class="none" href="index.php"><img src="images/vcmap_logo_v2.jpg" style="width: 298px ; height: 282px ;" alt="VCMap"></a>
  </div>
  <!--div style="float: left ;">
  <h2 class="typeface-js">provided by</h2>
    <div style="position: relative ; top: 40px ; left: 35px ;">
      <a class="none" href="http://bioneos.com/"><img src="images/bioneos_logo.png" style="width: 258px ; height: 61px ;" alt="Bio::Neos, Inc."></a>
    </div>
  </div-->
  <p style="padding-top:170px;"></p>

  <p class="description" style="clear: both ; margin-top: 15px ;">
    With the variety of tasks you can perform with VCMap, it is no suprise there are
    some questions that you might have. Below are some of the questions about VCMap
    that are frequently asked. If you do not see your question answered below, be sure
    to leave us <a href="feedback.php">feedback</a>.
  </p>
  <h1 class="typeface-js">FAQ</h1>
  <a name="top"></a>
  <div class="line"></div>
    <ol>
      <li><a href="#q1">How do I load a map?</a>
      <li><a href="#q2">What is a backbone?</a></li>
      <li><a href="#q3">What does it mean to &quot;swap&quot; a backbone?</a></li>
      <li><a href="#q4">What kinds of maps are available to load</a></li>
      <li><a href="#q5">Why is annotation being grouped the way it is?</a></li>
      <li><a href="#q6">How do I find out more information about a certain annotation?</a></li>
      <li><a href="#q7">How do I get to the source webpage for a feature?</a></li>
      <li><a href="#q8">How do I search for a specific feature?</a></li>
      <li><a href="#q9">How do I load additional annotation?</a></li>
      <li><a href="#q10">How do I load custom annotation from a file?</a></li>
      <li><a href="#q11">What file types does VCMap support?</a></li>
      <li><a href="#q12">How do I download the annotation information to a file?</a></li>
    </ol>
  <div class="line"></div>
  <ol>
    <li>
      <div class="question">
        <a name="q1">How do I load a map?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          To load a map in VCMap:
        </p>
        <ol>
          <li>From the &quot;Map&quot; menu, select &quot;Load...&quot;</li>
          <li>Specify a species, type of map, and release of the map from the drop-down menus</li>
          <li>
            If you would like to load a backbone map, select the checkbox
            <p style="margin-top: 0.25em ;"><em>Note, this will clear all previously loaded data and load a single map as a backbone</em></p>
          </li>
          <li>If you are loading this map as a backbone map, specify a chromosome</li>
        </ol>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q2">What is a backbone?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          A backbone map is the primary map that will serve as the anchor off of which all
          comparative maps loaded will locate their sequence.  For the backbone map, you
          must specify a single chromosome to be loaded at a time.  When other comparative
          maps are loaded on top of that backbone, they will load all chromosomes that
          have syntenic regions that fall on the single chromosome of the backbone map,
          usually from more than one chromosome.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q3">What does it mean to &quot;swap&quot; a backbone?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          When you load multiple maps from different species, all of the
          off-backbone maps are anchored relative to the single chromosome from
          the backbone map, often resulting in multiple chromosomes appearing
          for each off-backbone species.  The &quot;Swap Backbone&quot; feature
          of VCMap allows you to view the currently loaded maps from the
          opposite angle.  That is, when you swap backbones, you can choose
          a single chromosome from an off-backbone map to become the new
          backbone.  All of the currently loaded maps will still be loaded.
          However, these maps will now be anchored to a new, different 
          backbone and therefore, different homologous regions from different
          chromosomes may be loaded as well.  All of the maps will then change
          so that they are anchored to the new backbone map you have chosen.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q4">What kinds of maps are available to load?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          The loadable maps within VCMap have been gathered from multiple
          locations and have all been compiled by NCBI. You are able to load
          genomic, genetic or radiation hybrid maps. All comparitive maps are
          based on the UCSC synteny for genomic maps.
        </p>
        <p>
          In the current version of VCMap, if you wish to load genetic or 
          radiation hybrid comparative map, the genomic version of that map 
          must be loaded before the genetic or radiation hybrid comparative map.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q5">Why is annotation being grouped the way it is?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          Because of the large size of the datasets related to genomic data,
          it is often difficult to visualize all data at once.  Even though
          VCMap only loads a single chromosome at a time, in most cases, it
          is still impossible to display all of the available features for
          that chromosome at once.  In order to handle this situation, the
          software groups pieces of nearby annotation together and opens a
          window with an expanded view of the annotation group.
        </p>
        <p>
          The grouping process is largely related to the proximity of annotation,
          with a few exceptions.  Additionally, overlapping annotation will 
          generally be separated into columns.  With large overlapping pieces
          of annotation, for example QTL, the annotation may be placed into
          groups if more than three features overlap in the same area of the
          map.  The popup window for these groups may still condense the
          annotation horizontally in order to avoid large popups that would
          require horizontal scrolling.  Simply mouse over the names of the
          annotation to see a highlighted view of that feature.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q6">How do I find out more about a certain annotation?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          To help you view more information about annotation, VCMap has a
          &quot;Details&quot; dialog that shows additional information about annotation.
          There are two easy ways to display the &quot;Details&quot; dialog. 
        </p>
        <ol>
          <li>
            If you have already selected one or more annotation, you can view more information
            for that annotation in a &quot;Details&quot; dialog by clicking the &quot;Details&quot;
            button on the top right of the VCMap window.
          </li>
          <li>
            You can also double-click any piece of annotation to display information about that 
            annotation in the &quot;Details&quot; dialog.
          </li>
        </ol>
        <p>
          To view even more information about the annotation displayed in the 
          &quot;Details&quot; dialog, you can click on the &quot;Source Link&quot; 
          or &quot;Homologene Link&quot; in the &quot;Details&quot; dialog to 
          view a web page with more information in your default web browser.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q7">How do I get to the source webpage for a feature?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          First open up the <a href="#q6">&quot;Details Dialog&quot;</a> for that feature.
          In that dialog box, there will be one or more hyperlinks (underlined and in blue) 
          that will open a browser with information about the selected feature provided 
          by the source from which this feature was gathered.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q8">How do I search for a specific feature?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          From the &quot;Search&quot; menu, select &quot;Find...&quot;. 
          A dialog box will appear that
          allows you to search annotation by name or by location.
        </p>
        <ul>
          <li>
            To search by name, click the &quot;Search by Name&quot; tab, enter 
            the whole name or a partial name of the annotation (no wildcards 
            necessary), and click the &quot;Search&quot; button.
          </li>
          <li>
            To search by location, click the &quot;Search by Location&quot; tab,
            enter the start position (no label required), enter the stop 
            position (no label required), select the map you would like to
            search and click the &quot;Search&quot; button.
          </li>
        </ul>
        <p>
          After clicking the &quot;Search&quot; button, VCMap will begin
          searching the currently loaded maps and the data from its database.
          The number of results found for your search parameters will be
          displayed after the search is completed. Searching the VCMap database
          can take some time, so you will see a graphical indicator while this
          search is in progress.  If you see the message
          &quot;Invalid Search&quot; this means you entered an invalid search
          character or have not selected a map to search.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q9">How do I load additional annotation?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          From the &quot;Annotation&quot; menu, select the &quot;Load Annotation...&quot;
          menu item.  The dialog box that appears will allow you to select:
        </p>
        <ol>
          <li>The type of annotation</li>
          <li>Which maps to load the annotation for</li>
          <li>Any ontology terms to use to filter what is loaded</li>
        </ol>
        <p>
          The types of annotation are limited to what have been loaded into the 
          VCMap database, and will likely be expanded in future versions of the 
          software.
        </p>
        <p>
          The ontology terms are defined jointly by ISU and MCW, and are not 
          available for all types of annotation.  Ontology terms are defined 
          in a tree, so after selecting a top-level term, the drop-down box will 
          then be populated with the second-level terms and the selected term
          will appear at the bottom of the dialog box.  If you select a term in error,
          simply click on a higher level term to go back to that level, or click on
          &quot;All Data&quot; to go back to the beginning.  After selecting what to
          load, simply click the &quot;Load&quot; button.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q10">How do I load custom annotation from a file?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          From the &quot;Annotation&quot; menu, select the &quot;Import from File...&quot;
          menu item.  The &quot;Import Data&quot; dialog box will appear. Select:
        </p>
        <ol>
          <li>
            The file containing the annotation to import
            <p>
              To specify the file, press the &quot;Browse&quot; button or click in the &quot;Path&quot; textfield.
              A file chooser will open that will allow you to locate the file containing the custom annotation. 
              If you do not see your data file, ensure that the file type is selected by changing the 
              &quot;Files of Type&quot; drop-down menu.
            </p>
          </li>
          <li>
            The map to load the annotation to
            <p>
              VCMap will attempt to associate files with a loaded map. If it is successful it will 
              display the map below the textfield in a drop-down menu. If VCMap is unable to associate 
              the data with one of the loaded maps, the drop-down menu will be populated with all 
              the loaded maps and you must choose the map you wish to associate the data from the file with. 
            </p>
          </li>
        </ol>
        <p>
          After selecting the data file and the map to load the annotation to, click the &quot;Load&quot; button 
          to start loading annotation.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q11">What file types does VCMap support?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          VCMap currently supports the following formats:
          <ul>
            <li>GFF/GFF3</li>
            <li>BED</li>
            <li>SAM/BAM</li>
          </ul>
        </p>
        <p>
          For a description of these formats please visit the
          <a href="supported-files.php">Supported File Types</a> page.
        </p>
      </div>
    </li>
    <li>
      <div class="question">
        <a name="q12">How do I download the annotation information to a file?</a> <a class="top" href="#top">Top</a>
      </div>
      <div class="answer">
        <p>
          From the &quot;File&quot; menu, select &quot;Download...&quot; A dialog box will appear
          that will allow you to choose what annotation information to download to
          a file.
        </p>
        <p>
          The dialog is broken into four basic sections that help you
          choose the annotation information you want.
        </p>
        <ol>
          <li>
            The &quot;Interval Info&quot; section shows you what intervals you have 
            selected in the VCMap window. You can select all or individual intervals 
            to include in your download.
          </li>
          <li>
            The &quot;Annotation Selection&quot; section shows what types of annotation 
            are within the intervals you have selected. You can select all or individual types
            of annotation to include in your download. 
          </li>
          <li>
            The &quot;Show/Hide Data&quot; section allows you to choose what annotation 
            information to download. You can select data items and use the arrows to 
            move them back and forth between the two lists. 
          </li>
          <li>
            The &quot;Preview&quot; section gives you a preview of what the
            annotation information will look like when you download and the number
            of annotation that will downloaded. You can rearrange columns by
            clicking and dragging the column headers to their desired location.
          </li>
        </ol>
        <p>
          After choosing what annotation information you would like to download,
          click the &quot;Open&quot; button to download the annotation information. A
          temporary comma separated values (.csv) file will be created and opened
          in your default speadsheet application.
        </p>
      </div>
    </li>
  </ol>
  <div class="backhome">    
    <a href='index.php'>Back to VCMap Home</a>
  </div>
</div>

<div id="bottomnav">
  <ul>
    <li><a href="http://animalgenome.org/" id="current"><span>animalgenome.org</span></a></li>
    <li><a href="mailto:vcmap@animalgenome.org?Subject=help"><span>Contact</span></a></li>
    <li><a href="http://bioneos.com/"><span>Developers</span></a></li>
    <li><span>Copyright &copy; <?= date("Y"); ?></span></li>
  </ul>
</div>

</body>
</html>
