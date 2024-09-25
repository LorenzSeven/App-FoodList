function ricetta_id()
{
  var name = localStorage.getItem("ricetta");
  return name;
}

const SEZIONE_RICETTA = document.querySelector("#sezione_ricetta");
var apiendpoint = "http://localhost:8080/Ricette/getRicettaIng?id=" + ricetta_id();
$.get(apiendpoint, function (ricetta) {
  postRicetta(ricetta);
  console.log("funziona",ricetta);
})

function postRicetta(ricetta) {
  var pagina = `<div id="div_Ricetta">

  <div class="contenitore_titolo_ricetta">
    <h1 class="titolo">${ricetta.nome}</h1>
    <button class="cuore">Aggiungi ai preferiti ❤️</button>
  </div>

  <div class="contenitore_immagine_descrizione">
    <div id="immagine_ricetta"><img id = "foto_ricetta" src= ${ricetta.immagine}></div>
    <div class="descrizione">
      <table class="tabella_proprietà">
        <tr>
          <td class="proprietà_sopra"><b>Tipo: </b>${ricetta.tipo}</td>
        </tr>
        <tr>
          <td class="proprietà"><b>Nazionalità: </b>${ricetta.nazionalità}</td>
        </tr>
        <tr>
          <td class="proprietà"><b>Tempo di preparazione: </b>${ricetta.tempo_preparazione}</td>
        </tr>
        <tr>
          <td class="proprietà_sotto"><b>Difficoltà: </b>${ricetta.difficoltà}</td>
        </tr>
      </table>
    </div>

  </div>

  <h1 class="titolo_ingredienti">Ingredienti</h1>

  <div id="contenitore_ingredienti">
    <style>
      .colonna_quantità {
        left: -60px;
      }
    </style>
    <div id = "temporaneo">${ricetta.lista_ingredienti.map(a => a.nome)}</div>
    <div id = "temporaneo2">${ricetta.lista_ingredienti.map(a => a.valore)}</div>
    <div id = "temporaneo3">${ricetta.lista_ingredienti.map(a => a.unitàMisura)}</div>
    <table id="tabella_ingredienti">

    </table>

  </div>

  <a class="aggiungi_carrello" href="/SitoWeb1/html/carrello.html">Aggiungi al Carrello</a>

  <h1 class="titolo_preparazione">Descrizione</h1>

  <div class="contenitore_preparazione">
    <div id = "step">

     ${ricetta.descrizione}

    </div>
  </div>
</div>`;

var div = document.createElement("div");
div.innerHTML = pagina;
SEZIONE_RICETTA.appendChild(div);


var testoIngredienti = document.getElementById("temporaneo");
Ingredienti_lista = testoIngredienti.innerHTML;
var Array_list_ingr = Ingredienti_lista.split(",");

var testoIngredienti_valore = document.getElementById("temporaneo2");
Ingredienti_lista_valore = testoIngredienti_valore.innerHTML;
var Array_list_ingr_valore = Ingredienti_lista_valore.split(",");

var testoIngredienti_pesi = document.getElementById("temporaneo3");
Ingredienti_lista_peso = testoIngredienti_pesi.innerHTML;
var Array_list_ingr_pesi = Ingredienti_lista_peso.split(",");


var tabella_ingredienti = document.getElementById("tabella_ingredienti");
var tr = [];
num_righe = 0;
if (Array_list_ingr.length%2 == 0)
{
  num_righe = Array_list_ingr.length/2;
}
if (Array_list_ingr.length%2 != 0)
{
  num_righe = (Array_list_ingr.length+1)/2;
}

for(i=0;i<num_righe;i++)
{
  tr[i] = 
`<tr>
<td class='colonna_ingrediente'><b>${Array_list_ingr[(i*2)]}</b></td>
<td class="colonna_quantità">${Array_list_ingr_valore[(i*2)]}${Array_list_ingr_pesi[(i*2)]}</td>
<td class="colonna_ingrediente"><b>${Array_list_ingr[(i*2)+1]}</b></td>
<td class="colonna_quantità">${Array_list_ingr_valore[(i*2)+1]}${Array_list_ingr_pesi[(i*2)+1]}</td>
</tr>`;
}

tr2 = tr;
tr2[num_righe-1] = tr[num_righe-1].replaceAll("undefined", "");
tr3 = [];
for (i=0;i<tr2.length;i++)
{
  tr3[i] = tr2[i].replaceAll("0q.b.","q.b.");
}

contenuto_tabella = "";
for(i=0;i<num_righe;i++)
{
  contenuto_tabella += tr3[i];
}
tabella_ingredienti.innerHTML = contenuto_tabella;
testoIngredienti.innerHTML = "";
testoIngredienti_valore.innerHTML = "";
testoIngredienti_pesi.innerHTML = "";



var descrizione_ricetta = document.getElementById("step");
testo_preparazione = descrizione_ricetta.innerHTML;

function converti_descrizione_in_html(testo) {
  testo_nuovo = "";
  testo_nuovo2 = "";
  testo_nuovo3 = "";
  lettera = "";

  for (i = 0; i < testo.length; i++) 
  {
      lettera = testo.substring(i, i + 1);
      if (lettera == "(") 
      {
          testo_nuovo = testo.replaceAll("(", "<h class='titolo_step'>");
      }
      if (lettera == ")") 
      {
          testo_nuovo2 = testo_nuovo.replaceAll(")", "</h>");
      }
      if (lettera == "|") 
      {
          testo_nuovo3 = testo_nuovo2.replaceAll("|", "<br>");
      }
  }
  return testo_nuovo3;
}

testo_convertito = "";
testo_convertito = converti_descrizione_in_html(testo_preparazione);
descrizione_ricetta.innerHTML = testo_convertito;

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
