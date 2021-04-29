package com.example.CRDMmensal.dao;
import com.example.CRDMmensal.factory.ConnectionFactory;
import com.example.CRDMmensal.model.Relato;
import com.example.CRDMmensal.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaUsuario() {
        String sql = "CREATE TABLE IF NOT EXISTS usuario (" +
                "idUsuario INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(200) NOT NULL"+
                "idade int NOT NULL" +
                "email VARCHAR(100) NOT NULL" +
                "telefone VARCHAR(100) NOT NULL" +
                "nascimneto VARCHAR(100) NOT NULL" +
                "endereco VARCHAR(100) NOT NULL" +
                "tipoUsuario VARCHAR(100) NOT NULL" +
                "status VARCHAR(100) NOT NULL" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("tabela Usuario criada.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario" +
                " (nome, idade  , email, telefone, nascimento, endereco, tipoUsuario, status) " +
                "VALUES (?,?,?,?,?,?,?,?,)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getNascimento());
            stmt.setString(6, usuario.getEndereco());
            stmt.setInt(7, usuario.getTipoUsuario());
            stmt.setString(8, usuario.getStatus());


            stmt.execute();
            ResultSet resultSet = stmt.getGeneratedKeys();
            while (resultSet.next()){
                usuario.setIdUsuario(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> listaUsuario() {
        String sql = "SELECT * FROM usuario";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Usuario> usuario = new ArrayList<>();
            Usuario usuario1;

            while (resultSet.next()) {
                usuario1 = new Usuario();
                usuario1.setIdUsuario(resultSet.getInt("idusuario"));
                usuario1.setNome(resultSet.getString("nome"));
                usuario1.setIdade(resultSet.getInt("idade"));
                usuario1.setEmail(resultSet.getString("email"));
                usuario1.setTelefone(resultSet.getString("telefone"));
                usuario1.setNascimento(resultSet.getString("nascimneto"));
                usuario1.setEndereco(resultSet.getString("endereco"));
                usuario1.setTipoUsuario(resultSet.getInt("tipoUsuario"));
                usuario1.setStatus(resultSet.getString("status"));
                usuario.add(usuario1);
            }

            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario buscaUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idusuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setNascimento(resultSet.getString("nascimneto"));
                usuario.setEndereco(resultSet.getString("endereco"));
                usuario.setTipoUsuario(resultSet.getInt("tipoUsuario"));
                usuario.setStatus(resultSet.getString("status"));

                return usuario;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
