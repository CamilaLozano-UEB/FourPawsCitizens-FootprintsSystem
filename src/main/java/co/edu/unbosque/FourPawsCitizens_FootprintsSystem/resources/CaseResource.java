package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.petCases.CasePOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.CaseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owner/{username}/pet/{pet_id}/petCases")
public class CaseResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String caseUsername, @PathParam("pet_id") Integer pet_id, CasePOJO casePojo) {
        casePojo.setPet_id(pet_id);
        System.out.println(casePojo.getPet_id());
        String message = new CaseService().saveCase(casePojo);
        return Response.status(Response.Status.CREATED).entity(message).build();
    }
}