package edu.upc.dsa.Service;

import edu.upc.dsa.*;
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

    public MyBikeService(){
        this.mb = MyBikeImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");


        this.mb.addStation("Station1", "description:: station1", 10, 3, 3);
        this.mb.addStation("Station2", "description:: station2", 10, 3, 3);


        try {
            this.mb.addBike("bike101", "descripton", 25.45, "Station1");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            this.mb.addBike("bike102", "descripton", 70.3, "Station1");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            this.mb.addBike("bike103", "descripton", 10.2, "Station1");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            this.mb.addBike("bike201", "descripton", 1325.45, "Station2");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            this.mb.addBike("bike202", "descripton", 74430.3, "Station2");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            this.mb.addBike("bike203", "descripton", 1320.2, "Station2");
        } catch (StationFullException e1) {
            e1.printStackTrace();
        } catch (StationNotFoundException e1) {
            e1.printStackTrace();
        }
    }

//Dame bicis ordenadas por km
    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getbikesByStationOrderByKms(@PathParam("idStation") String idStation)throws StationNotFoundException {
        List<Bike> bikes;
        try {
            bikes =this.mb.bikesByStationOrderByKms(idStation);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bikes) {
            };
            return Response.status(201).build();
        }
        catch (StationNotFoundException e){return Response.status(404).build();}
    }
//Dame la primera bici de una estacion
    @GET
    @ApiOperation(value = "get the first Bike of the station", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFirstBike(@PathParam("idStation") String idStation)throws UserNotFoundException, StationNotFoundException  {
        List<Bike> bikes;
        try {
            bikes =this.mb.bikesByUser(idStation);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bikes) {
            };
            return Response.status(201).build();
        }
        catch (UserNotFoundException e){return Response.status(404).build();}
        //catch (StationNotFoundException e){return Response.status(404).build();}

    }
//Dame bicis de un usuario
    @GET
    @ApiOperation(value = "get the bikes used by the user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikesUser(@PathParam("idUser") String idUser)throws UserNotFoundException{
        List<Bike> bikes;
        try {

            bikes =this.mb.bikesByUser(idUser);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(bikes) {
            };
            return Response.status(201).build();
        }
        catch (UserNotFoundException e){return Response.status(404).build();}

    }

    //Add user
    @POST
    @ApiOperation(value = "Nuevo usuario", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/addBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUsario(UsuarioClass u){
        String idUser=u.getIdUser();
        String name=u.getName();
        String surname=u.getSurname();
        this.mb.addUser(idUser, name, surname);
            return Response.status(201).build();
        }

        //Add station
    @POST
    @ApiOperation(value = "Nueva estacion", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
    })
    @Path("/addBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStation(Station s){
        String idStation=s.getIdStation();
        String description=s.getDescription();
        double lat=s.getLat();
        double lon=s.getLon();
        int max=s.getMax();
        this.mb.addStation(idStation, description, max, lon, lat);
        return Response.status(201).build();
    }

    //Añadir bike en estacion
    @POST
    @ApiOperation(value = "Nueva bici de estacion", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/addBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBikeStation(Bike b)throws StationFullException, StationNotFoundException{

        String idBike=b.getIdBike();
        String description=b.getDescription();
        double kms=b.getKms();
        String idStation=b.getIdStation();
        try {
            this.mb.addBike(idBike, description, kms, idStation);
            return Response.status(201).build();
        }
        catch(StationNotFoundException e) {
            return Response.status(404).build();
        }
        catch(StationFullException e) {
            return Response.status(404).build();
        }
    }
    //Dame usuarios
    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getnumUsers(){
        this.mb.numUsers();

        return Response.status(201).build();
    }

    //Dame estaciones
    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/stations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getnumStations(){
        this.mb.numStations();

        return Response.status(201).build();
    }
    //Dame bicis de estacione
    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getnumBikeStation(Station s)throws StationNotFoundException{
        String idStation=s.getIdStation();
        try{
        this.mb.numBikes(idStation);
        return Response.status(201).build();
        }
        catch (StationNotFoundException e){
            return Response.status(404).build();
        }

    }
    //Limpia
    @GET
    @ApiOperation(value = "Get the bikes of a station ordered by kilometers ", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/stations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClear(){
        this.mb.clear();
        return Response.status(201).build();
    }


}
