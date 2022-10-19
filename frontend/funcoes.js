//vai requisitar uma API

let edit = false // variavel para evitar edição seguida

async function cadastrar(){
    let id= document.getElementById("id").value
    let nome= document.getElementById("nome").value
    let idade= Number(document.getElementById("idade").value) 
    let posicao= document.getElementById("posicao").value 
    let overall= Number(document.getElementById("overall").value)
    let habilidade= Number(document.getElementById("habilidade").value)

    let dado
    let metodo // vai conter post ou put

    if(id && (edit == true)){ // vai atualizar
        //alterar o dado para enviar
        metodo = 'PUT'
        dado={
            id, nome, idade, posicao, overall, habilidade
        }
    }
    else{ // vai cadastrar
        //criar o dado para enviar
        metodo = 'POST'
        dado={
            nome, idade, posicao, overall, habilidade
        }
    }
    

    //chamando a api utilizando o fetch
    await fetch('http://localhost:8080/FifaPlayer', {
        method: metodo,
        body: JSON.stringify(dado),
        headers: {"Content-Type":"application/json; charset=UTF-8"}
    })
    //resposta de sucess "servidor"
    .then(response => {
        if(edit == false){
            alert("Cadastro realizado com sucesso")
            limpa()
        }
        else{
            alert("Edição realizada com sucesso")
            edit = false
            limpa()
        }
        consultar()
    })
    //resposta de error do "servidor"
    .catch(error =>{
        alert(error)
    })
}

async function consultar(){
    //consome a API e recupera os FifaPlayers

    let dados = await fetch('http://localhost:8080/FifaPlayer')
    .then( response =>{
        return response.json() // = atribui os dados em json para dado
    })
    //resposta de error do "servidor"
    .catch(error =>{
        alert(error)
    })

    //vamos crirar uma variavel result para concatenar a resposta
    let resposta = ''
    //percorrer a variavel dados
    dados.map(dado=>{
        resposta += `<tr><td>${dado.nome}</td> <td>${dado.idade}</td> <td>${dado.posicao}</td> <td>${dado.overall}</td> 

        <td> ${dado.habilidade} <i class="bi bi-star-fill" style="color:gold"></i> </td> 

        <td> <i onClick='remove(${dado.id})'class='bi bi-trash3'> </i> </td> 
        <td> <i onClick="atualiza(${dado.id},'${dado.nome}',${dado.idade},'${dado.posicao}',${dado.overall}, ${dado.habilidade})" class='bi bi-pencil pulse'> </i> </td> </tr>`
    })
    //colocar a resposta no body da tabela
    document.getElementById("conteudoTabela").innerHTML = resposta
}

//remove um FifaPlayer do banco de dados
//quem chamar a função remove pode fazer outra ação antes de receber resposta

async function remove(id){
    let confirma = confirm('Confirma a exclusão do Jogador?')
    if (confirma){
        //chama a api -> sincrona(await) = enquanto não houver retorno do servidor aguarda 
        await fetch(`http://localhost:8080/FifaPlayer/${id}`,{
            method:'DELETE'
        })
        .then(response =>{//quando o servidor retornou
            alert("Jogador foi removido com sucesso")
            consultar()
        })
        .catch( error =>{ //quando há erro na comunicação com o servidor
            alert("Problema na remoção")
        })
    }
}

function atualiza(id, nome, idade, posicao, overall, habilidade){
    document.getElementById("id").value = id
    document.getElementById("nome").value = nome
    document.getElementById("idade").value = idade
    document.getElementById("posicao").value = posicao
    document.getElementById("overall").value = overall
    document.getElementById("habilidade").value = habilidade
    edit = true
}

function limpa(){
    document.getElementById("id").value = ""
    document.getElementById("nome").value = ""
    document.getElementById("idade").value = ""
    document.getElementById("posicao").value = ""
    document.getElementById("overall").value = ""
    document.getElementById("habilidade").value = ""
}


async function listagem(){
    //consome a API e recupera os FifaPlayers

    let dados = await fetch('http://localhost:8080/FifaPlayer')
    .then( response =>{
        return response.json() // = atribui os dados em json para dado
    })
    //resposta de error do "servidor"
    .catch(error =>{
        alert(error)
    })

    //vamos crirar uma variavel result para concatenar a resposta
    let resposta = ''
    //percorrer a variavel dados
    dados.map(dado=>{
        resposta += `<tr><td>${dado.nome}</td> <td>${dado.idade}</td> <td>${dado.posicao}</td> <td>${dado.overall}</td> 

        <td> ${dado.habilidade} <i class="bi bi-star-fill" style="color:gold"></i> </td> 

        <td> <i onClick='remove(${dado.id})'class='bi bi-trash3'> </i> </td> </tr>`
    })
    //colocar a resposta no body da tabela
    document.getElementById("conteudoTabela").innerHTML = resposta
}

//remove um FifaPlayer do banco de dados
//quem chamar a função remove pode fazer outra ação antes de receber resposta

async function remove(id){
    let confirma = confirm('Confirma a exclusão do Jogador?')
    if (confirma){
        //chama a api -> sincrona(await) = enquanto não houver retorno do servidor aguarda 
        await fetch(`http://localhost:8080/FifaPlayer/${id}`,{
            method:'DELETE'
        })
        .then(response =>{//quando o servidor retornou
            alert("Jogador foi removido com sucesso")
            consultar()
        })
        .catch( error =>{ //quando há erro na comunicação com o servidor
            alert("Problema na remoção")
        })
    }
}
