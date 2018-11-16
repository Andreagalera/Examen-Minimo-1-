package edu.upc.dsa;

public class Bike {

    //Atributos
    String idBike;
    String description;
    double kms;
    String idStation;

    //Constructor JSON
    public Bike(){ }
    //Constructor
    public Bike(String idBike, String description, double kms, String idStation){
        this.idBike=idBike;
        this.description=description;
        this.kms=kms;
        this.idStation=idStation;
    }

    //Gets i Sets
    public String getIdBike() {
        return idBike;
    }

    public void setIdBike(String idBike) {
        this.idBike = idBike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

}
