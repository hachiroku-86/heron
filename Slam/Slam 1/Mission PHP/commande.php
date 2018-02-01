<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Commande</title>
    <script type="text/javascript"> function showValue1(newValue){ document.getElementById("baignoire").innerHTML=newValue ;} </script>
    <script type="text/javascript"> function showValue2(newValue){ document.getElementById("lolo").innerHTML=newValue ;} </script>
    <script type="text/javascript"> function showValue3(newValue){ document.getElementById("courgette").innerHTML=newValue ;} </script>
</head>
<body>

<?php 
    require_once 'header.php';
?>

    <form method="post" id="frmConnection" action="infocmd.php">
        <p>
            <label>Baignoire</label> : <input type="range" min="0" max="5" name="baignoire" onchange="showValue1(value)"><span id="baignoire"></span>
        </p>
        <p>
            <label>ouistit du Brésil</label> : <input type="range" min="0" max="100" name="ouistiti" onchange="showValue2(value)"><span id="lolo"></span>
        </p>
        <p>
            <label>Courgette sèché</label> : <input type="range" min="0" max="30" name="courgette" onchange="showValue3(value)"><span id="courgette"></span>
        </p>
            <input type="submit" value="Valider" />
    </form>
</body>
<br>
<br>
<a href="bonjour.php">Retour</a></br></br>
</html>

