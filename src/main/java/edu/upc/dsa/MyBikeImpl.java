package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyBikeImpl implements MyBike {

    //LLamamos a las propiedades log4j del archivo
    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());

    //Singleton
    //Inicializamos producto
    private static MyBike instance;

    //Metodo que retorna ejemplo tipo instance
    //Si instance ea nulo genera instancia
    public static MyBike getInstance() {
        if (instance == null) {
            //Generamos una instancia
            instance = new MyBikeImpl();
        }
        return instance;
    }
    //Constructor privado
    private MyBikeImpl() {
        stations = new ArrayList<>();
        bikesofStation = new LinkedList<>();
        bikesofUser = new LinkedList<>();
        usuarios = new HashMap<>();
    }

    //Inicializar listas
    //Array de Staciones
    private List<Station> stations;
    //LinkedList the bicis de una estacion
    private LinkedList<Bike> bikesofStation;
    //LinkedList the bicis de un usuario
    private LinkedList<Bike>bikesofUser;
    //Inicializamos el hashmap(key: string; value: Usuarios) de UsuarioClass
    private HashMap<String, UsuarioClass> usuarios;

    //Funciones o metodos
    //Añadir usuario
    public void addUser(String idUser, String name, String surname){
        log.info("Usuario para añadir "  +idUser +name +surname);
        usuarios.put(idUser, new UsuarioClass(idUser, name, surname));
        log.info("Id Usuario: " +usuarios.get(idUser));

    }
    //Añadir Stacion
    public void addStation(String idStation, String description, int max, double lat, double lon){
        log.info("Estacion para añadir: " + idStation +description +max +lat +lon);
        if (S<10) {
            Station s = new Station(idStation, description, max, lat, lon);
            log.info("Estación creada");
            }
        else
        {
            log.info("No hay espacio para otra estacion");
        }
    }
    //Añadir Bike
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{
        log.info("Bici para añadir: " + idBike +description +kms +idStation);
        String theStation=null;
        Station p =null;
        for(int i =0; i<this.stations.size();i++) {
            if (stations.equals(this.stations.get(i).idStation)) {
                theStation = "si";
            }
        }
        if (theStation !=null){
            Bike b =new Bike(idBike, description, kms, idStation);
            log.info("Bici creada");
        }
        else
            log.error("StationFullException");
            throw new StationFullException();
            //log.error("StationNotFoundException");
            //throw new StationNotFoundException();

    }
    //Get the bikes of a station ordered by kilometers
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException{
        log.info("Bike dada: " +idStation);
        List<Bike> bikes;
        String theStation=null;
        Station p =null;
        for(int i =0; i<this.stations.size();i++) {
            if (stations.equals(this.stations.get(i).idStation)) {
                theStation = "si";
            }
        }
        if(theStation !=null){
            //We want to create a copy of the actual list of Employees, because it will be better not to modify the list.
            List<Bike> ret = new ArrayList<>();
            ret.addAll(this.bikesofStation);
            //As we did in figures, we have to tell to the sort method, which criteria has to apply
            Collections.sort(ret, new Comparator<Bike>() {
                @Override
                //Function to compare the salary
                public int compare(Bike pr1, Bike pr2) {
                    return (int)(pr1.getKms()-pr2.getKms());
                }
            });
            log.info("List de kilometros de una estacion ordenado por kilometros: " + ret);

            return ret;
        }
        else
            log.error("StationNotFoundException");
            throw new StationNotFoundException();
    }
    //Dame la Primera bici de una estacion
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException{
        log.info("Stacion y usuario dados: " +stationId+ userId);
        UsuarioClass theUser = this.usuarios.get(userId);
        String theStation=null;
        Station p =null;
        for(int i =0; i<this.stations.size();i++) {
            if (stations.equals(this.stations.get(i).idStation)) {
                theStation = "si";
            }
        }
        Boolean encontrado=false;

        if (theUser !=null && theStation !=null){
            for(int i =0; i<this.bikesofStation.size() && encontrado==false ;i++) {
                for(int j=0; j<this.bikesofUser.size() && encontrado==false;j++){
                    encontrado=true;
            }
            }
        }
        else{
            log.error("UserNotFoundException");
            throw new UserNotFoundException();
            //log.error("StationNotFoundException");
            //throw new StationNotFoundException();

        }
        return null;
    }
    //Dame las bicis de un Usuario
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException{
        log.info("Usuario dado: " +userId);
        List<Bike> bike;
        UsuarioClass theUser = this.usuarios.get(userId);
        String theStation=null;
        Station p =null;
        for(int i =0; i<this.stations.size();i++) {
            if (stations.equals(this.stations.get(i).idStation)) {
                theStation = "si";
            }
        }
        List<Bike> ret = new ArrayList<>();

        if (theUser !=null){
            for(int j=0; j<this.bikesofUser.size(); j++){


            }

        }
        else{
            log.error("UserNotFoundException");
            throw new UserNotFoundException();


        }
      return null;
    }
    //Dame numero usuarioa
    public int numUsers(){
        HashMap<String, ArrayList<UsuarioClass>> hMap = new LinkedHashMap<String, ArrayList<UsuarioClass>>();
        int hSize;
        hSize = hMap.size();
        return hSize;
    }
    //Dame el numero de Stations
    public int numStations(){
        log.info("Función para saber numero de Stations");
        int contador;
        contador= stations.size();

        log.info("Numero de Stations:" +contador);
        return contador;
    }
    //Dame el numero de Bikes en una Stacion
    public int numBikes(String idStation) throws StationNotFoundException{
        log.info("Bike dada: " +idStation);
        int contador;
        String theStation=null;
        Station p =null;
        for(int i =0; i<this.stations.size();i++) {
            if (stations.equals(this.stations.get(i).idStation)) {
                theStation = "si";
            }
        }
        if(theStation !=null){
            contador= stations.size();
        }
        else {
            log.error("StationNotFoundException");
            throw new StationNotFoundException();
        }

        log.info("Numero de Stations:" +contador);
        return contador;
    }
    //Limpia las estrcuturas
    public void clear(){
        instance=null;
    }
    //Numero de Stations
    public static final int S = 10;


}
