package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/official")
public class OfficialResource {

    @GET
    @Path("/totalOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalOwnersByNeighborhood() {
        return Response.ok().entity(new OfficialService().getTotalOwners()).build();
    }

    @GET
    @Path("/totalPets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalPets() {
        return Response.ok().entity(new OfficialService().petsRegistered()).build();
    }

    @GET
    @Path("/totalCases")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalCases() {
        return Response.ok().entity(new OfficialService().findTotalCasesPerType()).build();
    }

    @GET
    @Path("/totalVisits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalVisits() {
        return Response.ok().entity(new OfficialService().findTotalVisitsByVetAndType()).build();
    }

    @GET
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPetsFiltered(@QueryParam("idF") String idF,
                                     @QueryParam("microchipF") String microchipF,
                                     @QueryParam("nameF") String nameF,
                                     @QueryParam("speciesF") String speciesF,
                                     @QueryParam("raceF") String raceF,
                                     @QueryParam("sizeF") String sizeF,
                                     @QueryParam("sexF") String sexF) {

        if (speciesF != null) speciesF = "'" + speciesF.replaceAll(",", "' , '") + "'";
        if (sizeF != null) sizeF = "'" + sizeF.replaceAll(",", "' , '") + "'";
        if (sexF != null) sexF = "'" + sexF.replaceAll(",", "' , '") + "'";

        return Response.
                ok(new OfficialService().findPetsFiltered(idF, microchipF, nameF, speciesF, raceF, sizeF, sexF)).
                build();
    }

}