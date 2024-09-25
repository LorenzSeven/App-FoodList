



var apiEndpoint = 'http://localhost:8080/User/profilo/consumer';

var data = {
  emailUtente: "mario01@email.com",
  passwordUtente: "password123"
};

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

  var list_items = `
  <h1>Profilo Utente</h1>
            <img src="${profilo.immagineUtente}"
                alt="logo brand">
            <div class="info-profilo">
                <div class="info">
                    <p class="username">Username:</p>
                    <p>${profilo.nomeUtente}</p>
                </div>
                <div class="info">
                    <p class="email">Email:</p>
                    <p>${profilo.emailUtente}</i></p>
                </div>
                <div class="info">
                    <p class="password">Password:</p>
                    <p>${profilo.passwordUtente}</p>
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
