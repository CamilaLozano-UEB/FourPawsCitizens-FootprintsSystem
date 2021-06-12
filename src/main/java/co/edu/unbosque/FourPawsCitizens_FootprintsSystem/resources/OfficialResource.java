package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.filters.Logged;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/official")
public class OfficialResource {

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"official".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }

    @GET
    @Path("/owners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalOwnersByNeighborhood() {
        return Response.ok().entity(new OfficialService().getTotalOwners()).build();
    }

    @GET
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalPets() {
        return Response.ok().entity(new OfficialService().petsRegistered()).build();
    }

    @GET
    @Path("/cases")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalCases() {
        return Response.ok().entity(new OfficialService().findTotalCasesPerType()).build();
    }

    @GET
    @Path("/visits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalVisits() {
        return Response.ok().entity(new OfficialService().findTotalVisitsByVetAndType()).build();
    }

}