package edu.comu.haber.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlParser {
    private Document html;
    private Elements table;

    protected void fetchHtml(String url) throws IOException {
      this.html=  Jsoup.connect(url).get();
    }

    protected void findTable(String tags) {
        this.table = this.html.select(tags);

    }

    protected Elements getTable() {
        return table;
    }

    protected String findLink(String tags, int id) {
        return this.table.get(id).select(tags).attr("href");
        //.select(tags).get(id).attr("href");
    }

    protected String findTitle(String tags, int id) {
        return this.table.get(id).text();
    }

}
