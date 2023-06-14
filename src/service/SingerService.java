package service;

import model.Singer;

public class SingerService {
    public static Singer[] singerList = new Singer[100];
    public  boolean  saveSinger(Singer singer){
        if(singer == null){
            return false;
        }
        for (int i = 0; i < singerList.length; i++) {
            if(singerList[i] == null || singerList[i].getId() == singer.getId()){
                singerList[i] = singer;
                return true;
            }
        }
        return false;
    }
    public Singer findById(int id){

        for (int i = 0; i < singerList.length; i++) {
            if(singerList[i] != null && singerList[i].getId() == id){
                return singerList[i];
            }
        }
        return null;
    }
    public void deleteId(int id){
        for (int i = 0; i < singerList.length; i++) {
            if (singerList[i] == null) continue;
            if( singerList[i].getId() == id){
                singerList[i] = null;
                return;
            }
        }
    }
}
