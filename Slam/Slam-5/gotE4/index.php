<?php 
require 'vendor/autoload.php';
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;
use \Firebase\JWT\JWT;

$dsn = 'mysql:dbname=GamesOfThrones;host=heront.cpkeew4cmc1b.eu-west-1.rds.amazonaws.com'; 
$user = 'heront'; 
$password = 'cresta1jz';
$test_co = 0;
 
$app = new \Slim\App;

ini_set('display_errors', 1);

/* Début Got 4 */

$app->get('/bonjourgot4', function(Request $request, Response $response){	
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
    return $dbh = new PDO('mysql:dbname=GameOfThrones;host=heront.cpkeew4cmc1b.eu-west-1.rds.amazonaws.com','heront', 'cresta1jz', array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
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
    $token = $tb["token"];
    if(validJWT($token)){
        $login = $tb["login"];
        $pw = $tb["pw"];
        return checkUser($login, $pw);
    }else{
        return $response->withStatus(401);
        //fonction d'insertion
    }
    
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
    $token = $tb["token"];
    if(validJWT($token)){
        $login = $tb["loginIns"];
        $pw = $tb["pwIns"];
        return insertUser($mailIns, $loginIns, $pwIns);
    }else{
        return $response->withStatus(401);
        //fonction d'insertion
    }
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

/* Fin Got 4 */

/* Début Got 5 */

$app->get('/user/{login}', function(Request $request, Response $response){
        $token = $request->getAttribute('token');
        if(validJWT(token)){
            $login = $request->getAttribute('login');
            return getLogin($login);
        }else{
            return $response->withStatus(401);
        }
        
});
function getLogin($login)
{
    $sql = "DELETE FROM logs WHERE login= '".$login."'";
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

$app->put('/user', function(Request $request, Response $response){
    $tb = $request->getQueryParams();
    $token = $tb["token"];
    if(validJWT($token)){
        $login = $tb["login"];
        $mail = $tb["mail"];
        return changeMail($login, $mail);
    }else{
        return $response->withStatus(401);
        //fonction d'insertion
    }
});
 
function changeMail($login, $mail)
{
    $sql = "UPDATE logs SET mail='".$mail."' WHERE login='".$login."'";
    echo $sql;
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

$app->get('/personnages', function(Request $request, Response $response){
        return hundredUser();
});
 
function hundredUser()
{
    $sql = "SELECT * FROM characters LIMIT 100";
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

/* Fin Got 5 */

/* Début Got 6 */

$app->get('/obtentionToken', function(Request $request, Response $response){  
      //vérification de l'utilisateur
    $tb = $request->getQueryParams();
    $logingot6 = $tb["login-got6"];
    $pwgot6 = $tb["pw-got6"];  
    $allowed= checkUserGot6($logingot6,$pwgot6);
    if($allowed){
        return getTokenJWT();
    }else{
        return $response->withStatus(401);
    }
});

    function checkUserGot6($logingot6, $pwgot6){

        $sql = "SELECT login, password FROM logs WHERE login='".$logingot6."' AND password ='".$pwgot6."'";
        try{
            $dbh=connexion();
            $statement = $dbh->prepare($sql);
            $statement->execute();
            foreach($statement->fetchAll(PDO::FETCH_CLASS) as $ligne){
                return true;
            }
            return false;
        } catch(PDOException $e){
            return false;
        }
    }

    $app->post('/token', function(Request $request, Response $response){
      $tb = $request->getQueryParams();
      $token = $tb["token"];
      if(validJWT($token)){
        return true;
        //J'execute la fonction
      }else{
        //non autorisé
        return $response->withStatus(401);
      }  
    });
     function getTokenJWT() {
       // Make an array for the JWT Payload
      $payload = array(
        //30 min
        "exp" => time() + (60 * 1)
      );
       // encode the payload using our secretkey and return the token
      return JWT::encode($payload, "secret");
    }
      function validJWT($token) {
        $res = false;
        try {
            $decoded = JWT::decode($token, "secret", array('HS256'));       
        } catch (Exception $e) {
          return $res;
        }
        $res = true;
        return $res;  
      }

/* Fin Got 6 */

/* Début Got 7 */


    $app->get('/stats', function(Request $request, Response $response){
        return overTenPerHouse();
    });
 
    function overTenPerHouse()
    {
        $sql = "SELECT count(characters.id) nb, houses.name name FROM characters, houses WHERE house != 'NULL' AND characters.house = houses.id GROUP BY house HAVING count(characters.id) >= 10";
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

    $app->get('/cityByType', function(Request $request, Response $response){
        return cityByType();
    });
 
    function cityByType()
    {
        $sql = "SELECT count(cities.id) nb, cities_type.name name FROM cities, cities_type WHERE cities.type = cities_type.id GROUP BY name";
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

    $app->get('/perso100', function(Request $request, Response $response){
        return perso100();
    });
 
    function perso100()
    {
        $sql = "CALL getPerso100";
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

 /* Fin Got 7 */

 $app->put('/culture', function(Request $request, Response $response){
    $tb = $request->getQueryParams();
    $token = $tb["token"];
    if(validJWT($token)){
        $nameold = $tb["cultname"];
        $namenew = $tb["cultnamenew"];
        return changeCult($nameold, $namenew);
    }else{
        return $response->withStatus(401);
        //fonction d'insertion
    }
});
 
function changeCult($nameold, $namenew)
{
    $sql = "UPDATE cultures SET name='".$namenew."' WHERE name='".$nameold."'";
    echo $sql;
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


$app->run();