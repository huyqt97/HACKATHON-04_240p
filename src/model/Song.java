package model;

import java.util.Date;

public class Song {
    private int id;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(int id, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.id = id;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    @Override
    public String toString() {
        return " id = " + id + " || " +
                " songName = " + songName +  " || " +
                " descriptions = " + descriptions +  " || " +
                " singer = " + singer + " || " +
                " songWriter = " + songWriter +  " || " +
                " createdDate = " + createdDate + " || " +
                " songStatus = " + (songStatus ? "phát hành" : "giới thiệu");
    }
}
