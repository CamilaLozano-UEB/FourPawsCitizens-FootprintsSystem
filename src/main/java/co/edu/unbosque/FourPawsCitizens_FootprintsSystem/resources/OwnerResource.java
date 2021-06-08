package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owner/{username}")

public class OwnerResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPets(@PathParam("username") String username) {
        return Response
                .ok()
                .entity(new OwnerService().listPets(username))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modifyOwner(@PathParam("username") String username, OwnerPOJO ownerPojo) {
        ownerPojo.setUsername(username);
        String message = new OwnerService().modifyOwner(ownerPojo);
        return Response.status(Response.Status.OK).entity(message).build();
    }
}