package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class TracksManagerImpl implements TracksManager {

    //LLamamos a las propiedades log4j del archivo
    final static Logger log = Logger.getLogger(TracksManagerImpl.class.getName());

    //Singleton
    //Inicializamos producto
    private static TracksManager instance;

    //Metodo que retorna ejemplo tipo instance
    //Si instance ea nulo genera instancia
    public static TracksManager getInstance() {
        if (instance == null) {
            //Generamos una instancia
            instance = new TracksManagerImpl();
        }
        return instance;
    }
    //Constructor privado
    private TracksManagerImpl() {
        tracks = new LinkedList<>();
    }

    //Inicializar listas private o protected acuerdate lista tracks
    private List<Track> tracks;


    public int size() {
        log.info("Tamaño lista track: " +this.tracks.size());
        return this.tracks.size();
    }

    public void addTrack(Track t) {
        log.info("Track: " +t.singer +t.title +t.id );
        this.tracks.add (t);
    }

    public void addTrack(String title, String singer) {
        log.info("Title: " +title +singer);
        this.addTrack(new Track(title, singer));
    }

    public Track getTrack(int i) {
        Track t=null;
        if (i<this.tracks.size())
            t = this.tracks.get(i);
        log.info("Dame track dado posicion: " +t);
        return t;
    }

    public List<Track> findAll() {
        log.info("Dame toda la lista: " +tracks);
        return this.tracks;
    }

    @Override
    public void deleteTrack(int id) {
        log.info("Id de la track eliminado: " +id);
        this.tracks.remove(id);

    }

    @Override
    public void updateTrack(Track p) {
        //Recoges id de la cancion que quieres cambiar en t
        Track t = this.getTrack(p.getId());
        //Cambias  el singer y el title de t
        t.setSinger(p.getSinger());
        t.setTitle(p.getTitle());
    }
}
