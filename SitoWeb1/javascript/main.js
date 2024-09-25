var x = document.getElementById('lista');  
var y = document.getElementById('menuTendina');
var z= document.getElementById('loadingIcon')
  
  
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

//$('#searchBar').click(function(){
//  z.style.visibility = "visible";
//})

function ricetta_pizza_margherita()
{
  localStorage.setItem("ricetta", "1");
}
function ricetta_lasagne()
{
  localStorage.setItem("ricetta", "2");
}
function ricetta_risotto()
{
  localStorage.setItem("ricetta", "3");
}
function ricetta_spaghetti()
{
  localStorage.setItem("ricetta", "4");
}
function ricetta_tiramisù()
{
  localStorage.setItem("ricetta", "5");
}
function ricetta_tagliatelle()
{
  localStorage.setItem("ricetta", "6");
}
function ricetta_parmigiana()
{
  localStorage.setItem("ricetta", "7");
}
function ricetta_pizza_marinara()
{
  localStorage.setItem("ricetta", "8");
}
function ricetta_gnocchi()
{
  localStorage.setItem("ricetta", "9");
}
function ricetta_ossobuchi()
{
  localStorage.setItem("ricetta", "10");
}
function ricetta_sacher()
{
  localStorage.setItem("ricetta", "11");
}
function ricetta_arancini()
{
  localStorage.setItem("ricetta", "12");
}
