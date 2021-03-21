<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post resultaat</title>
</head>
<body>
<h1>post data</h1>
<pre>
<?php
echo
    'Voornaam: ' . htmlspecialchars($_POST["Voornaam"]) . "\n" .
    'Familienaam: ' . htmlspecialchars($_POST["Familienaam"]) . "\n" .
    'E-mail: ' . htmlspecialchars($_POST["E-mail"]) . "\n" .
    'telefoonnummer: ' . htmlspecialchars($_POST["telefoonnummer"]) . "\n" .
    'Vraag: ' . htmlspecialchars($_POST["Vraag"]);
?>
  </pre>
</body>
</html>