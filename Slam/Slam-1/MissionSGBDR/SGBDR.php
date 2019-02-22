<?php
$dsn = 'mysql:dbname=SGBDR;host=sl-us-south-1-portal.9.dblayer.com:25143'; 
$user = 'pdo_user'; 
$password = 'toto'; 

try { 
    $dbh = new PDO($dsn, $user, $password, array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8')); // Créer une nouvelle connexion. 
} catch (PDOException $e) { 
    echo 'Connexion échouée : ' . $e->getMessage(); 
} 
$sql = "SELECT COUNT(*) as total FROM Produit";
$resultats=$dbh->prepare($sql) ;
 
$resultats->execute() ;
foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
{
	echo 'Nombre de produits : '.$ligne->total.'<br><br>';
}

$sql = "SELECT NomColl FROM Collection";
$resultats=$dbh->prepare($sql) ;
 
$resultats->execute() ;
foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
{
	echo 'Nom :'.$ligne->NomColl.'<br>';
}

echo'<table border=\"1\">Liste des produits:
						<tr>
							<th> Numéro de la collection </th>
							<th> Date de lancement </th>
							<th> Reférence </th>
							<th> Nom du produit </th>
							<th> Couleur du produit </th>
							<th> Nom de la collection </th>
							<th> Dimensions </th>
							<th> Harmonie </th>
							<th> Prix </th>
						</tr>
			';
		$sql = "SELECT * FROM Produit";
		$resultats=$dbh->prepare($sql) ;
		$resultats->execute();
		foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
		{
			echo'<tr> 
						<td>'.$ligne->NumColl.'</td>
						<td>'.$ligne->DateL.'</td>
						<td>'.$ligne->RefProd.'</td>
						<td>'.$ligne->NomProd.'</td>
						<td>'.$ligne->Couleur.'</td>
						<td>'.$ligne->NomColl.'</td>
						<td>'.$ligne->Dimensions.'</td>
						<td>'.$ligne->Harmonie.'</td>
						<td>'.$ligne->PrixHT.'</td>
					</tr>
				';
		}
		echo '</table>';
		echo '<br>';

			$sql = "SELECT * FROM Produit ORDER BY NumColl;";
		$resultats=$dbh->prepare($sql);
 
		$resultats->execute() ; 
		foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
		{
	echo 'Voici les produits rangés par collection: '.$ligne->NomProd.", ".$ligne->RefProd.'<br>';
}


?>