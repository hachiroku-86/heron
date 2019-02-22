let test ='{"marque":"toyota", "modele":"trueno AE86"}';

obj = JSON.parse(test);

console.log(obj.marque);

console.log(obj.modele);

let variable1 = 1;

function func1(var2) {
	var2 = variable1 + 1;
	return var2;
}

let variable2 = func1();

function funct2(){
	let variable3 = variable1 + variable2;
	document.getElementById("idTest").innerHTML = "Voici le chiffre " + variable3 + ". Ca sert à rien mais c'est là quand même.";
}



function testUploadFile() {
	let uploadFiles = document.getElementById("uploadFiles");		// Variable qui récupère l'élément dont l'id est "uploadFiles" (HTML).
	let fileList = document.getElementById("fileList");				// Variable qui récupère l'élément dont l'id est "fileList" (HTML).
		
	function traverseFiles(files) {
		let li;
		let file;
		let fileInfo;

		document.getElementById("fileList").innerHTML = "";				// Variable qui récupère l'élément dont l'id est "fileList" (HTML) et le remplace unechaine de caractères vide.
			
		for (let i = 0, il = files.length ; i < il; i++) {				// Boucle for prennant la taille du fichier en paramètre
			li = document.createElement("li");							// Variable qui créer l'élément d'id "li" (HTML).
			file = files[i];											// Variable prend la valeur du fichier qui est lu.
			fileInfo = "<div><b>Nom : </b>" + file.name + "</div>"+		// Variable qui récupère le nom, la taille et le type du fichier et les affiches en gras dans des div HTML.
			 "<div><b>Taille : </b>" + file.size + "bytes</div>"+
			 "<div><b>Type : </b>" + file.type + "</div>" + "<br>";
			li.innerHTML = fileInfo;									// Remplace le contenu de la balise <li> par le contenu de la variable fileInfo.
			document.getElementById("fileList").appendChild(li);		// 
			lecteurFichier(files);										// Appelle de la fonction lecteurFichier avec comme paramètre le fichier lu.
		}

	}

	uploadFiles.onchange = function testClick(){						// Fonction qui s'exécute lorsque le contenu de l'élément d'id="uploadFiles" change.
		traverseFiles(this.files);										// Elle appelle à son tour la fonction traverseFiles avec en paramètre le fichier selectionné.
	}

	function lecteurFichier(files){

		let reader = new FileReader(files);								// Création d'un objet type FileReader.

	       	reader.addEventListener('loadend', function() {				// Ajout d'un évènement se déclenchant une fois la lecture du fichier terminée.
	        	
	           	let json = reader.result;								// reader.result retourne le contenu du fichier, on l'attribut à la variable json.
	       		//document.getElementById('idTest').innerHTML = json;		// Affichage du contenu dans l'élément d'id="idTest".


	       		let lines = json.split("\r\n");

	       		var myObj = {name: 'John', age: 31, city: 'New York'};
				var myJSON = JSON.stringify(myObj);						

	       		let lines_parse = [];
	       		/*let jsonString = JSON.stringify(json);
	       		jsonString = jsonString.replace(/"{\\"(.*)"\\}"/g,/"{"(.*)"}"/);*/								

	       		for (let n = 0; n < lines.length; n++) {
	       			if (lines[n].match(/^"{(.*)}"$/)) {							// Vérifie si la ligne sélèctionnée correspond au paterne voulu.
	      				let retour = lines[n].replace(/^"{(.*)}"$/, '{$1}');	// Expression régulière permettant de remplacer les doubles guillemets pas de simples guillemets.
	       				retour = retour.replace(/""/gi, '"');					// Remplace les guillemets par des cotes.
	       				try {
	       					lines_parse[n-1] = JSON.parse(lines);				// Ajoute les lignes découpées dans un tableau.
	       					jQuery("#qrcode").qrcode({
							    //render:"table"
							    width: 150,
							    height: 150,
							    text: lines_parse[n-1] 
							});
	       				} catch (e) {
	       					console.log('ligne ' + n)
	       					console.log(e);
	       					console.log(retour);
	       				}
	        				
	       			}

	        	}
	        	
	       	console.log(lines_parse);			// Affiche le tableau dans la console.

        	return;

	        });

	   	reader.readAsText(files[0]);		// Lit le contenu du fichier.

	};

};

function qrCode(){
	jQuery("#qrcode").qrcode({
    //render:"table"
    width: 128,
    height: 128,
    text: "LICORNES"
});
}
