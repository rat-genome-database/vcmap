<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <title>Database Statistics - VCMap hosted at AnimalGenome.org</title>
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

<?php
  // Check our devel status
  $devel = ($_GET['devel'] !== null);

  // First create the connection to the database
  $vcmap = mysql_connect("localhost", "sgdavis", "goVC*_*");
  if ($devel)
    mysql_select_db("vcmap_devel", $vcmap);
  else
    mysql_select_db("vcmap", $vcmap);

  // Now grab our load date
  $updated = "unknown";
  $result = mysql_query("SELECT MAX(loaded) FROM versions", $vcmap);
  if ($row = mysql_fetch_row($result)) $updated = $row[0];

  // Now to generate the type list
  $types = array();
  $result = mysql_query("SELECT DISTINCT(type) FROM annotation_sets", $vcmap);
  while ($row = mysql_fetch_row($result))
    $types[] = $row[0];

  // And the species list
  $species = array();
  $result = mysql_query("SELECT DISTINCT(species), id FROM maps ORDER BY species", $vcmap);
  while ($row = mysql_fetch_row($result))
    $species[$row[0]][] = $row[1];
?>

  <h1 class="typeface-js" style="margin-top: 100px;">Database Statistics</h1>
  <p class="description" style="clear: both ; margin-top: 15px ;">
    This page displays the current statistics for the VCMap database.  Please take
    note that some of the values here will reflect duplicates for features that are
    associated with multiple maps, for example, an STS marker from a genetic linkage
    map that has also been mapped to the genomic sequence map.
  </p>
  <table>
    <thead>
      <tr>
        <td></td>
        <td colspan="<?= sizeof($types)?>">Last updated: <?= $updated ?></td>
      </tr>
<?php
  // Output the header
  print "<tr class='type'>\n";
  print "<td></td>";
  foreach ($types as $type)
  {
    print "<td>$type</td>";
  }
  print "</tr>\n";
  print "</thead>\n";
  print "<tbody>\n";

  // And now the table body
  $counts = array();
  $even = false;
  foreach ($species as $name => $mapids)
  {
    // First make our counts (not the fastest thing ever)
    $sql = "SELECT s.type, COUNT(a.id) FROM annotation_sets s, annotation a WHERE " .
      "s.map_id IN (" . join($mapids, ",") . ") " .
      "AND s.id=a.annotation_set_id GROUP BY s.type";
    $result = mysql_query($sql, $vcmap);
    while ($row = mysql_fetch_row($result))
      $counts[$name][$row[0]] = $row[1];
    if ($even)
      print ("<tr class='even'>\n");
    else
      print ("<tr>\n");
    print ("<td>$name</td>\n");
    foreach ($types as $type)
    {
      print ("<td>" . $counts[$name][$type] . "</td>\n");
    }
    print ("</tr>\n");
    $even = !$even;
  }

  // Finally totals
  print "<tr class='totals'>\n";
  print "<td>Totals</td>\n";
  foreach ($types as $type)
  {
    $total = 0;
    foreach ($species as $name => $val)
      $total += $counts[$name][$type];
    print "<td>$total</td>\n";
  }
  print "</tr>\n";
?>
    </tbody>
  </table>
  <div class="backhome">    
    <a href='index.php'>Back to VCMap Home</a>
  </div>
</div>

<div id="bottomnav">
  <ul>
    <li><a href="http://animalgenome.org/" id="current"><span>animalgenome.org</span></a></li>
    <li><a href="http://animalgenome.org/bioinfo/community/team"><span>Contact</span></a></li>
    <li><a href="http://bioneos.com/"><span>Developers</span></a></li>
    <li><span>Copyright &copy; <?= date("Y"); ?></span></li>
  </ul>
</div>

</body>
</html>
