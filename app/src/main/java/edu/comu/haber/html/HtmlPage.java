package edu.comu.haber.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlPage {
    private Elements table;
    private Document page;
    private  final String  URL = "http://ctbmyo.comu.edu.tr/arsiv/duyurular";

    public Elements getTable() {
        return table;
    }

    public void setTable(){
        this.table = this.page.getElementsByClass("table table-hover table-striped table-bordered").select("tbody").select("tr");
    }


    public Document getPage() {
        return page;
    }

    public void setPage() throws IOException {
        this.page = Jsoup.connect(URL).get();
    }
}
