package edu.upc.dsa;

import java.util.LinkedList;

public class Station{
    //Atributos
    String idStation;
    String description;
    int max;
    double lat;
    double lon;
    LinkedList<Bike> bicisofStation;

    //Constructor JSON
    public Station(){ }

    //Constructor
    public Station(String idStation, String description, int max, double lat, double lon){
        this.idStation=idStation;
        this.description=description;
        this.max=max;
        this.lat=lat;
        this.lon=lon;
        this.bicisofStation = new LinkedList<>();
    }

    //Gets i Sets


    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public LinkedList<Bike> getBicisofStation() {
        return bicisofStation;
    }

    public void setBicisofStation(LinkedList<Bike> bicisofStation) {
        this.bicisofStation = bicisofStation;
    }

    //Añadir bici
    public void addBike(Bike bike){
        this.bicisofStation.add(bike);
    }
}
