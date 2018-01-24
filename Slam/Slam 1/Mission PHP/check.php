<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>

<?php session_start();
$login = [["Lacroix", "Clement"], ["Cataldi", "Matis"]];
$step=false;

for($i=0; $i < count($login); $i++){
	if($_POST['nom'] == $login[$i][0] && $_POST['prenom'] == $login[$i][1]){
		$step =true;
	}
}

if($step == true){
	echo "Personne connue "."</br></br><a href='commande.html'>Passer commande</a>"."</br></br><a href='formulaire.html'>Retour au formulaire</a>";
} else {
	echo "Personne inconnue "."</br></br><a href='formulaire.html'>Retour au formulaire</a>";
}
?>

</body>



</html>