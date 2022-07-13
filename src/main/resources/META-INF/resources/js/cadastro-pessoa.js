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