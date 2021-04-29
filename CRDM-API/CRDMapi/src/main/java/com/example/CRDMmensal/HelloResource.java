package com.example.CRDMmensal;

import javax.ws.rs.*;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String HelloWorld() {
        return "Hello, World!";
    }


}