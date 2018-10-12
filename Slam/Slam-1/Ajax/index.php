<?php
session_start(); 
 echo "bonjour Ajax ";
 echo "<br>";
 $dsn = 'mysql:dbname=Ajax;host=sl-us-south-1-portal.9.dblayer.com:25143'; 
$user = 'admin'; 
$password = 'XIYIAJDHRFPMRSIF'; 


try { 
    $dbh = new PDO($dsn, $user, $password, array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8')); 
} catch (PDOException $e) { 
    echo 'Connexion échouée : ' . $e->getMessage(); 
} 
$sql="SELECT count(*) as nb FROM utilisateur WHERE Mail=:email ";

$resultats =$dbh->prepare($sql) ;

$email=$_GET["email"];
$resultats->bindParam(':email',$email);
$resultats->execute(); 

$nb=0;
foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
{
	$nb=$ligne->nb;	
}

if($nb==1){
	echo " Adresse trouvée";
}
else{
	echo " Adresse Introuvée";
}

?>