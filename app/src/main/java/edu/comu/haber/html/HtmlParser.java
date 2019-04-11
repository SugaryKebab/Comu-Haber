package edu.comu.haber.html;

import android.util.Log;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import edu.comu.haber.News;

public class HtmlParser extends HtmlPage {
    private List<News> news;
    private Elements table;


    public List<News> getNews() {
        return news;
    }

    public void setNews() {
      table =   super.getTable();
      for(int i = 0; i< 4; i++){
          //news.add(new News(table.select("td").get(1).select("a").attr("href").toString(),table.select("td").get(1).select("a").text()));
          Log.d("ye",table.select("tr").get(i).select("td").get(1).select("a").attr("href").toString());
      }
    }

    public void deneme(){
        try {
            super.setPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.setTable();
        Log.d("yeyeyeye",super.getTable().toString());
    }
}
