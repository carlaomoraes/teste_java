const toolbar = new toolbar();

toolbar.criar("toolbar");

toolbar.acao("btnNovo", novoUsuario);
toolbar.acao("btnSalvar", salvarUsuario);
toolbar.acao("btnListar", listarUsuarios);
toolbar.acao("btnCancelar", cancelarUsuario);
toolbar.acao("btnVoltar", () => history.back());