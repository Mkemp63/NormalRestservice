package nl.hu.iac.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Matthijs on 23-6-2017.
 */
@Path("/hello")
public class NormalService {


    @GET
    @Path("/{kurtosis}")
    public Response getKurtosis(@PathParam("kurtosis") int kurtosis) {

        String output = "Kurtosis is: "+kurtosis + " ";
        String output2 = "vul ook alstublieft de skewness in";

        return Response.status(200).entity(output+output2).build();

    }


    @GET
    @Path("/{kurtosis}/{skewness}")
    public Response getResult(
            @PathParam("skewness") int skewness,
            @PathParam("kurtosis") int kurtosis) {

        String output = "Kurtosis is: "+kurtosis+ ". ";
        String output2 = "Skewness is: "+skewness+ ". ";
        boolean result = false;
        if (kurtosis <= 0.5 && kurtosis >= -0.5 && skewness <= 0.5 && skewness <= 0.5){
            result = true;
        }

        return Response.status(200).entity(output+output2+" Hypothese normaliteit bevestigd: "+ result).build();

    }

}
