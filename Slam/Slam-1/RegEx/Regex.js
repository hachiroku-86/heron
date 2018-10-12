var nom = prompt("Saisissez votre nom");
alert(nom);
if(/^[a-zA-Z]+[a-zA-Z]+[a-zA-Z]$/i.test(nom)){
	alert("GENERALE");
}

else{
	alert("ALED");
}
document.getElementById('simple').value = nom;