$(document).ready(function (){
 
$('#btn-valide').click(function(){ 
$.ajax({ 
      type: "GET",
      contentType: 'application/json; charset=utf-8',
      url: "http://localhost/Slam-5/missiongot4/server/bonjour.php/bonjour",
     success: function(data){
         alert(data);
      	}
	});
});


$('#btn-personnage').click(function(){ 
	var name=$('#name').val();
	$.ajax({ 
			type: "GET",
			url: "http://localhost/Slam-5/missiongot4/server/bonjour.php/personnage/"+name,
			success: function(data){  
				$("#resultat").html(data);
			}
		});
	});


$('#btn-log').click(function(){ 
var login=$('#login').val();
var pw=$('#pw').val();
	$.ajax({ 
      	type: "GET",
      	contentType: 'application/json; charset=utf-8',
     	url: "http://localhost/Slam-5/missiongot4/server/bonjour.php/user?login="+login+"&pw="+pw,
     	success: function(data){
         	$("#resultlog").html(data);
      	}
 	});
});

$('#btn-inscription').click(function(){ 
var mailIns=$('#mailIns').val();
var loginIns=$('#loginIns').val();
var pwIns=$("#pwIns").val();
$.ajax({ 
      type: "POST",
      contentType: 'application/json; charset=utf-8',
      url: "http://localhost/Slam-5/missiongot4/server/bonjour.php/userIns?mailIns="+mailIns+"&loginIns="+loginIns+"&pwIns="+pwIns,
     success: function(data){
      }
 });
});
});