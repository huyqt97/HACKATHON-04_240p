package controller;

import model.Singer;
import service.SingerService;

public class SingerController {
    private static SingerService service = new SingerService();

    public static boolean createSinger(Singer singer){
        return service.saveSinger(singer);
    }
    public static Singer findById(int id){
        return service.findById(id);
    }
    public static void deleteId(int id){
        service.deleteId(id);
    }
}
