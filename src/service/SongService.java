package service;

import model.Song;

public class SongService {
    public static Song[] songList = new Song[100];
    public  boolean  saveSong(Song song){
        if(song == null){
            return false;
        }
        for (int i = 0; i < songList.length; i++) {
            if(songList[i] == null || songList[i].getId() == song.getId()){
                songList[i] = song;
                return true;
            }
        }
        return false;
    }
    public Song findById(int id){

        for (int i = 0; i < songList.length; i++) {
            if(songList[i] != null && songList[i].getId() == id){
                return songList[i];
            }
        }
        return null;
    }
    public void deleteId(int id){
        for (int i = 0; i < songList.length; i++) {
            if (songList[i] == null) continue;
            if( songList[i].getId() == id){
                songList[i] = null;
                return;
            }
        }
    }
}
