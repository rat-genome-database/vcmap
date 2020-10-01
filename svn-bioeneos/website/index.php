<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>VCMap hosted at AnimalGenome.org</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="vcmap.css">
  <!--[if lt IE 8]>
    <style>
      h1.typeface-js
      {
        top: 10px ;
      }
    </style>
  <![endif]-->
  <script src="lib/typeface-0.14.js" type="text/javascript"></script>
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
    <img src="images/vcmap_logo_v2.jpg" style="width: 298px ; height: 282px ;" alt="VCMap">
  </div>
  <!--div style="float: left ;">
    <h2 class="typeface-js">provided by</h2>
    <div style="position: relative ; top: 40px ; left: 35px ;">
      <a class="none" href="http://bioneos.com/"><img src="images/bioneos_logo.png" style="width: 258px ; height: 61px ;" alt="Bio::Neos, Inc."></a>
    </div>
  </div -->
  <p style="padding-top:170px;"></p>

  <p class="description" style="clear: both ; margin-top: 15px ;">
    The Virtual Comparative Map (VCMap) tool was originally developed by 
    <a href='http://www.int-med.uiowa.edu/divisions/Cardiology/Directory/AnneKwitek.html'>Dr. Anne Kwitek</a>,
    <a href='http://www.phys.mcw.edu/fac_jacob.htm'>Howard Jacob</a>, and
    <a href='mailto:tone@mcw.edu'>Peter Tonellato</a> at the
    <a href='http://mcw.edu'>Medical College of Wisconsin</a> as part of the
    <a href='http://rgd.mcw.edu'>Rat Genome Database</a>.
    It was designed to explore the conserved synteny between Rat, Mouse and
    Human. In 2008, through a collaboration between
    <a href='http://www.ans.iastate.edu/faculty/index.php?id=jreecy'>Dr. Jim Reecy</a> 
    (<a href='http://iastate.edu'>IA State</a>), 
    <a href='http://www.int-med.uiowa.edu/divisions/Cardiology/Directory/AnneKwitek.html'>Dr. Anne Kwitek</a> 
    (<a href='http://www.uiowa.edu'>University of Iowa</a>),
    <a href="mailto:shimoyama@mcw.edu">Mary Shimoyama</a> (<a href="http://rgd.mcw.edu">Rat Genome Database</a>), and 
    <a href='http://fcd.mcw.edu/?module=faculty&amp;func=view&amp;id=2287'>Dr. Melinda Dwinell</a> 
    (<a href='http://mcw.edu/'>Medical College of Wisconsin</a>) the tool was 
    updated by <a href='http://bioneos.com'>Bio::Neos</a>. Genomes and
    annotations of additional species (Chicken, Cow, and Pig) were added to the
    database of information accessible to VCMap.  This project is funded by
    USDA grant <em>2007-04187</em>.
  </p>

  <div style="margin: 25px 0; width:100%; text-align: center; height: 86px ; margin-top: 20px ;">
    <a id="jnlp-link" href="vcmap.jnlp"><img src="images/pixel-clear.gif" alt="clear"></a>
  </div>

  <h3>News</h3>
  <p class="description" style="margin-top: 15px;">
  <em>July 28, 2009</em><br>We have officially released version 1.0 of VCMap.
  </p>
  <p class="description" style="margin-top: 15px;">
  <em>January 15, 2011</em><br>We have officially released version 2.0 of VCMap.<br>
  <em style="font-size: .95em">If you are experiencing any problems, please try loading the Preferences Dialog (File...Preferences) and clicking the "Restore Defaults" button.</em>
  </p>
  <p class="description" style="margin-top: 15px;">
  <em>December 12th, 2011</em><br>We have officially released version 3.0 of VCMap.
  </p>
  
  <h1 class="typeface-js">VCMap Support</h1>
  <div class="line"></div>
  <div class="nav">
    <ul>
      <li>Visit the <a href="faq.php">FAQ</a> for answers to frequently asked questions</li>
      <li>View the <a href="stats.php">Statistics</a> for our database</li>
      <li>Send us <a href="feedback.php">feedback</a> about problems or suggestions</li>
    </ul>
  </div>

  <h1 class="typeface-js">Resources</h1>
  <div class="line"></div>
  <div class="nav">
    <ul>
      <li><a href="http://rgd.mcw.edu/">The Rat Genome Database</a> at the <a href="http://mcw.edu/">Medical College of Wisconsin</a></li>
      <li><a href="http://www.animalgenome.org/QTLdb/">Animal QTL Database</a> at <a href="http://iastate.edu/">Iowa State University</a></li>
      <li><a href="http://bioneos.com/">Bio::Neos, Inc.</a> technical developer of the VCMap software</li>
    </ul>
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
