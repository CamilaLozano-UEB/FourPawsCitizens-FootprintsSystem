package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.filters.Logged;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners")
public class OwnersResource {

    /**
     * Method that creates an owner and save it to the db
     * @param ownerPOJO owner's pojo
     * @return a response status
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(OwnerPOJO ownerPOJO) {

        String message = new OwnerService().saveOwner(ownerPOJO);

        return Response.
                status(Response.Status.CREATED)
                .entity(message)
                .build();
    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owners".equals(role))
           // Response.temporaryRedirect(Regresar Al inicio)
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();
        //Response.temporaryRedirect(URI) la pagina de owner acceptado
        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
}