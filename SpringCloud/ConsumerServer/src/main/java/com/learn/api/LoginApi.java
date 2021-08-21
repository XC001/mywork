package com.learn.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/account")
public class LoginApi {

    @GET
    @Path("/login")
    @Produces({"application/json"})
    public String login(){
        return "hello";
    }
}
