package edu.upc.dsa;

import java.util.LinkedList;

public class UsuarioClass {
    String idUser;
    String name;
    String surname;
    LinkedList<Bike> bicisofUser;

    //Constructor JSON
    public UsuarioClass(){ }

    //Constructor
    public UsuarioClass(String idusername, String name, String surname ){
        this.idUser=idUser;
        this.name=name;
        this.surname=surname;
        this.bicisofUser=new LinkedList<>();

    }
    //Set i Get
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LinkedList<Bike> getBicisofUser() {
        return bicisofUser;
    }

    public void setBicisofUser(LinkedList<Bike> bicisofUser) {
        this.bicisofUser = bicisofUser;
    }

}
