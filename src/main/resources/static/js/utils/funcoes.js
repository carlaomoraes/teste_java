function mostrarMensagemNaTela(resultado, mensagem, tipoMensagem = "error") {
    const container = document.getElementById(resultado);
    let cor;
    switch (tipoMensagem) {
        case "success":
            cor = "#16a34a";
            break;
        case "warning":
            cor = "#c2d329";
            break;
        case "error":
        default:
            cor = "#dc2626";
            break;
    }
    if (container) {
        container.innerHTML = `<p class="mensagem-centralizada" style="color:${cor}; text-align: center;">${mensagem}</p>`;
    } else {
        alert(mensagem); // Feedback visual simples caso não tenha o container
    }
}

//Verifica se a cor é válida
function corHexValida(cor) {
    return /^#([0-9A-F]{3}|[0-9A-F]{6})$/i.test(cor);
}

function formatarData(data) {
    if (!data) return "";

    const [ano, mes, dia] = data.split("-");
    return `${dia}/${mes}/${ano}`;
}
function converterMaiusculo(campo) {
    campo.value = campo.value.toUpperCase();
}
function configurarToolbar(opcoes){

    const botoes = [
        "btnNovo",
        "btnSalvar",
        "btnCancelar",
        "btnEditar",
        "btnExcluir",
        "btnPesquisar"
    ];

    botoes.forEach(id => {
        const botao = document.getElementById(id);

        if(opcoes[id] === false){
            botao.style.display = "none";
        }else{
            botao.style.display = "";
        }

        botao.disabled = !!opcoes[id + "Disabled"];
    });

}