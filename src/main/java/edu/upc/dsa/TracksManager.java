package edu.upc.dsa;

import java.util.List;

public interface TracksManager {

    void addTrack(String title, String singer);
    void addTrack(Track t);
    Track getTrack(int i);
    List<Track> findAll();
    void deleteTrack(int id);
    void updateTrack(Track t);

    int size();
}
