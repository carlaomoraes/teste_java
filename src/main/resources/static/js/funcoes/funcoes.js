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