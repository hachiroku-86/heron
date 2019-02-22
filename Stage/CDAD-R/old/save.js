function testUploadFile() {
		let uploadFiles = document.getElementById("uploadFiles");		// Variable qui récupère l'élément dont l'id est "uploadFiles" (HTML).
		let fileList = document.getElementById("fileList");				// Variable qui récupère l'élément dont l'id est "fileList" (HTML).
		//var voitures = ['[{"marque":"BMW","modele":"330i","annee":"2011"},{"marque":"Toyota","modele":"AE86","annee":"1988"},{"marque":"Honda","modele":"Civic","annee":"2010"}]'];

		//json = JSON.parse(voitures) ;

		//this.fileReader(json);
		
		function traverseFiles(files) {
			let li;
			let file;
			let fileInfo;

			document.getElementById("fileList").innerHTML = "";			// Variable qui récupère l'élément dont l'id est "fileList" (HTML) et le remplace unechaine de caractères vide.
			
			for (let i = 0, il = files.length ; i < il; i++) {			// Boucle for prennant la taille du fichier en paramètre
				li = document.createElement("li");						// Variable qui créer l'élément d'id "li" (HTML).
				file = files[i];										// Variable prend la valeur du fichier qui est lu.
				fileInfo = "<div><b>Nom : </b>" + file.name + "</div>"+	// Variable qui récupère le nom, la taille et le type du fichier et les affiches en gras dans des div HTML.
				 "<div><b>Taille : </b>" + file.size + "bytes</div>"+
				 "<div><b>Type : </b>" + file.type + "</div>" + "<br>";
				li.innerHTML = fileInfo;								// Remplace le contenu de la balise <li> par le contenu de la variable fileInfo.
				document.getElementById("fileList").appendChild(li);	// 
				lecteurFichier(files);									// Appelle de la fonction lecteurFichier avec comme paramètre le fichier lu.
			}

		}

		uploadFiles.onchange = function testClick(){		// Fonction qui s'exécute lorsque le contenu de l'élément d'id="uploadFiles" change.
			traverseFiles(this.files);						// Elle appelle à son tour la fonction traverseFiles avec en paramètre le fichier selectionné.
		}

		function lecteurFichier(files){

			let reader = new FileReader(files);							// Création d'un objet type FileReader.

	        	reader.addEventListener('loadend', function() {			// Ajout d'un évènement se déclenchant une fois la lecture du fichier terminée.
	        	
	            	let json = reader.result;							// reader.result retourne le contenu du fichier, on l'attribut à la variable json.
	        		document.getElementById('idTest').innerHTML = json;	// Affichage du contenu dans l'élément d'id="idTest".

					let ligneJson = decomposeCSV(json);					// Appelle de la fonction decomposeCSV avec la variable contenant le contenu du fichier.

					for (let i = 0; i < files.length; i++) {			// Boucle for prennant la taille du fichier en paramètre.

				    	files = JSON.parse(ligneJson);					// La methode JSON.parse analyse la variable ligneJson et stock les données dans la variable files.

				    	/*console.log(files.marque);
				    	console.log(files.modele);
				    	console.log(files.annee);*/

				    	console.log(files.numSerie);
				        console.log(files.nno);
				        console.log(files.adresseMac);
				        console.log(files.dateGarantie);
				        console.log(files.millesime);
				        console.log(files.numFeb);
				        console.log(files.numCmd);
				        console.log(files.comAdmin);
						console.log(files.comCorsic);
				        console.log(files.modifiable);
				        console.log(files.connuSilicium);
				        console.log(files.statut);
				        console.log(files.etat);
				        console.log(files.typePrestation);
				        console.log(files.cadreNormatif);
				        console.log(files.credoOrga);
				        console.log(files.libelleOrga);
				        console.log(files.refArticle);
				        console.log(files.constructeur);
				        console.log(files.reseauAccueil);
				        console.log(files.reseauMetierAbrege);
				        console.log(files.reseauMetier);
				        console.log(files.renouvellementDIRISI);
				        console.log(files.numMarcheDIRISI);
				        console.log(files.numEj);
				        console.log(files.dateEj);
				        console.log(files.numTitulaireMarche);
				        console.log(files.nomTitutlaireMarche);
				        console.log(files.positionFicheMateriel);
				        console.log(files.nomUc);
				        console.log(files.type);
				        console.log(files.numApsi);
				        console.log(files.tailleEcran);
					}
	        });

	    reader.readAsText(files[0]);							// Lit le contenu du fichier.

		};
	function decomposeCSV(json){
		//var supTitle = voitures.replace("#json\r\n", "");
		//var stringSupTitle = JSON.stringify(supTitle);
		let stringifyJson = JSON.stringify(json);				// Transformation de la variable json en une chaine de caractères.
		let decompJson = stringifyJson.split("\r\n");			// Découpe la chaine de caractères à chaque retour à la ligne. (\r = fin de ligne, \n = début nouvelle ligne)

		return decompJson;										// Retourne la chaine découpée.

	}
};

