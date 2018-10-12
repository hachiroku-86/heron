<?php 

session_start();

$email = $_GET['email'];
$login = $_GET['login'];

echo 'Votre login est : '.$login;
echo '<br>';
echo 'Votre adresse mail est : '.$email;

 ?>