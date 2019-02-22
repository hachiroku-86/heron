<?php session_start();
	if(isset($_SESSION['login'])){
		echo '<html>';
		echo '<head>';
		echo '<title>Page de notre section membre</title>';
		echo '</head>';

		echo '<body>';
		echo '<header>';
		echo 'Votre login est '.$_SESSION['login'].'.';
		echo '</br>';
		echo '<a href="logout.php">Déconnection</a>';
		echo '</header>';
		echo '</body>';
		echo '</html>';
	}
?>