package br.com.taskboard.demo.DAO;

import br.com.taskboard.demo.Modelo.Usuario;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOTest {

    @Test
    void inserir() throws SQLException {
        int resultado;
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario 01");
        usuario.setSenha("senha");
        usuario.setLogin("login");
        usuario.setEmail("email");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            resultado = usuarioDAO.inserir(usuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(resultado, 1);

    }

    @Test
    void atualizar() {

    }

    @Test
    void deletar() {
    }
}