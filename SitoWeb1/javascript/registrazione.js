var utente = document.getElementById('formUtente')
var azienda = document.getElementById('formAzienda')

$('#utente').click(function(){
    utente.style.display = 'block';
    azienda.style.display = 'none'
})

$('#azienda').click(function(){
    azienda.style.display = 'block'
    utente.style.display = 'none'

})

/*
function SubForm (){
    $.ajax({
        url: 'http:localhost:8080/User/registerUtente',
        type: 'post',
        data: $('#myForm').serialize(),
        success: function(){
            alert("worked");
        }
    });
}
*/

$('.submit').click(function(){
    self.location.href = "/SitoWeb1/html/mainUtente.html";
})