$ ( document ).ready(function() {
 var liste = [
    "thomas.heron@hautil.fr",
    "matis.cataldi@hautil.fr",
    "raphael.olivier@hautil.fr",
    "andy.martin@hautil.fr",
    "florent.reigner@hautil.fr"
];

$('#emailhtml').autocomplete({
    source : liste 
});

});