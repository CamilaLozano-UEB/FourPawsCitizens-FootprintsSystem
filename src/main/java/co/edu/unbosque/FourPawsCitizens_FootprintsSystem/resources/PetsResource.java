package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/owners/{username}/pets")
public class PetsResource {
    /**
     * Method that creates a pet and save it in the db
     *
     * @param username owner's username
     * @param petPOJO  pet's pojo
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
     *
     * @param petId   pet's id
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

    /**
     * This Method bring a list of visits and cases filtered with date
     *
     * @param initialDate first date
     * @param finalDate   last date
     * @param pet_id      pet'id
     * @return response status
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}/visitsCases")
    public Response listVisitsCases(@QueryParam("initialDate") String initialDate,
                                    @QueryParam("finalDate") String finalDate,
                                    @PathParam("pet_id") Integer pet_id) {
        Date initDate, fDate;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            initDate = df.parse(initialDate);
            fDate = df.parse(finalDate);
        } catch (ParseException e) {
            return Response.status(Response.Status.OK).entity("El formato de fecha es incorrecto!").build();
        }
        return Response.
                status(Response.Status.OK).
                entity(new PetService().listVisitsAndCasesOnDateRange(pet_id, initDate, fDate)).
                build();
    }

    /**
     * bring a list with all the visits and cases without filters
     *
     * @param pet_id pet's id
     * @return response status
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}/visitsCasesAll")
    public Response listVisitsCasesAll(@PathParam("pet_id") Integer pet_id) {

        return Response.
                status(Response.Status.OK).
                entity(new PetService().listVisitsAndCaseAll(pet_id)).
                build();
    }

}