<?php

	require_once ("Characters.php");
	require_once ("Noble.php");
	require_once ("Hero.php");
	require_once ("Maison.php");
	require_once ("Culture.php");
	require_once ("Region.php");
	require_once ("index.php");

	for ($i=1; $i <= sizeof($TabPersos) ; $i++) { 
		echo $TabPersos[$i]->__toString();
		echo "<br>";
	}
?>