var x = document.getElementById('lista');  
var y = document.getElementById('menuTendina');
  
  
  //quando clicco il menu ☰ attivo tendina appare
$('#hamburger').click(function(){
    tendinaAppare()
})

//funzione che fa apparire il menu a tendina laterale
function tendinaAppare() {
  
  if (y.style.visibility === 'hidden') {
    y.style.visibility = 'visible';
  } else {
    y.style.visibility = 'hidden';
  }
}

//quando clicco mostra o nasconde i filtri
$('#searchBar').click(function(){

  if (x.style.visibility === 'hidden') {
    x.style.visibility = 'visible';
  } else {
    x.style.visibility = 'hidden';
  }
})
 
//quando digito lascia nella barra solo i risultati con le prime lettere uguali
//a quelle da me inserite
function barraRicerca() {

  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('searchBar');
  filter = input.value.toUpperCase();
  ul = document.getElementById("lista");
  li = ul.getElementsByTagName('li');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("a")[0];
    txtValue = a.textContent || a.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}

function barraAppare() {

$(".a").visibility = 'hidden'
}