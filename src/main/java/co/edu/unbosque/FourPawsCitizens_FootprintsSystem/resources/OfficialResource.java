package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.filters.Logged;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services.OfficialService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/official/{username}")
public class OfficialResource {

    /**
     * Verify the login and the role of the user
     *
     * @param role user's rol
     * @return response message
     */
    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {
        // If role doesn't match
        if (!"official".equals(role)) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();
        }

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }

    /**
     * Bring the table of owners filtered by neighborhood
     *
     * @return response entity
     */
    @GET
    @Path("/totalOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalOwnersByNeighborhood() {
        return Response.ok().entity(new OfficialService().getTotalOwners()).build();
    }

    /**
     * Bring the table of pets to the official
     *
     * @return response entity
     */
    @GET
    @Path("/totalPets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalPets() {
        return Response.ok().entity(new OfficialService().petsRegistered()).build();
    }

    /**
     * Bring the table of cases to the official
     *
     * @return response entity
     */
    @GET
    @Path("/totalCases")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalCases() {
        return Response.ok().entity(new OfficialService().findTotalCasesPerType()).build();
    }

    /**
     * Bring the table of visits to the official
     *
     * @return response entity
     */
    @GET
    @Path("/totalVisits")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalVisits() {
        return Response.ok().entity(new OfficialService().findTotalVisitsByVetAndType()).build();
    }

    /**
     * Bring the table of pets with filters to the official
     *
     * @param idF        id filter
     * @param microchipF microchip filter
     * @param nameF      name filter
     * @param speciesF   specie filter
     * @param raceF      race filter
     * @param sizeF      size filter
     * @param sexF       sex filter
     * @return response entity
     */
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