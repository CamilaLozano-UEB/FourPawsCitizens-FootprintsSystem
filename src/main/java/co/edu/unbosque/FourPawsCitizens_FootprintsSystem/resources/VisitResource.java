package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitNamePOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.PetService;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/vet/{username}/visits")
public class VisitResource {
    /**
     * Method that creates a visit. If the visit is microchip implantation validates it and save it in the db
     *
     * @param vetUsername, vet's username
     * @param visitPOJO    visit's pojo
     * @return a response status
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String vetUsername, VisitPOJO visitPOJO) {
        String message;
        visitPOJO.setVetUsername(vetUsername);
        if (visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() == null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción de implantación de microchip requiere que este sea especificado!!!")
                    .build();
        } else if (!visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() != null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción " + visitPOJO.getType() + " no tiene permitido el campo microchip!!!")
                    .build();

        } else if (visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() != null) {
            if (new VisitService().verifyMicrochipVisit(visitPOJO)) {

                message = new VisitService().saveVisit(visitPOJO);
                new PetService().modify(new PetPOJO(visitPOJO.getPet_id(), visitPOJO.getMicrochip()));
            } else {
                message = "Los datos ingresados son erroneos";
            }
            return Response.status(Response.Status.CREATED).entity(message).build();
        } else if (visitPOJO.getType().equals("Esterilización")) {

            if (new VisitService().verifySterilizationVisit(visitPOJO)) {
                message = new VisitService().saveVisit(visitPOJO);
            } else {
                message = "Los datos ingresados son erroneos";
            }
            return Response.status(Response.Status.CREATED)
                    .entity(message)
                    .build();
        } else {
            message = new VisitService().saveVisit(visitPOJO);
            return Response.status(Response.Status.CREATED)
                    .entity(message)
                    .build();
        }
    }

    /**
     * Find the visits of a pet in a range of dates and a name of the pet in a descending way
     *
     * @param initialDate first date range
     * @param finalDate   second date range
     * @param petName     the name of the pet
     * @return a response status
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPetsByDatesAndName(@QueryParam("initialDate") String initialDate,
                                           @QueryParam("finalDate") String finalDate,
                                           @QueryParam("petName") String petName,
                                           @PathParam("username") String username) {
        Date initDate, fDate;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            initDate = df.parse(initialDate);
            fDate = df.parse(finalDate);
        } catch (ParseException e) {
            return Response.status(Response.Status.OK).entity("El formato de fecha es incorrecto!").build();
        }
        List<VisitNamePOJO> visitNamePOJOS = new VisitService().
                findVisitsBetweenDatesByName(initDate, fDate, petName, username);

        return Response.
                ok().
                entity(visitNamePOJOS)
                .build();
    }

    /**
     * bring a list with all the visits of vet without filters
     *
     * @param username vet's username
     * @return response entity
     */
    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllVisits(
            @PathParam("username") String username) {

        List<VisitNamePOJO> visitNamePOJOS = new VisitService().listVisitsAll(username);
        return Response.
                ok().
                entity(visitNamePOJOS)
                .build();
    }
}