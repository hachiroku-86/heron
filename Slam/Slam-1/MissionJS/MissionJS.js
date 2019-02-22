alert("Bonjour");
var nom= prompt("Entrez votre nom et prenom : ");
alert("Heureux de vous rencontrez " + nom);

nombre1 = parseInt(prompt("Entrez un premier nombre"));

nombre2 = parseInt(prompt("Entrez un second nombre"));

resultat = nombre1 + nombre2;

alert("Le résultat de " + nombre1 + " + " + nombre2 + " est : " + resultat);

suppinf = parseInt(prompt("Saisissez un nombre : "));

if (suppinf < 20){
	alert(suppinf + " est inférieur à 20")
}

else if (suppinf > 20){
	alert(suppinf + " est superieur à 20")
}
else{
	alert(suppinf + " est égale à 20")
}

nombreCx1 = parseInt(prompt("Entrez un premier nombre"));

nombreCx2 = parseInt(prompt("Entrez un second nombre"));

var choix = parseInt(prompt("Entrez 1 pour additionner, 2 pour soustraire, 3 pour multiplier, 4 pour diviser"));
switch (choix) {
case 1:
alert("Le résultat est : " + nombreCx1 + nombreCx2);
break;
case 2:
alert("Le résultat est : " + nombreCx1 - nombreCx2);
break;
case 3:
alert("Le résultat est : " + nombreCx1 * nombreCx2);
break;
case 4:
alert("Le résultat est : " + nombreCx1 / nombreCx2);
break;
default:
alert("Aucun choix") ;
}

valeur = 5;
l = 0;
while (valeur != 0){
	somme5 = parseInt(prompt("Saisissez un nombre : "))
	valeur = valeur - 1;
	l = l + somme5;

}

alert(l);

test = 1;
m = 0;
while (test != 0){
	somme5x = parseInt(prompt("Saisissez un nombre : "))
	test = test - 1;
	m = m * somme5x;
	test = parseInt(prompt("Pour saisir d'autre nombre faite 1, stoper la saisie faite 0"))

}

alert(m);