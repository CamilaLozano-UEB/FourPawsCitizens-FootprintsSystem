package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners/{username}/pets")
public class PetsResource {
    /**
     * Method that creates a pet and save it in the db
     * @param username owner's username
     * @param petPOJO pet's pojo
     * @return a response status
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String username, PetPOJO petPOJO) {

        petPOJO.setOwner_username(username);
        String message = new PetService().savePet(petPOJO);

        return Response.
                status(Response.Status.CREATED)
                .entity(message)
                .build();
    }

    /**
     * Method that modify a pet. Compare the ids and update the data in the db
     * @param petId pet's id
     * @param petPojo pet's pojo
     * @return a response status
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}")
    public Response modifyPet(@PathParam("pet_id") Integer petId, PetPOJO petPojo) {
        petPojo.setPet_id(petId);
        String message = new PetService().modifyPet(petPojo);
        return Response.status(Response.Status.OK).entity(message).build();
    }

}