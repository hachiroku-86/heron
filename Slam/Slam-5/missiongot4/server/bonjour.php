<?php 
require 'vendor/autoload.php';
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

$dsn = 'mysql:dbname=GamesOfThrones;host=sl-us-south-1-portal.34.dblayer.com:56255'; 
$user = 'admin'; 
$password = 'MJZODZCSVZSAMRWE';
$test_co = 0;
 
$app = new \Slim\App;
$app->get('/bonjour', function(Request $request, Response $response){	
	return "Bonjour !";
});

$app->get('/personnage/{name}', function(Request $request, Response $response){
		$name = $request->getAttribute('name');
       return getPersonnage($name);
});
function connexion()
{
    /*IBM Cloud
     * $vcap_services = json_decode($_ENV['VCAP_SERVICES'], true);
     * $uri = $vcap_services['compose-for-mysql'][0]['credentials']['uri'];
     * $db_creds = parse_url($uri);
     * $dbname = "patisserie";
     * $dsn = "mysql:host=" . $db_creds['host'] . ";port=" . $db_creds['port'] . ";dbname=" . $dbname;
     * return $dbh = new PDO($dsn, $db_creds['user'], $db_creds['pass'],array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
     * */
    //autre
    return $dbh = new PDO('mysql:dbname=GameOfThrones;host=sl-us-south-1-portal.34.dblayer.com:56255','admin', 'MJZODZCSVZSAMRWE', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
}
function getPersonnage($name)
{
	$sql = "SELECT * FROM characters WHERE name= '".$name."'";
	try{
		$dbh=connexion();
		$statement = $dbh->prepare($sql);
		$statement->execute();
		 $result = $statement->fetchAll(PDO::FETCH_CLASS); 
                 return json_encode($result, JSON_PRETTY_PRINT);
	} catch(PDOException $e){
		return '{"error":'.$e->getMessage().'}';
	}
}

$app->get('/user', function(Request $request, Response $response){
    $tb = $request->getQueryParams();
    $login = $tb["login"];
    $pw = $tb["pw"];
        //fonction d'insertion
    return checkUser($login, $pw);
});
 
function checkUser($login, $pw)
{
    $sql = "SELECT mail FROM logs WHERE login='".$login."' AND password ='".$pw."'";
    try{
        $dbh=connexion();
        $statement = $dbh->prepare($sql);
        $statement->execute();
        $result = $statement->fetchAll(PDO::FETCH_CLASS); 
                 return json_encode($result, JSON_PRETTY_PRINT);
    } catch(PDOException $e){
        return '{"error":'.$e->getMessage().'}';
    }
}

$app->post('/userIns', function(Request $request, Response $response){
    $tb = $request->getQueryParams();
    $mailIns = $tb["mailIns"]; 
    $loginIns = $tb["loginIns"];
    $pwIns = $tb["pwIns"];
        return insertUser($mailIns, $loginIns, $pwIns);
});
 
function insertUser($mailIns, $loginIns, $pwIns)
{
    $sql = "INSERT into logs VALUES ('".$loginIns."','".$mailIns."','".$pwIns."')";
    try{
        $dbh=connexion();
        $statement = $dbh->prepare($sql);
        $statement->execute();
        $result = $statement->fetchAll(PDO::FETCH_CLASS); 
    } catch(PDOException $e){
        return '{"error":'.$e->getMessage().'}';
    }
}

$app->run();