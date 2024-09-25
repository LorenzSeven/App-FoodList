var utente = document.getElementById('formUtente');
var azienda = document.getElementById('formAzienda');


$('#utente').click(function(){
    utente.style.display = 'block';
    azienda.style.display = 'none'
})

$('#azienda').click(function(){
    azienda.style.display = 'block'
    utente.style.display = 'none'

})

$('#submitUtente').click(function(){

    var emailUtente = document.getElementById('emailUtente').value;
    let passUtente = document.getElementById('passwordUtente').value
    
    if(emailUtente != "" & passUtente != "") {
        self.location.href = "/SitoWeb1/html/mainUtente.html"
    }  
})

$('#submitAzienda').click(function(){

    var emailAzienda = document.getElementById('emailAzienda').value;
    let passAzienda = document.getElementById('passwordAzienda').value
    
    if(emailAzienda != "" & passAzienda != "") {
        self.location.href = "/SitoWeb1/html/mainAziendale.html";
    } 
})

/*
$('#myForm').submit(function(e){
    e.preventDefault();
    $.ajax({
        url: '/Car/Edit/17/',
        type: 'post',
        data:$('#myForm').serialize(),
        success:function(){
            // Whatever you want to do after the form is successfully submitted
        }
    });
});

*/