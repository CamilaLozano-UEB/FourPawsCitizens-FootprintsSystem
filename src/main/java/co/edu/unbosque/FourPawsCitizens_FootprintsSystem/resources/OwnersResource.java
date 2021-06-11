package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.filters.Logged;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OwnerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

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
        URI uri= null;

        // If role doesn't match
        if (!"owner".equals(role)) {try {
            uri = new URI("http://127.0.0.1:8081/owner.html");
            Response.temporaryRedirect(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();
        }

        try {
            uri = new URI("http://127.0.0.1:8081/owner.html");
            System.out.println(uri);
            Response.temporaryRedirect(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }
}