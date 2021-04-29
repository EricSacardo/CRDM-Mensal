package com.example.CRDMmensal.controller;
import com.example.CRDMmensal.dao.RelatoDAO;
import com.example.CRDMmensal.model.Relato;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("relato")
public class RelatoControl {

    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaRelato() {
        RelatoDAO relatoDAO = new RelatoDAO();
        relatoDAO.criaRelato();
        return Response.ok(new Gson().toJson("Tabela Relato criada.")).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criaRelato(Relato relato) {
        RelatoDAO relatoDAO = new RelatoDAO();
        relatoDAO.cadastraRelato(relato);
        return Response.ok(new Gson().toJson(relato)).build();
    }

    @GET
    @Produces("application/json")
    public Response listaRelato() {
        RelatoDAO relatoDAO = new RelatoDAO();
        List<Relato> relato = relatoDAO.listaRelato();
        return Response.ok(new Gson().toJson(relato)).build();
    }

    @GET
    @Path("{idRelato}")
    @Produces("application/json")
    public Response buscaRelatoPorId(@PathParam("idRelato") int idRelato) {
        RelatoDAO relatoDAO = new RelatoDAO();
        Relato relato = relatoDAO.buscaRelatoPorId(idRelato);
        return Response.ok(new Gson().toJson(relato)).build();
    }
}
