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
     *
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

    /**
     * Verify the login and the role of the user
     *
     * @param role user's rol
     * @return response message
     */
    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owner".equals(role)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();
        }


        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
}