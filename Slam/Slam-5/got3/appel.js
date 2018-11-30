$(document).ready(function () {
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
				alert("coucou2");
			},
			
		});
	});
	$('#btnV').click(function () {
		$.ajax({
			url: 'https://api.got.show/api/cities/'+$('#nameV').val()+'',
			type: "GET",
            success: function (resultat) {
                var id = resultat.data._id;
                var name = resultat.data.name;
                $('#table-cities-1').html(id);
                $('#table-cities-2').html(name);
            }
		});
	});
});