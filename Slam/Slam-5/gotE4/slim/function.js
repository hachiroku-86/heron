$(document).ready(function (){

  var token=sessionStorage.getItem('token');
  var nbPersoByHouseParse;

  /* Début Got 4 */

  $('#btn-bonjour').click(function(){ 
  $.ajax({ 
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        url: "../index.php/bonjourgot4",
       success: function(data){
           alert(data);
        	}
  	});
  });


  $('#btn-got4-1').click(function(){ 
    $("#resultat-got4-1").bootstrapTable({ 
  			url: "../index.php/personnage/"+$('#name').val(),
  			columns: [{
          field: 'name',
          title: 'Nom'
        },{
          field: 'id',
          title: 'Id'
  			},]
  		});
  	});


  $('#btn-got4-2').click(function(){ 
  var login=$('#login').val();
  var pw=$('#pw').val();
  	$.ajax({ 
        	type: "GET",
        	contentType: 'application/json; charset=utf-8',
       	url: "../index.php/user?login="+login+"&pw="+pw+"&token="+token,
       	success: function(data){
           	$("#resultat-got4-2").html(data);
        	},
        error: function(){
          $("#resultat-got4-2").html("Token invalide.")
        }
   	});
  });

  $('#btn-got4-3').click(function(){ 
  var mailIns=$('#mailIns').val();
  var loginIns=$('#loginIns').val();
  var pwIns=$("#pwIns").val();
  $.ajax({ 
      type: "POST",
      contentType: 'application/json; charset=utf-8',
      url: "../index.php/userIns?mailIns="+mailIns+"&loginIns="+loginIns+"&pwIns="+pwIns+"&token="+token,
      success: function(data){
        $("#resultat-got4-3").html("Utilisateur ajouté.")
      },
      error: function(){
        $("#resultat-got4-3").html("Token invalide.")
      }
    });
  });


  /* Fin Got 4 */

  /* Début Got 5*/


  $('#btn-got5-1').click(function(){ 
    var logingot5=$('#login-got5').val();
    $.ajax({ 
        type: "GET",
        url: "../index.php/user/"+logingot5+"&token="+token,
        success: function(data){  
          $("#resultat-got5-1").html(data);
        },
        error: function(){
          $("#resultat-got5-1").html("Token invalide.")
        }
      });
    });


  $('#btn-got5-2').click(function(){ 
  var login=$('#login2').val();
  var mail=$('#mail').val();
    $.ajax({ 
          type: "PUT",
          contentType: 'application/json; charset=utf-8',
          url: "../index.php/user?login="+login+"&mail="+mail+"&token="+token,
          success: function(data){
            $("#resultat-got5-2").html(data);
          },
          error: function(){
          $("#resultat-got5-2").html("Token invalide.")
        }
    });
  });

  $('#btn-got5-3').click(function(){ 
  $("#tablePerso").bootstrapTable({ 
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        url: "../index.php/personnages",
        columns: [{
          field: 'name',
          title: 'Nom'
        },{
          field: 'titles',
          title: 'Titre'
        },{
          field: 'culture',
          title: 'Culture'
        },]
      });
    });

  /* Fin Got 5 */

  /* Déut Got 6 */

  $("#btn-got6-1").click(function(event) {
  var logingot6=$('#login-got6').val();
  var pwgot6=$('#pw-got6').val();               
      $.ajax({ 
            type: "GET",
            url: "../index.php/obtentionToken?login-got6="+logingot6+"&pw-got6="+pwgot6,
            success: function(data){
             sessionStorage.setItem('token', data);                               
            },
      error: function(XMLHttpRequest, textStatus, errorThrown) {      
        $(".form-group-password").addClass("has-danger");
        $("#pw-got6").addClass("form-control-danger");
      }             
    });
  });

  $("#btn-got6-2").click(function(){
    $.ajax({
      type: "POST",
      url: "../index.php/token?token=" + sessionStorage.getItem('token'),
      success: function(){
        $('#resultat-got6-2').html("Le token est valide.");
      },
      error: function(){
        $('#resultat-got6-2').html('Le token est invalide.');
      }
    });
  });

  /* Fin Got 6 */

  /* Début Got 7 */
  
  function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
  };



  $.ajax({
    type: "GET",
    url: "../index.php/stats",
    success: function(data){
      console.log(data);
      nb = data;
      nbPersoByHouseParse = JSON.parse(data);
    },
  });
  


$("#btn-got7-1").click(function(event){
  var nombre = new Array();
  var nom = new Array();
  var backgroundColor = new Array();

  for (var i = 0; i < nbPersoByHouseParse.length; i++) {
    nombre[i] = nbPersoByHouseParse[i].nb;
    nom[i] = nbPersoByHouseParse[i].name;
    backgroundColor[i] = getRandomColor();
  }

  var ctx = document.getElementById("myChart").getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: nom,
        datasets: [{
          label: 'Nombre de personnages par maison',
          data: nombre,
          backgroundColor: backgroundColor
        }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero:true
          }
        }]
      }
    }
  });
});

$.ajax({
    type: "GET",
    url: "../index.php/cityByType",
    success: function(data){
      console.log(data);
      nb = data;
      nbCityByType = JSON.parse(data);
    },
  });
  


$("#btn-got7-2").click(function(event){
  var nombre = new Array();
  var nom = new Array();
  var backgroundColor = new Array();

  for (var i = 0; i < nbCityByType.length; i++) {
    nombre[i] = nbCityByType[i].nb;
    nom[i] = nbCityByType[i].name;
    backgroundColor[i] = getRandomColor();
  }

  var ctx2 = document.getElementById("myChart2").getContext('2d');
  var myChart = new Chart(ctx2, {
    type: 'doughnut',
    data: {
      labels: nom,
        datasets: [{
          label: 'Nombre de villes par type',
          data: nombre,
          backgroundColor: backgroundColor
        }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero:true
          }
        }]
      }
    }
  });
});

 /*  Fin Got 7 */

   $('#btn-got-E4').click(function(){ 
  var nameold=$('#cultname').val();
  var namenew=$('#cultnamenew').val();
    $.ajax({ 
          type: "PUT",
          contentType: 'application/json; charset=utf-8',
          url: "../index.php/culture?cultname="+nameold+"&cultnamenew="+namenew+"&token="+token,
          success: function(data){
            $("#resultat-got-E4").html(data);
          },
          error: function(){
            $("#resultat-got-E4").html("Token invalide.")
        }
    });
  });

});