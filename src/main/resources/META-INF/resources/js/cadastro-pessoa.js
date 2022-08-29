function getRequest(url, dto){
    return new Request(window.location.origin+url, {
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(dto)
    });
}

function getFormDTO(){
    let url =  window.location.origin + "/pessoa/cadastro/formdata"
    fetch(url)
        .then(response => response.json())
        .then(function (pessoaFormDTO) {
            populateSelect(pessoaFormDTO);
        })
        .catch(function (erro) {
            alert(erro);
            console.log(erro)
        });
}

function populateSelect(obj){
    let select=document.getElementById('sexoSelect');
    let option=document.createElement('option');
    option.value="";
    option.text="Selecione...";
    select.appendChild(option);
    obj.sexos.forEach(function(item){
        let option=document.createElement('option');
        option.value=item;
        option.text=item;
        select.appendChild(option);
    });
}

getFormDTO();

function getDTO(){
    return {
        "nome": document.getElementById("nomeInput").value,
        "email": document.getElementById("emailInput").value,
        "sexo": document.getElementById("sexoSelect").value
    }
}

function save(){
    fetch(getRequest("/pessoa/cadastro/save", getDTO()))
        .then(response => response.json()) // solicitando o tipo de dado da resposta (promessa)
        .then(function(dto) { // recebendo o dado da resposta
            console.log(dto)
            alert(JSON.stringify(dto));
        })
        .catch(function(error) {
            console.error(error);
        });
}