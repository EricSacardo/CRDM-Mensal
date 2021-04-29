package com.example.CRDMmensal.controller;

import com.example.CRDMmensal.dao.UsuarioDAO;
import com.example.CRDMmensal.model.Relato;
import com.example.CRDMmensal.model.Usuario;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("usuario")
public class UsuarioControl {

    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.criaUsuario();
        return Response.ok(new Gson().toJson("Tabela Usuario criada.")).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criaRelato(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastraUsuario(usuario);
        return Response.ok(new Gson().toJson(usuario)).build();
    }

    @GET
    @Produces("application/json")
    public Response listaUsuario() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuario = usuarioDAO.listaUsuario();
        return Response.ok(new Gson().toJson(usuario)).build();
    }

    @GET
    @Path("{idUsuario}")
    @Produces("application/json")
    public Response buscaUsuarioPorId(@PathParam("idUsuario") int idUsuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscaUsuarioPorId(idUsuario);
        return Response.ok(new Gson().toJson(usuario)).build();
    }

}
