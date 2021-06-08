package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.PetService;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vet/{username}/visits")
public class VisitResource {
    /**
     * Method that creates a visit. If the visit is microchip implantation validates it and save it in the db
     *
     * @param vetUsername, vet's username
     * @param visitPOJO    vet's pojo
     * @return a response status
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String vetUsername, VisitPOJO visitPOJO) {

        if (visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() == null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción de implantación de microchip requiere que este sea especificado!!!")
                    .build();
        } else if (!visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() != null) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("La opción " + visitPOJO.getType() + " no tiene permitido el campo microchip!!!")
                    .build();

        } else if (visitPOJO.getType().equalsIgnoreCase("implantación de microchip") && visitPOJO.getMicrochip() != null) {
            String message;
            if (new VisitService().verificateVisit(visitPOJO)) {

                visitPOJO.setVetUsername(vetUsername);

                message = new VisitService().saveVisit(visitPOJO);
                new PetService().modifyPet(new PetPOJO(visitPOJO.getPet_id(), visitPOJO.getMicrochip()));
            } else {
                message = "Los datos ingresados son erroneos";
            }
            return Response.status(Response.Status.CREATED).entity(message).build();
        } else {
            visitPOJO.setVetUsername(vetUsername);

            return Response.status(Response.Status.CREATED)
                    .entity(visitPOJO)
                    .build();
        }
    }
}