<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>

<?php 

require_once 'header.php';
$login = [["Lacroix", "Clement"], ["Cataldi", "Matis"]];
$logins =["Lacroix","Cataldi"];
$step=false;

for($i=0; $i < count($login); $i++){
	if($_POST['nom'] == $login[$i][0] && $_POST['prenom'] == $login[$i][1]){
		$step =true;
	}
}

if($step == true){
	echo "Personne connue "."</br></br><a href='commande.php'>Passer commande</a>"."</br></br><a href='formulaire.html'>Retour au formulaire</a>";
} else {
	echo "Personne inconnue "."</br></br><a href='formulaire.html'>Retour au formulaire</a></br></br>";

	echo("<select name=’maListe’ size=’1’>") ;
 
	foreach($logins as $login){ 
	echo("<option>".$login." </option>") ;
 
	} 
	echo("</select >") ;

	}
?>

</body>



</html>