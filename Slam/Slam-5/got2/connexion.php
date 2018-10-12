<?php session_start();

error_reporting(E_ALL);
ini_set('display_errors', 1);

$dsn = 'mysql:dbname=BTS_SIO_2;host=sl-us-south-1-portal.34.dblayer.com:56255'; 
$user = 'admin'; 
$password = 'MJZODZCSVZSAMRWE';
$login = $_GET['login'];
$mdp = $_GET['mdp'];
$test_co = 0;


try { 
    $dbh = new PDO($dsn, $user, $password, array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
} catch (PDOException $e) { 
    echo 'Connexion échouée : ' . $e->getMessage(); 
} 
$sql = "SELECT Login, Mdp, Email FROM GOT2 where Login = '".$login."' AND Mdp = '".$mdp."'";
$resultats = $dbh->prepare($sql);
$resultats->execute();
foreach($resultats->fetchAll(PDO::FETCH_OBJ) as $ligne)
{
	echo "Conexion réussie<br>";
	echo "<div id = 'sendmail'>".$ligne->Email."</div>";
	echo "<input type = 'text' id = 'email' value = '".$ligne->Email."'></input>";
	echo "<input type = 'text' id = 'loginrecup' value = '".$login."'/>";
	$test_co = 1;
	echo "<input type = 'hidden' id = 'test_co' value = '".$test_co."'/>";
}
if ($test_co == 0){
	echo "Echec de la connexion.";
}
 
?>