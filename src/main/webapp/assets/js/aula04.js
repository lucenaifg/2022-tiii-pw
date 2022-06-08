function exemplo01(){

    let url =  "http://localhost:8080/api/aula04"
    fetch(url)
        .then(response => response.text())
        .then(function (texto) {
            alert(texto);
            console.log(texto)
        })
        .catch(function (erro) {
            alert(erro);
            console.log(erro)
        });

}

function exemplo02(){

    let url = "http://localhost:8080/api/aula04/save"

    let data = {
        "nome": "Daniel",
        "telefone": "123"
    }

    var request = new Request(url, {
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(data)
    });

    fetch(request)
        .then(response => response.json()) // solicitando o tipo de dado da resposta (promessa)
        .then(function(pessoa) { // recebendo o dado da resposta
            console.log(pessoa)
            alert(JSON.stringify(pessoa));
        })
        .catch(function(error) {
            console.error(error);
        });
}


function exemplo03(){

    let url = "http://localhost:8080/api/ok"


    var request = new Request(url, {
        method: 'GET',
        headers: new Headers({
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        })
    });

    fetch(request)
        .then(response => response.json())
        .then(function(list) {
            alert(JSON.stringify(list));
            console.log(list);
        })
        .catch(function(error) {
            console.error(error);
        });
}