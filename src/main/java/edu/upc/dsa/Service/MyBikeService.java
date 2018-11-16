package edu.upc.dsa.Service;

import edu.upc.dsa.Bike;
import edu.upc.dsa.MyBike;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
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
        List<Bike> productos = this.mb.num("idStation") String idStation);

        GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bikes) {
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

    @POST
    @ApiOperation(value = "place an Order", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/addBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response placeAnOrder() throw  {

        String userName = p.getUsuario().getNombre();

            this.mb.realizarPedido(userName, p);
            return Response.status(201).build();
        } catch NotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }





}
