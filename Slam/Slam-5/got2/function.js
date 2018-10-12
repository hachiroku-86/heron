$(document).ready(function () {
//click sur l'id btn
    console.log(sessionStorage.getItem('recupmail'), localStorage.getItem('recuplogin'));
    document.getElementById('login').value = localStorage.getItem("recuplogin");
    var test_co = "0";
    $('#btn').click(function () {
        $.ajax({
        		url: "connexion.php",
                type: "GET",
                data: {
                	login:$('#login').val(),
                	mdp:$('#mdp').val(),
                },
                success: function (resultat) {
                    $("#result").html(resultat);
                    test_co = $('#test_co').val();

                    if(test_co == 1){
                        sessionStorage.setItem('recupmail', $('#email').val());
                        var recupmail = sessionStorage.getItem('recupmail');

                        localStorage.setItem("recuplogin", $('#loginrecup').val());
                        var recuplogin = localStorage.getItem('recuplogin');

                        var user1 = new Utilisateur(recupmail, recuplogin);
                        $("#afficheruser").html(user1.email + ' ' + user1.login);
                    }
                }
                
            });
    });

    $('#perso').click(function () {
        $.ajax({
                url: "mesPersonnages.php",
                type: "GET",
                data: {
                    email:sessionStorage.getItem('recupmail'),
                    login:localStorage.getItem('recuplogin')
                },
                success: function (res) {
                    if(test_co == 1){
                        $("#res").html(res);
                    }
                    else{
                        $("#res").html("Vous n'êtes pas connecté.")
                    }
                }
                
            });
    });
});