package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/officials")
public class OfficialResource {
    @GET
    @Produces("text/plain")
    public Response create(OfficialPOJO officialPOJO) {
        return null;
    }
}