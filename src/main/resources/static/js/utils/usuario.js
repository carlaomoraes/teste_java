const toolbar = new Toolbar();

toolbar.salvar(salvarUsuario);
toolbar.listar(listarUsuarios);
toolbar.voltar(() => history.back());
toolbar.novo(novoUsuario);