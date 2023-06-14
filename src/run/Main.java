package run;

import config.Config;
import controller.SingerController;
import controller.SongController;
import model.Singer;
import model.Song;
import service.SingerService;
import service.SongService;

import java.util.Date;

public class Main {
    static Singer[] singerList = SingerService.singerList;
    static Song[] songList = SongService.songList;

    public static void main(String[] args) {
        while (true) {
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1.\tQuản lý ca sĩ\n" +
                    "2.\tQuản lý bài hát\n" +
                    "3.\tTìm kiếm bài hát\n" +
                    "4.\tThoát");
            System.out.println("nhập lựa chọn của bạn: ");
            int choice = Config.getScanner().nextInt();
            switch (choice) {
                case 1:
                    singer();
                    break;
                case 2:
                    song();
                    break;
                case 3:
                    showSearch();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void singer() {
        System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                "1.\tThêm mới thông tin ca sĩ mới\n" +
                "2.\tHiển thị tất cả các ca sĩ\n" +
                "3.\tThay đổi thông tin ca sĩ\n" +
                "4.\txóa\n" +
                "5.\tThoát");
        System.out.println("nhập lựa chọn của bạn: ");
        int choice = Config.getScanner().nextInt();
        switch (choice) {
            case 1:
                createSinger();
                break;
            case 2:
                showSinger();
                break;
            case 3:
                editSinger();
                break;
            case 4:
                deleteSinger();
                break;
            case 5:
                System.exit(0);
        }
    }

    static void showSinger() {
        System.out.println("**********************Singer**********************");
        int check = -1;
        for (int i = 0; i < singerList.length; i++) {
            if (singerList[i] != null) {
                System.out.println(singerList[i]);
                check = i;
            }
        }
        if (check == -1) {
            System.err.println("Không có ca sĩ nào!");
        }
    }

    public static void createSinger() {
        Singer singer = new Singer();
        int id = idAutoIncrement();
        singer.setId(id);
        System.out.println("nhập tên ca sĩ: ");
        String singerName = Config.getScanner().nextLine();
        System.out.println("nhập tuổi");
        int age = Config.getScanner().nextInt();
        System.out.println("Quốc tịch: ");
        String nationality = Config.getScanner().nextLine();
        boolean gender = getGender();
        System.out.println("Thể loại: ");
        String genre = Config.getScanner().nextLine();
        Singer singer1 = new Singer(id, singerName, age, nationality, gender, genre);
        boolean checkCreate = SingerController.createSinger(singer1);
        if (checkCreate) {
            System.out.println("thêm mới thành công!");
        } else System.out.println("thêm mới lỗi!");
    }

    static int idAutoIncrement() {
        int maxId = 0;
        for (int i = 0; i < singerList.length; i++) {
            if (singerList[i] != null && maxId < singerList[i].getId()) {
                maxId = singerList[i].getId();
            }
        }
        return maxId + 1;
    }

    static boolean getGender() {
        System.out.println("giới tính: ");
        System.out.println("1.Nam");
        System.out.println("2.Nữ");
        int choice = Config.getScanner().nextInt();
        return choice == 1 ? true : false;
    }

    static void deleteSinger() {
        System.out.println("chọn id học sinh muốn xóa: ");
        int id = Config.getScanner().nextInt();
        Singer singer = SingerController.findById(id);
        if (singer != null) {
            SingerController.deleteId(id);
            System.out.println("xóa thành công");
        } else {
            System.err.println("không tìm thấy sinh viên");
        }
    }

    static void editSinger() {
        System.out.println("nhập id ca sĩ muốn sửa");
        int id = Config.getScanner().nextInt();
        Singer singer = SingerController.findById(id);
        if (singer == null) {
            System.out.println("không thấy học sinh có id này");
            return;
        }
        System.out.println(singer);
        System.out.println("nhập lại tên ca sĩ: ");
        String singerName = Config.getScanner().nextLine();
        System.out.println("nhập lại tuổi");
        int age = Config.getScanner().nextInt();
        System.out.println("nhập lại Quốc tịch: ");
        String nationality = Config.getScanner().nextLine();
        boolean gender = getGender();
        System.out.println("nhập lại Thể loại: ");
        String genre = Config.getScanner().nextLine();
        singer.setSingerName(singerName);
        singer.setAge(age);
        singer.setNationality(nationality);
        singer.setGender(gender);
        singer.setGenre(genre);
        boolean check = SingerController.createSinger(singer);
        if (check) {
            System.out.println("sửa thành công");
        } else System.out.println("sửa thất bại");
    }

    public static void song() {
        System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                "1.\tThêm bài hát mới\n" +
                "2.\tHiển thị tất cả bài hát\n" +
                "3.\tThay đổi thông tin bài hát\n" +
                "4.\txóa\n" +
                "5.\tThoát");
        System.out.println("nhập lựa chọn của bạn: ");
        int choice = Config.getScanner().nextInt();
        switch (choice) {
            case 1:
                createSong();
                break;
            case 2:
                showSong();
                break;
            case 3:
                editSong();
                break;
            case 4:
                deleteSong();
                break;
            case 5:
                System.exit(0);
        }
    }

