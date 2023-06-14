package model;

public class Singer {
    private int id; // id
    private String singerName;//tên ca sỹ
    private int age;//tuổi
    private String nationality;// quốc tịch
    private boolean gender;//giới tính
    private String genre;// thể loại

    public Singer() {
    }

    public Singer(int id, String singerName, int age, String nationality, boolean gender, String genre) {
        this.id = id;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return
                "id= " + id + " || " +
                " singerName = " + singerName + " || " +
                " age = " + age + " || " +
                " nationality = " + nationality + " || " +
                " gender = " + (gender ? "Nam" : "Nữ") + " || " +
                " genre = " + genre;
    }
}
