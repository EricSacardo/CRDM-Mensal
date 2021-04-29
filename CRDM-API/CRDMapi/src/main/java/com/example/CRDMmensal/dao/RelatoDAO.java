package com.example.CRDMmensal.dao;

import com.example.CRDMmensal.factory.ConnectionFactory;
import com.example.CRDMmensal.model.Relato;
import com.example.CRDMmensal.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatoDAO {

    private Connection connection;

    public RelatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaRelato() {
        String sql = "CREATE TABLE IF NOT EXISTS relato (" +
                "idRelato INT PRIMARY KEY AUTO_INCREMENT," +
                "titulo INT(11) NOT NULL," +
                "descricao VARCHAR(5)," +
                "depoimento VARCHAR(10)," +
                "data VARCHAR(255)," +
                "usuario_IdUsuario INT," +
                "CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuario)" +
                "REFERENCES usuario(idUsuario)" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("Tabela Relato criada.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraRelato(Relato r) {
        String sql = "INSERT INTO relato" +
                " (titulo, descricao, depoimento, data, usuario_IdUsuario) " +
                "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, r.getTitulo());
            stmt.setString(2, r.getDescricao());
            stmt.setString(3, r.getDepoimento());
            stmt.setString(4, r.getData());
            stmt.setInt(5, r.getUsuario_IdUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Relato> listaRelato() {
        String sql = "SELECT * FROM relato";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Relato> relato = new ArrayList<>();
            Relato relato1;

            while (resultSet.next()) {
                relato1 = new Relato();
                relato1.setIdRelato(resultSet.getInt("idRelato"));
                relato1.setTitulo(resultSet.getString("titulo"));
                relato1.setDescricao(resultSet.getString("descricao"));
                relato1.setDepoimento(resultSet.getString("depoimento"));
                relato1.setData(resultSet.getString("data"));

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscaUsuarioPorId(resultSet.getInt("usuario_IdUsuario"));
                relato1.setUsuario_IdUsuario(usuario);

                relato.add(relato1);
            }

            return relato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Relato buscaRelatoPorId(int idRelato){
        String sql = "SELECT * FROM relato WHERE idRelato = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idRelato);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Relato relato = new Relato();
                relato.setIdRelato(resultSet.getInt("idRelato"));
                relato.setTitulo(resultSet.getString("titulo"));
                relato.setDescricao(resultSet.getString("descricao"));
                relato.setDepoimento(resultSet.getString("depoimento"));
                relato.setData(resultSet.getString("data"));

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscaUsuarioPorId(resultSet.getInt("usuario_IdUsuario"));
                relato.setUsuario_IdUsuario(usuario);
                return relato;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
