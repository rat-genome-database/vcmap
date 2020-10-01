<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>Supported Files - VCMap hosted at AnimalGenome.org</title>
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
  </div -->
  <p style="padding-top:170px;"></p>

  <div style="clear: both;"></div>
  <h1 class="typeface-js">Supported File Types</h1>
  <div class="line"></div>
  <p class="description" style="clear: both ; margin-top: 15px ;">
    VCMap provides support for loading custom user annotation from
    multiple file formats. For more information about loading custom
    annotation please visit our <a href="faq.php">FAQ</a> page or use
    the tutorial included in the VCMap application.</p>
  <p class="description" style="clear: both ; margin-top: 15px ;">
    <a href="http://www.sequenceontology.org/gff3.shtml">GFF3/GFF Format</a><br>
    The <strong>GFF </strong>(General Feature Format) lines are based
    on the GFF standard file format. GFF lines have nine required fields
    that must be tab-separated. Undefined fields are replaced with the "."
    character. Unescaped quotation marks, backslashes and other ad-hoc
    escaping conventions that have been added to the GFF format are
    explicitly forbidden. The  <strong>GFF</strong>3 format addresses
    the most common extensions to GFF, while preserving backward
  compatibility with previous formats.</p>
  <p class="description" style="clear: both ; margin-top: 15px ;">
    <a href="http://genome.ucsc.edu/FAQ/FAQformat#format1">BED Format</a><br>
    The <strong>BED </strong>(Browser Extensible Data) format was
    designed at UCSC for displaying data tracks in the Genome Browser.
    BED format provides a flexible way to define the data lines that
    are displayed in an annotation track. BED lines have three
    required fields and nine additional optional fields. The number
    of fields per line must be consistent throughout any single set
    of data in an annotation track. The order of the optional fields
    is binding: lower-numbered fields must always be populated if
    higher-numbered fields are used.
  </p>
  <p class="description" style="clear: both ; margin-top: 15px ;">
    <a href="http://samtools.sourceforge.net">SAM/BAM Format</a><br>
    The <strong>SAM </strong>(Sequence Alignment Map) format is a compact
    and index-able representation of nucleotide sequence alignments. The
    SAM format consists of one header section and one alignment section.
    The whole header section can be absent, but keeping the header is
    recommended. The <strong>BAM</strong> (Binary Sequence Alignment Map)
    format is the compressed binary version of the SAM format. For a more
    detailed description of the formats please download the
    <a href="http://samtools.sourceforge.net/SAM1.pdf">format specification document</a>.</p>
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
