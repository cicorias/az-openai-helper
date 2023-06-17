package com.shawn.examples;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("again")
    // @Produces(MediaType.APPLICATION_JSON)
    public Uni<String> hello2() {
        return Uni.createFrom().item("Hello").onItem().transform(s -> s + " World");
    }
}
