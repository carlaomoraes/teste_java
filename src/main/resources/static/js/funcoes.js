function mostrarMensagemNaTela(resultado, mensagem, tipoMensagem = "error") {
    const container = document.getElementById(resultado);
    let cor;
    switch (tipoMensagem) {
        case "clear":
            container.innerHTML = '';
            break;
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
    return typeof cor === "string" &&
        /^#([0-9A-F]{3}){1,2}$/i.test(cor);
}

function formatarData(data) {
    if (!data) return "";

    const [ano, mes, dia] = data.split("-");
    return `${dia}/${mes}/${ano}`;
}
function converterMaiusculo(campo) {
    campo.value = campo.value.toUpperCase();
}
function obterIconeTipo(tipo) {
    switch (tipo) {
        case "BUG":
            return '<i class="bi bi-bug-fill text-danger"></i>';
        case "FUNCIONALIDADE":
            return '<i class="bi bi-stars text-primary"></i>';

        case "MELHORIA":
            return '<i class="bi bi-wrench text-warning"></i>';

        case "DOCUMENTACAO":
            return '<i class="bi bi-file-earmark-text text-secondary"></i>';

        case "TESTE":
            return '<i class="bi bi-check2-square text-success"></i>';

        default:
            return '<i class="bi bi-circle-fill text-secondary"></i>';
    }
}