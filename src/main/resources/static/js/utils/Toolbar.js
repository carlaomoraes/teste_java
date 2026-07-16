class Toolbar {

    acao(idBotao, callback){
        const botao = document.getElementById(idBotao);

        if(botao){
            botao.onclick = callback;
        }
    }

    habilitar(idBotao){
        document.getElementById(idBotao).disabled = false;
    }

    desabilitar(idBotao){
        document.getElementById(idBotao).disabled = true;
    }

    mostrar(idBotao){
        document.getElementById(idBotao).style.display = "";
    }

    ocultar(idBotao){
        document.getElementById(idBotao).style.display = "none";
    }
}