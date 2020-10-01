<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>Release site for Development versions of VCMap</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" type="text/css" href="vcmap-devel.css">
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
    </div >
  </div -->
  <p style="padding-top:170px;"></p>

  <div style="clear: both;">
    <h1 id="development">Development VCMap</h1>
    <p>This webpage is where the development VCMap will be launched.  It will be a snapshot of VCMap as new features are added.
    As the new features are added, they will be listed here and will be able to be tested by launching the application.</p>
    
    <h2 id="launch">This will launch the development version of VCMap</h2>
    If this is not what you would like to do, please click <a href="http://bioneos.com/VCMap">here</a>
    to go to the main VCMap homepage.
  </div>
  <div style="margin: 25px 0; width:100%; text-align: center; height: 86px ; margin-top: 20px ;">
    <a id="jnlp-link" href="vcmap-devel.jnlp"><img src="images/pixel-clear.gif" alt="clear"></a>
  </div>

  <h1 class="typeface-js">VCMap Support</h1>
  <div class="line"></div>
  <div class="nav">
    <ul>
      <li>Visit the <a href="faq.php">FAQ</a> for answers to frequently asked questions</li>
      <li>View the <a href="stats.php?devel=true">Statistics</a> for our database</li>
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
    <li><span>Copyright &copy; <?= date("Y"); ?></span></li>
  </ul>
</div>

</body>
</html>
