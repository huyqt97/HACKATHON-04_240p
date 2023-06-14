package controller;

import model.Song;
import service.SingerService;
import service.SongService;

public class SongController {
    private static SongService service = new SongService();

    public static boolean createSong(Song song){
        return service.saveSong(song);
    }
    public static Song findById(int id){
        return service.findById(id);
    }
    public static void deleteId(int id){
        service.deleteId(id);
    }
}
