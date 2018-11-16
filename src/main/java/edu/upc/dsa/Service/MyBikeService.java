package edu.upc.dsa.Service;

import edu.upc.dsa.Bike;
import edu.upc.dsa.MyBike;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value="/orders", description = "Endpoint to Order Service")
@Path("/orders")
public class MyBikeService {
    final static Logger log = Logger.getLogger(MyBikeService.class.getName());
    private MyBike mb;

    public MyBikeService(){}


    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {


        GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(productos) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get the first Bike of the station", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {


       {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get the bikes used by the user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {


        {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get the bikes used by the user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {


        {
        };
        return Response.status(201).entity(entity).build();
    }




}
