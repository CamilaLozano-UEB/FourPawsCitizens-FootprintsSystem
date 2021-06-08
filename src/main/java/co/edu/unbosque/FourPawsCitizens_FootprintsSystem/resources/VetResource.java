package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.vet.VetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vet")
public class VetResource {
    /**
     * Method that creates a vet and save it in the db
     *
     * @param vetPOJO vet's pojo
     * @return a response status
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VetPOJO vetPOJO) {
        String message = new VetService().saveVet(vetPOJO);
        return Response.
                status(Response.Status.CREATED)
                .entity(message)
                .build();
    }

    /**
     * Method that modify the data in a vetPojo's object
     *
     * @param username vet's username
     * @param vetPOJO  vet's pojo
     * @return a response status
     */
    @PUT
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, VetPOJO vetPOJO) {
        String message = new VetService().modifyVet(vetPOJO);

        return Response.
                status(Response.Status.OK)
                .entity(message)
                .build();
    }
}