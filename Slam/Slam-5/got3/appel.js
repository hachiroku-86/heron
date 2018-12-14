$(document).ready(function (){
	$('#btn-get-houses').click(function () {
		$('#table-houses').bootstrapTable({
			url: 'https://api.got.show/api/houses',
			columns: [{
				field: 'name',
				title: 'Nom'
			},{
				field: 'currentLord',
				title: 'Seigneur'
			},{
				field: 'region',
				title: 'Region'
			},{
				field: 'title',
				title: 'title'
			},]
		});
	});


	$('#btn-get-villes').click(function () {
			alert("coucou1");
		$.ajax({
			type : "GET",
			url: 'https://api.got.show/api/cities/'+$('#villeurl').val(),
			success: function(resultat){
				$('#resultat').html(resultat.data.name + "<br>"
					+ resultat.data._id + "<br>"
					+ resultat.data.coordX + "<br>"
					+ resultat.data.coordY + "<br>"
					+ resultat.data.type + "<br>"
					+ resultat.data.priority + "<br>"
					+ resultat.data.link + "<br>"
				);
			},
			
		});
	});



	$('#btn-get-perso').click(function () {
		$.ajax({
			type : "GET",
			url: 'https://api.got.show/api/characters/'+$('#persourl').val(),
			success: function(resultat){
				$('#resultat').html(resultat.data.name + "<br>"
					+ resultat.data._id + "<br>"
					+ resultat.data.house + "<br>"
					+ resultat.data.slug + "<br>"
					+ resultat.data.male + "<br>"
					+ resultat.data.pageRank + "<br>"
					+ resultat.data.books + "<br>"
				);
				sessionStorage.setItem('houseP', resultat.data.house);
				sessionStorage.getItem('houseP');
			},
			
		});
		$.ajax({
			type : "GET",
			url: 'https://api.got.show/api/houses/'+sessionStorage.getItem('houseP'),
			success: function(resultat){
				$('#table-houses').html(resultat.data._id + "<br>"
					+ resultat.data.imageLink + "<br>"
					+ resultat.data.cadetBranch + "<br>"
					+ resultat.data.overlord + "<br>"
					+ resultat.data.title + "<br>"
					+ resultat.data.region + "<br>"
					+ resultat.data.currentLord + "<br>"
					+ resultat.data.words + "<br>"
					+ resultat.data.coatsOfArms + "<br>"
					+ resultat.data.name + "<br>"
					+ resultat.data.ancestralWeapon + "<br>"
				);
			},
			
		});
	});	
});