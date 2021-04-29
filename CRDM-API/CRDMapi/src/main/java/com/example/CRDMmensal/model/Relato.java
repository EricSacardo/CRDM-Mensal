package com.example.CRDMmensal.model;

public class Relato {
    private int idRelato;
    private String titulo;
    private String descricao;
    private String depoimento;
    private String data;
    private Usuario usuario_IdUsuario;


    public Relato() {
    }

    public Relato(int idRelato, String titulo, String descricao, String depoimento, String data, int usuario_IdUsuario) {
        this.idRelato = idRelato;
        this.titulo = titulo;
        this.descricao = descricao;
        this.depoimento = depoimento;
        this.data = data;
        usuario_IdUsuario = usuario_IdUsuario;
    }

    public int getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(int idRelato) {
        this.idRelato = idRelato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDepoimento() {
        return depoimento;
    }

    public void setDepoimento(String depoimento) {
        this.depoimento = depoimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getUsuario_IdUsuario() {
        return usuario_IdUsuario.getIdUsuario();
    }

    public void setUsuario_IdUsuario(Usuario usuario_IdUsuario) {
        usuario_IdUsuario = usuario_IdUsuario;
    }

    @Override
    public String toString() {
        return "Relato{" +
                "idRelato=" + idRelato +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", depoimento='" + depoimento + '\'' +
                ", data='" + data + '\'' +
                ", usuario_IdUsuario=" + usuario_IdUsuario +
                '}';
    }
}
