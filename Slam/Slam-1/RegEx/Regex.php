<?php

	$chaine = "piano à queue";
 	if (preg_match("[piano]", $chaine)){
 		echo "oui";
 	}else{
 		echo "non";
 	}

 	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	echo preg_replace("[piano]", "PIANO", $chaine);

	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	$chaine2 = "j'adore la programmation";

 	if (preg_match("/^[aeiouy]/", $chaine2)){
 		echo "check";
 	}else{
 		echo "uncheck";
 	}

 	echo "<br>";
 	echo "<br>";
 	echo "<br>";

	if (preg_match("/[programmation]$/", $chaine2)){
 		echo "validé";
 	}else{
 		echo "réfuté";
 	}

	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	$chaine3 = "youyou ;)";

 	if (preg_match("/[;)]/", $chaine3)){
 		echo ":)";
 	}else{
 		echo ":(";
 	}

 	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	$mail = 'raphael.olivier@sio.fr';

	if (preg_match("/^[a-z0-9._-]+@sio.fr$/", $mail)){
 		echo $mail;
 	}else{
 		echo "mauvaise adresse";
 	}

	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	$chaine4 = "lili";
 	preg_match("[lili]", $chaine4);
 	
 	echo preg_replace("[lili]", "lulu", $chaine4);
 	
 	echo "<br>";
 	echo "<br>";
 	echo "<br>";

 	echo $chaine;


?>