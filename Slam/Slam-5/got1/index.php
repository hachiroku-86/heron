 <?php
	
	require_once ("Characters.php");
	require_once ("Noble.php");
	require_once ("Hero.php");
	require_once ("Maison.php");
	require_once ("Culture.php");
	require_once ("Region.php");


	$Dorne = new Region("1", "Dorne");

	$Stark = new Maison("Winterfell", "Stark", "Le roi du nord", "02/11/438");
	$Lanister = new Maison("Westeros", "Lanister", "Un Lanister paie toujours ses dètes", "24/05/440");

	$Pop = new Culture("1", "Pop");
	$Kanjo = new Culture("2", "Kanjozoku");

	$JohnSnow = new Noble("Caitlyn", "Ned", "khalisi", $Stark, "1", "John", "04/11/333", "-/-/-", $Kanjo);

	echo $JohnSnow->getMyHome()->getNom();
	echo "<br>";

	$TabPersos = array(1 => $JohnSnow,
		2 => new Noble("Maria", "Thierry", "Chloe", $Stark, "2", "Raphael", "1234", "4321", $Kanjo),
		3 => new Noble("Florence", "Jean Francois", "Aurelien", $Lanister, "3", "Andyyyyyyyyyyyy", "2222", "3333", $Kanjo),
		4 => new Noble("Corinne", "Gregory", "Léa", $Stark, "4", "Matis", "6666", "5555", $Pop),
		5 => new Noble("Martine", "Didier", "Void", $Lanister, "5", "florent", "1111", "9999", $Kanjo),
		6 => new Noble("Miguelita", "Miguel", "Maitre Sombre", $Stark, "6", "Thomas", "1932", "1933", $Pop)
		);

	echo '<form method="POST" action="nbPersonnage.php">';
	echo '<input type="submit" value="nbPersonnage" >';
	echo '</form>';


	echo '<form method="POST" action="mesPersonnages.php">';
	echo '<input type="submit" value="mesPersonnages" >';
	echo '</form>';


	echo "<br>";


?>