



var apiEndpoint = ' http://localhost:8080/User/profilo/azienda';

var data = {
  emailAzienda: "ash10@example.com",
  passwordAzienda:"password10"};

$.get(apiEndpoint, data, function(profilo) { // richiesta GET 
  console.table("tabella", profilo);
  addTodoDB(profilo);
});


const LISTA_NEGOZI = document.querySelector('#tutto');


function addTodoDB(profilo) {

  var added_li = document.querySelectorAll(".added_tasks li");
  var task = document.querySelector(".addtask textarea");
  var id = profilo.id;
  console.log(profilo);

  var list_items = `  <h1 class="azienda-h1">Profilo Utente Azienda</h1>
  <img src="${profilo.immagineAzienda}"
      alt="logo brand">
  <div class="info-profilo">
      <div class="info">
          <p class="brand">Brand:</p>
          <p>${profilo.brandAzienda}</p>
      </div>
      <div class="info">
          <p class="email">Email:</p>
          <p>${profilo.emailAzienda}</i></p>
      </div>
      <div class="info">
          <p class="password">${profilo.passwordAzienda}:</p>
          <p>pizza123</p>
      </div>
      <div class="info">
          <p class="sede-legale">Sede legale:</p>
          <p>${profilo.sedeAzienda}</p>
      </div>
      <div class="info">
          <p class="p-iva">Partita Iva:</p>
          <p>${profilo.partitaAzienda}</p>
      </div>
  </div>

`;




  var div = document.createElement("div");
  div.setAttribute("class", "profilo");
  div.setAttribute("id", "-" + id)
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
