function mostrarMensagemNaTela(mensagem, tipoMensagem = "error") {
    const container = document.getElementById("resultado");
    if (!container) {
        alert(mensagem);
        return;
    }
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
    container.innerHTML = `<p style="color:${cor};">${mensagem}</p>`;
}
//Verifica se a cor é válida
function corHexValida(cor) {
    return /^#([0-9A-F]{3}|[0-9A-F]{6})$/i.test(cor);
}
