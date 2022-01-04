package inflearn.inflearnspringboot.chapter1;

public class Music {
    private String singer;
    private String title;

    public Music(String singer, String title) {
        this.singer = singer;
        this.title = title;
    }
    public Music(){

    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }
}
