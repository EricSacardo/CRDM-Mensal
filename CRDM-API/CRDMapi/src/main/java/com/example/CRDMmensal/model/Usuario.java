package com.example.CRDMmensal.model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private int idade;
    private String email;
    private String telefone;
    private String nascimento;
    private String endereco;
    private int tipoUsuario;
    private String Status;


    public Usuario() {

    }

    public Usuario(int idUsuario, String nome, int idade, String email, String telefone, String nascimento, String endereco, int tipoUsuario, String status) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.tipoUsuario = tipoUsuario;
        Status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nascimento='" + nascimento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }


}
