package br.com.taskboard.demo.DAO;

import br.com.taskboard.demo.Modelo.Usuario;
import br.com.taskboard.demo.conexao.Conexao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO  {

    // CREATE
    public int inserir(Usuario usuario) throws SQLException {
        int NumMaximo = 0;
        String sql = "INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());

            stmt.executeUpdate();

            NumMaximo = stmt.getMaxRows();

            stmt.close();

            Conexao.fecharConexao(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return NumMaximo;
    }
    // READ
    public List<Usuario> listar() {

        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
            Conexao.fecharConexao(conn);
            return usuarios;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // UPDATE
    public int atualizar(Usuario usuario) {
        int NumMaximo;

        String sql = "UPDATE usuario SET nome=?, login = ?, senha = ?, email=? WHERE id=?";

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setLong(5, usuario.getIdusuario());

            stmt.executeUpdate();
            NumMaximo = stmt.getMaxRows();

            stmt.close();
            Conexao.fecharConexao(conn);

        } catch (SQLException e) {
            NumMaximo = -1;
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return NumMaximo;
    }

    // DELETE
    public int deletar(int id) {
        int NumMaximo;

        String sql = "DELETE FROM usuario WHERE idUsuario = ?";

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            NumMaximo =  stmt.getMaxRows();

            Conexao.fecharConexao(conn);

        } catch (SQLException | IOException e) {
            NumMaximo = -1;
            e.printStackTrace();
        }
        return NumMaximo;
    }

    public Usuario buscar(int id) {

        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getLong("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                return usuario;
            }

            Conexao.fecharConexao(conn);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
