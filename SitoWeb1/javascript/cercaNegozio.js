

/* ---------------------- Richiesta GET tutti i negozi ---------------------- */

var apiEndpoint = 'http://localhost:8080/NegoziCtrl/utente/1/cerca/negozio/distanza'



var data = { latitudineUtente: 45.4642, longitudineUtente: 9.1900, distanzaMax: 100000000 };

$.get(apiEndpoint, data, function (negozi) { /// richiesta GET 
  console.table("tabella", negozi);
  negozi.forEach(negozio => {
    addTodoDB(negozio);
  });

});


var apiEndpoint2 = ' http://localhost:8080/Ricette/utente/3/carrello'
let ingTotali = 0;
$.get(apiEndpoint2, function (ingredienti) { /// richiesta GET 
  console.table("tabella2", ingredienti);
  let ingredientiArray = [];
  ingredienti.forEach(i => {
    ingredientiArray.push(i);
  })

});




const LISTA_NEGOZI = document.querySelector('#lista-negozio');


function addTodoDB(negozio) {

  var added_li = document.querySelectorAll(".added_tasks li");
  var task = document.querySelector(".addtask textarea");
  var id = negozio.id;
  console.log(negozio);

  let distanza = (negozio.distanza).toFixed(2);
  let spesaTotale = (negozio.prezzoTotaleIngredienti).toFixed(2);

  let mapId = "map-" + id;

  var list_items = `
  <div class="info-negozio">
  <div class="dati-negozio ">
    <div class="titolo">
      <h1 class="nome-negozio">${negozio.nome}</h1>
    </div>

    <h4 class="indirizzo">${negozio.indirizzo}</h4>
    <div class="info-orario-distanza">
      <h7 class="orario"><b>orari apertura/chiusura</b></h7>
      <p class="orario">${negozio.orari}</p>

      <p class="distanza"> <b>distanza:</b> ${distanza} km</p>
    </div>

  </div>
  <div class="img-spazio">
    <div class="img-negozio" style="background-image: url(${negozio.immagineNegozio})">

    </div>
  </div>

  <div class="mappa">
    <div id="${mapId}"></div>
  </div>
</div>

<div class="barra-costo">
  <div class="totale-spesa">
    <p><b>Costo Spesa:</b> ${spesaTotale}€ </p>
    <p></p>
    <p></p>
    <p><b> Lista:</b> ${negozio.ingredientiPresenti} / 10 ing.</p>
  </div>
</div>

`;



console.log('mapId: ', mapId);



  var div = document.createElement("div");
  div.setAttribute("class", "negozio");
  div.setAttribute("id", "negozio-" + id)
  div.innerHTML = list_items;


  LISTA_NEGOZI.appendChild(div);

  $("#"+mapId).css({
    "border": "1px green solid",
    "width": "100%",
    "height": "100%",
    "margin": "1.5%",
    "background-color": "green"
  });

  let lat = negozio.latitudine;
  let lng = negozio.longitudine;
  initMap(mapId, lat, lng);



}





let mapId = "map-1"
let lat = 45.4642;
let lng = 9.1900;

function initMap(id, lat, lng) {
  var position = { lat: lat, lng: lng };
  var map = new google.maps.Map(document.getElementById(id), {
    zoom: 14,
    center: position,
    disableDefaultUI: true
  });
  var marker = new google.maps.Marker({
    position: position,
    map: map
  });
}

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


