<?php
// This file simply reads all of the command line options, generates an
// appropriate temporary jnlp file, and emits the file contents back to
// the client browser.  The file must be created and web accessible though
// due to the WebStart process of always reading the url before launch.
// 
// This will also record usage times and IP addresses. TODO

/**
 * Helper method to generate a random 32-character filename for dynamically
 * generated JNLP files to be stored in our jnlp cache: "tmp/".  
 */
function generate_random32()
{
  $filename = "";
  $valid = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for ($i = 0; $i < 32; $i++)
    $filename .= substr($valid, mt_rand(0, 61), 1);
  return $filename;
}

//
// Main processing
//
// Read in the template that contains special replacement strings for the
// dynamic information.
$file_contents = file_get_contents("jnlp.template");

// Create the filename for the temp directory
$jnlp = null;
do
{
  $filename = generate_random32() . ".jnlp";
  $jnlp = "tmp/$filename";
} while (file_exists($jnlp));

// Replace the URL first
$file_contents = preg_replace("/\\\$HREF\\\$/", "tmp/$filename", $file_contents);

// Now, read our GET / POST parameters looking for backbone and off
$backbone = "";
if (!empty($_POST['backbone']))
  $backbone = $_POST['backbone'];
else if (!empty($_GET['backbone']))
  $backbone = $_GET['backbone'];

$maps = array();
if (!empty($_POST['off-backbone']))
{
  foreach ($_POST['off-backbone'] as $map)
    $maps[] = $map;
}
else if (!empty($_GET['off-backbone']))
{
  foreach ($_GET['off-backbone'] as $map)
    $maps[] = $map;
}
// And replace
$args = "";
if (!empty($backbone))
  $args .= "<argument>--backbone=$backbone</argument>\n";
if (!empty($maps))
{  
  foreach ($maps as $map)
    $args .= "<argument>--off-backbone=$map</argument>\n";
}
$file_contents = preg_replace("/\\\$ARGS\\\$/", $args, $file_contents);

// Write the new jnlp to the file
$file = fopen($jnlp, "w");
fwrite($file, $file_contents);
fclose($file);

// And output to the client browser (sending cache settings in the header)
header("Cache-Control: no-cache");
header("Expires: Sat, 26 Jul 1997 05:00:00 GMT");
// Identify ourselves as a JNLP file (not txt/html -- the default)
header("Content-type: application/x-java-jnlp-file");
//header("Content-type: text/xml");
?>
<?= $file_contents ?>
