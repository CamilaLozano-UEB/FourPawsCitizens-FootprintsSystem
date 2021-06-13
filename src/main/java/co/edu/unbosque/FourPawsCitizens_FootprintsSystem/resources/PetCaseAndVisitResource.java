package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases.CasePOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.CaseService;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Path("/owner/{username}/pet/{pet_id}")
public class PetCaseAndVisitResource {
    /**
     * Find the visits of a pet in a range of dates in a descending way
     *
     * @param initialDate first date range
     * @param finalDate   second date range
     * @param pet_id      the pet id
     * @return a response status
     */
    @GET
    @Path("/visits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPetsByDatesAndName(@QueryParam("initialDate") String initialDate,
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
        List<VisitPOJO> visitPOJOS = new VisitService().
                findVisitsBetweenDatesByPet(initDate, fDate, pet_id);

        return Response.
                ok().
                entity(visitPOJOS)
                .build();
    }

    /**
     * Find the cases of a pet in a range of dates in a descending way
     *
     * @param initialDate first date range
     * @param finalDate   second date range
     * @param pet_id      the pet id
     * @return a response status
     */
    @GET
    @Path("/cases")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPetsByDatesAndPet(@QueryParam("initialDate") String initialDate,
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

        List<CasePOJO> casesPOJOS = new CaseService().
                findCasesBetweenDatesByPet(initDate, fDate, pet_id);

        return Response.
                ok().
                entity(casesPOJOS)
                .build();
    }
}