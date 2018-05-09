$( document ).ready(function() {
 
//click sur l'id btn
$('#btn').click(function(){ 
    var mailjs=$('#emailhtml').val();
//AJAX en JQUERY      
$.ajax({       
      type: "GET",
//appel de index.php sur le serveur web
      url: "index.php",
      success: function(data){ 
       	$("#result").html(data);
      }
    });
 });
$('#btn2').click(function(){
	var email=$('#emailhtml').val();
	alert(email);
        $.ajax({
        	contentType: 'application/json; charset=utf-8',
            url: 'index.php?email='+email,
            type: 'get',
            
            success: function(data) {
                $("#result2").html(data);
            }
        });
    });

 
});