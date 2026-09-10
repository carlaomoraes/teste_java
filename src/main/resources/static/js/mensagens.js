const COR = {
    SUCESSO: "#198754",
    ERRO: "#dc3545",
    ALERTA: "#ffc107",
    INFO: "#0dcaf0",

    PROGRESSO_100: "#198754",
    PROGRESSO_75: "#20c997",
    PROGRESSO_50: "#ffc107",
    PROGRESSO_0: "#dc3545"
};
const MSG = {
    salvo: (nome) => `${nome} salvo(a) com sucesso.`,
    alterado: (nome) => `${nome} alterado(a) com sucesso.`,
    excluido: (nome) => `${nome} excluído(a) com sucesso.`,
    erroSalvar: (nome) => `Erro ao salvar ${nome}.`,
    erroExcluir: (nome) => `Erro ao excluir ${nome}.`,
    erroCarregar: (nome) => `Erro ao carregar ${nome}.`,
    errolistar: (nome) => `Erro ao listar ${nome}.`,
    naoEncontrado: (nome) => `${nome} não encontrado.`,
    naoEncontrada: (nome) => `${nome} não encontrada.`
};
