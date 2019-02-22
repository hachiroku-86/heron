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


	       		let lines = json.split(";");
	       		console.log(lines);

	       		var myObj = {name: 'John', age: 31, city: 'New York'};
				var myJSON = JSON.stringify(myObj);						

	       		let lines_parse = [];

	       		for (let n = 0; n < lines.length; n++) {
	       			
	       				try {

		       					let htmlDiv = document.createElement('div');
		       					let htmlUl = document.createElement('ul');
		       					let htmlLi1 = document.createElement('li');
		       					let htmlLi2 = document.createElement('li');
		       					let htmlLi3 = document.createElement('li');

		       					htmlDiv.className = 'classQRCode';
		       					htmlUl.id = 'htmlUl';
		       					htmlLi1.id = 'htmlLi';
		       					htmlLi2.id = 'htmlLi';


		       					jQuery(document.body.appendChild(htmlDiv)).qrcode({
								    //render:"table"
								    width: 100,
								    height: 100,
								    text: lines[n] 
								});

								testparse = JSON.parse(lines[n]);

								console.log(testparse);

		       					jQuery(htmlDiv.appendChild(htmlUl));

		       					jQuery(htmlUl.appendChild(htmlLi1)).text("Marque : " + testparse.Marque);
		       					jQuery(htmlUl.appendChild(htmlLi2)).text("Modele : " + testparse.Modele);

		       					jQuery(ligne3qr.appendChild(htmlDiv));

	       				} catch (e) {
	       					console.log('ligne ' + n)
	       					console.log(e);
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