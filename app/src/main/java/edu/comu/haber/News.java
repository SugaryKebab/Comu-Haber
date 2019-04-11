package edu.comu.haber;

public class News {
    private String title;
    private String url;

    News (String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getList() {
        return url;
    }

    public void setList(String list) {
        this.url = list;
    }

}
