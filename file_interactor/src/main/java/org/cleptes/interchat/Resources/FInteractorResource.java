package org.cleptes.interchat.Resources;

import org.cleptes.interchat.FileHandles.FileHandler;
import org.cleptes.interchat.Objects.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@Path("messages")
public class FInteractorResource {
    FileHandler fh = new FileHandler();


    @GET
    public Response getMessages(){
        return Response.ok(fh.getData()).build();
    }

    @POST
    public Response addMessage(Message message){
        String response = fh.writeData(message);
        return Response.ok(response).build();

    }

}