    static void showSong() {
        System.out.println("**********************Singer**********************");
        int check = -1;
        for (int i = 0; i < songList.length; i++) {
            if (songList[i] != null) {
                System.out.println(songList[i]);
                check = i;
            }
        }
        if (check == -1) {
            System.err.println("Không có ca sĩ nào!");
        }
    }

    public static void createSong() {
        Song song = new Song();
        int id = idAutoIncrement1();
        song.setId(id);
        System.out.println("nhập tên bài hát: ");
        String songName = Config.getScanner().nextLine();
        System.out.println("mô tả bài hát: ");
        String descriptions = Config.getScanner().nextLine();
//        Singer singer = getSingerSong();
        System.out.println("người sáng tác: ");
        String songWriter = Config.getScanner().nextLine();
        System.out.println("ngày đăng: ");
        Date createdDate = new Date();
        boolean songStatus = getSongStatus();
        Song song1 = new Song(id, songName, descriptions, null, songWriter, createdDate,songStatus);
        boolean checkCreate = SongController.createSong(song1);
        if (checkCreate) {
            System.out.println("thêm mới thành công!");
        } else System.out.println("thêm mới lỗi!");
    }

    static int idAutoIncrement1() {
        int maxId = 0;
        for (int i = 0; i < songList.length; i++) {
            if (songList[i] != null && maxId < songList[i].getId()) {
                maxId = songList[i].getId();
            }
        }
        return maxId + 1;
    }

    static boolean getSongStatus() {
        System.out.println("Trạng thái: ");
        System.out.println("1. đang phát hành");
        System.out.println("2. giới thiệu");
        int choice = Config.getScanner().nextInt();
        return choice == 1 ? true : false;
    }

    static void deleteSong() {
        System.out.println("chọn id học bài hát muốn xóa: ");
        int id = Config.getScanner().nextInt();
        Song song = SongController.findById(id);
        if (song != null) {
            SongController.deleteId(id);
            System.out.println("xóa thành công");
        } else {
            System.err.println("không tìm thấy bài hát");
        }
    }

    static void editSong() {
        System.out.println("nhập id bài hát muốn sửa");
        int id = Config.getScanner().nextInt();
        Song song = SongController.findById(id);
        if (song == null) {
            System.out.println("không thấy học sinh có id này");
            return;
        }
        System.out.println(song);
        System.out.println("nhập lại tên bài hát: ");
        String songName = Config.getScanner().nextLine();
        System.out.println("mô tả lại bài hát: ");
        String descriptions = Config.getScanner().nextLine();
//        boolean singer = getSingerSong();
        System.out.println("người sáng tác: ");
        String songWriter = Config.getScanner().nextLine();
        boolean songStatus = getSongStatus();
        song.setSongName(songName);
        song.setDescriptions(descriptions);
        song.setSinger(null);
        song.setSongWriter(songWriter);
        song.setSongStatus(songStatus);
        boolean check = SongController.createSong(song);
        if (check) {
            System.out.println("sửa thành công");
        } else System.out.println("sửa thất bại");
    }

    public static void showSearch() {
        System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                "1.\tTìm kiếm bài hát theo tên ca sĩ hoặc thể loại\n" +
                "2.\tTìm kiếm ca sĩ theo tên hoặc thể loại\n" +
                "3.\tHiển thị danh sách bài hát theo thứ tự tên tăng dần\n" +
                "4.\tHiển thị 10 bài hát được đăng mới nhất\n" +
                "5.\tThoát");
        System.out.println("nhập lựa chọn của bạn: ");
        int choice = Config.getScanner().nextInt();
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
        }
    }
}
