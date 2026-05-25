package br.com.taskboard.demo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;

public class Conexao {

    public static  Connection abrirConexao() throws IOException {
        final String URL =
                "jdbc:mysql://127.0.0.1:3306/teste_java?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        // Usuário do MySQL
        final String USER = "root";

        // Senha do MySQL
        final String PASSWORD = "masterkey";

        // Método para conectar
        Connection conn = null;
        try {

            // Carrega o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Cria conexão
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexão realizada com sucesso!");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver JDBC não encontrado!");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Erro ao conectar com o banco!");
            e.printStackTrace();
        }

       return conn;
    }

    // Método para fechar conexão
    public static void fecharConexao(Connection conn) {

        try {

            if (conn != null) {
                conn.close();
                System.out.println("Conexão fechada.");
            }

        } catch (SQLException e) {

            System.out.println("Erro ao fechar conexão!");
            e.printStackTrace();
        }
    }
}

