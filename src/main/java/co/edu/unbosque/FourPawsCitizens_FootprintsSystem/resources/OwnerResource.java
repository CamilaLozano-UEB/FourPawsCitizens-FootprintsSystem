package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

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
}